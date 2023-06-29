/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
public class S {
	public static void main (String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t--!=0)
		{
		    int a=in.nextInt();
		    int b=in.nextInt();
		    int min=Math.min(a,b);
		    int max=Math.max(a,b);
		    int res=0;
		    while(min!=0)
		    {
		        res=res+max/min;
		        int temp=min;
		        min=max%min;
		        max=temp;
		    }
		    System.out.println(res);
		}
	}
	
}