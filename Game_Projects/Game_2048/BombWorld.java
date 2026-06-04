import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class BombWorld extends MyWorld{
    public BombWorld(){
        super();

    }
    
    public void act(){
        super.act();
        List<Bomb> b = this.getObjects(Bomb.class);
        if(Greenfoot.getRandomNumber(100)==1 && b.size()==0){
            addBomb();
        }
    }
    
    public void addBomb(){ 
        int random = getRandomPair(); 
        Bomb b = new Bomb(tileLen, tileLen); 
        addObject(b, getXTileValue(random), getYTileValue(random)); 
        
    }
}
