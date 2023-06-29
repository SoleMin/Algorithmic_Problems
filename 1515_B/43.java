import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            if(n%2==1)
            {
                System.out.println("NO");
                continue;
            }
            // squares of 2
            int num=n/2;
            int root = (int)Math.sqrt(num);
            if(root*root==num)
            {
                System.out.println("YES");
                continue;
            }
            // squares of 4
            if(n%4!=0)
            {
                System.out.println("NO");
                continue;
            }
            num = n/4;
            root = (int) Math.sqrt(num);
            if(root*root==num)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
    }
}