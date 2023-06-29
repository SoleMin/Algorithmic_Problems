import java.io.*;
import java.util.*;
public final class subtractions
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	
	static long solve(long a,long b)
	{
		if(a<=0 || b<=0)
		{
			return 0;
		}
		else
		{
			long max=Math.max(a,b),min=Math.min(a,b);
			long low=1,high=(long)(1e9);
			while(low<high)
			{
				long mid=(low+high)>>1,val=(min*mid),curr=max-val;
				if(curr<min)
				{
					high=mid;
				}
				else
				{
					low=mid+1;
				}
			}
			return low+solve(min,max-(low*min));
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		int t=sc.nextInt();
		while(t>0)
		{
			long a=sc.nextLong(),b=sc.nextLong();
			out.println(solve(a,b));
			t--;
		}
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