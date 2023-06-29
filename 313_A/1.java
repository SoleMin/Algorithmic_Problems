/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner ob=new Scanner(System.in);
	    long n=ob.nextLong();
	    if(n>=0)
	    {
	        System.out.println(n);
	    }
	    else
	    {
	        String s1=""+n;
	        int t=s1.length();
	        String s2=s1.substring(0,t-1);
	        String s3=s1.substring(0,t-2)+s1.substring(t-1);
	        long n1=Long.parseLong(s2);
	        long n2=Long.parseLong(s3);
	        System.out.println(Math.max(n1,n2));
	    }
	}
}
