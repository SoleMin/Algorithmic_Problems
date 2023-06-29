import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemA {

	String fileName = "prizes";

	public void solve() throws IOException {
		int n = nextInt();
		int d = nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		int ans = 2;
		for (int i = 1; i < n; i++) {
			if (a[i] - a[i - 1] == 2 * d)
				ans++;
			if (a[i] - a[i - 1] > 2 * d)
				ans += 2;

		}
		out.println(ans);
	}

	public void run() {
		try {

			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out, true);

			// out = new PrintWriter(fileName + ".out");
			// br = new BufferedReader(new FileReader(fileName + ".in"));
			// out = new PrintWriter(fileName + ".out");
			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	BufferedReader br;
	StringTokenizer in;
	static PrintWriter out;

	public String nextToken() throws IOException {
		while (in == null || !in.hasMoreTokens()) {
			in = new StringTokenizer(br.readLine());
		}
		return in.nextToken();
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

	public static void main(String[] args) throws IOException {
		new ProblemA().run();
	}

}