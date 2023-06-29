import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class Main implements Runnable {

	long INF = (long) 1e9 + 7;
	int MAXN = (int) 1e6 + 1;

	private void solve() throws IOException {
		int n = nextInt();
		int m = nextInt();
		int del = n - 1;
		for (int row = 0; row < n; ++row) {
			int row1 = row;
			int row2 = row1 + del;
//			System.err.println(row1 + " " + row2);
			int col1 = 0;
			int col2 = m - 1;
			if (row1 <= row2) {
				if (row1 == row2) {
					int del2 = m - 1;
					for (int count = 0; count < m / 2; ++count) {
						pw.println((row1 + 1) + " " + (col1 + count + 1));
						pw.println((row1 + 1) + " " + (col1 + count + del2 + 1));
						del2 -= 2;
					}
					if (m % 2 == 1) {
						pw.println((row1 + 1) + " " + (m / 2 + 1));
					}
				} else {
					for (int count = 0; count < m; ++count) {
						pw.println((row1 + 1) + " " + (col1 + count + 1));
						pw.println((row2 + 1) + " " + (col2 - count + 1));
					}
				}
			}
			del -= 2;
		}
	}

	private void brute() throws Exception {
	}

	void test() throws IOException {
		Random rnd = new Random();
		for (int i = 0; i < 5; ++i) {
			int n = rnd.nextInt(5) + 1;
			int m = rnd.nextInt(5) + 1;
			System.err.println(n + " " + m);
			for (int j = 0; j < m; ++j) {
				int l = rnd.nextInt(n) + 1;
				int r = l + rnd.nextInt(n - l + 1);
				int q = rnd.nextInt(10);
				System.err.println(l + " " + r + " " + q);
			}
//			solve(n, a);
			System.err.println();
		}
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter pw;

	public static void main(String args[]) {
		new Main().run();
	}

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in), 32768);
			pw = new PrintWriter(System.out);
			st = null;
			solve();
			pw.flush();
			pw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
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

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}
}
