/*
    Name:       Sanika Thatte
    Date:       9/30/25
    Period:     3

    Is this lab fully working?  Yes
*/

import gpdraw.*;
import java.awt.Color;

public class P3_Thatte_Sanika_KochCurve{
    DrawingTool p;
    public P3_Thatte_Sanika_KochCurve(){
        p = new DrawingTool(new SketchPad(600,600));
        p.up();
        p.move(0,0);
        p.setDirection(90);
    }

    public void drawKochCurve(int level, int length){
        p.down();
        p.setColor(Color.BLACK);
        //System.out.println(" level: " + level+" length: " + length);
        if(level<1){
            p.move(length);
            //System.out.println(" level: " + level+" length: " + length);
            return;
        }else{
            drawKochCurve(level-1, length/3);
            p.turnLeft(60);
            drawKochCurve(level-1, length/3);
            p.turnRight(120);
            drawKochCurve(level-1, length/3);
            p.turnLeft(60);
            drawKochCurve(level-1, length/3);
        }
    }

    public void drawKochSnowflake(int level, int length){
        for(int i=0;i<3;i++){
            drawKochCurve(level,length);
            p.turnRight(120);
        }
    }
}
