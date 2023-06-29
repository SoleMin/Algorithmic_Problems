import java.io.*;
import java.util.*;
public final class round_364_c
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	
	public static void main(String args[]) throws Exception
	{
		int n=sc.nextInt();char[] arr=sc.next().toCharArray();int[] sum=new int[123];int[][] pre=new int[123][n+1];
		char[] a=new char[n+1];
		for(int i=1;i<=n;i++)
		{
			a[i]=arr[i-1];
		}
		boolean[] v=new boolean[123];
		for(int i=1;i<=n;i++)
		{
			sum[a[i]]++;v[a[i]]=true;
			for(int j=65;j<=90;j++)
			{
				pre[j][i]=sum[j];
			}
			for(int j=97;j<=122;j++)
			{
				pre[j][i]=sum[j];
			}
		}
		long min=Integer.MAX_VALUE;
		for(int i=1;i<=n;i++)
		{
			int low=0,high=n-i+1;boolean got=false;
			while(low<high)
			{
				int mid=(low+high)>>1;
				boolean curr=true;
				for(int j=65;j<=90;j++)
				{
					if(v[j])
					{
						if(pre[j][i+mid]-pre[j][i-1]<=0)
						{
							curr=false;
							break;
						}
					}
				}
				for(int j=97;j<=122;j++)
				{
					if(v[j])
					{
						if(pre[j][i+mid]-pre[j][i-1]<=0)
						{
							curr=false;
							break;
						}
					}
				}
				if(curr)
				{
					got=true;
					high=mid;
				}
				else
				{
					low=mid+1;
				}
			}
			if(got)
			{
				min=Math.min(min,(i+low)-i+1);
			}
		}
		out.println(min);
		out.close();
	}
}
class FastScanner
{
    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }
	
    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
	
	public String next() throws Exception {
		return nextToken().toString();
	}
	
    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}