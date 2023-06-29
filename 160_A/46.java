import java.io.*;
import java.util.*;
import java.lang.Math.*;
public class A111
{
     public static void main(String args[])throws Exception
     {
         Scanner in=new Scanner(System.in);
         // br=new BufferedReader(new InputStreamReader(System.in));
         PrintWriter pw=new PrintWriter(System.out);
         int n,i,j,k=0,l;
         n=in.nextInt();
         int a[]=new int[n];
         int sum=0,sum1=0;
         for(i=0;i<n;i++)
         {
            a[i]=in.nextInt(); 
            sum+=a[i];
            }
            Arrays.sort(a);
         for(j=n-1;j>=0;j--)
         {
             sum1+=a[j];
             k++;
             if(sum1*2>sum)
             break;
            }
            pw.println(k);
         pw.flush();
     }
}