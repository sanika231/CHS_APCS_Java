import greenfoot.*;

public class InstructionWorld extends World {
    Color buttonColor = new Color(240, 226, 202);
    Color gridBckgdColor = new Color(160, 144, 120);
    Color bulletColor = Color.WHITE;
    Color paddingColor = new Color(240, 226, 202);
    
    int worldW;
    int worldH;
    
    int paddingBetweenBullets = 25;
    int bulletFontSize = 25;
    int headerFontSize = 50;
    public InstructionWorld() {    
        super(500, 500, 1);
        
        worldW = getWidth();
        worldH = getHeight();
                
        GreenfootImage background = new GreenfootImage(worldW, worldH);
        background.setColor(gridBckgdColor);
        background.fill();
        setBackground(background);

        GreenfootImage topText = new GreenfootImage("How to Play", headerFontSize, MyWorld.COLOR1024, gridBckgdColor);
        getBackground().drawImage(topText, worldW / 2 - topText.getWidth() / 2, worldH / 10 - topText.getHeight() / 2);
        
        GreenfootImage bullet1 = new GreenfootImage("• use the arrow keys to slide the tiles", bulletFontSize, bulletColor, gridBckgdColor);
        int bulletX = worldW / 2 - bullet1.getWidth() / 2;
        getBackground().drawImage(bullet1, bulletX, (int)(worldH / 10 - topText.getHeight() / 2 + bullet1.getHeight() + paddingBetweenBullets*1.5));
    
        GreenfootImage bullet2 = new GreenfootImage("• when two tiles with the same number", bulletFontSize, bulletColor, gridBckgdColor);
        getBackground().drawImage(bullet2, bulletX, (int)(worldH / 10 - topText.getHeight() / 2 + bullet1.getHeight()*2 + paddingBetweenBullets * 2));
    
        GreenfootImage bullet2Continued = new GreenfootImage("   they touch & combine into one", bulletFontSize, bulletColor, gridBckgdColor);
        getBackground().drawImage(bullet2Continued, bulletX, (int)(worldH / 10 - topText.getHeight() / 2 + bullet1.getHeight() * 3 + paddingBetweenBullets * 2.25));
    
        GreenfootImage bullet3 = new GreenfootImage("• a new tile appears after every move", bulletFontSize, bulletColor, gridBckgdColor);
        getBackground().drawImage(bullet3, bulletX, (int)(worldH / 10 - topText.getHeight() / 2 + bullet1.getHeight() * 4 + paddingBetweenBullets * 2.5));
    
        GreenfootImage bullet4 = new GreenfootImage("• you lose if the board fills up and you", bulletFontSize, bulletColor, gridBckgdColor);
        getBackground().drawImage(bullet4, bulletX, (int)(worldH / 10 - topText.getHeight() / 2 + bullet1.getHeight() * 5 + paddingBetweenBullets * 2.75));
    
        GreenfootImage bullet5 = new GreenfootImage("  can't make any more moves", bulletFontSize, bulletColor, gridBckgdColor);
        getBackground().drawImage(bullet5, bulletX, (int)(worldH / 10 - topText.getHeight() / 2 + bullet1.getHeight() * 6 + paddingBetweenBullets * 3));
    
        GreenfootImage bullet6 = new GreenfootImage("• you win once you get to 2048! ", bulletFontSize, bulletColor, gridBckgdColor);
        getBackground().drawImage(bullet6, bulletX, (int)(worldH / 10 - topText.getHeight() / 2 + bullet1.getHeight() * 7 + paddingBetweenBullets * 3.25));
        
        GreenfootImage bullet7 = new GreenfootImage("• Bombs: once bomb spawned, click on", bulletFontSize, bulletColor, gridBckgdColor);
        getBackground().drawImage(bullet7, bulletX, (int)(worldH / 10 - topText.getHeight() / 2 + bullet1.getHeight() * 7 + paddingBetweenBullets * 4.75));

        GreenfootImage bullet8 = new GreenfootImage("  the bomb to remove a row or column", bulletFontSize, bulletColor, gridBckgdColor);
        getBackground().drawImage(bullet8, bulletX, (int)(worldH / 10 - topText.getHeight() / 2 + bullet1.getHeight() * 7 + paddingBetweenBullets * 6));
        
        GreenfootImage bullet9 = new GreenfootImage("• Cats: original world, but with cute cats :)", bulletFontSize, bulletColor, gridBckgdColor);
        getBackground().drawImage(bullet9, bulletX, (int)(worldH / 10 - topText.getHeight() / 2 + bullet1.getHeight() * 7 + paddingBetweenBullets * 7.25));
        
        GreenfootImage bullet10 = new GreenfootImage("Enjoy Playing!", (int)(bulletFontSize*1.5), MyWorld.COLOR256, gridBckgdColor);
        getBackground().drawImage(bullet10, getWidth()/2 - bullet10.getWidth()/2, (int)(worldH / 10 - topText.getHeight() / 2 + bullet1.getHeight() * 7 + paddingBetweenBullets * 9.5));
        
        Button back = new Button("BACK", getWidth()/4, getHeight()/10, headerFontSize, paddingColor, "MenuWorld", Color.BLACK);
        addObject(back, back.getImage().getWidth()/2, getHeight() - back.getImage().getHeight()/2);
        
        Button play = new Button("PLAY", getWidth()/4, getHeight()/10, headerFontSize, paddingColor, "LevelWorld", Color.BLACK);
        addObject(play, getWidth()-back.getImage().getWidth()/2, getHeight() - back.getImage().getHeight()/2);
        
        //String s, int w, int h, int size, Color c, World world
        //Button back = new Button("BACK", worldW / 5, worldH / 9, bulletFontSize, buttonColor, new MenuWorld());
        //addObject(back, worldW / 2, worldH / 2);
    }
}
