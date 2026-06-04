package engine;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.ImageView;

public abstract class Actor extends ImageView{
	public Actor() {
		
	}
	
	public abstract void act(long now);
	
	public void add(Actor actor) {
		getWorld().add(actor);
		actor.addedToWorld();
	}
	
	public void addedToWorld() {
		
	}
	
	public double getHeight() {
		return getBoundsInParent().getHeight();
	}
	
	public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
		List<A> possibleA = getWorld().getObjects(cls);
		List<A> touchingA = new ArrayList<A>();
		for(A obj: possibleA) {
			if(obj!=this && obj.getBoundsInParent().intersects(this.getBoundsInParent())) {
				touchingA.add(obj);
			}
		}
		return touchingA;
	}
	
	public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls){
		List<A> list = getIntersectingObjects(cls);
		if(list.size()==0) {
			return null;
		}else {
			return list.get(0);
		}
	}
	
	public double getWidth() {
		return getBoundsInParent().getWidth();
	}
	
	public World getWorld() {
		return (World)getParent();
	}
	
	public void move(double dx, double dy) {
		setX(getX()+dx);
		setY(getY()+dy);
	}

}
