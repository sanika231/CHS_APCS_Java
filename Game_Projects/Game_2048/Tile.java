import greenfoot.*;

public class Tile extends Actor {
    GreenfootImage img;
    
    int tileW;
    int tileH;
    
    public Tile() {
        img = new GreenfootImage(3, 3);
        img.setColor(Color.GRAY);
        img.fill();
        setImage(img);
        
        tileW = getImage().getWidth();
        tileH = getImage().getHeight();
    }
    
    public Tile(int w, int h, Color color) {
        img = new GreenfootImage(w,h);
        img.setColor(color);
        img.fill();

        setImage(img);
        
        tileW = getImage().getWidth();
        tileH = getImage().getHeight();
    }
    
    public void act() {
        
    }
    
    public boolean isCoveredByMovingTile() {
        if (!getWorld().getObjectsAt(getX(), getY(), MovingTile.class).isEmpty()) {
            return true;
        }
        return false;
    }
}