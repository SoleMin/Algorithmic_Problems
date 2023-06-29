//package cf196;

import java.util.*;
import java.io.*;

public class A {
	FastScanner in;
	PrintWriter out;
	final long mod = (long) 1e9 + 9 ; 
	public void solve() throws IOException {
		long n = in.nextInt();
		long m = in.nextInt();
		long k = in.nextInt();
		long l = n / k;
		long c = n - m;
		long mul2 = Math.max(0, l - c);
		if (mul2 == 0) {
			out.println(m);
			return;
		}
		long ans = power(2, mul2 + 1, mod);
		ans = (ans + mod - 2) % mod;
		ans = (ans * k) % mod;
		long z = mul2 * k;
		long r = m - z;
		ans = (ans + r) % mod;
		out.print(ans);
	}
	public long power(long x, long pow, long mod) {
		if (pow == 0) {
			return 1;
		}
		if ((pow % 2) == 0) {
			return power(((x * x) % mod), pow / 2, mod);
		} else {
			return (power(x, pow - 1, mod) * x) % mod;
		}
	}
	public void run() {
		try {
			in = new FastScanner(System.in);
			out = new PrintWriter(System.out);

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public FastScanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

	public static void main(String[] arg) {
		new A().run();
	}
}