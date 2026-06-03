import gpdraw.*;
import java.awt.Color;

public class MouseHoleDriver{
    public static void main(String[] args){
        SketchPad pad = new SketchPad(800,600);
        DrawingTool p = new DrawingTool(pad);
        MouseHole m = new MouseHole();
        m.draw();
        MouseHole m2 = new MouseHole(50,100,p);
        m2.setPosition(-50,0);
        m2.setWallColor(new Color(200,0,200));
        m2.draw();
        MouseHole m3 = new MouseHole();
        m3.wallColor = Color.GREEN;
        m3.setHoleHeight(200);
        m3.setHoleWidth(-100);
        m3.draw();
    }
}
