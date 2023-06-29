import java.io.*;
import java.util.*;

public class A {

	long gcd(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	long solve(long a,long b) {
		if (a == 0 || b ==0) {
			return 0;
		}
		long t = gcd(a,b);
		a /= t;
		b /= t;
		if (a>b) {
			return solve(a%b,b)+a/b;
		} else {
			return solve(a,b%a)+b/a;
		}
		
	}

	void solve() throws IOException {
		long a = nextLong();
		long b = nextLong();
		out.println(solve(a, b));
	}

	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		new A().run();
	}

	BufferedReader br;
	PrintWriter out;
	StringTokenizer str;

	String next() throws IOException {
		while (str == null || !str.hasMoreTokens()) {
			str = new StringTokenizer(br.readLine());
		}
		return str.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

}
