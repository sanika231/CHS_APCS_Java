/*
    Name:       Sanika Thatte
    Date:       9/1/25
    Period:     3

    Is this lab fully working?  Yes
*/

import gpdraw.*;
import java.awt.Color;

/**
 * <p>The class P3_Thatte_Sanika_Roof is used to draw a triangular shaped roof
 * on a SketchPad using gpdraw. The location (x and y coordinates) can be changed
 * as well as the scaling of the roof. The roof width and height is scaled
 * and can be changed through the constructor, as well as the radius of the ovals
 * making up the roof. The roof is drawn with the location (x,y) being at the bottom
 * left corner of the triangle. <br> </p>
 * 
 * <p>The default values set are the following: <br>
 *      - Location specified in the constructor <br>
 *      - Roof is scaled with a set width of 300 <br>
 *      - Roof color is Black <br>
 *      - Roof oval radius is set to 10 <br>
 * </p>
 * 
 * <p>Example Usage: <br>
 *      // creates new SketchPad which can be passed to the constructor <br>
 *      // specifies which SketchPad to draw the window on <br>
 *      SketchPad pad = new SketchPad(600,600); <br>
 * 
 *      // creates an instance of the class named "roof" <br>
 *      // passes in parameters to constructor <br>
 *      P3_Thatte_Sanika_Roof roof = new P3_Thatte_Sanika_Roof(pad, 0, 0, Color.RED, 150, 5); <br>
 *      <br>
 *      // draws a roof with specified parameters <br>
 *      roof.draw(); <br>
 * </p>
 *
 * @author Sanika Thatte
 * @version 9/1/25
 */
public class P3_Thatte_Sanika_Roof{
    /** x position of the specified location which will be the left bottom corner of the roof*/
    int xPos;
    /** y position of the specified location which will be the left bottom corner of the roof*/
    int yPos;
    /** color of the roof*/
    Color c;
    /** width of roof */
    int w;
    /** radius of smaller ovals drawn to make up the roof*/
    int rad;
    /** DrawingTool object used to draw specified roof */
    public static DrawingTool p;
    
    
    /** <p> This constructor takes parameters to draw a roof on the specified pad
       and location. The default color is Black, default width is 300, and the
       default oval radius is 10. <br></p>
       
       @param pad Specified pad to draw on
       @param x The x coordinate for set location
       @param y The y coordinate for set location
       
    */
    public P3_Thatte_Sanika_Roof(SketchPad pad, int x, int y){
        xPos = x;
        yPos = y;
        p = new DrawingTool(pad);
        c = Color.BLACK;
        rad = 10;
        w = 300;
    }
    
    /** <p> This constructor takes the parameters listed below to draw a roof
        with the bottom left corner at (x,y). <br></p>
       
       @param pad Specified pad to draw on
       @param x The x coordinate for set location
       @param y The y coordinate for set location
       @param color Color of the roof
       @param width Width of the roof
       @param roofR Radius of ovals drawn to make up roof
       
    */
    public P3_Thatte_Sanika_Roof(SketchPad pad, int x, int y, Color color, int width, int roofR){
        xPos = x;
        yPos = y;
        p = new DrawingTool(pad);
        c = color;
        rad = roofR;
        w = width;
    }
    
    /** This method draws the roof. */
    public void draw(){
        //drawRoof(-houseW/2,roofR, new Color(147,105,66), houseW, roofR);
        p.up();
        p.move(xPos,yPos);
        p.setColor(c);
        p.setDirection(0);
        boolean turnLeft = true;
        for(int i=0;i<35;i+=3){
            p.down();
            for(int n=0;n<(w/(rad*2))-i;n++){
                p.fillOval(rad*2,rad*4);
                p.move(rad*2);
            }
            p.up();
            if(turnLeft){
                p.turnLeft();
                p.move(rad*4);
                p.turnLeft();
                p.move(rad*5);
                
                turnLeft = false;
            }else{
                p.turnRight();
                p.move(rad*4);
                p.turnRight();
                p.move(rad*5);
                
                turnLeft = true;
            }
        }
        p.up();
        p.home();
    }
}
