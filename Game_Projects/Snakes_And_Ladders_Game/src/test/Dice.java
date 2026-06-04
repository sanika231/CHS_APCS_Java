/*
    Name:       Sanika Thatte
    Date:       05-08-2026
    Period:     3

    Is this lab fully working?  Yes
*/

package test;

import javafx.scene.image.Image;
import engine.Actor;
import javafx.animation.RotateTransition;
import javafx.util.Duration;
import javafx.scene.image.ImageView;

public class Dice extends Actor{
	ImageView img;
	Image[] images = new Image[6];
	public int numRolled=0;
	
	public Dice() {
		for(int i=0; i<6; i++) {
			images[i]=new Image("file:images/dice" + (i+1) + ".png");
		}
		setImage(images[0]);
		setFitWidth(80);
		setFitHeight(80);
	}
	
	//simulates a dice roll + animation
	public int roll() {
		int move = (int)(Math.random()*6)+1;
		
		//rotation movement
		numRolled=move;
		System.out.println("rolled: " + move);

		setImage(images[move-1]);		
		RotateTransition rt = new RotateTransition(Duration.seconds(3),this);
		rt.setByAngle(360);
        rt.setCycleCount(2);
        rt.play();
        
		return move;
		
	}
	
	public int numberRolled() {
		return numRolled;
	}
	
	public ImageView getImgView() {
		//needed to add to main view
		return img;
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
}
