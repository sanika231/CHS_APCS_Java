import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class MovingTile extends Tile {
    MyWorld w;
    MovingTile m;

    public Tile[][] greyTiles = new Tile[4][4];

    int worldW;
    int worldH;

    Color color;
    int num;
    int len;
    int speed = 20;

    GreenfootImage tileBackground;
    GreenfootImage tileText;
    int tileTextH;
    int tileTextW;

    int paddingAroundGrid; 
    int paddingAroundTiles;  

    int frame = 0;
    Tile target;

    String keyDown = null;
    int score;
    
    public MovingTile() {

    }

    public MovingTile(int w, int h, Color c, int n) {
        color = c;
        num = n;

        tileBackground = new GreenfootImage(w, h);
        tileBackground.setColor(c);
        tileBackground.fill();
        setImage(tileBackground);
        len = tileBackground.getWidth();

        Color darkGray = new Color(104, 100, 108);
        tileText = new GreenfootImage("" + num, 54, darkGray, color);
        tileTextH = tileText.getHeight();
        tileTextW = tileText.getWidth();
    }

    public void addedToWorld(World l) {
        getImage().drawImage(tileText, len / 2 - tileTextW / 2, len / 2 - tileTextH / 2);        
        worldW = getWorld().getWidth();
        worldH = getWorld().getHeight();

        w = (MyWorld)(getWorld());
        greyTiles = w.getGreyTiles();
    }

    public void act() {
        score = w.getScore(); 
        
        List<Tile> tilesAtCurrLocation = getWorld().getObjectsAt(getX(), getY(), Tile.class);
        Tile grayTileCurrentlyAbove;
        int row = -1;
        int col = -1;
        boolean merged = false;

        for (int i = 0; i < tilesAtCurrLocation.size(); i++) {
            if (getIndexOfTileInGreyTiles(tilesAtCurrLocation.get(i)) != null)  {
                row = getRowOfTile(tilesAtCurrLocation.get(i));
                col = getColOfTile(tilesAtCurrLocation.get(i));

                grayTileCurrentlyAbove = greyTiles[row][col];
            }
        }

        // if @ target, reset target to null
        if (target != null && Math.abs(getX() - target.getX()) < speed && Math.abs(getY() - target.getY()) < speed) {
            setLocation(target.getX(), target.getY());

            MovingTile intersectingMT = (MovingTile)getOneIntersectingObject(MovingTile.class);
            if (intersectingMT != null && intersectingMT.getX() == getX() && intersectingMT.getY() == getY()) {
                onMerge(intersectingMT);
            }

            target = null;
            
            if (target == null || (target.getX() == getX() && target.getY() == getY())){
                keyDown = null; 
                target = null;
                return;
            }

        }

        // if target present, head toward target in increments (creates 'sliding' effect)
        if (target != null) {
            // target should only ever be vertically or horizontally away, never diagnoal
            if (target.getX() != getX()) { // move HORIZONTALLY
                if (target.getX() > getX()) {
                    setLocation(getX() + speed, getY());
                } else if (target.getX() < getX()) {
                    setLocation(getX() - speed, getY());
                }
            } else if (target.getY() != getY()) { // move VERTICALLY
                if (target.getY() > getY()) {
                    setLocation(getX(), getY() + speed);
                } else if (target.getY() < getY()) {
                    setLocation(getX(), getY() - speed);
                }
            }
        }

        if (keyDown == null){
            keyDown = w.getCurrentKey();

        }
        //if do not have target, then sets target when key pressed
        if (target == null && keyDown != null) {
            findTarget(row, col); 
            if (target != null) {
                w.setMovementInProgress(true);
            }
        }
        frame++;
    }

    public void findTarget(int row, int col){
        if (row == -1 || col == -1) {
            return;
        }

        if (keyDown.equals("DOWN")) {
            int coveredCount = 0; //num of grey tiles covered by MovingTile
            for (int r = row + 1; r < greyTiles.length; r++) {
                if (greyTiles[r][col].isCoveredByMovingTile()) {
                    coveredCount++;
                }
            }
            target = greyTiles[greyTiles.length - 1 - coveredCount][col];
            merge(coveredCount, row, col,"Down");
            
        } else if (keyDown.equals("UP")) {
            int coveredCount = 0; //num of grey tiles covered by MovingTile
            for (int r = row-1; r >= 0; r--) {
                if (greyTiles[r][col].isCoveredByMovingTile()) {
                    coveredCount++;
                }
            }
            target = greyTiles[coveredCount][col];
            merge(coveredCount, row, col,"Up"); 

        } else if (keyDown.equals("RIGHT")) {
            int coveredCount = 0; //num of grey tiles covered by MovingTile
            for (int c = col+1 ; c < greyTiles.length; c++) {
                if (greyTiles[row][c].isCoveredByMovingTile()) {
                    coveredCount++;
                }
            }
            target = greyTiles[row][greyTiles.length - 1 - coveredCount];
            merge(coveredCount, row, col,"Right"); 

        } else if (keyDown.equals("LEFT")) {
            int coveredCount = 0; //num of grey tiles covered by MovingTile
            for (int c = col-1 ; c >= 0; c--) {
                if (greyTiles[row][c].isCoveredByMovingTile()) {
                    coveredCount ++;
                }
            }
            target = greyTiles[row][coveredCount];
            merge(coveredCount, row, col,"Left");
            
        }
    }

    public MovingTile getMovingTileAt(Tile t) {
        List<MovingTile> mts = getWorld().getObjectsAt(t.getX(), t.getY(), MovingTile.class);
        if (mts.isEmpty()) {
            return null;
        }
        return mts.get(0);
    }

    public void merge(int coveredCount, int row, int col, String direction){
        //System.out.println("col: " + col); 
        List<MovingTile> possibleMovingTiles; 
        if (direction.equals("Left")){
            possibleMovingTiles= w.getObjectsAt(getX() - len - paddingAroundTiles, getY(), MovingTile.class); 
        } else if (direction.equals("Right")){
            possibleMovingTiles= w.getObjectsAt(getX() + len + paddingAroundTiles, getY(), MovingTile.class); 
        } else if (direction.equals("Up")){
            possibleMovingTiles= w.getObjectsAt(getX(), getY() - len - paddingAroundTiles, MovingTile.class); 
        } else if (direction.equals("Down")){
            possibleMovingTiles= w.getObjectsAt(getX(), getY() + len + paddingAroundTiles, MovingTile.class); 
        }else{
            possibleMovingTiles= null; 
        }

        if (!possibleMovingTiles.isEmpty()){
            MovingTile possibleMovingTile = possibleMovingTiles.get(0); 
            int possibleTileNumber = possibleMovingTile.getNum(); 
            
            if (num == possibleTileNumber){
                if (coveredCount!=0){
                    if (direction.equals("Left")){
                        target = greyTiles[row][coveredCount-1]; 
                    } else if (direction.equals("Right")){
                        target = greyTiles[row][greyTiles.length - coveredCount]; 
                    } else if (direction.equals("Down")){
                        target = greyTiles[greyTiles.length - coveredCount][col]; 
                    } else{
                        target = greyTiles[coveredCount-1][col]; 
                    }
                }

            }

        }
    }

    public void onMerge(MovingTile t){
        if (num != 0 && t.getNum() != 0) {
            List<MovingTile> allMovingTiles = w.getObjects(MovingTile.class); 
            w.addMovingNumTile(num*2, getX(), getY());
            score += (num*2);
            w.setScore(score); 
            
            w.removeObject(t);
            w.removeObject(this);        
        }
    }

    public int getRowOfTile(Tile t) { // in greyTiles
        String position = getIndexOfTileInGreyTiles(t);
        int indexOfComma = position.indexOf(",");
        String row = position.substring(0, indexOfComma);
        return Integer.parseInt(row);
    }

    public int getColOfTile(Tile t) { // in greyTiles
        String position = getIndexOfTileInGreyTiles(t);
        int indexOfComma = position.indexOf(",");
        String col = position.substring(indexOfComma+1);
        return Integer.parseInt(col);
    }

    public String getIndexOfTileInGreyTiles(Tile t) { // returns i,j or null
        for (int row = 0; row < greyTiles.length; row++) {
            for (int col = 0; col < greyTiles[row].length; col++) {
                if (greyTiles[row][col].equals(t)) {
                    return row + "," + col;
                }
            }
        }
        return null;
    }

    public int getNum() {
        return num; 
    }

    public Tile getTarget() {
        return target;
    }
}