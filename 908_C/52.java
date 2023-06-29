
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
	static int n,r,x[];
	static double ans[];
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		n = sc.nextInt();
		r = sc.nextInt();
		x = new int[n];
		ans = new double[n];
		for (int i=0;i<n;i++)
			x[i] = sc.nextInt();
		for (int i=0;i<n;i++)
		{
			ans[i] = r;
			for (int j=0;j<i;j++)
			{
				if (Math.abs(x[i]-x[j])>2*r)
					continue;
				int deltaxsq = (x[i]-x[j])*(x[i]-x[j]);
				int deltaysq = 4 * r * r - deltaxsq;
				double deltay = Math.sqrt(deltaysq);
				ans[i] = Math.max(ans[i], ans[j]+deltay);
			}
			pw.print(ans[i]+" ");
		}
		pw.flush();
		pw.close();
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
		
		public boolean ready() throws IOException {return br.ready();}
	
	
	}
}
