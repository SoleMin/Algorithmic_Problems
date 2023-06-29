import java.io.*;
import java.util.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Main implements Runnable {
	
	int n;
	
	boolean inBound (int x, int y) {
		return x >= 1 && y >= 1 && x <= n && y <= n;
	}
	
	void solve() throws Exception {
		n = sc.nextInt();
		int y = sc.nextInt();
		int x = sc.nextInt();
		int c = sc.nextInt();
		
		int yu = y;
		int yd = y;
		int xl = x;
		int xr = x; 
		
		int current = 1;
		int time = 0;
		while (current < c) {
			time++;
			yu--;
			yd++;
			xl--;
			xr++;
			// left - up
			{
				int cur = time - 1;
				if (yu < 1) {
					cur -= (-yu);
				}
				if (xl < 1) {
					cur -= (-xl);
				}
				if (cur > 0) {
					current += cur;
				}
			}
			// right - up
			{
				int cur = time - 1;
				if (yu < 1) {
					cur -= (-yu);
				}
				if (xr > n) {
					cur -= (xr - n - 1);
				}
				if (cur > 0) {
					current += cur;
				}
			}
			// left - down
			{
				int cur = time - 1;
				if (yd > n) {
					cur -= (yd - n - 1);
				}
				if (xl < 1) {
					cur -= (-xl);
				}
				if (cur > 0) {
					current += cur;
				}
			}
			// right - down
			{
				int cur = time - 1;
				if (yd > n) {
					cur -= (yd - n - 1);
				}
				if (xr > n) {
					cur -= (xr - n - 1);
				}
				if (cur > 0) {
					current += cur;
				}
			}
			
			if (inBound(x, yd)) current++;
			if (inBound(x, yu)) current++;
			if (inBound(xl, y)) current++;
			if (inBound(xr, y)) current++;
		}
		
		out.println(time);
	}

	BufferedReader in;
	PrintWriter out;
	FastScanner sc;

	static Throwable uncaught;

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			sc = new FastScanner(in);
			solve();
		} catch (Throwable t) {
			Main.uncaught = t;
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) throws Throwable {
		Thread t = new Thread(null, new Main(), "", (1 << 26));
		t.start();
		t.join();
		if (uncaught != null) {
			throw uncaught;
		}
	}

}

class FastScanner {

	BufferedReader reader;
	StringTokenizer strTok;

	public FastScanner(BufferedReader reader) {
		this.reader = reader;
	}

	public String nextToken() throws IOException {
		while (strTok == null || !strTok.hasMoreTokens()) {
			strTok = new StringTokenizer(reader.readLine());
		}
		return strTok.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

}