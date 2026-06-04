package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		MyWorld world = new MyWorld(stage);
		Scene scene = new Scene(world);
		stage.setScene(scene);
		stage.setTitle("Game");
		stage.show();
		
		
	}
	
	
	
}
