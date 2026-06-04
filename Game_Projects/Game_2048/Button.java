import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor{
    String setWorld;
    String string;
    public Button(String s, int w, int h, int size, Color c, String world){
        GreenfootImage b = new GreenfootImage(w,h);
        b.setColor(c);
        //b.drawOval(0,0 ,w, h);
        b.fill();
        string = s;
        GreenfootImage str = new GreenfootImage(s, size, Color.WHITE, null);
        b.drawImage(str,b.getWidth()/2 - str.getWidth()/2,b.getHeight()/2 - str.getHeight()/2);
        setImage(b);
        setWorld = world;
    }
    
    public Button(String s, int w, int h, int size, Color c, String world, Color outline){
        GreenfootImage b = new GreenfootImage(w,h);
        b.setColor(c);
        b.fill();
        string = s;
        GreenfootImage str = new GreenfootImage(s, size, Color.WHITE, null, outline);
        b.drawImage(str,b.getWidth()/2 - str.getWidth()/2,b.getHeight()/2 - str.getHeight()/2);
        setImage(b);
        setWorld = world;
    }
    
    public Button() {
        
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this)){
            if(setWorld == "InstructionWorld"){
                Greenfoot.setWorld(new InstructionWorld());
            }else if(setWorld == "MenuWorld"){
                Greenfoot.setWorld(new MenuWorld());
            }else if(setWorld == "MyWorld"){
                Greenfoot.setWorld(new MyWorld());
            }else if(setWorld == "LevelWorld"){
                Greenfoot.setWorld(new LevelWorld());
            }else if(setWorld == "CatWorld"){
                Greenfoot.setWorld(new CatWorld());
            }else if(setWorld == "BombWorld"){
                Greenfoot.setWorld(new BombWorld());
            }else if(setWorld=="ChangeSound"){
                //System.out.println(MenuWorld.sound);
                if(MenuWorld.sound=="On"){
                    MenuWorld.sound = "Off";
                    //System.out.println(MenuWorld.sound + " entered");
                    string = "Sound: "+MenuWorld.sound;
                }else{
                    MenuWorld.sound = "On";
                    string = "Sound: "+MenuWorld.sound;
                }
                MenuWorld m = (MenuWorld)(getWorld());
                getWorld().addObject(new Button(string, 200, 50, 32, new Color(240, 226, 202), "ChangeSound"), getWorld().getWidth()/2,m.getSoundButtonY());
            }/*else if(setWorld == "EndWorld"){
                Greenfoot.setWorld(new EndWorld());
                //for testing purposes
            }*/
        }
    }
    
    public String getString(){
        return string;
    }
}
