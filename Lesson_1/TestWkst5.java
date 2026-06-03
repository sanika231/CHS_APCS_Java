public class TestWkst5
{
    public static void main(String[] args){
        TestWkst5 w = new TestWkst5();
        int n1 = 40;
        int n2 = 25;
        int h = w.north(n1,n2);
        System.out.println("after, n1 - n2 = "+ (n1-n2));
        System.out.println("north returned" + h);
    }

    public int north(int n1, int n2){
        int temp = n1;
        n1 = n2;
        n2 = temp;
        System.out.println("n1 - n2 = " +(n1-n2));
        return (3* (n1-n2));
    }
}
