import java.util.*;
public class Main
{
    public static void main(String[]args)
    {
        Scanner input=new Scanner (System.in);
        while(input.hasNext())
        {
            long n=input.nextLong();
            if(n==1||n==2)
                System.out.println(n);
            else if(n%2==1)
                System.out.println(n*(n-1)*(n-2));
            else
                if(n%3!=0)
                    System.out.println(Math.max(n*(n-1)*(n-3),n*(n-1)*(n-2)/2));
                else
                    System.out.println(Math.max(  Math.max(n*(n-1)*(n-3)/3,n*(n-1)*(n-2)/2) , Math.max((n-2)*(n-1)*(n-3),n*(n-2)*(n-3)/6) ));
        }
    }
}