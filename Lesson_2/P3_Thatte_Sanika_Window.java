/*
    Name:       Sanika Thatte
    Date:       9/1/25
    Period:     3

    Is this lab fully working?  Yes
*/

import gpdraw.*;
import java.awt.Color;

/**
 * <p>The class P3_Thatte_Sanika_Window is used to draw a square shaped window
 * on a SketchPad using gpdraw. The location (x and y coordinates) can be changed
 * as well as the scaling of the window. The window is scaled according to width,
 * which can be changed through the constructor. The window is drawn centered on
 * the given location point (x,y). <br> </p>
 * 
 * <p>The default values set are the following: <br>
 *      - Location specified in the constructor <br>
 *      - Window is scaled with a set width of 300 <br>
 * </p>
 * 
 * <p>Example Usage: <br>
 *      // creates new SketchPad which can be passed to the constructor <br>
 *      // specifies which SketchPad to draw the window on <br>
 *      SketchPad pad = new SketchPad(600,600); <br>
 * 
 *      // creates an instance of the class named "window" <br>
 *      // passes in parameters to constructor <br>
 *      P3_Thatte_Sanika_Window window = new P3_Thatte_Sanika_Window(pad, 0, 0, 150); <br>
 *      <br>
 *      // draws window with specified parameters <br>
 *      window.draw(); <br>
 * </p>
 *
 * @author Sanika Thatte
 * @version 9/1/25
 */
public class P3_Thatte_Sanika_Window{
    /** x position of the specified location on which the window will be centered*/
    int xPos;
    /** y position of the specified location on which the window will be centered*/
    int yPos;
    /** width (and height) of the window; will be used to scale the window appropriately*/
    int w;
    /** DrawingTool object used to draw specified window */
    public static DrawingTool p;
    
    /** <p> This constructor takes parameters to draw a window on the specified pad
       and location. The default width is 300. <br></p>
       
       @param pad Specified pad to draw on
       @param x The x coordinate for set location
       @param y The y coordinate for set location
       
    */
    public P3_Thatte_Sanika_Window(SketchPad pad, int x, int y){
        xPos = x;
        yPos = y;
        p = new DrawingTool(pad);
        w = 300;
    }
    
    /** <p> This constructor takes the parameters listed below to draw a window
     * centered at (x,y). <br></p>
       
       @param pad Specified pad to draw on
       @param x The x coordinate for set location
       @param y The y coordinate for set location
       @param width The width of the window
       
    */
    public P3_Thatte_Sanika_Window(SketchPad pad, int x, int y, int width){
        xPos = x;
        yPos = y;
        p = new DrawingTool(pad);
        w = width;
    }
    
    /** This method draws the window. */
    public void draw(){
        //drawWindow((houseW/3)-(houseW/10),-(houseH/3), houseW);
        p.up();
        p.move(xPos,yPos);
        p.setDirection(90);
        p.setColor(Color.BLACK);
        p.down();
        p.setWidth(3);
        p.drawRect(w/3,w/3);
        p.setWidth(1);
        p.setColor(new Color(123, 228, 235, 180));
        p.fillRect(w/3,w/3);
        p.setColor(Color.BLACK);
        p.turnRight();
        p.move((w/3)-(w/6));
        p.turnRight();
        p.turnRight();
        p.move(2*((w/3)-(w/6)));
        p.turnRight();
        p.turnRight();
        p.move((w/3)-(w/6));
        
        p.turnRight();
        p.move((w/3)-(w/6));
        p.turnRight();
        p.turnRight();
        p.move(2*((w/3)-(w/6)));
        p.up();
        p.home();
    }
}
