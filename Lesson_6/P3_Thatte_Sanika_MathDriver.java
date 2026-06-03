import java.awt.Point;

public class P3_Thatte_Sanika_MathDriver{
    public static void main(String[] args){
        char d = 176;
        System.out.println("212"+d+"F --> " + P3_Thatte_Sanika_Math.fToC(212)+d+"C");
        System.out.println("98.6"+d+"F --> " + P3_Thatte_Sanika_Math.fToC(98.6)+d+"C");
        System.out.println("37"+d+"C --> " + P3_Thatte_Sanika_Math.cToF(37)+d+"F");
        System.out.println("-15"+d+"C --> " + P3_Thatte_Sanika_Math.cToF(-15)+d+"F\n");
        
        System.out.println("Volume of a sphere with radius 11 is " + P3_Thatte_Sanika_Math.calcVolume(11) + ", rounded to the nearest integer");
        System.out.println("Volume of a sphere with radius 5 is " + P3_Thatte_Sanika_Math.calcVolume(5) + ", rounded to the nearest integer\n");
        
        System.out.println("A right triangle with sides 3 and 4 has hypotenuse of " +P3_Thatte_Sanika_Math.calcHypotenuse(3,4));
        System.out.println("A right triangle with sides 2.5 and 9.25 has hypotenuse of " +P3_Thatte_Sanika_Math.calcHypotenuse(2.5,9.25) +"\n");
    
        System.out.println("0.75g of \"Fe\" contains " + P3_Thatte_Sanika_Math.gramsToAtoms(55.85,0.75) + " atoms");
        System.out.println("5.24g of \"Fe\" contains " + P3_Thatte_Sanika_Math.gramsToAtoms(196.97,5.24) + " atoms");
        System.out.println("2.0g of \"Fe\" contains " + P3_Thatte_Sanika_Math.gramsToAtoms(20.18,2.0) + " atoms\n");
        
        for(int i=0;i<6;i++){
            System.out.println("A random number between 7 and 9 is: " + P3_Thatte_Sanika_Math.generateRandNum(7,9));
        }
        
        Point p = new Point(1,2);
        Point p2 = new Point(3,4);
        Point p3 = new Point(5,1);
        System.out.println("A triangle wil vertices: \n\t" + p.toString() +"\n\t" + p2.toString() + "\n\t" + p3.toString() + "\nhas a perimeter of " + P3_Thatte_Sanika_Math.calcPerim(p,p2,p3));
    }
}
