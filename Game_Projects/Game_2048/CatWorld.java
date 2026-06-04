import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class CatWorld extends MyWorld{
    final static String Cat2 = "Cat2.jpg";
    final static String Cat4 = "Cat4.jpg";
    final static String Cat8 = "Cat8.jpg";
    final static String Cat16 = "Cat16.jpg";
    final static String Cat32 = "Cat32.jpg";
    final static String Cat64 = "Cat64.png";
    final static String Cat128 = "Cat128.jpg";
    final static String Cat256 = "Cat256.jpg";
    final static String Cat512 = "Cat512.png";
    final static String Cat1024 = "Cat1024.png";
    final static String Cat2048 = "Cat2048.jpg";
    
    public CatWorld() {
        super();
        
        gridBckgdColor = new Color(160, 144, 120);
        paddingAroundGrid = 25;
        paddingAroundTiles = 10;
        
        gridBackground = new Tile(getWidth() - 2 * paddingAroundGrid, getHeight() - 2 * paddingAroundGrid, gridBckgdColor);
        tileLen = (gridBackground.getImage().getHeight() - (TILES_PER_ROW + 1) * paddingAroundTiles) / TILES_PER_ROW;
    }

    @Override
    public void addMovingNumTile(int number, int x, int y) {
        //System.out.println("addMovingTile entered"); 
        CatTile ct = new CatTile(tileLen, tileLen, getColor(number),getCat(number), number);
        addObject(ct, x, y);
        //System.out.println("x: " + x + " y: " + y); 
    }
    
    public String getCat(int number){
        if (number == 2) {
            return Cat2;
        } else if (number == 4) {
            return Cat4;
        } else if (number == 8) {
            return Cat8;
        } else if (number == 16) {
            return Cat16;
        } else if (number == 32) {
            return Cat32;
        } else if (number == 64) {
            return Cat64;
        } else if (number == 128) {
            return Cat128;
        } else if (number == 256) {
            return Cat256;
        } else if (number == 512) {
            return Cat512;
        } else if (number == 1024) {
            return Cat1024;
        } else if (number == 2048) {
            return Cat2048;
        }
        return Cat2;
    }
    
    public String getSound(){
        return "CatMeow.wav";
    }
}
