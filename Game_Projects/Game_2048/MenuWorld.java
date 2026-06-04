import greenfoot.*;
// import java.awt.Font;

public class MenuWorld extends World{
    Color paddingColor;
    Color gridBckgdColor;
    GreenfootImage t;
    int bestScore = 0;
    int highestMoves = 0;
    public static String sound = "On";
    
    public MenuWorld(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 500, 1); 
        paddingColor = new Color(240, 226, 202);
        gridBckgdColor = new Color(160, 144, 120);
        
        GreenfootImage background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(gridBckgdColor);
        background.fill();
        setBackground(background);
        int headerFontSize = 100;

        t = new GreenfootImage("2", headerFontSize, MyWorld.COLOR2, null);
        getBackground().drawImage(t,getWidth()/2 - 2*t.getWidth(), getHeight()/8);

        GreenfootImage z = new GreenfootImage("0", headerFontSize, Color.WHITE, null);
        getBackground().drawImage(z,getWidth()/2 - z.getWidth(), getHeight()/8);

        GreenfootImage f = new GreenfootImage("4", headerFontSize, MyWorld.COLOR4, null);
        getBackground().drawImage(f,getWidth()/2, getHeight()/8);

        GreenfootImage e = new GreenfootImage("8", headerFontSize, MyWorld.COLOR8, null);
        getBackground().drawImage(e,getWidth()/2 + t.getWidth(), getHeight()/8);

        GreenfootImage g = new GreenfootImage("Game", 85*headerFontSize/100, MyWorld.COLOR16, null);

        //tried to change font
        /*GreenfootImage g = new GreenfootImage(t.getWidth(),t.getHeight());
        Font titleFont = new Font("Times New Roman", true ,true, 85);
        g.setFont(titleFont);
        g.drawString("Game",t.getWidth(),t.getHeight());
        g.setColor(MyWorld.COLOR16);*/

        getBackground().drawImage(g,getWidth()/2 - g.getWidth()/2, getHeight()/3);

        drawButtons();

    }

    public void drawButtons(){
        Button b = new Button("PLAY", 200, 50, 32, paddingColor, "LevelWorld");
        addObject(b,getWidth()/2,getHeight()/2 + t.getHeight()/2);
        /*int x = b.getX()+b.getImage().getWidth()/4;
        int y = b.getY()-b.getImage().getHeight()/2;

        for(int i=0;i<2;i++){

        GreenfootImage a = new GreenfootImage(50,50);
        a.setColor(Color.GREEN);
        a.fillOval(0,0,50,50);
        //a.fill();
        getBackground().drawImage(a,x,y);

        GreenfootImage c = new GreenfootImage(25,25);
        c.setColor(gridBckgdColor);
        c.fill();
        getBackground().drawImage(c,b.getX()+b.getImage().getWidth()/3+12, y-b.getImage().getHeight()/3);

        }

        //removeObject(b);
         */
        
        addObject(new Button("HOW TO PLAY", 200, 50, 32, paddingColor, "InstructionWorld"), getWidth()/2,getHeight()/2 + t.getHeight());
        
        GreenfootImage p = new GreenfootImage("Project by: Sanika Thatte, Ziya Ahmad, Irene Yang", 20, Color.WHITE, null);
        getBackground().drawImage(p,getWidth()/2 - p.getWidth()/2,getHeight()/2 +4*b.getImage().getHeight());
        
        addObject(new Button("Sound: "+sound, 200, 50, 32, paddingColor, "ChangeSound"), getWidth()/2,getHeight()/2 + t.getHeight()+t.getHeight()/2 +1);
        
        //testing
        //Button c = new Button("EndWorld", 200, 50, 32, paddingColor, "EndWorld");
        //addObject(c,50,50);
    }
    
    public void setScore(int s){
        bestScore = s; 
    }
    public int getScore(){
        return bestScore; 
    }
    public int getSoundButtonY(){
        return getHeight()/2 + t.getHeight()+t.getHeight()/2 +1;
    }
}
