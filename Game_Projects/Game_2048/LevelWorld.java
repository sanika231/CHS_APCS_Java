import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelWorld extends World{
    public static String sound;
    public LevelWorld(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 500, 1); 
        Color paddingColor = new Color(240, 226, 202);
        Color gridBckgdColor = new Color(160, 144, 120);
        
        GreenfootImage background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(gridBckgdColor);
        background.fill();
        setBackground(background);
        
        int bulletFontSize = 32;
        Color bulletColor = Color.WHITE;
        
        //easy - original
        //medium - twos taken out every minute
        //bombs - bomb world
        
        GreenfootImage t = new GreenfootImage("Levels", 100, MyWorld.COLOR1024, null);
        getBackground().drawImage(t,getWidth()/2-t.getWidth()/2,t.getHeight()/2);
        
        Button e = new Button("Easy", 200, 50, 32, paddingColor, "MyWorld");
        addObject(e,getWidth()/2,getHeight()/2-e.getImage().getHeight()/2);
        
        Button m = new Button("Cats", 200, 50, 32, paddingColor, "CatWorld");
        addObject(m,getWidth()/2,getHeight()/2+e.getImage().getHeight()/2+1);
        
        Button b = new Button("Bombs", 200, 50, 32, paddingColor, "BombWorld");
        addObject(b,getWidth()/2,getHeight()/2+e.getImage().getHeight()+e.getImage().getHeight()/2+2);
    
        GreenfootImage bullet1 = new GreenfootImage("• press 'r' to reset game", bulletFontSize* 9/10, bulletColor, gridBckgdColor);
        int bulletX = getWidth() / 2 - bullet1.getWidth() / 2;
        getBackground().drawImage(bullet1, bulletX,(int)(getHeight()/2+2.25*e.getImage().getHeight()));
    
        //GreenfootImage bullet2 = new GreenfootImage("• press 's' to open score popup", bulletFontSize * 9/10, bulletColor, gridBckgdColor);
        //int bullet2X = getWidth() / 2 - bullet2.getWidth() / 2;
        //getBackground().drawImage(bullet2, bullet2X,(int)(getHeight()/2+3.25*e.getImage().getHeight()));
    
        GreenfootImage bullet3 = new GreenfootImage("• score is shown at the end", bulletFontSize* 9/10, bulletColor, gridBckgdColor);
        int bullet3X = getWidth() / 2 - bullet3.getWidth() / 2;
        getBackground().drawImage(bullet3, bullet3X, (int)(getHeight() / 2 + 3.25 * e.getImage().getHeight()));
        //getBackground().drawImage(bullet3, bullet3X, (int)(getHeight() / 2 + 4.25 * e.getImage().getHeight()));
        
        sound = MenuWorld.sound;
    }
}
