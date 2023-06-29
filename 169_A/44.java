import java.util.*;
import java.math.*;
import java.io.*;
public class Main
	{
	public static void main(String args[])	throws IOException
		{
		Scanner c=new Scanner(System.in);
		int n=c.nextInt();
		int a=c.nextInt();		//higher
		int b=c.nextInt();		//lower
		int C[]=new int[n];
		for(int i=0;i<n;i++) 
			C[i]=c.nextInt();
		Arrays.sort(C);
		//System.out.println(Arrays.toString(C));
		int petya=C[n-a];
		System.out.println((C[n-a]-C[n-a-1]));
		}
	}

//must declare new classes here