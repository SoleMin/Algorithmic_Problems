import java.util.*;
import java.io.*;

public class Fish
{
	static double[][] prob= new double[18][18];
	static double[][] dp= new double[2][1<<18];
	static ArrayList<Integer>[] adj= new ArrayList[1<<18];
	static int n;
	public static void init()
	{
		for(int i=0; i<(1<<18); i++)
			adj[i]= new ArrayList<Integer>();
		for(int i=0; i<(1<<18); i++)
			for(int j=0; j<18; j++)
				if(((i>>j)&1)==1)
					adj[i].add(i^(1<<j));
	}
	public static double value(int cur, int next)
	{
		int i=0;
		int z= cur^next;
		double p=0;
		int alive= Integer.bitCount(cur);
		while((z>>i)!=1)
			i++;
		for(int k=0; k<n; k++)
			if( ((next>>k)&1)==1)
				p+= prob[k][i];
		p/= alive*(alive-1)/2;
		return p;
	}
	public static void main(String[] args)throws Exception
	{
		Scanner scan= new Scanner(System.in);
		init();
		n=scan.nextInt();
		int m= (1<<n)-1;
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				prob[i][j]= scan.nextDouble();
		dp[0][m]=1;
		
		for(int i=0; i<(n-1); i++)
		{
			for(int j=0; j<=m; j++)
				if(dp[i%2][j]>0)
					for(Integer next: adj[j])
						dp[(i+1)%2][next]+= value(j,next)*dp[i%2][j];
			Arrays.fill(dp[i%2],0);
		}
	
		for(int i=0; i<n; i++)
		{
			if(i!=0)
			System.out.print(" ");
			System.out.printf("%.6f",dp[(n-1)%2][1<<i]);		
		}
		
	}
}
