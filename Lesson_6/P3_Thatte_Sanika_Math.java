import java.util.Random;
import java.awt.Point;

/** This class is used for calculations and conversions.
 * 
 * @author Sanika Thatte
*/
public class P3_Thatte_Sanika_Math{
    /**this method converts farenheight to celsius (as a double)
       
       @param f the degrees in F*/
    public static double fToC(double f){
        return (5/9.0)*(f-32);
    }
    
    /**this method converts celsius to farenheight (as a double)
       
       @param c the degrees in C*/
    public static double cToF(double c){
        return (c*9/5)+32;
    }
    
    /**this method calculates the volume of a circle (as an int) given the radius
       
       @param r the radius of the circle*/
    public static int calcVolume(int r){
        return (int)Math.round((4*Math.PI/3)*Math.pow(r,3));
    }
    
    /**this method calculates the hypotenuse (as a double) given two side lengths
       
       @param s1 first side length
       @param s2 second side length*/
    public static double calcHypotenuse(double s1, double s2){
        return Math.sqrt(Math.pow(s1,2) + Math.pow(s2,2));
    }
    
    /**avogadro's constant*/
    public static final double CONSTANT = 6.022140857e23;
    /**this method converts the number of grams to atoms(as a double) given the mass and number of grams
       
     * @param mass the mass of the object
     * @param grams the number of grams in the object
       */
    public static double gramsToAtoms(double mass, double grams){
        return (grams/mass)*CONSTANT;
    }
    
    /**this method generates a random number between the given values (inclusive).
     * it returns an integer
     * 
     * @param a first number
     * @param b second number
       
       */
    public static int generateRandNum(int a, int b){
        Random rand = new Random();
        if(a>b){
            return rand.nextInt(a-b+1)+b;
        }else if(b>a){
            return rand.nextInt(b-a+1)+a;
        }
        return a;
    }  
    
    /**calculates perimeter given distance between 3 points
     * 
     * @param a Point a
     * @param b Point b
     * @param c Point c
    */
    public static double calcPerim(Point a, Point b, Point c){
        double s1 = a.distance(b);
        double s2 = b.distance(c);
        double s3 = c.distance(a);
        return s1+s2+s3;
    }
}