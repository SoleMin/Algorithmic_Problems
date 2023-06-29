import java.util.*;
import java.math.*;
import java.io.*;
public class Main
	{
	public static void main(String args[])	throws IOException
		{
		Scanner c=new Scanner(System.in);
		int N=c.nextInt();
		int A[]=new int[N];
		for(int i=0;i<N;i++) 
			{
			A[i]=c.nextInt();
			}
		Arrays.sort(A);
		int sum=0;
		for(int i=0;i<N;i++) 
			{
			sum+=A[i];
			}
		int my=0;
		int coins=0;
		for(int i=N-1;i>=0;i--) 
			{
			coins++;			//include coin i
			my+=A[i];
			if(my>sum-my)
				{
				System.out.println(coins);
				break;
				}
			}
		}
	}

//must declare new classes here