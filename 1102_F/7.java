import java.io.*;
import java.util.*;

public class F 
{
	static Scanner in = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(System.out);
	
	static int n,m,res=0;
	static int[][] a=new int[20][10005],Min=new int[20][20],Min1=new int[20][20];
	static int[][][] f=new int[1<<16][20][20];
	
	static int GetBit(int x,int k)
	{
		return (x>>k)&1;
	}
	
	static int TurnBit(int x,int k)
	{
		return x^(1<<k);
	}

	public static void main(String[] args) 
	{
		n=in.nextInt();
		m=in.nextInt();
		for(int i=0;i<n;i++)
			for(int j=1;j<=m;j++)
				a[i][j]=in.nextInt();
		if(n==1)
		{
			res=(int)1e9;
			for(int i=1;i<m;i++)
				res=Math.min(res,Math.abs(a[0][i]-a[0][i+1]));
			out.print(res);
			out.close();
			return;
		}
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				Min[i][j]=Min1[i][j]=(int)1e9;
				for(int t=1;t<=m;t++)
					Min[i][j]=Math.min(Min[i][j],Math.abs(a[i][t]-a[j][t]));
				for(int t=1;t<m;t++)
					Min1[i][j]=Math.min(Min1[i][j],Math.abs(a[i][t]-a[j][t+1]));
			}
		for(int i=0;i<n;i++)
			f[1<<i][i][i]=(int)1e9;
		for(int mask=0;mask<(1<<n);mask++)
			if(Integer.bitCount(mask)>1)
				for(int i=0;i<n;i++)
					if(GetBit(mask,i)==1)
						for(int j=0;j<n;j++)
							if(i!=j&&GetBit(mask,j)==1)
							{
								for(int t=0;t<n;t++)
									if(j!=t&&GetBit(mask,t)==1)
										f[mask][i][j]=Math.max(f[mask][i][j],Math.min(f[TurnBit(mask,j)][i][t],Min[j][t]));
								if(mask==(1<<n)-1)									
									res=Math.max(res,Math.min(f[mask][i][j],Min1[j][i]));
							}
		out.print(res);
		out.close();
	}
}