import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class CatTile extends MovingTile{
    String img;

    public CatTile(int w, int h, Color c, String i, int n) {
        color = c;
        num = n;
        img = i;
        
        tileBackground = new GreenfootImage(w, h);
        tileBackground.setColor(c);
        tileBackground.fill();
        setImage(tileBackground);
        len = tileBackground.getWidth();

        Color darkGray = new Color(104, 100, 108);
        tileText = new GreenfootImage("" + num, 54, darkGray, color);
        tileTextH = tileText.getHeight();
        tileTextW = tileText.getWidth();
    }
    
    public void addedToWorld(World l) {
        getImage().drawImage(tileText, len / 2 - tileTextW / 2, len / 2 - tileTextH / 2);
        GreenfootImage c = new GreenfootImage(img);
        c.scale(len,len);
        getImage().drawImage(c,0,0);
        worldW = getWorld().getWidth();
        worldH = getWorld().getHeight();

        w = (MyWorld)(getWorld());
        greyTiles = w.getGreyTiles();
    }
}
