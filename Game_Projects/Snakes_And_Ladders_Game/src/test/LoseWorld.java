package test;

import engine.World;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoseWorld extends World{
	int loser;
	public LoseWorld(int num) {
		loser=num;
	}
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDimensionsInitialized() {
		// TODO Auto-generated method stub
		 Image img=new Image("file:images/losescreen.jpeg");
		 ImageView bg=new ImageView(img);
		 bg.setFitWidth(getWidth());
		 bg.setFitHeight(getHeight());
		 getChildren().add(bg);
		
	}
}
