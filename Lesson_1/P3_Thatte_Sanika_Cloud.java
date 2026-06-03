/*
    Name:       Sanika Thatte
    Date:       9/1/25
    Period:     3

    Is this lab fully working?  Yes
*/

import gpdraw.*;
import java.awt.Color;

/**
 * <p>The class P3_Thatte_Sanika_Cloud is used to draw a cloud shape
 * on a SketchPad using gpdraw. The location (x and y coordinates) can be changed.
 * The radius of each oval making up the cloud can be scaled and can be changed through
 * the constructor. The cloud is drawn with the location (x,y) being at the
 * bottom left of the shape. The left most oval at the bottom of the
 * cloud is centered at (x,y). <br> </p>
 * 
 * <p>The default values set are the following: <br>
 *      - Location specified in the constructor <br>
 *      - Radius of each oval is set to 50 <br>
 *      
 * </p>
 * 
 * <p>Example Usage: <br>
 *      // creates new SketchPad which can be passed to the constructor <br>
 *      // specifies which SketchPad to draw the window on <br>
 *      SketchPad pad = new SketchPad(600,600); <br>
 * 
 *      // creates an instance of the class named "cloud" <br>
 *      // passes in parameters to constructor <br>
 *      P3_Thatte_Sanika_Cloud cloud = new P3_Thatte_Sanika_Cloud(pad, 0, 0, 60); <br>
 *      <br>
 *      // draws a cloud with specified parameters <br>
 *      cloud.draw(); <br>
 * </p>
 *
 * @author Sanika Thatte
 * @version 9/1/25
 */
public class P3_Thatte_Sanika_Cloud{
    /** x position of the specified location ... */
    int x;
    /** y position of the specified location ... */
    int y;
    /** radius height of each oval in the cloud (height is radius, width is double the radius)*/
    int r;
    /** DrawingTool object used to draw specified cloud */
    public static DrawingTool p;
    
    /** <p> This constructor takes parameters to draw a cloud on the specified pad
       and location. The default radius is set to 50. <br></p>
       
       @param pad Specified pad to draw on
       @param xPos The x coordinate for set location
       @param yPos The y coordinate for set location
       
    */
    public P3_Thatte_Sanika_Cloud(SketchPad pad, int xPos, int yPos){
        p = new DrawingTool(pad);
        x = xPos;
        y = yPos;
        r = 50;
    }
    
    /** <p> This constructor takes the parameters listed below to draw a cloud
        with the bottom left oval of the cloud being centered at (x,y). <br></p>
       
       @param pad Specified pad to draw on
       @param xPos The x coordinate for set location
       @param yPos The y coordinate for set location
       @param rad Radius of ovals making up cloud
       
    */
    public P3_Thatte_Sanika_Cloud(SketchPad pad, int xPos, int yPos, int rad){
        p = new DrawingTool(pad);
        x = xPos;
        y = yPos;
        r = rad;
    }
    
    /** This method draws the cloud. */
    public void draw(){
        p.up();
        p.move(x,y);
        p.setColor(Color.WHITE);
        p.down();
        //bottom
        p.fillOval(r*2,r);
        p.setDirection(0);
        for(int i = 0;i<2;i++){
            p.move(r);
            p.fillOval(r*2,r);
        }

        //middle
        p.move(p.getXPos()-r/2, p.getYPos()+r/2);
        p.fillOval(r*2,r);
        p.setDirection(180);
        p.move(r);
        p.fillOval(r*2,r);

        //top
        p.move(p.getXPos()+r/2,p.getYPos()+r/2);
        p.fillCircle(r);
        p.up();
        p.home();
    }
}
