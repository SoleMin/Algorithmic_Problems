import java.io.*;

import java.awt.geom.Point2D;
import java.text.*;
import java.math.*;
import java.util.*;

public class Main implements Runnable {

	final String filename = "";

	public void solve() throws Exception {
		int n = iread(), m = iread();
		int INF = -1;
		if (m > n) {
			int t = m;
			m = n;
			n = t;
		}
		int[][][] d = new int[2][1 << m][1 << m];
		for (int i = 0; i < 1 << m; i++)
			Arrays.fill(d[0][i], INF);

		int[] cnt = new int[1 << m];
		for (int i = 0; i < 1 << m; i++)
			cnt[i] = cnt[i / 2] + i % 2;

		int step = 0;
		d[0][0][0] = 0;
		for (int u = 0; u < n; u++) {
			for (int i = 0; i < 1 << m; i++)
				Arrays.fill(d[step ^ 1][i], INF);
			for (int mask1 = 0; mask1 < 1 << m; mask1++)
				for (int mask2 = 0; mask2 < 1 << m; mask2++) {
					int t = d[step][mask1][mask2];
					if (t == INF)
						continue;
					for (int mask = 0; mask < 1 << m; mask++) {
						if ((mask1 & mask) != mask1)
							continue;
						int mask01 = ((1 << m) - 1) & ~mask2;

						for (int j = 0; j < m; j++)
							if ((mask & (1 << j)) != 0) {
								if (j > 0)
									mask01 &= ~(1 << (j - 1));
								mask01 &= ~(1 << j);
								if (j + 1 < m)
									mask01 &= ~(1 << (j + 1));
							}
						int mask02 = mask;

						int t2 = t + cnt[((1 << m) - 1) & ~mask];
						if (d[step ^ 1][mask01][mask02] < t2) {
							d[step ^ 1][mask01][mask02] = t2;
						}
					}
				}
			step ^= 1;
		}
		int ans = INF;
		for (int mask = 0; mask < 1 << m; mask++) {
			ans = Math.max(ans, d[step][0][mask]);
		}
		out.write(ans + "\n");
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