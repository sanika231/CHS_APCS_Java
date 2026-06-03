import java.util.Scanner;

public class DataTypesCheck{
    public static void main(String[] args) {
        /*int b=2;
        int a = b++;
        System.out.println(b);
        System.out.println(a);*/
        /*System.out.println( (double) (3 / 2) );	// What is printed?
        System.out.println( (double) 3 / 2 );		// What is printed?
        System.out.println( 1.5 == 3 / 2 );*/
        //System.out.printf("%$8d",300);

        /*int month = 5;
        switch(month){
    case 1: 
        System.out.println("January"); // sopl stands for System.out.println
        break;
    case 2:
        System.out.println("February");
        break;
    case 3: 
        System.out.println("March");
        break;
    case 4: 
        System.out.println("April");
        break;
    case 5: 
        System.out.println("May");
    case 6: 
        System.out.println("June");
    default:  
        System.out.println("Summer or Fall");
        }*/

        /*Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String name = keyboard.nextLine();
        System.out.print("Name two flowers: ");
        String flowers = keyboard.next();
        System.out.print("Cats or dogs? ");
        String animal = keyboard.next();

        System.out.printf("\nName: %s\n", name);
        System.out.printf("Flowers: %s\n", flowers);
        System.out.printf("Animal: %s", animal);*/

        /*String name = "Christopher";
        double pi = Math.PI;	// 3.141592653589793
        boolean b = false;

        System.out.printf("1. It's %b, %-5s loves %2.4f\n", !b, name, pi);
        System.out.printf("2. %3.4s5 loves %d eat %7.3f!\n", name, 2, pi);
        System.out.printf("3. %-4.2s loves %3d eat %c%c!!", name, 2, 'p', 'i');

        System.out.printf("%-10s", "Name:");
        System.out.printf("%11s", "Price:\n");
        System.out.printf("%-10s", "Soda");
        System.out.printf("%10.2f", 10.25);
        System.out.println();
        System.out.printf("%-10s", "Candy");
        System.out.printf("%10.2f", 1.50);*/

        //System.out.println(DataTypesCheck.power(3,2));
        //System.out.println(DataTypesCheck.neg(-3));

        /*int sum1 = 10+5;
        double sum2 = 10+5.0;
        int quotient1 = 15/4;
        double quotient2 = 15/4;
        double quotient3 = 15/4.0;
        int remainder1 = 15 % 4;
        double remainder2 = 17.84 % 2.3;

        System.out.println("10+5 is " + sum1);
        System.out.println("10+5.0 is " + sum2);
        System.out.println("15/4 is " + quotient1);
        System.out.println("15/4 is " + quotient2);
        System.out.println("15/4.0 is " + quotient3);
        System.out.println("15 % 4 is " + remainder1);
        System.out.println("17.84 % 2.3 is " + remainder2);
         */

        Scanner keyboard = new Scanner(System.in);
        double payCheck, price;
        int numFriends;
        String movie1, movie2;

        System.out.println("You’ve just received your first paycheck, and");
        System.out.println("you want to use it to take friends to a movie!");
        System.out.print("Enter the amount of your paycheck: ");
        payCheck = keyboard.nextDouble();
        System.out.println();
        System.out.print("Enter the price of a movie: ");
        price = keyboard.nextDouble();
        System.out.print("Enter two movies to consider seeing: ");
        movie1 = keyboard.next();
        movie2 = keyboard.next();
        numFriends = (int)(payCheck/price);
        System.out.print("You can take " + numFriends);
        System.out.println(" friends to see " + movie1 + " or " + movie2);

    }

    //public static double power(int b, int n){
    /*if(n>0){
    return b*power(b,n-1);
    }else{
    return 1;
    }*/

    //return (n>0) ? b*power(b,n-1):1;
    //}

    public static int neg(int num){
        if(num>=20){
            return -5;
        }else{
            return neg(num+4)+2*num;
        }
    }
}
