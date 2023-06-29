import java.io.*;
import java.util.*;

public class TemnayaAssambleya implements Runnable {
	public static void main(String[] args) {
		new Thread(new TemnayaAssambleya()).run();
	}

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer in;
	PrintWriter out = new PrintWriter(System.out);

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

	int[] l;
	int[] ln;
	int[] pw;
	int[] p;
	int A;
	double max = 0;

	public void gen(int n, int k) {
		if (n == 0) {
			n = p.length;
			p[0] = k;
			for (int i = 0; i < n; i++) {
				ln[i] = l[i] + p[i] * 10;
				if (ln[i] > 100)
					ln[i] = 100;
			}

			double ans = 0;
			for (int mask = 0; mask < 1 << n; mask++) {
				int z = 0;
				double pos = 1;
				int power = 0;
				for (int i = 0; i < n; i++) {
					if ((mask & (1 << i)) > 0) {
						z++;
						pos *= ln[i] * 1. / 100;
					} else {
						pos *= (100 - ln[i]) * 1. / 100;
						power += pw[i];
					}
				}

				if (z > n / 2) {
					ans += pos;
				} else {
					ans += pos * A / (A + power);
				}
			}
			
			max = Math.max(ans, max);
			return;
		}

		for (int i = 0; i <= Math.min(k, 10 - l[n] / 10); i++) {
			p[n] = i;
			gen(n - 1, k - i);
		}
	}

	public void solve() throws IOException {
		int n = nextInt();
		int k = nextInt();
		A = nextInt();

		p = new int[n];
		pw = new int[n];
		l = new int[n];
		ln = new int[n];

		for (int i = 0; i < n; i++) {
			pw[i] = nextInt();
			l[i] = nextInt();
		}

		gen(n - 1, k);
		out.println(max);
	}

	public void run() {
		try {
			solve();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
