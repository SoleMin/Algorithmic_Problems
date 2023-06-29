import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C8 {
	static int[] mem;
	static int[] bag;
	static int[][] items;
	static int[] close;
	static PrintWriter pw;
	static int n;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		
		bag = new int[2];
		bag[0] = sc.nextInt();
		bag[1] = sc.nextInt();
		
		n = sc.nextInt();
		items = new int[n][2];
		
		for(int i = 0;i<n;i++)
		{
			items[i][0] = sc.nextInt();
			items[i][1] = sc.nextInt();
		}
		
		//System.out.println((items[0][1]-bag[1])*(items[0][1]-bag[1]));
		
		
		mem = new int[1<<n];
		
		Arrays.fill(mem, -1);
		
		pw.println(dp(0));
		trace(0);
		pw.print(0);
		
		pw.flush();
	}
	static int dp(int mask){
		if(mask==(1<<n)-1)
			return 0;
		
		if(mem[mask]!=-1)
			return mem[mask];
		
		int ans = (int)1e9;
		for(int i = 0;i<n;i++)
			if((1<<i&mask)==0)
			{	
				ans = getDisBag(i)*2+dp(mask|1<<i);
				
				
				for(int j = i+1;j<n;j++)
					if((1<<j&mask)==0)
						ans = Math.min(ans, getDisBag(i)+getDis(i,j)+getDisBag(j)+dp(mask|1<<i|1<<j));
				
				break;
			}
		
		return mem[mask] = ans;
	}
	static int getDis(int i, int j){
		return (items[i][0]-items[j][0])*(items[i][0]-items[j][0])+(items[i][1]-items[j][1])*(items[i][1]-items[j][1]);
	}
	static int getDisBag(int i){
		return (items[i][0]-bag[0])*(items[i][0]-bag[0])+(items[i][1]-bag[1])*(items[i][1]-bag[1]);
	}
	static int getClosest(int i, int mask){
		int ret = -1;
		for(int j = 0;j<n;j++)
			if(i!=j&&(mask&1<<j)==0)
				if(ret==-1||getDis(i, j)<getDis(i, ret))
					ret = j;
		return ret;
	}
	static void trace(int mask){
		if(mask==(1<<n)-1)
			return;
		
		int ans = (int)1e9;
		for(int i = 0;i<n;i++)
			if((1<<i&mask)==0)
			{	
				ans = getDisBag(i)*2+dp(mask|1<<i);
				if(mem[mask]==ans)
				{
					pw.print(0+" "+(i+1)+" ");
					trace(mask|1<<i);
					return;
				}
				
				for(int j = i+1;j<n;j++)
					if((1<<j&mask)==0)
						if(mem[mask] == getDisBag(i)+getDis(i,j)+getDisBag(j)+dp(mask|1<<i|1<<j))
						{
							pw.print(0+" "+(i+1)+" "+(j+1)+" ");
							trace(mask|1<<i|1<<j);
							return;
						}

			}
		
	}
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}

		public boolean ready() throws IOException {return br.ready();}


	}
}
