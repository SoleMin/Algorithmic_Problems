import java.io.*;
import java.util.*;

public class Sol122A {

	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	long nextLong() throws Exception {
		return Long.parseLong(next());
	}

	double nextDouble() throws Exception {
		return Double.parseDouble(next());
	}

	void solve() throws Exception {
		long x = nextLong();
		out.println((x % 4) * (x % 7) * (x % 74) * (x % 47) * (x % 44) * (x % 77) * (x % 444) * (x % 447) * (x % 474) * (x % 477) * (x % 744) * (x % 747) * (x % 774) * (x % 777) == 0 ? "YES" : "NO");
	}

	void run() {
		try {
			Locale.setDefault(Locale.US);
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		new Sol122A().run();
	}

}
