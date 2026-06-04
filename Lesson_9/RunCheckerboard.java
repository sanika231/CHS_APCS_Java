import gpdraw.*;

public class RunCheckerboard{
    public static void main(String[] args){
        SketchPad pad = new SketchPad(300, 300);
        DrawingTool p = new DrawingTool(pad);
        DrawCheckerboard d = new DrawCheckerboard();
        d.draw(p);
    }
}
