package engine;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public abstract class World extends Pane{
	private AnimationTimer myTimer;
	private boolean isTimerRunning;
	private HashSet<KeyCode> codes;
	boolean isWidthSet;
	boolean isHeightSet;
	
	
	public World() {
		isWidthSet = false;
		isHeightSet = false;
		isTimerRunning = false;
		codes = new HashSet<KeyCode>();
		
		widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				if(arg2.intValue() > 0 && arg1.intValue() <= 0) {
					isWidthSet = true;
					if(isWidthSet && isHeightSet) {
						onDimensionsInitialized();

					}
				}
			}
			
		});
		
		heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				if(arg2.intValue() > 0 && arg1.intValue() <= 0) {
					isHeightSet = true;
					if(isWidthSet && isHeightSet) {
						onDimensionsInitialized();

					}
				}
			}
			
		});
		
		
		sceneProperty().addListener(new ChangeListener<Scene>() {
			@Override
			public void changed(ObservableValue<? extends Scene> arg0, Scene arg1, Scene arg2) {
				requestFocus();
				
			}
		});
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				codes.add(arg0.getCode());
				
			}
			
		});
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				codes.remove(arg0.getCode());
				
			}
			
		});
		
		myTimer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				act(arg0);
				List<Actor> list = getObjects(Actor.class);
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getWorld() != null) {
						list.get(i).act(arg0);
					}
				}
				
			}
		};
		
	}
	
	public abstract void act(long now);
	
	public void add(Actor actor) {
		getChildren().add(actor);
		actor.addedToWorld();
		
	}
	
	public <A extends Actor> List<A> getObjects(java.lang.Class<A> cls) {
		ObservableList<Node> list = getChildren();
		ArrayList<A> arr = new ArrayList<A>();
		for(int i = 0; i < list.size(); i++) {
			Node n = list.get(i);
			if(cls.isInstance(n)) {
				arr.add(cls.cast(n));
			}
		}
		return (List<A>) arr;
		
	}
	public boolean isKeyPressed(KeyCode code) {
		for(int i = 0; i < codes.size(); i++) {
			if(codes.contains(code)) {
				return true;
			}
		}
		return false;
		
	}
	public <A extends Actor> List<A> getObjectsAt(double x, double y, java.lang.Class<A> cls) {
		List<A> list = getObjects(cls);
		List<A> actors = new ArrayList<A>();
		for(int i = 0; i < list.size(); i++) {
			Node n = list.get(i);
			if(n.getBoundsInParent().contains(x, y)) {
				actors.add((A) n);
			}
			
		}
		return actors;

	}
	public boolean isStopped() {
		return !isTimerRunning;
		
	}
	
	public abstract void onDimensionsInitialized();
	
	public void remove(Actor actor) {
		getChildren().remove(actor);
	}
	
	public void start() {
		myTimer.start();
		isTimerRunning = true;
		
	}
	
	public void stop() {
		myTimer.stop();
		isTimerRunning = false;
	}

	
	
}
