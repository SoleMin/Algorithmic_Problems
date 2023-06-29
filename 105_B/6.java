import java.io.*;

import java.awt.geom.Point2D;
import java.text.*;
import java.math.*;
import java.util.*;

public class Main implements Runnable {

	final String filename = "";

	public void solve() throws Exception {
		int n = iread(), k = iread(), A = iread();
		int[] b = new int[n], l = new int[n];
		for (int i = 0; i < n; i++) {
			l[i] = iread();
			b[i] = iread();
		}

		int[] c = new int[n];
		double ans = 0.0;
		for (int mask = 0; mask < 1 << (k + n - 1); mask++) {
			int t = 0;
			for (int i = 0; i < n + k - 1; i++) {
				if ((mask & (1 << i)) != 0)
					t++;
			}
			if (t != k)
				continue;

			int x = mask;
			for (int i = 0; i < n; i++) {
				c[i] = b[i];
				while (x % 2 == 1) {
					c[i] += 10;
					x /= 2;
				}
				if (c[i] > 100)
					c[i] = 100;
				x /= 2;
			}
			double res = 0.0;
			for (int mask2 = 0; mask2 < 1 << n; mask2++) {
				int m = 0;
				double p = 1.0;
				t = 0;
				for (int i = 0; i < n; i++) {
					if ((mask2 & (1 << i)) == 0) {
						t += l[i];
						p *= (100.0 - c[i]) / 100.0;
					} else {
						p *= c[i] / 100.0;
						m++;
					}
				}
				if (m * 2 > n)
					res += p;
				else
					res += p * A * 1.0 / (A + t);
			}
			ans = Math.max(ans, res);
		}
		DecimalFormat df = new DecimalFormat("0.0000000");
		out.write(df.format(ans) + "\n");
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new BufferedWriter(new OutputStreamWriter(System.out));
			// in = new BufferedReader(new FileReader(filename+".in"));
			// out = new BufferedWriter(new FileWriter(filename+".out"));
			solve();
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public int iread() throws Exception {
		return Integer.parseInt(readword());
	}

	public double dread() throws Exception {
		return Double.parseDouble(readword());
	}

	public long lread() throws Exception {
		return Long.parseLong(readword());
	}

	BufferedReader in;

	BufferedWriter out;

	public String readword() throws IOException {
		StringBuilder b = new StringBuilder();
		int c;
		c = in.read();
		while (c >= 0 && c <= ' ')
			c = in.read();
		if (c < 0)
			return "";
		while (c > ' ') {
			b.append((char) c);
			c = in.read();
		}
		return b.toString();
	}

	public static void main(String[] args) {
		try {
			Locale.setDefault(Locale.US);
		} catch (Exception e) {

		}
		// new Thread(new Main()).start();
		new Thread(null, new Main(), "1", 1 << 25).start();
	}
}