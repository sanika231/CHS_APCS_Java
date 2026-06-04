/*
    Name:       Sanika Thatte
    Date:       05-08-2026
    Period:     3

    Is this lab fully working?  Yes
*/

package test;

import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import javafx.animation.TranslateTransition;

import engine.Actor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.*;

public class Player extends Actor{
	final int SPEED = 6;
	int num;
	Board board;
	int r;
	int c;
	//board num
	int pos;
	int tPos;
	Dice dice;
	MyWorld world;
	Cell target;
	int tRow;
	int tCol;
	int snakeRow;
	int snakeCol;
	int ladderRow;
	int ladderCol;
	Image img;
	int x = 0;
	int movesRemaining;
	boolean transitionInProgress=false;
	Snake currSnake=null;
	Ladder currLadder=null;
	boolean animation = false;
	
	int moveNum = 0;
	
	boolean vMove = true;
	boolean hMove = true;
	boolean won=false;
	boolean snakeMove = false;
	boolean ladderMove = false;
	public Player(int n, Board b,Dice d, MyWorld w) {
		num=n;
		board = b;
		r=9;
		c=0;
		pos=1;
		tPos=1;
		dice=d;
		world=w;
		target=null;
		img =new Image("file:images/player" + (n) + ".png");
		setImage(img);
		board.show();
	}
	
	
	
	public int getNum() {
		return num;
	}
	
	public void moveSpot(int move) {
		/*if (moveNum == 0 || moveNum==1) {
			move++;
			moveNum++;
		}*/
//			
//		} else if (moveNum == 1) {
//			move = 6;
//			moveNum++;
//		} else if (moveNum == 2) {
//			move = 8;
//			moveNum++;
//		}
		System.out.println("Player "+getNum()+" moves "+move+" places.");
		//move=17;
		
		//System.out.println("pos: "+pos+" tPos: "+tPos);
		//pos+=move;
		tPos=pos+move;
		//pos++;
		//System.out.println("pos: "+pos+" tPos: "+tPos);
		
		if(tPos>=100) {
			tPos=100;
			won=true;
		}else if(tPos<1) {
			tPos=1;
		}
		
		//int movesRemaining = tPos-pos;
		movesRemaining = move; //animation
		//System.out.println("movesRemaining: "+ movesRemaining);
		//target row/col
		int tempRow = pos/10;
		int tempCol = pos%10;
		
		if(tempRow%2!=0) {
			tempCol=9-tempCol;
		}
		tempRow = 9-tempRow;
		
		tRow=tempRow;
		tCol=tempCol;
		//
		
		int checkR = (tPos-1)/10;
		int checkC = (tPos-1)%10;
		
		if(checkR%2!=0) {
			checkC=9-checkC;
		}
		checkR = 9-checkR;
		
		//System.out.println(checkR+" "+checkC);
		int val = board.getValue(checkR,checkC);
		//System.out.println("value: "+val);
		//System.out.println(target.getX() + " "+target.getY());
		//if(val==0) {
			//snake
		ArrayList<Snake> snakes = world.getSnakes();
		for(Snake s: snakes) {
			if(s.playerOnSnake(checkR,checkC)) {
				snakeMove = true;
				currSnake=s;
				snakeRow = board.getEndRowSnake(s.getSnake());
				
				//tPos = board.getValue(snakeRow, s.getStartCol()) - 1;

				//tRow = board.getEndRowSnake(s.getSnake());
				//pos = pos - board.getValue(tRow, tCol);
			}
		}
			//set pos accordingly
		//}else if(val==-1) {
			//ladder
		ArrayList<Ladder> ladders = world.getLadders();
		for(Ladder s: ladders) {
			if(s.playerOnLadder(checkR,checkC)) {
				ladderMove = true;
				currLadder=s;
				ladderRow = board.getEndRowLadder(s.getLadder());
				ladderCol = board.getEndColLadder(s.getLadder());
				
				//tPos = board.getValue(ladderRow, ladderCol) - 1;
				
				//tRow = board.getEndRowLadder(s.getLadder());
				//pos = pos - board.getValue(tRow, tCol);
			}
			//}
		}
			//set pos accordingly
		//}else {
		if(!ladderMove && !snakeMove) {
			//spot
			r=tRow;
			c=tCol;
		}
		//}
		
		//System.out.println("trowCol" + tRow + " " + tCol);
		target=world.getTilePos(tRow, tCol);
		//System.out.println("target: " + target.toString());
		//System.out.println("pos: " + pos);
		
		
	}

