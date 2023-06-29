import java.util.*;

public class LCM235A
{
    public static void main(String[] args) 
    {
        // Set up scanner
        Scanner sc = new Scanner(System.in); 
        // System.out.println("Enter n");
        long n = sc.nextLong();
        
        if (n==1)
        {
            System.out.println(1);
            return;
        }
        if (n==2)
        {
            System.out.println(2);
            return;
        }
        if (n==3)
        {
            System.out.println(6);
            return;
        }
        if (n==4)
        {
            System.out.println(12);
            return;
        }
        
        if (n%2 ==1)   // Odd number easy
        {
            System.out.println(n*(n-1)*(n-2));
            return;
        }
        
        // Even number is a bit harder
        if (n%3 == 0)
        {
            System.out.println((n-1)*(n-2)*(n-3));
        }
        else
        {
            System.out.println(n*(n-1)*(n-3));
        }
    }
}