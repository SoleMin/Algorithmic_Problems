import java.util.*;
import java.math.*;
import java.io.*;

public class Main
	{
	public static void main(String args[]) throws IOException
		{
		Scanner c = new Scanner(new FileReader("input.txt"));
		PrintWriter out = new PrintWriter(new File("output.txt"));

		int N=c.nextInt();
		int M=c.nextInt();
		int A[][]=new int[N][M];
		for(int i=0;i<N;i++)
			Arrays.fill(A[i],Integer.MAX_VALUE/100);
		int K=c.nextInt();
		for(int i=0;i<K;i++)
			{
			int x=c.nextInt()-1;
			int y=c.nextInt()-1;
			for(int i1=0;i1<N;i1++)
				{
				for(int j1=0;j1<M;j1++)
					A[i1][j1]=Math.min(A[i1][j1],Math.abs(i1-x)+Math.abs(j1-y));
				}
			}
		int maxi=0;
		int maxj=0;
		for(int i=0;i<N;i++)
			{
			for(int j=0;j<M;j++)
				{
				if(A[i][j]>A[maxi][maxj])
					{
					maxi=i;
					maxj=j;
					}
				}
			}
		out.println((maxi+1)+" "+(maxj+1));
		out.close();
		}
	}

//must declare new classes here