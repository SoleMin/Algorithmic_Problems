import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	private void solve() throws IOException {

		out.println(solve(nl()));
		out.close();

	}

	private long solve(long n) throws IOException {
		if (n > 0) {
			n <<= 1;
			long k = nl();
			n--;
			int M = 1000000007;
			long p = power(2, k, M);
			// Helper.tr(n * p + 1);
			n = (n % M * p + 1) % M;
		}
		return n;
	}

	long power(long a, long b, long mod) {
		long x = 1, y = a;
		while (b > 0) {
			if (b % 2 != 0) {
				x = (x * y) % mod;
			}
			y = (y * y) % mod;
			b /= 2;
		}
		return x % mod;
	}

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;

	private int[][] na(int n) throws IOException {
		int[][] a = new int[n][2];
		for (int i = 0; i < n; i++) {
			a[i][0] = ni();
			a[i][1] = i;
		}
		return a;
	}

	String ns() throws IOException {
		while (!tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine(), " ");
		}
		return tok.nextToken();
	}

	int ni() throws IOException {
		return Integer.parseInt(ns());
	}

	long nl() throws IOException {
		return Long.parseLong(ns());
	}

	double nd() throws IOException {
		return Double.parseDouble(ns());
	}

	String[] nsa(int n) throws IOException {
		String[] res = new String[n];
		for (int i = 0; i < n; i++) {
			res[i] = ns();
		}
		return res;
	}

	int[] nia(int n) throws IOException {
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = ni();
		}
		return res;
	}

	long[] nla(int n) throws IOException {
		long[] res = new long[n];
		for (int i = 0; i < n; i++) {
			res[i] = nl();
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		tok = new StringTokenizer("");
		Main main = new Main();
		main.solve();
		out.close();
	}
}