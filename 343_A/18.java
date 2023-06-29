import java.io.*;
import java.util.*;

public class taskA {

	void solve() throws IOException {
		long a = nextLong();
		long b = nextLong();

		long ans = 0;
		while (a  != 0 && b != 0) {
			if (a > b) {
				ans += a / b;
				a %= b;
			} else {
				long c = b % a;
				ans += b / a;
				b = a;
				a = c;
			}
		}
		out.println(ans);
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;

	void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			// br = new BufferedReader(new FileReader(new File("taskA.in")));
			// out = new PrintWriter("taskA.out");
			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new taskA().run();
	}

	String nextToken() throws IOException {
		while ((st == null) || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}

	double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(nextToken());
	}

	long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(nextToken());
	}
}
