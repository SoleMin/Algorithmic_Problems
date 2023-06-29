import java.io.*;
import java.util.*;

public class Main implements Runnable {

	public void _main() throws IOException {
		long n = nextLong();
		long m = nextLong();
		long k = nextLong();
		long numBlocks = Math.min(Math.min(n / k, n - m), m / (k - 1));
		n -= numBlocks * k;
		m -= numBlocks * (k - 1);
		long numFullBlocks = m / k;
		long rem = m % k;
		long res = 0;
		res = (res + ((p2(numFullBlocks + 1) + MOD - 2) % MOD) * k) % MOD;
		res = (res + rem) % MOD;
		res = (res + numBlocks * (k - 1)) % MOD;
		out.println(res);
	}

	final int MOD = 1000000009;
	private long p2(long s) {
		long res = 1;
		long x = 2;
		while (s > 0) {
			if (s % 2 == 1) {
				res = res * x % MOD;
			}
			x = x * x % MOD;
			s /= 2;
		}
		return res;
	}

	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer st;

	private String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String rl = in.readLine();
			if (rl == null)
				return null;
			st = new StringTokenizer(rl);
		}
		return st.nextToken();
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	private double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.UK);
		new Thread(new Main()).start();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			//in = new BufferedReader(new FileReader("a.in"));
			//out = new PrintWriter(new FileWriter("a.out"));

			_main();

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(202);
		}
	}

}
