/*
    Name:       Sanika Thatte
    Date:       9/27/25
    Period:     3

    Is this lab fully working? Yes.
*/

public class P3_Thatte_Sanika_Fibonacci_Driver{
    public static void main(String[] args){
        P3_Thatte_Sanika_Fibonacci a =  new P3_Thatte_Sanika_Fibonacci();
        System.out.println(a.getFibonacciNumber(1));
        System.out.println(a.getFibonacciNumber(2));
        System.out.println(a.getFibonacciNumber(3));
        System.out.println(a.getFibonacciNumber(5)+"\n");
        
        System.out.println(a.posMultiplication(7,8));
        System.out.println(a.posMultiplication(5,1));
        System.out.println(a.posMultiplication(5,0));
        System.out.println(a.allMultiplication(-7,8));
        System.out.println(a.allMultiplication(-7,-8));
        System.out.println(a.allMultiplication(7,-8));
        System.out.println(a.allMultiplication(7,-9));
    }
}
