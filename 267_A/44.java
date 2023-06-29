import java.io.*;
import java.util.*;
import java.lang.*;
public class file{

     public static void main(String []args) {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      while(n-->0)
      {
          int a=sc.nextInt();
          int b=sc.nextInt();
          int ans=f(a,b);
          System.out.println(ans);
      }
     }
     public static int f(int a,int b)
     {
         if(a==0||b==0)
           return 0;
         if(a>b)
         {
             return a/b + f(b,a%b);
         }
         else
             return b/a + f(a,b%a);
     }
}