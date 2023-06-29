import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class a {

	private void solve() throws Exception {
		int n = nextInt(), t = nextInt();
		int[] x = new int[n], a = new int[n];
		for (int i = 0; i < n; ++i){
			x[i] = nextInt();
			a[i] = nextInt();
		}
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n - 1; ++j){
				if (x[j] > x[j + 1]){
					int tmp = x[j];
					x[j] = x[j + 1];
					x[j + 1] = tmp;
					
					tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		int res = 2;
		for (int i = 1; i < n; ++i){
			int betw = (x[i] - x[i - 1]) * 2 - a[i] - a[i - 1];
			if (betw == t * 2)
				++res;
			else if (betw > t * 2)
				res += 2;
		}
		out.print(res);
	}

	public void run() {
		try {
			solve();
		} catch (Exception e) {
			NOO(e);
		} finally {
			out.close();
		}
	}

	PrintWriter out;
	BufferedReader in;
	StringTokenizer St;

	void NOO(Exception e) {
		e.printStackTrace();
		System.exit(1);
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	String nextToken() {
		while (!St.hasMoreTokens()) {
			try {
				String line = in.readLine();
				St = new StringTokenizer(line);
			} catch (Exception e) {
				NOO(e);
			}
		}
		return St.nextToken();
	}

	private a(String name) {
		try {
			in = new BufferedReader(new FileReader(name + ".in"));
			St = new StringTokenizer("");
			out = new PrintWriter(new FileWriter(name + ".out"));
		} catch (Exception e) {
			NOO(e);
		}
	}

	private a() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			St = new StringTokenizer("");
			out = new PrintWriter(System.out);
		} catch (Exception e) {
			NOO(e);
		}
	}

	public static void main(String[] args) {
		new a().run();
	}

}
