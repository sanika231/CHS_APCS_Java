/*
Name:       Sanika Thatte
Date:       11/22/25
Period:     3

Is this lab fully working?  Yes
 */

public class P3_Thatte_Sanika_Taxes{
    private double gP;
    int hours;
    double rate;
    final double FEDERAL_TAX_PERCENTAGE = 0.124;
    final double FICA_TAX_PERCENTAGE = 0.0775;
    final double STATE_TAX_PERCENTAGE = 0.093;
    public P3_Thatte_Sanika_Taxes(int h, double r){
        gP = h*r;
        hours = h;
        rate = r;
    }

    private double getGrossPay(){
        return gP;
    }

    private double getFederalTaxPercentage(){
        return gP*FEDERAL_TAX_PERCENTAGE;
    }

    private double getFICATaxPercentage(){
        return gP*FICA_TAX_PERCENTAGE;
    }

    private double getStateTaxPercentage(){
        return gP*STATE_TAX_PERCENTAGE;
    }
    
    private double getNetPay(){
        return gP - (getFederalTaxPercentage() + getFICATaxPercentage() + getStateTaxPercentage());
    }
    
    public void printTaxes(){
        System.out.println("Gross pay: " + getGrossPay() + "\n");
        System.out.println("Federal Tax Pay (" + (100*FEDERAL_TAX_PERCENTAGE) + "%): " + getFederalTaxPercentage());
        System.out.println("FICA Tax Pay (" + (100*FICA_TAX_PERCENTAGE) + "%): " + getFICATaxPercentage());
        System.out.println("State Tax Pay (" + (100*STATE_TAX_PERCENTAGE) + "%): "  + getStateTaxPercentage());
        System.out.println("\nNet pay: " + getNetPay());
    }
    
    public int getHours(){
        return hours;
    }
    public double getRate(){
        return rate;
    }
    public void setHours(int h){
        hours = h;
    }
    public void setRate(double r){
        rate = r;
    }
}
