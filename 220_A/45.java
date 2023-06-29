import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class A {
	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;

	void solve() throws IOException {
		int n = nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		int[] b = a.clone();
		Arrays.sort(b);
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] != b[i]) {
				k++;
			}
		}
		if (k <= 2) {
			out.println("YES");
		} else {
			out.println("NO");
		}
	}

	void run() {
		try {
			// br = new BufferedReader(new FileReader("G.in"));
			// out = new PrintWriter("G.out");

			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new A().run();
	}

	public String nextToken() throws IOException {
		while ((st == null) || (!st.hasMoreTokens()))
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
}