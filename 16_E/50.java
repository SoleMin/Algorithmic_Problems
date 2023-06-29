import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.*;

public class BetaRound16_E implements Runnable {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	public static void main(String[] args) {
		new Thread(null, new BetaRound16_E(), "", 256 * (1L << 20)).start();
	}

	public void run() {
		try {
			long t1 = System.currentTimeMillis();
			if (System.getProperty("ONLINE_JUDGE") != null) {
				in = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			} else {
				in = new BufferedReader(new FileReader("input.txt"));
				out = new PrintWriter("output.txt");
			}
			Locale.setDefault(Locale.US);
			solve();
			in.close();
			out.close();
			long t2 = System.currentTimeMillis();
			System.err.println("Time = " + (t2 - t1));
		} catch (Throwable t) {
			t.printStackTrace(System.err);
			System.exit(-1);
		}
	}

	String readString() throws IOException {
		while (!tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	int readInt() throws IOException {
		return Integer.parseInt(readString());
	}

	long readLong() throws IOException {
		return Long.parseLong(readString());
	}

	double readDouble() throws IOException {
		return Double.parseDouble(readString());
	}

	// solution
	
	double[] p;
	int n;
	double[][] a;
	
	void solve() throws IOException {
		n = readInt();
		a = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = readDouble();
			}
		}
		p = new double[1 << n];
		Arrays.fill(p, -1);
		p[(1 << n) - 1] = 1;
		for (int i = 0; i < n; i++) {
			out.printf("%.12f ", p(1 << i));
		}
	}
	
	double p(int mask) {
		if (p[mask] != -1) return p[mask];
		double ans = 0;
		for (int eaten = 0; eaten < n; eaten++) {
			int prev = mask | (1 << eaten);
			if (prev != mask) {
				for (int eats = 0; eats < n; eats++) {
					if ((mask & (1 << eats)) != 0) {
						ans += a[eats][eaten] * p(prev);
					}
				}
			}
		}
		int bc = Integer.bitCount(mask);
		int norm = bc * (bc + 1) / 2;
		return p[mask] = ans / norm;
	}
	
}
