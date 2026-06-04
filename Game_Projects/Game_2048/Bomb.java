import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Bomb extends MovingTile {
    int count = 0; 

    public Bomb(int w, int h) {
        num = 0;
        color = new Color(211, 211, 211);

        tileBackground = new GreenfootImage(w, h);
        tileBackground.setColor(color);
        tileBackground.fill();
        setImage(tileBackground);
        len = tileBackground.getWidth();

        Color darkGray = new Color(104, 100, 108);
        tileText = new GreenfootImage("" + num, 54, darkGray, color);
        tileTextH = tileText.getHeight();
        tileTextW = tileText.getWidth();
    }

    public void addedToWorld(World l) {
        //getImage().drawImage(tileText, len / 2 - tileTextW / 2, len / 2 - tileTextH / 2);
        GreenfootImage c = new GreenfootImage("bomb.png");
        getImage().drawImage(c,len / 2 - c.getWidth() / 2, len / 2 - c.getHeight() / 2);

        worldW = getWorld().getWidth();
        worldH = getWorld().getHeight();

        w = (MyWorld)(getWorld());
        greyTiles = w.getGreyTiles();
    }

    public void act(){ 
        MovingTile mt = (MovingTile)getOneIntersectingObject(MovingTile.class);
        if (mt != null) {
            int currTransp = mt.getImage().getTransparency();
            int newTransp = (int)(currTransp * 0.7);
            mt.getImage().setTransparency(newTransp);
            if (newTransp < 0.10 * 255) {
                getWorld().removeObject(mt);
            }
        }
        
        if (Greenfoot.mouseClicked(this)){
            //System.out.println("clicked"); 
            onClick(); 
        }
    }

    public void onClick(){
        //delete all tiles in the same row and same column; 
        MyWorld w = (MyWorld)(getWorld());

        int tileLen = w.getTileLen(); 

        //decide removing vertical/horizontal
        boolean removeVertical = false; 
        int random = Greenfoot.getRandomNumber(2); 
        if (random == 1){
            removeVertical = true; 
        }

        // add tileLen to the currentY value each time to check if there is 
        // a movingTile actor present; if there is, remove the object.

        /*if (removeVertical){
            System.out.println("removed vt"); 
        } else{
            System.out.println("removed hz"); 
        }*/
    
        if (!removeVertical){
            int bombY = this.getY();

            List<MovingTile> allMovingTiles = getWorld().getObjects(MovingTile.class); 
            List<Tile> greyTiles = getWorld().getObjects(Tile.class);
            for(int i=0;i<allMovingTiles.size();i++){
                if(allMovingTiles.get(i)!=this){
                    if(bombY==allMovingTiles.get(i).getY()){
                        getWorld().removeObject(allMovingTiles.get(i)); 
                    }
                }
            }
            //checking rows below
            /*while (checkingRowYVal<getWorld().getHeight()){
            Actor possibleMovingTile = getOneObjectAtOffset(0, checkingRowYVal, MovingTile.class); 
            if (possibleMovingTile!=null){
            getWorld().removeObject(possibleMovingTile); 
            }

            checkingRowYVal+=tileLen; 
            }
            checkingRowYVal = this.getY(); 
            //checking rows above
            while (checkingRowYVal>0){
            Actor possibleMovingTile = getOneObjectAtOffset(0, checkingRowYVal, MovingTile.class); 
            if (possibleMovingTile!=null){
            getWorld().removeObject(possibleMovingTile); 
            }

            checkingRowYVal-=tileLen; 
            }*/
        } else{

            int bombX = this.getX(); 

            List<MovingTile> allMovingTiles = getWorld().getObjects(MovingTile.class); 
            List<Tile> greyTiles = getWorld().getObjects(Tile.class);
            for(int i=0;i<allMovingTiles.size();i++){
                if(allMovingTiles.get(i)!=this){
                    if(bombX==allMovingTiles.get(i).getX()){
                        getWorld().removeObject(allMovingTiles.get(i)); 
                    }
                }
            }
            //checking col left: same logic
            /*while (checkingColXVal>0){
            Actor possibleMovingTile = getOneObjectAtOffset(checkingColXVal, 0, MovingTile.class); 
            if (possibleMovingTile!=null){
            getWorld().removeObject(possibleMovingTile); 
            }

            checkingColXVal-=tileLen; 
            }

            //right
            while (checkingColXVal<getWorld().getWidth()){
            Actor possibleMovingTile = getOneObjectAtOffset(checkingColXVal, 0, MovingTile.class); 
            if (possibleMovingTile!=null){
            getWorld().removeObject(possibleMovingTile); 
            }

            checkingColXVal+=tileLen; 
            }*/
        }
        getWorld().removeObject(this); 
    }
}
