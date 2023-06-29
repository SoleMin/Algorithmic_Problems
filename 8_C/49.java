import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LookingForOrder {
static int n;
static int []x,y,memo;
static StringBuilder sb;
static int distance(int i,int j)
{
	int dx=x[i]-x[j];
	int dy=y[i]-y[j];
	return dx*dx+dy*dy;
}
public static int dp(int msk)
{
	if(msk==(1<<(n+1))-2)
		return 0;
	if(memo[msk]!=-1)
		return memo[msk];
	int ans=10000000;
	boolean found=false;
	for(int i=1;i<=n && !found;i++)
		
		for(int j=i;j<=n && (msk&1<<i)==0;j++)
			if((msk&1<<j)==0)
			{	
				
				found=true;
				int newM=msk|1<<i;
				newM|=1<<j;
				ans=Math.min(ans, dp(newM)+Math.min(distance(0,i)+distance(i,j)+distance(j,0), distance(0,j)+distance(j,i)+distance(i,0)));
			}
	return memo[msk]=ans;
			
}
public static void print(int msk)
{
	if(msk==(1<<(n+1))-2)
		return ;
	
	for(int i=1;i<=n;i++)
		
		for(int j=i;j<=n && (msk&1<<i)==0;j++)
			if((msk&1<<j)==0)
			{	
				
				int newM=msk|1<<i;
				newM|=1<<j;
				int d1=distance(0,i)+distance(i,j)+distance(j,0);
				int d2=distance(0,j)+distance(j,i)+distance(i,0);
				if(dp(msk)== dp(newM)+Math.min(d1,d2))
				{
					
					if(i==j)
					
						sb.append("0 "+i+" ");
					
					else if(d1<d2)
						sb.append("0 "+i+" "+j+" ");
					else
						sb.append("0 "+j+" "+i+" ");
						
					
					print(newM);
					return ;
				}
			}
	
			
}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int xS=sc.nextInt(),yS=sc.nextInt();
		n=sc.nextInt();
		x=new int [n+1];
		y=new int [n+1];
		x[0]=xS;y[0]=yS;
		for(int i=1;i<=n;i++)
		{	
			x[i]=sc.nextInt();
			y[i]=sc.nextInt();
		
		}	
		memo=new int [1<<(n+1)];
		Arrays.fill(memo,-1);
		sb=new StringBuilder();

		sb.append(dp(0)+"\n");
		print(0);
		sb.append("0");
		System.out.println(sb);
	}
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		public Scanner(InputStream s)
		{
			br=new BufferedReader(new InputStreamReader(s));
		}
		public String nextLine() throws IOException
		{
			return br.readLine();
		}
		public String next() throws IOException
		{
			while(st==null || !st.hasMoreTokens())
				st=new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
			
		}
		public double nextDouble() throws IOException
		{
			return Double.parseDouble(next());
		}
		public boolean ready() throws IOException
		{
			return br.ready();
		}
		public long nextLong() throws IOException
		{
			return Long.parseLong(next());
		}
	}
}
