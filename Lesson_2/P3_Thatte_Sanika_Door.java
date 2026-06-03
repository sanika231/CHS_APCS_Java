/*
    Name:       Sanika Thatte
    Date:       9/1/25
    Period:     3

    Is this lab fully working?  Yes
*/


import gpdraw.*;
import java.awt.Color;

/**
 * <p>The class P3_Thatte_Sanika_Door is used to draw a door
 * on a SketchPad using gpdraw. The location (x and y coordinates) can be changed.
 * The door and doorknob can be scaled and can be changed through
 * the constructor. The door is drawn centered around the point (x,y). <br> </p>
 * 
 * <p>The default values set are the following: <br>
 * 
 *      - Location specified in the constructor <br>
 *      - Width of door is 100 <br>
 *      - Height of door is 200 <br>
 *      - Radius of knob is 10 <br>
 *      - Color of Door is a specified brown color (new Color(173, 111, 73)) <br>
 *      - Color of Knob is black <br>
 *      - The boolean that specifies whether to add an outline is set to false (default is no outline) <br>
 *      
 * </p>
 * 
 * <p>Example Usage: <br>
 *      // creates new SketchPad which can be passed to the constructor <br>
 *      // specifies which SketchPad to draw the window on <br>
 *      SketchPad pad = new SketchPad(600,600); <br>
 * 
 *      // creates an instance of the class named "door" <br>
 *      // passes in parameters to constructor <br>
 *      P3_Thatte_Sanika_Door door = new P3_Thatte_Sanika_Door(pad, 0, 0, 200, 400, 20); <br>
 *      <br>
 *      // draws a door with specified parameters <br>
 *      door.draw(); <br>
 * </p>
 *
 * @author Sanika Thatte
 * @version 9/1/25
 */
public class P3_Thatte_Sanika_Door{
    /** x position of the specified location on which the door is centered */
    int x;
    /** y position of the specified location on which the door is centered */
    int y;
    /** width of door*/
    int w;
    /** height of door */
    int h;
    /** radius of knob */
    int knobRadius;
    /** color of door */
    Color doorColor;
    /** color of knob */
    Color knobColor;
    /** specifies whether to draw an outline for the door or not */
    boolean outline;
    /** DrawingTool object used to draw specified door */
    public static DrawingTool p;

    /** <p> This constructor takes parameters to draw a door on the specified pad
       and location. The default attributes are set in a method to the following: <br>
       
           - Location specified in the constructor <br>
           - Width of door is 100 <br>
           - Height of door is 200 <br>
           - Radius of knob is 10 <br>
           - Color of Door is a specified brown color (new Color(173, 111, 73)) <br>
           - Color of Knob is black <br>
           - The boolean that specifies whether to add an outline is set to false (default is no outline) <br>
 
       </p>
       
       @param pad Specified pad to draw on
       @param xPos The x coordinate for set location
       @param yPos The y coordinate for set location
       
    */
    public P3_Thatte_Sanika_Door(SketchPad pad, int xPos, int yPos){
        p = new DrawingTool(pad);
        x = xPos;
        y = yPos;
        setDefaultAttributes();
    }
    
    /** <p> This constructor takes the parameters listed below to draw a door
        with the door being centered at (x,y). <br></p>
       
       @param pad Specified pad to draw on
       @param xPos The x coordinate for set location
       @param yPos The y coordinate for set location
       @param width Width of door
       @param height Height of door
       @param knobR Radius of knob
       
    */
    public P3_Thatte_Sanika_Door(SketchPad pad, int xPos, int yPos, int width, int height, int knobR){
        p = new DrawingTool(pad);
        x = xPos;
        y = yPos;
        w = width;
        h = height;
        knobRadius = knobR;
    }

    /** This method draws the door. */
    public void draw(){
        //drawDoor(int x, int y, int w, int h, int knobRadius, Color doorColor, Color knobColor, boolean outline)
        p.up();
        p.move(x,y);
        p.setColor(doorColor);
        p.down();
        p.fillRect(w,h);
        if(outline){
            p.setColor(Color.BLACK);
            p.drawRect(w,h);
        }
        p.up();
        p.setDirection(0);
        p.move(-(w/2 - w/4));
        p.down();
        p.setColor(knobColor);
        p.drawCircle(knobRadius);
        p.up();
        p.home();
    }
    
    /** included in first constructor to set all default values for attributes */
    public void setDefaultAttributes(){
        w = 100;
        h = 200;
        knobRadius = 10;
        doorColor = new Color(173, 111, 73);
        knobColor = Color.BLACK;
        outline = false;
    } 
    
    /** This method sets the color of the door. If left unspecified, the door color
       will be set to Black. 
       
       @param dC Door Color
    */
    public void setDoorColor(Color dC){
        doorColor = dC;
    }
    
    /** This method sets the color of the doorknob. If left unspecified, the doorknob color
       will be set to Black. 
       
       @param kC Doorknob Color
    */
    public void setKnobColor(Color kC){
        knobColor = kC;
    }
    
    /** This method provides the option to add an outline. If left unspecified, an 
       outline will not be drawn.
       
       @param t Boolean for whether or not the outline should be drawn around the door.
    */
    public void addOutline(boolean t){
        outline = t;
    }
}
