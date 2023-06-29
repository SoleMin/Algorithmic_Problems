/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int q=0;q<t;q++){
		      String s = br.readLine();
		      int n = Integer.parseInt(s);
		      int a[] = new int[1000];
		      int index=0;
		      for(int i=0;i<n;i++){
		            int x = Integer.parseInt(br.readLine());
		            for(int j=index;j>=0;j--){
		                  if(x-1==a[j]){
		                        a[j]=x;
		                  
		                  for(int k=0;k<j;k++){
		                        System.out.print(a[k]+".");
		                  }
		                  System.out.print(a[j]);
		                  System.out.println();
		                  for(int k=j+1;k<1000;k++){
		                        if(a[k]!=0)
		                        a[k]=0;
		                        else 
		                        break;
		                  }
		                  index=j+1;
		                //  System.out.println(a[j]+"*"+j);
		                  break;
		                  }
		            }
		      }
		}
	}
}