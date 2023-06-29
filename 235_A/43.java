import java.util.*;
import java.io.*;

public class Main {
	boolean eof;

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return "-1";
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	void solve() {
		long n = nextInt(), ans = n;
		if (n % 6 == 0) {
			ans = Math.max((n - 1) * (n - 2) * (n - 3), ans);
		} else if (n % 2 == 0) {
			ans = Math.max(ans, n * (n - 1) * (n - 3));
		} else {
			ans = Math.max(n * (n - 1) * (n - 2), ans);
		}
		out.print(ans);
	}
	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;

	void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new OutputStreamWriter(System.out));

			// br = new BufferedReader(new FileReader("input.txt"));
			// out = new PrintWriter(new FileWriter("output.txt"));

			solve();

			br.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
