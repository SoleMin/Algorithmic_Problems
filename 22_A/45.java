import java.io.*;
import java.util.*;

public class Main implements Runnable {
	public void solution() throws IOException {
		int n = in.nextInt();
		int[] a = new int[n];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
			if (a[i] < min) {
				min = a[i];
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n; ++i) {
			if (a[i] != min && a[i] < res) {
				res = a[i];
			}
		}
		if (res == Integer.MAX_VALUE) {
			out.println("NO");
		} else {
			out.println(res);
		}
	}

	public void run() {
		try {
			solution();
			in.reader.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private class Scanner {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public Scanner(Reader reader) {
			this.reader = new BufferedReader(reader);
			this.tokenizer = new StringTokenizer("");
		}

		public boolean hasNext() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				String next = reader.readLine();
				if (next == null) {
					return false;
				}
				tokenizer = new StringTokenizer(next);
			}
			return true;
		}

		public String next() throws IOException {
			hasNext();
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public String nextLine() throws IOException {
			tokenizer = new StringTokenizer("");
			return reader.readLine();
		}
	}

	public static void main(String[] args) throws IOException {
		new Thread(null, new Main(), "", 1 << 28).start();
	}
	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	Scanner in = new Scanner(new InputStreamReader(System.in));
}
