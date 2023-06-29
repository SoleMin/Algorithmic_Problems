import java.io.*;
import java.util.*;
public class Ishu
{
    static Scanner scan = new Scanner(System.in);
    static void tc()
    {
    int n = scan.nextInt();
    int i;
    boolean zero = false;
    boolean neg = false;
    boolean pos = false;
    
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    long sum = 0l;
    for(i=0;i<n;++i)
        {
        int a = scan.nextInt();
        min = Math.min(a, min);
        max = Math.max(a, max);
        sum += Math.abs(a);
        if(a == 0)
            zero = true;
        if(a > 0)
            pos = true;
        if(a < 0)
            neg = true;
        }
    if(n == 1)
        {
        System.out.println(max);
        return ;
        }
    if(zero)
        System.out.println(sum);
    else
        {
        if(neg && pos)
            System.out.println(sum);
        else if(!neg && pos)
            System.out.println((sum - 2L * min));
        else if(!pos && neg)
            {
            max = max * (-1);
            System.out.println((sum - 2L * max));
            }
        }
    }
    public static void main(String[] args)
    {
    int t = 1;
    //t = scan.nextInt();
    while(t-- > 0)
        tc();
    }
}
