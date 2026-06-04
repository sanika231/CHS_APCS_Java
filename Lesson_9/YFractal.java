import gpdraw.*;
import java.awt.Color;

public class YFractal{
    // Attributes
    SketchPad pad;
    DrawingTool pen;

    // Constructor
    public YFractal() {

        pad = new SketchPad(600,600);
        pen = new DrawingTool(pad);

        // Back the pen up so the L is drawn in the middle of the screen
        pen.up();
        pen.setDirection(270);
        pen.backward(150);
        pen.move(0,-50);
        pen.down();
    }

    public void drawYFractal(int level, double length) {
        // Base case
        if (level == 0) {
            double x = pen.getXPos();
            double y = pen.getYPos();
            double dir = pen.getDirection();
            pen.forward(length);
            pen.move(x,y);
            pen.setDirection(dir);
            dir = pen.getDirection();
            pen.turnRight(120);
            pen.forward(length);
            pen.move(x,y);
            pen.setDirection(dir);
            pen.turnLeft(120);
            pen.forward(length);
            pen.move(x,y);
            pen.setDirection(dir);
        }

        // Recursive case:  Draw an L at each midpoint
        // of the current L's segments
        else {
            double x = pen.getXPos();
            double y = pen.getYPos();
            double dir = pen.getDirection();
            
            drawYFractal(0, length);
 
            // Move to first midpoint
            pen.forward(length / 2.0);
            pen.turnLeft(90);
            pen.forward(length / 2.0);
            //pen.fillCircle(10);
            pen.turnLeft(180);

            // Save current drawing position
            /*x = pen.getXPos();
            y = pen.getYPos();
            dir = pen.getDirection();*/

            // Recursively draw another L at the midpoint
            drawYFractal(level - 1, length / 2.0);

            // Restore drawing position
            pen.up();
            pen.move(x,y);
            pen.setDirection(dir);
            pen.down();

            // Move to second midpoint
            pen.turnLeft(120);
            pen.forward(length / 2.0);
            pen.turnLeft(90);
            pen.forward(length / 2.0);
            //pen.setColor(Color.BLUE);
            //pen.fillCircle(10);
            pen.turnLeft(180);
            
            drawYFractal(level - 1, length / 2.0);
            // Save current drawing position
            /*x = pen.getXPos();
            y = pen.getYPos();
            dir = pen.getDirection();*/

            pen.up();
            pen.move(x,y);
            pen.setDirection(dir);
            pen.down();
            pen.turnRight(120);
            pen.forward(length / 2.0);
            pen.turnLeft(90);
            pen.forward(length / 2.0);
            //pen.setColor(Color.BLUE);
            //pen.fillCircle(10);
            pen.turnLeft(180);
            
            drawYFractal(level - 1, length / 2.0);

            // Restore drawing position
            pen.up();
            pen.move(x,y);
            pen.setDirection(dir);
            pen.down();
        }
    }

    public static void main(String[] args) {

        YFractal fractal = new YFractal();

        // Draw LFractal with given level and side length
        fractal.drawYFractal(2, 200);
    }	
}
