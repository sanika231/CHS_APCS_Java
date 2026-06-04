import greenfoot.*;

public class ScoreDisplay extends Button {
    GreenfootImage s;
    public ScoreDisplay() {
       s = new GreenfootImage(100,100);
       setImage(s);
    }
    
    public void addedToWorld() {
        Button scorePopup = new Button("" + ((MyWorld)getWorld()).getScore(), getWorld().getWidth() / 2, getWorld().getHeight() / 5, 30, Color.BLACK, "MyWorld");
        setImage(scorePopup.getImage());
    }
    
    @Override public void act() {
        if(Greenfoot.mouseClicked(this)){
            getWorld().removeObject(this);
        }
    }
}
