import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.StringTokenizer;

public class A {
	
	private class Pair {
		public final int prob;
		public final int time;
		
		public Pair(int prob, int time) {
			this.prob = prob;
			this.time = time;
		}
	}
	
	private void solve() throws IOException {
		int n = nextInt();
		int k = nextInt();
		
		Pair[] p = new Pair[n];
		for (int i = 0; i < n; i++) {
			p[i] = new Pair(nextInt(), nextInt());
		}
		
		Arrays.sort(p, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.prob == o2.prob) {
					return o1.time - o2.time;
				}
				return o2.prob - o1.prob;
			}
		});
		
		int time = p[k - 1].time;
		int prob = p[k - 1].prob;
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (p[i].time == time && p[i].prob == prob) {
				res++;
			}
		}
		println(res);
	}

	private String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	private int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}

	private double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(nextToken());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	private void print(Object o) {
		writer.print(o);
	}

	private void println(Object o) {
		writer.println(o);
	}

	private void printf(String format, Object... o) {
		writer.printf(format, o);
	}

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		Locale.setDefault(Locale.US);
		new A().run();
		System.err.printf("%.3f\n", 1e-3 * (System.currentTimeMillis() - time));
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	private void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(System.out);
			solve();
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(13);
		}
	}
}