	@Override
	public void act(long now) {
		if(!transitionInProgress) {
			if(target==null) {
				return;
			}
			
			if((r%2!=0 && target.getX()>getX()) || (r%2==0 && target.getX()<getX())) {
				if(vMove) {
					if(Math.abs(target.getY()-getY())>SPEED) {
						setY(getY()+(Math.signum(target.getY()-getY())*SPEED));
					}else {
						setY(target.getY());
						vMove=false;
					}
				}else {
					
					if(Math.abs(target.getX()-getX())>SPEED) {
						setX(getX()+(Math.signum(target.getX()-getX())*SPEED));
					}else {
						setX(target.getX());
						
					}
				}
			}else {
				if(hMove) {
					if(Math.abs(target.getX()-getX())>SPEED) {
						setX(getX()+(Math.signum(target.getX()-getX())*SPEED));
					}else {
						setX(target.getX());
						hMove = false;
					}
				}else {
					if(Math.abs(target.getY()-getY())>SPEED) {
						setY(getY()+(Math.signum(target.getY()-getY())*SPEED));
					}else {
						setY(target.getY());
					}
				}
			}
	
			if(target.getX()==getX() && target.getY()==getY()){
				pos++;
				movesRemaining--;
				//System.out.println("moves remaining: " + movesRemaining);
				if(movesRemaining>0) {
					r=tRow;
					c=tCol;
					
					if(tPos==pos && (snakeMove || ladderMove)) {
						transitionInProgress=true;
						//MOVE
						/*pos=tPos;
						
						if(snakeMove) {tRow--;}
						if(ladderMove) {tRow++;}
						target = world.getTilePos(tRow, tCol);
						
						tPos = target.getNum();
						
						if(movesRemaining==1) {
							snakeMove=false;
							ladderMove=false;
						}*/
						//end MOVE
					}else {
						//changes to next target
						int tempRow = pos/10;
						int tempCol = pos%10;
						
						if(tempRow%2!=0) {
							tempCol=9-tempCol;
						}
						tempRow = 9-tempRow;
						
						tRow=tempRow;
						tCol=tempCol;
						
						if(tRow>=0 && tRow<10 && tCol>=0 && tCol<10) {
							target=world.getTilePos(tRow, tCol);
						}
						//System.out.println("target: "+target);
						//System.out.println("pos: "+pos + " tPOs: " + tPos);
						//end of target change
						vMove=true;
						hMove = true;
					}
				}else{
					if(pos>=100 && won) {
						won=false;
						((MyWorld)getWorld()).winScreen(getNum());
						return;
					}
					if(tPos==pos && (snakeMove || ladderMove)) {
						transitionInProgress=true;
					}
					//System.out.println("in else ladder omveo "+ ladderMove);
					/*if(snakeMove) {
						pos=tPos;
				
						int curr=tRow;
						tRow = snakeRow;
						target = world.getTilePos(tRow, tCol);
						
						tPos = target.getNum();
						pos++;
						
						movesRemaining = Math.abs(snakeRow-curr);
						
						snakeMove = false;
						System.out.println("pos: "+pos + " tPOs: " + tPos);
						//return;
					}
					if(ladderMove) {
						pos=tPos;
						
						int curr=tRow;
						tRow = ladderRow;
						target = world.getTilePos(tRow, tCol);
						
						tPos = target.getNum();
						pos++;
						
						movesRemaining = ladderRow-curr;
						
						ladderMove = false;
						System.out.println("pos: "+pos + " tPOs: " + tPos);
						//return;
					}*/
	
					
					r=tRow;
					c=tCol;
					target = null;
					vMove=true;
					hMove = true;
					//if(won) {
						//((MyWorld)getWorld()).winScreen(getNum());
					//}
				}
				
				
			}
		}else {
			if(!animation) {
				animation=true;
				snakeLadderMove();
				movesPlayer();
			}
			return;
			
			/*TranslateTransition tt = new TranslateTransition(Duration.seconds(3),this);
			tt.setToY(target.getY());
			
			tt.play();
			
			tt.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					transitionInProgress=false;		
					System.out.println(getY());
				}
			});*/
			
		}
		
	}
	
	public void movesPlayer() {
		Timeline timeline = new Timeline();
		timeline.setAutoReverse(false);
		timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000), new KeyValue (this.translateYProperty(), target.getY()-getY())));
		timeline.play();
		timeline.setOnFinished(e -> {
			animation=false;
		    transitionInProgress = false;
		    setTranslateX(0);
		    setTranslateY(0);
		    setX(target.getX());
		    setY(target.getY());
		    r = tRow;
		    c = tCol;
		    pos = tPos;
		    target=null;
		    
		});
	}
	
	public void snakeLadderMove() {
		pos=tPos;
	
		if(snakeMove) {tRow=snakeRow;}
		if(ladderMove) {tRow=ladderRow;}
		target = world.getTilePos(tRow, tCol);
		
		tPos = target.getNum();
		//System.out.println("target y: " +target.getY());
		
		if(movesRemaining==0) {
			snakeMove=false;
			ladderMove=false;
			//transitionInProgress=false;
			currSnake=null;
			currLadder=null;
		}
	}
	
	public void addedToWorld() {
		setX(50);
		setY(50*(10));
	}
}
