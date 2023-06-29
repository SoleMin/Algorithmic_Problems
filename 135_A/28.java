import java.io.*;
import java.math.*;
import java.util.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
	

	public void solve() throws Exception {
		int n = nextInt();
		int a [] = new int [n];
		for (int i = 0 ;i < n; i++) {
			a[i] = nextInt();
		}
		Arrays.sort(a);
		if (n == 1) {
			if (a[0] == 1) {
				out.print(2);
			} else {
				out.print(1);
			}
		} else {
			out.print(1);
			for (int i = 1; i < n; i++) {
				if (i == n-1 && a[i] == 1) {
					out.print(" "+2);
				} else {
					out.print(" "+a[i-1]);
				}
			}
		}
	}
	
		
	/********************************************************************************************/
	/* THERE IS INPUT */

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	long stime=0;
	
	private String next() throws Exception {
		while (st == null || !st.hasMoreElements())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	private int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	private long nextLong() throws Exception {
		return Long.parseLong(next());
	}

	private double nextDouble() throws Exception {
		return Double.parseDouble(next());
	}
	
	public void run() {
		try {
			//Locale.setDefault(Locale.US);
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			out.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Thread(null, new Solution(), "", 1 << 25).start();
	}

	
}
