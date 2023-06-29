import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;
import java.io.*;

public class Main {

	void solve() {
		int R = sc.nextInt();
		int C = sc.nextInt();
		int K = sc.nextInt();
		int[] x = new int[K];
		int[] y = new int[K];
		for (int i = 0; i < K; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}

		int best = -1;
		int bestX = 0;
		int bestY = 0;

		for (int r = 1; r <= R; r++) for (int c = 1; c <= C; c++) {
			int here = R + C;
			for (int i = 0; i < K; i++) {
				int t = abs(r - x[i]) + abs(c - y[i]);
				here = min(here, t);
			}
			if (best < here){
				best = here;
				bestX = r;
				bestY = c;
			}
		}

		out.println(bestX + " " + bestY);
	}

	void print(int[] a) {
		out.print(a[0]);
		for (int i = 1; i < a.length; i++) out.print(" " + a[i]);
		out.println();
	}

	static void tr(Object... os) {
		System.err.println(deepToString(os));
	}

	public static void main(String[] args) throws Exception {
		new Main().run();
	}

	MyScanner sc = null;
	PrintWriter out = null;
	public void run() throws Exception {
//		sc = new MyScanner(System.in);
//		out = new PrintWriter(System.out);
		sc = new MyScanner(new FileInputStream(new File("input.txt")));
		out = new PrintWriter(new File("output.txt"));
		for (;sc.hasNext();) {
			solve();
			out.flush();
		}
		out.close();
	}

	class MyScanner {
		String line;
		BufferedReader reader;
		StringTokenizer tokenizer;

		public MyScanner(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}
		public void eat() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					line = reader.readLine();
					if (line == null) {
						tokenizer = null;
						return;
					}
					tokenizer = new StringTokenizer(line);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		public String next() {
			eat();
			return tokenizer.nextToken();
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		public boolean hasNext() {
			eat();
			return (tokenizer != null && tokenizer.hasMoreElements());
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}
	}
}
