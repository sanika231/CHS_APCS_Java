import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EndWorld extends World{
    static String sound = MyWorld.isSoundOn;
    public EndWorld(int score){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 500, 1);

        Color paddingColor = new Color(240, 226, 202);
        Color gridBckgdColor = new Color(160, 144, 120);
        Color gameBoardColor = new Color(211, 211, 211);

        GreenfootImage background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(paddingColor);
        background.fill();
        setBackground(background);
        
        int buttonDist = 130;
        Color mainTextColor;
        int fontSize = 50;

        if(MyWorld.gameOver==false){
            //win world
            if(sound=="On"){
                Greenfoot.playSound("winSound.wav");
            }
            
            mainTextColor = new Color(81,249,51);
            
            GreenfootImage image = new GreenfootImage(250, 200);
            image.setFont(new Font("Times New Roman", fontSize)); 
            image.setColor(mainTextColor);
            image.drawString("YOU WIN!", 0,50);
            getBackground().drawImage(image,getWidth()/2 - image.getWidth()/2,getHeight()/2 - image.getHeight()/2);
            
            GreenfootImage a = new GreenfootImage(155, 150);
            a.setFont(new Font("Times New Roman", fontSize*3/5)); 
            a.setColor(mainTextColor);
            a.drawString("Great Job :D", 0,fontSize*3/5);
            getBackground().drawImage(a,getWidth()/2 - a.getWidth()/2,getHeight()/2);
            
            Button b = new Button("Play Again?", 200, 50, fontSize*32/50, new Color(168,120,74), "LevelWorld");
            addObject(b,getWidth()/2- buttonDist,getHeight()/2 + a.getHeight());
            
            Button m = new Button("Back to Menu", 200, 50, fontSize*32/50, new Color(168,120,74), "MenuWorld");
            addObject(m,getWidth()/2 + buttonDist,getHeight()/2 + a.getHeight());
            
        }else{
            if(sound=="On"){
                Greenfoot.playSound("loseSound.wav");
            }
            //gameOver        
            mainTextColor = new Color(250,35,35);
            Color subTextColor = new Color(235,77,80);
            
            GreenfootImage image = new GreenfootImage(250, 200);
            image.setFont(new Font("Times New Roman", fontSize)); 
            image.setColor(mainTextColor);
            image.drawString("You Lose...", 0,50);
            getBackground().drawImage(image,getWidth()/2 - image.getWidth()/2,getHeight()/2 - image.getHeight()/2);
            
            GreenfootImage a = new GreenfootImage(270, 150);
            a.setFont(new Font("Times New Roman", fontSize*3/5)); 
            a.setColor(subTextColor);
            a.drawString("Better luck next time :(", 0,fontSize*3/5);
            getBackground().drawImage(a,getWidth()/2 - a.getWidth()/2,getHeight()/2);
            
            Button b = new Button("Play Again?", 200, 50, fontSize*32/50, new Color(168,120,74), "LevelWorld");
            addObject(b,getWidth()/2- buttonDist,getHeight()/2 + a.getHeight());
            
            Button m = new Button("Back to Menu", 200, 50, fontSize*32/50, new Color(168,120,74), "MenuWorld");
            addObject(m,getWidth()/2 + buttonDist,getHeight()/2 + a.getHeight());
        }
        
        
        //score display
        Button scoreDisplay = new Button("Score: " + score + "", getWidth()/2, getHeight()/10, 40, paddingColor, "MyWorld", Color.BLACK); 
        addObject(scoreDisplay, getWidth()/2,2*getHeight()/3); 
    }
}
