/*
Name:       Sanika Thatte
Date:       9/27/25
Period:     3

Is this lab fully working? Yes.
 */

import gpdraw.*;
import java.awt.Color;

public class P3_Thatte_Sanika_Sphere{
    double radius;
    int dir;
    double x;
    double y;
    public static DrawingTool p;

    public P3_Thatte_Sanika_Sphere(SketchPad pad, double r, double xPos, double yPos){
        radius = r;
        x = xPos;
        y = yPos;
        dir = 45;
        p = new DrawingTool(pad);
    }

    public P3_Thatte_Sanika_Sphere(SketchPad pad, double r, double xPos, double yPos, int d){
        radius = r;
        x = xPos;
        y = yPos;
        dir = d;
        p = new DrawingTool(pad);
    }

    public double getVolume(){
        return (4*Math.pow(radius,3)*Math.PI/3);
    }

    public void draw(){
        p.up();
        p.move(x,y);
        for(int i=0;i<=255;i++){
            p.setDirection(dir);
            p.down();
            radius = radius - (radius*2/255); 
            p.move(radius*1.5/255);
            p.setColor(new Color(0,0,i));
            p.fillCircle(radius);
        }
    }
}
