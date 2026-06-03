public class Worksheet_Loop_Test{
    public static void main(String[] args){
        for(int i=1;i<101;i++){
            if(i==1 || i==2 || i==3 || i==5 || i==7 || i==9){
                System.out.print(i+" ");
            }else if(i%2!=0 && i%3!=0 && i%5!=0 && i%7!=0 && i%9!=0){
                System.out.print(i+" ");
            }
        }
    }
}
