package test;


import engine.Actor;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Cell extends Actor{
	Text t;
	int num;
	WritableImage image;
	public Cell(int n, Color c) {
		draw(c);
		t = new Text("" + n);
		num=n;
	}

	@Override
	public void act(long now) {
		
		
	}
	
	public void draw(Color color) {
		image = new WritableImage(50, 50);
		PixelWriter pixel = image.getPixelWriter();
		for(int i = 0; i < image.getWidth(); i++) {
			for(int j = 0; j < image.getHeight(); j++) {
				pixel.setColor(i, j, color);
			}
		}
		setImage(image);
	}
	
	public int getNum() {
		return num;
	}
	
	@Override
	public void addedToWorld() {
		t.setX(getX() + getWidth()/2);
		t.setY(getY() + getHeight()/2);
		t.setStyle("fx-font-size: 24px");
		getWorld().getChildren().add(t);
		//System.out.println("adding text: " + t.getText() + " at " + t.getX() + " " + t.getY());
	}
	
	public String toString() {
		return ""+getNum();
	}

}
