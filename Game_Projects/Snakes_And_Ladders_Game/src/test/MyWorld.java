package test;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import engine.World;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyWorld extends World{
	private Stage stageToTransition;
	public Dice d;
	ImageView h;
	int level = 1;
	int currPlayer;
	Image snake = new Image("file:images/Snake.png");
	Image ladder = new Image("file:images/ladder3.png");
	Image ladder1 = new Image("file:images/ladder4.png");
	
	Button rollButton;
	Button g;
	Button musicButton;
	ImageView homeScreen;
	MediaPlayer backgroundMusic;
	int x = 0;
	int y = 0;
	Cell[][] tiles = new Cell[10][10];
	ArrayList<Player> players = new ArrayList<>();
	ArrayList<Snake> snakeList = new ArrayList<>();
	ArrayList<Ladder> ladderList = new ArrayList<>();
	
	AnimationTimer timer;
	MyTimer t = new MyTimer();
	Label l = new Label("Time elapsed: " + t.getTime());
	
	public MyWorld(int width, int height, Stage s) {
		setPrefSize(width, height);
		stageToTransition = s;
	}
	
	public MyWorld(Stage s) {
		setPrefSize(950, 600);
		stageToTransition = s;
	}
	public MyWorld(int x, Stage s) {
		level = x;
		stageToTransition = s;
	}

	@Override
	public void act(long now) {
		
		
	}

	@Override
	public void onDimensionsInitialized() {
		Image grassImage=new Image("file:images/grassImage.jpeg");
		//h=new ImageView(grassImage);
		//h.setMaxWidth(850);
		//h.maxHeight(600);
		//h.setPreserveRatio(false);
		//getChildren().add(h);
		
		try {
			URL url = getClass().getResource("/sound/backgroundMusic.mp3");
			System.out.println(url);
			Media longMusic = new Media(getClass().getResource("/sound/backgroundMusic.mp3").toURI().toString());
		    backgroundMusic =  new MediaPlayer(longMusic);
		    backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);
		} catch (URISyntaxException e) {
		    e.printStackTrace();
		}
		//backgroundMusic.setCycleCount(AudioClip.INDEFINITE);
		Image homeImage=new Image("file:images/img.png");
		homeScreen=new ImageView(homeImage);
		homeScreen.setFitWidth(950);
		homeScreen.setFitHeight(600);
		homeScreen.setPreserveRatio(false);
		getChildren().add(homeScreen);
		//h.setAlignment(Pos.CENTER);
		g = new Button("Play");
		g.setAlignment(Pos.CENTER);
		g.setPrefSize(150, 50);
		g.setStyle("-fx-font-size: 25px;");
		g.setLayoutX(375);
		g.setLayoutY(515);
		g.setStyle("-fx-background-color: yellow; -fx-font: 18px 'Verdana';");
		getChildren().add(g);
		g.setOnAction(new ButtonHandler());
		
		Label credits = new Label("Game by: Akshita Bethi, Sanika Thatte, Vidushi Budhiraja");
		credits.setFont(Font.font("Cambria", 15));
		credits.setLayoutX(560);
		credits.setLayoutY(500);
		credits.setTextFill(Color.web("#d1ede4"));
		getChildren().add(credits);
		
		Button play = new Button("How To Play");
		play.setAlignment(Pos.CENTER);
		play.setPrefSize(150, 50);
		play.setStyle("-fx-font-size: 25px;");
		play.setLayoutX(375);
		play.setLayoutY(455);
		play.setStyle("-fx-background-color: yellow; -fx-font: 18px 'Verdana';");
		getChildren().add(play);
		play.setOnAction(new PlayHandler());
		
		timer = new AnimationTimer() {
		    @Override
		    public void handle(long now) {
		        act(now);
		        
		        for (Player p : players) {
		            p.act(now);
		        }
		    }
		};

		timer.start();
		
	}
	public void load() {
		Board b;
		
		if(level == 1) {
			b = new Board(3, 3);
		} else if(level == 2){
			b = new Board(5, 3);
		} else {
			b = new Board(7, 3);
		}
		int c = 0;
		int c1 = 0;
						
		
		for(int i = 0; i < b.getWidth(); i++) {
			for(int j = 0; j < b.getWidth(); j++) {
				int row = i;
				int col = j;
				if(b.getValue(i, j) == 0) {
					//System.out.println(row + ", " + col);
					int x = b.getEndRowSnake(c);
					int y = b.getEndColSnake(c);
					//System.out.println(x + ", " + y + "pos");
					Snake s = new Snake(row, col, x, y, c);
					s.setX(50 + 50 * col);
					s.setY(50 + 50 * row);
					s.setFitWidth(50);
					s.setFitHeight(50 * (Math.abs(x - row) + 1));
					s.setPreserveRatio(false);
					s.setImage(snake);
					add(s);
					snakeList.add(s);
					c++;
				} else if(b.getValue(i, j) == -1) {
					System.out.println(row + ",l " + col);
					int x = b.getEndRowLadder(c1);
					int y = b.getEndColLadder(c1);
					System.out.println(x + ",l " + y + "pos");
					Ladder l = new Ladder(x, y , row , col, c1);
					l.setY(50 + 50 * x);
					l.setFitWidth(50);
					l.setFitHeight(50 * (Math.abs(x - row) + 1));
					l.setX(50 + 50 * y);
					l.setImage(ladder);
					add(l);
					ladderList.add(l);
					c1++;

				}

			}


		}

		//testing code
		for(int i=0;i<2;i++) {
			Player p = new Player(i+1, b, d, this);
			p.setImage(new Image(("file:images/player"+p.getNum()+".png"),50,50,true,true));
			players.add(p);
			add(p);
		}
		//end test code

		
	}
	
	private class PlayHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			Stage stage = new Stage();
			stage.setTitle("Instructions");
			VBox b = new VBox(400);
			b.setStyle("-fx-background-color: pink;");
			Label info = new Label();
			info.setText("\n\nThis is a 2 player game!! Roll the dice to get number of moves a player has.\nWhoever reaches 100 first wins. \nRemember, Snakes bring you down but Ladders take you up!\n\n");
			info.setFont(Font.font("Cambria", 32));
			b.getChildren().add(info);
			Scene s = new Scene(b);
			stage.setScene(s);
			stage.sizeToScene();
			stage.show();
		}
		
	}
	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			getChildren().remove(homeScreen);
			getChildren().remove(g);
			Image grassI= new Image("file:images/grassImage.jpg");
			h=new ImageView(grassI);;
			h.setFitWidth(950);
			h.setFitHeight(600);
			h.setPreserveRatio(false);
			getChildren().add(h);
			Image rock= new Image("file:images/bedRock.png");
			ImageView rocks= new ImageView(rock);
			rocks.setX(-23);
			rocks.setY(-60);
			rocks.setFitWidth(645);
			rocks.setFitHeight(720);
			rocks.setPreserveRatio(false);
			getChildren().add(rocks);
			int x = 50;
			int num = 100;
			Random r = new Random();
			for(int i = 0; i < 10; i++) {
				if(i % 2 == 0) {
					for(int j = 0; j < 10; j++) {
						int red = r.nextInt(100) + 156;
						int green = r.nextInt(100) + 156;
						int blue = r.nextInt(100) + 156;
						Color color = Color.rgb(red, green, blue);
						Cell c = new Cell(num, color);
						c.setX(j * 50 + x);
						c.setY(i * 50 + x);
						tiles[i][j] = c;
						add(c);	
						num--;
					}
					
				} else {
					for(int j = 9; j >= 0; j--) {
						int red = r.nextInt(100) + 156;
						int green = r.nextInt(100) + 156;
						int blue = r.nextInt(100) + 156;
						Color color = Color.rgb(red, green, blue);
						Cell c = new Cell(num, color);
						c.setX(j * 50 + x);
						c.setY(i * 50 + x);
						tiles[i][j] = c;
						add(c);	
						num--;
					}
				}
			}
			load();
			d=new Dice();
			d.setX(600);
			d.setY(67);
			add(d);
			d.roll();
			
			rollButton=new Button("roll!");
			rollButton.setPrefSize(67, 39);
			rollButton.setStyle("-fx-font-size: 17px;");
			rollButton.setLayoutX(600);
			rollButton.setLayoutY(176);
			getChildren().add(rollButton);
			rollButton.setOnAction(new MyButtonHandler());
			
			musicButton=new Button("music OFF!");
			musicButton.setPrefSize(80,30);
			musicButton.setLayoutX(47);
			musicButton.setLayoutY(563);
			musicButton.setOnAction(new MyMusicHandler());
			getChildren().add(musicButton);
			
			l.setFont(Font.font("Cambria", 32));
			l.setLayoutX(600);
			l.setLayoutY(500);
			l.setTextFill(Color.web("#d1ede4"));
			getChildren().add(l);
			
			Label v = new Label("Level: " + level);
			v.setFont(Font.font("Cambria", 32));
			v.setLayoutX(600);
			v.setLayoutY(400);
			v.setTextFill(Color.web("#d1ede4"));
			getChildren().add(v);
			Stage stage = (Stage) getScene().getWindow();
			stage.sizeToScene();
		}
			
	}
	
	
	public Cell getTilePos(int row, int col){
		return tiles[row][col];
	}
	
	private class MyButtonHandler implements EventHandler<ActionEvent> {
	    @Override
	    public void handle(ActionEvent e) {
	    	if(x == 0) {
	    		t.start();
	    		x++;
	    	}
	    	if(y == 0) {
	    		int a = d.roll();
	    		System.out.println("yo");
	    		while(a != 6) {
	    			a = d.roll();
	    			
	    		}
	    		y++;
	    		
	    	}
	        // Handle button code here
	    	getCurrPlayer().moveSpot(d.roll());
	    	currPlayer = (currPlayer+1)%players.size();
	    	//d.roll();
	    }
	}
	
	private class MyMusicHandler implements EventHandler<ActionEvent> {
	    
	    boolean playing=false;
	    @Override
	    public void handle(ActionEvent e) {
	    	 if(!playing) {
	             backgroundMusic.play();
	             musicButton.setText("Music ON!");
	             playing=true;
	         }
	         else {
	             backgroundMusic.stop();
	             musicButton.setText("Music OFF!");
	             playing=false;
	         }
	    }
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public Player getCurrPlayer() {
		return players.get(currPlayer);
	}
	
	public void winScreen(int pNum) {
		t.stop();
		System.out.println("player " + pNum+" wins!");
		
		WinWorld winWorld = new WinWorld(pNum,level++);
		stageToTransition.setScene(new Scene(winWorld, getPrefWidth(),getPrefHeight()));
		stageToTransition.show();
	}
	
	public class MyTimer extends AnimationTimer{
		int count = 0;
		long time = 0;
		@Override
		public void handle(long arg0) {
			if(arg0 - time >= 1e9) {
				count++;
				time = arg0;
			}
			l.setText("Time elapsed: " + count);
			
		}
		
		public int getTime() {
			return count;
		}
		
	}
	
	public ArrayList<Snake> getSnakes(){
		return snakeList;
	}

	public ArrayList<Ladder> getLadders(){
		return ladderList;
	}
	
	public void setLevel(int num) {
		level = num;
	}
	
	public int getLevel() {
		return level;
	}
}

