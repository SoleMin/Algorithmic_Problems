import java.util.*;
public class Main {
	static int a[][],n;
	static boolean isClique[];
	static int maxClique[];
	static void DFS1(int p,int n,int S)
	{
		if(p>n)
		{
			isClique[S]=true;
			return ;
		}
		DFS1(p+1,n,S);
		boolean mark=true;
		for(int i=1;i<p;++i)
			if((S>>(i-1)&1)==1&&a[p][i]==0)
				mark=false;
		if(mark)
			DFS1(p+1,n,1<<(p-1)|S);
	}
	static void DFS2(int p,int n,int m,int S)
	{
		if(p>n)
		{
			int cnt=0;
			for(int i=m;i<=n;++i)
				if((S>>(i-m)&1)==1)
					++cnt;
			maxClique[S]=cnt;
			return ;
		}
		DFS2(p+1,n,m,S);
		boolean mark=true;
		for(int i=m;i<p;++i)
			if((S>>(i-m)&1)==1&&a[p][i]==0)
				mark=false;
		if(mark)
			DFS2(p+1,n,m,1<<(p-m)|S);
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		n=Integer.parseInt(sc.next());
		a=new int [n+10][n+10];
		int cap=Integer.parseInt(sc.next());
		for(int i=1;i<=n;++i)
			for(int j=1;j<=n;++j)
				a[i][j]=Integer.parseInt(sc.next());
		int m=(n+1)>>1;
		isClique=new boolean [1<<m];
		Arrays.fill(isClique,false);
		DFS1(1,m,0);
		maxClique=new int [1<<(n-m)];
		Arrays.fill(maxClique,0);
		DFS2(m+1,n,m+1,0);
		for(int i=1;i<1<<(n-m);++i)
			for(int j=m+1;j<=n;++j)
				if((i>>(j-m-1)&1)==1)
					maxClique[i]=Math.max(maxClique[i],maxClique[i-(1<<(j-m-1))]);
		int ans=0,tmp[]=new int [m+10];
		for(int i=0;i<1<<m;++i)
			if(isClique[i])
			{
				int mask=0,cnt=0;
				for(int j=1;j<=m;++j)
					if((i>>(j-1)&1)==1)
						tmp[++cnt]=j;
				for(int j=m+1;j<=n;++j)
				{
					boolean mark=true;
					for(int k=1;k<=cnt;++k)
						if(a[j][tmp[k]]==0)
							mark=false;
					if(mark)
						mask|=1<<(j-m-1);
				}
				ans=Math.max(ans,cnt+maxClique[mask]);
			}
		System.out.printf("%.9f\n",cap*cap*(ans-1)/2.0/ans);
	}
}
