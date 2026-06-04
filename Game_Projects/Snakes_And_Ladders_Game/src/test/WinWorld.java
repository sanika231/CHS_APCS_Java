/*
    Name:       Sanika Thatte
    Date:       05-25-2026
    Period:     3

    Is this lab fully working?  Yes
*/

package test;

import engine.World;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class WinWorld extends World{
	int winner;
	int lev;
	public WinWorld(int num, int x) {
		winner=num;
		lev = x;
	}
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDimensionsInitialized() {
		// TODO Auto-generated method stub
		 Image img=new Image("file:images/winscreen.png");
		 ImageView bg=new ImageView(img);
		 bg.setFitWidth(getWidth());
		 bg.setFitHeight(getHeight());
		 getChildren().add(bg);
		 Button homeButton = new Button("Home");
		 homeButton.setPrefSize(120, 50);
		 homeButton.setLayoutX(365);
		 homeButton.setLayoutY(450);
		 Button nextLevel = new Button("Next Level");
		 nextLevel.setPrefSize(120, 50);
		 nextLevel.setLayoutX(365);
		 nextLevel.setLayoutY(525);
		 nextLevel.setOnAction(new ButtonHandler());
		 
		 homeButton.setOnAction(new HomeHandler());
		 getChildren().addAll(homeButton, nextLevel);
	}
	
	private class HomeHandler implements EventHandler<ActionEvent> {
	    public void handle(ActionEvent e) {
	        Stage stage = (Stage) getScene().getWindow();
	        MyWorld world = new MyWorld(stage);
	        stage.setScene(new Scene(world, 850, 600));
	        stage.show();
	    }
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
	    public void handle(ActionEvent e) {
	    	Stage stage = (Stage) getScene().getWindow();
	        MyWorld world = new MyWorld(lev++, stage);
	        if(lev <= 3) {
	        	System.out.println("yoo");
	        	System.out.println(world.getLevel());
	        	world.setLevel(lev++);
	        	stage.setScene(new Scene(world, 850, 600));
		        stage.show();
	        }
	        
	    }
	}
}
