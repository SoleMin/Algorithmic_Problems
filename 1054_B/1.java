/* package codechef; // don't place package name! */

import java.util.Scanner;
import java.util.Arrays;
/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		try {
		    Scanner sc = new Scanner(System.in);
		    int n,i,q=0,c=0;
		    n=sc.nextInt();
		    int a [] = new int[n];
		    
		    for(i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		        
		        if(a[i]>i || a[i]>(q+1))
		        {
		            c=1;
		            break;
		        }
		        if(a[i]>q)
		         q=a[i];
		    }
		    if(c==0)
		     System.out.println(-1);
		     else
		     System.out.println(i+1);
		} catch(Exception e) {
		}
	}
}
