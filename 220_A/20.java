import java.io.*;
import java.util.*;
import java.math.*;

public class A {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static Random rnd;

	void solve() throws IOException {
		int n = nextInt();

		int[] arr = new int[n];
		Integer[] arrCopy = new Integer[n];

		for (int i = 0; i < n; i++)
			arr[i] = arrCopy[i] = nextInt();

		Arrays.sort(arrCopy);

		int bad = 0;

		for (int i = 0; i < n; i++)
			if (arr[i] != arrCopy[i])
				++bad;

		boolean fail = bad > 2;

		out.println(!fail ? "YES" : "NO");
	}

	public static void main(String[] args) {
		new A().run();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			rnd = new Random();

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(42);
		}
	}

	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String line = in.readLine();

			if (line == null)
				return null;

			st = new StringTokenizer(line);
		}

		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
}