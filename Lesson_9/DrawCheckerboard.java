import gpdraw.*;
import java.awt.Color;

public class DrawCheckerboard{
    public void draw(DrawingTool p){
        boolean isRed = true;
        double x = -87.5;
        double y = 87.5;
        double origY = y;
        p.up();
        p.move(x,y);
        for(int col = 0;col<8;col++){
            for(int row=0;row<8;row++){
                p.down();
                if(isRed){
                    p.setColor(Color.RED);
                    p.fillRect(25,25);
                }else{
                    p.setColor(Color.BLACK);
                    p.fillRect(25,25);
                }
                isRed = !isRed;
                y= y-25;
                p.up();
                p.move(x,y);
            }
            x = x+25;
            p.move(x,origY);
            y= origY;
            isRed = !isRed;
        }
        
    }
}
