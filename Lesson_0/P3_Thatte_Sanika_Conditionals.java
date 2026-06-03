/*
    Name:       Sanika Thatte
    Date:       8/19/25
    Period:     3

    Is this lab fully working?  Yes
*/

public class P3_Thatte_Sanika_Conditionals{
    public static void main(String[] args){
        int students = 34;
        int comps = 36;
        int teachers = 1;
        int tables = 5;
        if(teachers != 1 || comps<students || (double)(students)/tables>6 || students%2!=0){
            System.out.println("The classroom is invalid.");
        }else{
            System.out.println("The classroom is valid.");
        }
    }
}
