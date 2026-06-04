/*
    Name:       Sanika Thatte
    Date:       10/19/25
    Period:     3

    Is this lab fully working?  Yes
*/

import java.util.Scanner;

public class P3_Thatte_Sanika_LoanTable{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the loan amount: ");
        double p = s.nextDouble();
        System.out.println("Enter the length of the loan in years: ");
        int years = s.nextInt();
        System.out.println("Enter a low interest rate in %: ");
        double lowRate = s.nextInt();
        System.out.println("Enter a high interest rate in %: ");
        double highRate = s.nextInt();
        System.out.printf("%s","Annual Interest Rate");
        System.out.printf("%20s","Monthly Payment");
        System.out.println();
        for(double i=lowRate;i<=highRate;i+=0.25){
            System.out.printf("%-25.2f",i);
            System.out.printf("%.2f",P3_Thatte_Sanika_LoanTable.determinePayments(p,years,i));
            System.out.println();
        }
    }
    
    public static double determinePayments(double p, int years, double rate){
        double k = (rate/100)/12.0;
        int n = years*12;
        double c = Math.pow((1+k),n);
        double num = (p*k*c)/(c-1);
        return num;
    }
}
