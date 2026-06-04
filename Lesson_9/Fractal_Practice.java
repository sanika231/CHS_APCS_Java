import gpdraw.*;

public class Fractal_Practice{
    static SketchPad p = new SketchPad(600,600);
    static DrawingTool pen = new DrawingTool(p);
    public static void main(String[] args){
        /*pen.setDirection(0);
        Fractal_Practice.fractal(200,3);*/
        LFractal fractal = new LFractal();
        
        fractal.drawLFractal(4, 200);  // level 4

    }

    public static void fractal(double length, int level) {
        /*if (level == 0) {
            pen.forward(length);
            pen.turnLeft();
        }
        else {
            fractal(length / 2, level - 1);
            pen.turnRight();
            fractal(length / 2, level - 1);
            fractal(length / 2, level - 1);
        }*/
        
        if(level ==0){
            pen.move(length);
            pen.turnLeft();
        }else{
            fractal(length/2, level-1);
            fractal(length/3, level-1);
            pen.turnLeft();
            fractal(length/3, level-1);
            fractal(length/2, level-1);
        }
    }
}
