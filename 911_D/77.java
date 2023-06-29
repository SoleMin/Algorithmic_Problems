import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {

	public static void main(String[] args){
		FastScanner scan = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = scan.nextInt();
		int[] a = new int[n+1];
		for(int i = 1; i <= n; i++) a[i] = scan.nextInt();
		BIT bit = new BIT(n);
		int p = 0;
		for(int i = 1; i <= n; i++) {
			p ^= bit.atOrAbove(a[i])&1;
			bit.add(a[i], 1);
		}
		int m = scan.nextInt();
		for(int i = 0; i < m; i++) {
			int l = scan.nextInt(), r = scan.nextInt();
			int s = r-l+1;
			int in = s*(s-1)/2;
			if((in&1) == 1) p ^= 1;
			out.println(p==0?"even":"odd");
		}
		out.close();
	}

	static class BIT {

		int[] a;
		int n;

		public BIT(int n) {
			this.n = n;
			a = new int[n+1];
		}

		public void add(int i, int val) {
			while(i <= n) {
				a[i] += val;
				i += i & -i;
			}
		}

		public int sum(int j)
		{
			int res = 0;
			for(int i = j; i >= 1; i -= (i & -i)) res += a[i];
			return res;
		}

		public int sum(int i, int j) {
			return sum(j)-sum(i-1);
		}
		public int atOrAbove(int index) {
			int sub = 0;
			if (index > 0) sub = sum(index-1);
			return sum(n) - sub;
		}
	}
	
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			try	{
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine());
			} catch (Exception e){e.printStackTrace();}
		}

		public String next() {
			if (st.hasMoreTokens())	return st.nextToken();
			try {st = new StringTokenizer(br.readLine());}
			catch (Exception e) {e.printStackTrace();}
			return st.nextToken();
		}

		public int nextInt() {return Integer.parseInt(next());}

		public long nextLong() {return Long.parseLong(next());}

		public double nextDouble() {return Double.parseDouble(next());}

		public String nextLine() {
			String line = "";
			if(st.hasMoreTokens()) line = st.nextToken();
			else try {return br.readLine();}catch(IOException e){e.printStackTrace();}
			while(st.hasMoreTokens()) line += " "+st.nextToken();
			return line;
		}

		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}

		public long[] nextLongArray(int n){
			long[] a = new long[n];
			for(int i = 0; i < n; i++) a[i] = nextLong();
			return a;
		}

		public double[] nextDoubleArray(int n){
			double[] a = new double[n];
			for(int i = 0; i < n; i++) a[i] = nextDouble();
			return a;
		}

		public char[][] nextGrid(int n, int m){
			char[][] grid = new char[n][m];
			for(int i = 0; i < n; i++) grid[i] = next().toCharArray();
			return grid;
		}
	}


}
