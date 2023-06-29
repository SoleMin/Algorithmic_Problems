import java.io.*;
import java.util.*;

public class Main implements Runnable {
	class House implements Comparable<House> {
		int x;
		int a;

		public House(int x, int a) {
			this.x = x;
			this.a = a;
		}

		@Override
		public int compareTo(House other) {
			return x - other.x;
		}
	}

	// private void solution() throws IOException {
	// int t = in.nextInt();
	// while (t-- > 0) {
	// int n =in.nextInt();
	// int m = in.nextInt();
	// int x1 = in.nextInt();
	// int y1 = in.nextInt();
	// int x2 = in.nextInt();
	// int y2 = in.nextInt();
	//			
	// }
	// }
	private void solution() throws IOException {
		int n = in.nextInt();
		int t = in.nextInt();
		House[] h = new House[n];
		for (int i = 0; i < h.length; ++i) {
			h[i] = new House(in.nextInt(), in.nextInt());
		}
		Arrays.sort(h);
		int res = 2;
		for (int i = 0; i < h.length - 1; ++i) {
			double dist = h[i + 1].x - h[i + 1].a / 2.0 - (h[i].x + h[i].a / 2.0);
			if (dist >= t) {
				if (dist == t) {
					++res;
				} else {
					res += 2;
				}
			}
		}
		out.println(res);
	}

	public void run() {
		try {
			solution();
			in.reader.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
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
