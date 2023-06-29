import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    static int d[][];
    static int N;
    static boolean used[];
    static class point
    {
        int x = 0;
        int y = 0;
    }
    static point dats[];
     
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        
        
        long n = scan.nextLong();
        long k = scan.nextLong();
        if(n==1)
        {
            System.out.print("0");
            return;
        }
        if(n<=k) 
        {
            System.out.print("1");
            return;
        }
        long d = 9-4*(2*n-k*k+k);
        if(d<0) 
        {
            System.out.print("-1");
            return;
        }
        double a = ((3+Math.sqrt(d)) / 2) ;
            if(a>=1)
                System.out.println(Math.max(2, k-(long)a+1));
            else
            System.out.println(-1);
        
        
    }
    

}
