import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class MyWorld extends World {
    final static Color COLOR2 = new Color(240, 228, 220);
    final static Color COLOR4 = new Color(240, 220, 180);
    final static Color COLOR8 = new Color(248, 180, 116);
    final static Color COLOR16 = new Color(252, 152, 104);
    final static Color COLOR32 = new Color(248, 124, 100);
    final static Color COLOR64 = new Color(248, 92, 60);
    final static Color COLOR128 = new Color(240, 204, 116);
    final static Color COLOR256 = new Color(240, 204, 100);
    final static Color COLOR512 = new Color(240, 204, 84);
    final static Color COLOR1024 = new Color(240, 196, 60);
    final static Color COLOR2048 = new Color(240, 196, 44);

    public static boolean gameOver = false;
    private boolean isMoving = false;
    private boolean keyProcessing = false;
    private String currentKey = null;

    Color gridBckgdColor;
    Color paddingColor;
    Color gameBoardColor;

    int worldW;
    int worldH;
    final static int TILES_PER_ROW = 4;

    int paddingAroundGrid; // buffer space between grid bckgd and world bckd
    int paddingAroundTiles;
    int tileLen;
    public Tile gridBackground;

    List<Integer> backgroundTilesXValue = new ArrayList<>(); 
    List<Integer> backgroundTilesYValue = new ArrayList<>(); 
    List<Tile> gameboardTiles = new ArrayList<>();

    int currentScore = 0; 
    int currentMoveCount = 0; 
    List<Integer> numbers;
    List<MovingTile> m;

    int count = 0;
    public Tile[][] greyTiles = new Tile[4][4];
    Button scoreDisplay; 

    int score = 0; 
    String sound = getSound();
    static String isSoundOn;

    int frame = 0;
    boolean onCooldown = false; // if on cooldown, user can't input another key command
    int cooldownDuration = 17;

    public MyWorld() {
        super(500, 500, 1);

        // initializing variables
        worldW = getWidth();
        worldH = getHeight();

        gridBckgdColor = new Color(160, 144, 120);
        paddingColor = new Color(240, 226, 202);
        gameBoardColor = new Color(211, 211, 211);

        paddingAroundGrid = 25;
        paddingAroundTiles = 10;

        // setting up world layout
        GreenfootImage background = new GreenfootImage(worldW, worldH);
        background.setColor(paddingColor);
        background.fill();
        setBackground(background);

        gridBackground = new Tile(worldW - 2 * paddingAroundGrid, worldH - 2 * paddingAroundGrid, gridBckgdColor);
        addObject(gridBackground, worldW / 2, worldH / 2);

        tileLen = (gridBackground.getImage().getHeight() - (TILES_PER_ROW + 1) * paddingAroundTiles) / TILES_PER_ROW;

        int gameBoardX = tileLen / 2 + paddingAroundGrid + paddingAroundTiles;
        for (int i = 0; i < TILES_PER_ROW; i++) { // using TILES_PER_ROW for columns b/c they are equal
            makeRowOfTiles(gameBoardX, gameBoardX + paddingAroundTiles * i + tileLen * i, gameBoardColor, TILES_PER_ROW, tileLen, tileLen, i);
        }

        addMovingNumTile(2, gameBoardX + paddingAroundTiles + tileLen, worldH - gameBoardX - paddingAroundTiles - tileLen);
        addMovingNumTile(4, gameBoardX + paddingAroundTiles + tileLen, gameBoardX);
        addMovingNumTile(4, gameBoardX + 2*paddingAroundTiles + 2*tileLen, gameBoardX + 2*paddingAroundTiles + 2*tileLen);
        addMovingNumTile(2, worldW - gameBoardX, worldH - gameBoardX); 
        addMovingNumTile(2, gameBoardX + 2*paddingAroundTiles + 2*tileLen, worldH - gameBoardX); 

        //t = getObjects(Tile.class);
        MyWorld.isSoundOn = LevelWorld.sound;
        
        setUpTiles();
        List<MovingTile> allMovingTiles = getObjects(MovingTile.class); 
    }

    public void setUpTiles() {
        int r1 = Greenfoot.getRandomNumber(greyTiles.length);
        int c1 = Greenfoot.getRandomNumber(greyTiles.length);
        addMovingNumTile(2, greyTiles[r1][c1].getX(), greyTiles[r1][c1].getY());
        
        int r2 = Greenfoot.getRandomNumber(greyTiles.length);
        int c2 = Greenfoot.getRandomNumber(greyTiles.length);
        while (r2 == r1 && c2 == c1) { // make sure the 2 tiles dont go on the same spot
            r2 = Greenfoot.getRandomNumber(greyTiles.length);
            c2 = Greenfoot.getRandomNumber(greyTiles.length);
        }
        addMovingNumTile(2, greyTiles[r2][c2].getX(), greyTiles[r2][c2].getY());
    }
    
    public void act() {
        if (frame % cooldownDuration == 0) {
            onCooldown = false;
        }

        if (Greenfoot.isKeyDown("r")) {
            Greenfoot.setWorld(new LevelWorld());
        }

        if (Greenfoot.isKeyDown("s") && getObjects(ScoreDisplay.class).isEmpty()){
            ScoreDisplay sd = new ScoreDisplay();
            addObject(sd, worldW / 2, worldH / 2);
        } else {
            if (!getObjects(ScoreDisplay.class).isEmpty()) {
                removeObject(getObjects(ScoreDisplay.class).get(0));
            }
        }

        if (allTilesReachedTarget()) {
            isMoving = false;
        } else {
            isMoving = true;
        }

        m = getObjects(MovingTile.class);
        for(int i=0;i<m.size();i++){
            if(m.get(i).getNum()==2048){
                gameOver = false;
                if(isMoving==false){
                    Greenfoot.delay(50);
                    Greenfoot.setWorld(new EndWorld(score));
                }
            }
        }

        gameOver = isGameOver();
        if(gameOver){
            if(isMoving==false){
                Greenfoot.delay(50);
                Greenfoot.setWorld(new EndWorld(score));
            }
        }

        if (!isMoving && !onCooldown) {
            if (Greenfoot.isKeyDown("UP")) {
                currentKey = "UP";
                if(MyWorld.isSoundOn=="On"){
                    Greenfoot.playSound(sound);
                }
                addRandomTile();
                onCooldown = true;
            } else if (Greenfoot.isKeyDown("DOWN")) {
                currentKey = "DOWN";   
                if(MyWorld.isSoundOn=="On"){
                    Greenfoot.playSound(sound);
                }
                addRandomTile();
                onCooldown = true;
            } else if (Greenfoot.isKeyDown("LEFT")) {
                currentKey = "LEFT";
                if(MyWorld.isSoundOn=="On"){
                    Greenfoot.playSound(sound);
                }
                addRandomTile();
                onCooldown = true;
            }else if (Greenfoot.isKeyDown("RIGHT")) {
                currentKey = "RIGHT";
                if(MyWorld.isSoundOn=="On"){
                    Greenfoot.playSound(sound);
                } 
                addRandomTile();
                onCooldown = true;
            }
        } else {
            currentKey = null; // disable input while tiles are moving
        }

        frame++;
    }

    //check if all tiles are full and no more movement is possible
    //must figure out movement/target setting issues before adding feature
    public boolean allTilesReachedTarget() {
        List<MovingTile> allTiles = getObjects(MovingTile.class);
        for (int i = 0; i < allTiles.size(); i++) {
            if (allTiles.get(i).getTarget() != null) {
                return false;
            }
        }
        return true;
    }

    public void makeRowOfTiles(int x, int y, Color c, int num, int w, int h, int i) {
        for (int j = 0; j < num; j++) {
            Tile t = new Tile(w, h, c);
            int xVal = x + paddingAroundTiles*j + w*j; 
            addObject(t, xVal, y);

            greyTiles[i][j] = t;

            //store all the x and y values of the background gameboard; used in 
            gameboardTiles.add(t);
            backgroundTilesXValue.add(xVal); 
            backgroundTilesYValue.add(y); 
        }
    }

    public void addMovingNumTile(int number, int x, int y) {
        MovingTile mt = new MovingTile(tileLen, tileLen, getColor(number), number);
        addObject(mt, x, y);
    }

    public int getPaddingAroundTiles(){
        return paddingAroundTiles; 
    }

    public int getPaddingAroundGrid(){
        return paddingAroundGrid;
    }

    public Color getColor(int number) {
        if (number == 2) {
            return COLOR2;
        } else if (number == 4) {
            return COLOR4;
        } else if (number == 8) {
            return COLOR8;
        } else if (number == 16) {
            return COLOR16;
        } else if (number == 32) {
            return COLOR32;
        } else if (number == 64) {
            return COLOR64;
        } else if (number == 128) {
            return COLOR128;
        } else if (number == 256) {
            return COLOR256;
        } else if (number == 512) {
            return COLOR512;
        } else if (number == 1024) {
            return COLOR1024;
        } else if (number == 2048) {
            return COLOR2048;
        }
        return Color.GREEN; // return green so that it doesnt throw an error
    }

    public int getRandomPair(){
        int random = Greenfoot.getRandomNumber(backgroundTilesXValue.size()); 
        List<Tile> t = getObjectsAt(backgroundTilesXValue.get(random), backgroundTilesYValue.get(random), Tile.class); 

        //if there are more than two tiles on the same x and y values, (moving + background)
        //reassign it until there is only one tile present
        while (t.size()>2){
            random = Greenfoot.getRandomNumber(backgroundTilesXValue.size()); 
            t = getObjectsAt(backgroundTilesXValue.get(random), backgroundTilesYValue.get(random), Tile.class); 
        }
        return random; 
    }

    public int getXTileValue(int r){
        return backgroundTilesXValue.get(r); 
    }

    public int getYTileValue(int r){
        return backgroundTilesYValue.get(r); 
    }

    public void addRandomTile(){
        List<MovingTile> mt = getObjects(MovingTile.class);
        if(mt.size()<16){
            //pick a random x&y pair of the tiles in the gameboard
            int random = getRandomPair(); 

            int n; 
            int chance = Greenfoot.getRandomNumber(2); 
            if (chance == 0) {
                n=2;
            }else{
                n=4;
            }

            addMovingNumTile(n, backgroundTilesXValue.get(random), backgroundTilesYValue.get(random)); 
        }
    }

    public boolean isGameOver(){
        List<MovingTile> mt = getObjects(MovingTile.class); 
        if (mt.size() != 16){
            return false;
        } 

        // size is 16
        //checks if full and returns if game over
        for(int i=0;i<mt.size();i++){
            MovingTile curr = mt.get(i);
            List<MovingTile> leftMt = getObjectsAt(curr.getX()-tileLen-paddingAroundTiles,curr.getY(), MovingTile.class);
            List<MovingTile> rightMt = getObjectsAt(curr.getX()+tileLen+paddingAroundTiles,curr.getY(), MovingTile.class);
            List<MovingTile> upMt = getObjectsAt(curr.getX(), curr.getY()-tileLen-paddingAroundTiles, MovingTile.class);
            List<MovingTile> downMt = getObjectsAt(curr.getX(), curr.getY()+tileLen+paddingAroundTiles, MovingTile.class);
            if (!leftMt.isEmpty()){
                if(leftMt.get(0).getNum() == curr.getNum()){
                    return false;
                }
            }
            if (!rightMt.isEmpty()){
                if(rightMt.get(0).getNum() == curr.getNum()){
                    return false;
                }
            }
            if (!upMt.isEmpty()){
                if(upMt.get(0).getNum() == curr.getNum()){
                    return false;
                }
            }
            if (!downMt.isEmpty()){
                if(downMt.get(0).getNum() == curr.getNum()){
                    return false;
                }
            }
        }
        return true;
    }

    public Tile[][] getGreyTiles() {
        return greyTiles;
    }

    public void setCurrentMoveCount(int m){
        currentMoveCount = m; 
    }

    public int getCurrentMoveCount(){
        return currentMoveCount; 
    }

    public int getTileLen(){
        return tileLen; 
    }

    public boolean isMovementInProgress() {
        return isMoving;
    }

    public void setMovementInProgress(boolean m) {
        isMoving = m;
    }

    public String getCurrentKey() {
        return currentKey;
    }

    public void setScore(int s){
        score = s; 
    }

    public int getScore(){
        return score; 
    }

    public String getSound() {
        return "tileMovingSound.wav";
    }
}