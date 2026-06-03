/*
 * 1. The loophole is that the variable 'balance' is public.
 * This means that it could be changed from any class, without
 * this change being recorded in the transaction log.
 * 
 * 2. The log can still be edited from other classes in the
 * same package.
 * 
 * 3. This could be fixed by making the variables 'log' and
 * 'balance' private.
 * 
 * 4. If multiple bank accounts are created, they have a
 * common log. This is because the log variable is static
 * and is therefore shared among all instances of the
 * BankAccount class.
 * 
 * 5. If multiple bank accounts are created, each account has
 * its own balance. This is because balance is not a static,
 * or class variable. Instead, it is an instance variable. 
 * This means that it changes with each instance of the class
 * and all bank accounts do not have a common/shared balance.
*/

public class BankAccount{
    public static final int DEFAULT_BALANCE = 0;
    public double balance;
    static String log;
    private String accNum;
    
    public BankAccount(){
        balance = DEFAULT_BALANCE;
        log = "";
        accNum = generateAccountNumber();
        log= log+("Account "+ accNum+ " created\n");
    }
    
    public void executeTransaction(double b){
        double oldBalance = balance;
        balance+=b;
        log = log+("Account "+accNum+" changed by $"+b+" from $"+oldBalance + " to $"+balance+"\n");
    }
    
    private String generateAccountNumber(){
        String a = "";
        for(int i=0;i<10;i++){
            a=a+((int)(Math.random()*10));
        }
        return a;
    }
    
    public static void printLog(){
        System.out.println(log);
    }
}
