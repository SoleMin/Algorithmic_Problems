import java.util.*;
import java.io.*;
import java.math.*;

/**
 *
 * @author Dstoical
 */

public class G {

	private static int M = 1000000007, MM = 998244353;
	private static int N = 15,n,T;
	private static int[] time,gi;
	private static int[][][] dp;

	public static void process() throws IOException {

		n = sc.nextInt();T = sc.nextInt();
		time = new int[n+1];
		gi = new int[n+1];
		for(int i=0; i<n; i++) {
			int a = sc.nextInt(),b = sc.nextInt();
			time[i] = a;
			gi[i] = b-1;
		}
		
		dp = new int[1<<n][T+1][3];
		for(int i=0; i<1<<n; i++) {
			for(int j=0; j<T+1; j++) {
				for(int k=0; k<3; k++)dp[i][j][k] = -1;
			}
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			if(time[i] <= T) {
				ans = (ans + solve(1<<i,time[i],gi[i]))%M;
			}
		}
		println(ans);
	}

	private static int solve(int mask, int tim, int code) {
		if(tim == T)return 1;
		if(dp[mask][tim][code] != -1)return dp[mask][tim][code];
		int ans = 0;
		for(int i=0; i<n; i++) {
			if((mask>>i & 1) > 0)continue;
			if(code == gi[i])continue;
			if(tim + time[i] > T)continue;
			ans = (ans + solve(mask|(1<<i), time[i]+tim, gi[i]))%M;
			
		}
		return dp[mask][tim][code] = (ans%M);
	}

	//=============================================================================
	//--------------------------The End---------------------------------
	//=============================================================================

	static FastScanner sc;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		boolean oj = true;
		if (oj) {
			sc = new FastScanner();
			out = new PrintWriter(System.out);
		} else {
			sc = new FastScanner(100);
			out = new PrintWriter("output.txt");
		}
		int t = 1;
//		t = sc.nextInt();
		while (t-- > 0) {
			process();
		}
		out.flush();
		out.close();
	}

	static class Pair implements Comparable<Pair> {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.x, o.x);
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	static void println(Object o) {
		out.println(o);
	}

	static void println() {
		out.println();
	}

	static void print(Object o) {
		out.print(o);
	}

	static void pflush(Object o) {
		out.println(o);
		out.flush();
	}

	static int ceil(int x, int y) {
		return (x % y == 0 ? x / y : (x / y + 1));
	}

	static long ceil(long x, long y) {
		return (x % y == 0 ? x / y : (x / y + 1));
	}

	static int max(int x, int y) {
		return Math.max(x, y);
	}

	static int min(int x, int y) {
		return Math.min(x, y);
	}

	static int abs(int x) {
		return Math.abs(x);
	}

	static long abs(long x) {
		return Math.abs(x);
	}

	static int log2(int N) {
		int result = (int) (Math.log(N) / Math.log(2));
		return result;
	}

	static long max(long x, long y) {
		return Math.max(x, y);
	}

	static long min(long x, long y) {
		return Math.min(x, y);
	}

	public static int gcd(int a, int b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		return gcd.intValue();
	}

	public static long gcd(long a, long b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		return gcd.longValue();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner() throws FileNotFoundException {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		FastScanner(int a) throws FileNotFoundException {
			br = new BufferedReader(new FileReader("input.txt"));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		String nextLine() throws IOException {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		int[] readArray(int n) throws IOException {
			int[] A = new int[n];
			for (int i = 0; i != n; i++) {
				A[i] = sc.nextInt();
			}
			return A;
		}

		long[] readArrayLong(int n) throws IOException {
			long[] A = new long[n];
			for (int i = 0; i != n; i++) {
				A[i] = sc.nextLong();
			}
			return A;
		}
	}

	static void ruffleSort(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
		Arrays.sort(a);
	}

	static void ruffleSort(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
		Arrays.sort(a);
	}
}
