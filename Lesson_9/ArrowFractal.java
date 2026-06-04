import gpdraw.*;

public class ArrowFractal {
    SketchPad pad = new SketchPad(800, 600, 50);
    DrawingTool p = new DrawingTool(pad);
    public void drawArrowFractal(int level, double length) {
        double x = p.getXPos();
        double y = p.getYPos();
        double dir = p.getDirection();
        if(level==0){
            p.down();
            p.move(length);
        }else{
            p.down();
            if(level==1){
                drawArrowFractal(level-1,length*2);
                x = p.getXPos();
                y = p.getYPos();
                dir = p.getDirection();
            }else{
                drawArrowFractal(0,length*level);
                x = p.getXPos();
                y = p.getYPos();
                dir = p.getDirection();
                p.turnLeft(180);
                drawArrowFractal(0,length*level);
                p.turnLeft(180);
                //drawArrowFractal(level-1,length);
                p.up();
                p.move(x,y);
                p.setDirection(dir);
                p.down();
            }
            p.turnLeft(135);
            drawArrowFractal(0,length);
            if(level!=1){
                p.turnRight(90);
                drawArrowFractal(level-1,length);
            }
            p.up();
            p.move(x,y);
            p.setDirection(dir);
            p.down();
            p.turnRight(135);
            drawArrowFractal(0,length);
            if(level!=1){
                p.turnLeft(90);
                drawArrowFractal(level-1,length);
            }
        }
    }

    public static void main(String[] args){
        ArrowFractal a = new ArrowFractal();
        a.drawArrowFractal(3,50);
    }
}
