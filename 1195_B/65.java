import java.util.*;
public class algo_1802
{
    public static void main(String args[])
    {
        Scanner ex=new Scanner(System.in);
        int n=ex.nextInt();
        int k=ex.nextInt();
        int x=(int)((Math.sqrt(9.0+8.0*((double)n+(double)k))-3.0)/2.0);
        System.out.println(n-x);
    }
}