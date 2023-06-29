import java.io.*;

import java.awt.geom.Point2D;
import java.text.*;
import java.math.*;
import java.util.*;

public class Main implements Runnable {

	final String filename = "";

	public void solve() throws Exception {
		int n = iread();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = iread();
		Arrays.sort(a);
		boolean test = true;

		for (int i = 0; i < n; i++) {
			if (a[i] != 1)
				test = false;
			int min = (i == 0) ? 1 : a[i - 1];
			if (test && i == n - 1)
				out.write((min + 1) + "");
			else
				out.write(min + "");
			if (i == n - 1)
				out.write("\n");
			else
				out.write(" ");
		}
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