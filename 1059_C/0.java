import java.util.*;

import java.io.*;
import java.math.*;
import java.awt.geom.*;
import static java.lang.Math.*;

public class Solution implements Runnable {

	long mod1 = (long) 1e9 + 7;
	int mod2 = 998244353;

	public void solve() throws Exception {
		int n=sc.nextInt();
		if(n==1) {
			out.println(1);
			return;
		}
		else if(n==2) {
			out.println(1+" "+2);
			return;
		} 
		else if(n==3) {
			out.println("1 1 3");
			return;
		}
		else call(n,1);


	}
	
	public void call(int x,int y) {
		if(x==1) {
			out.print(y+" ");
			return;
		}
		if(x==3) {
			out.print(y+" "+y+" "+3*y);
			return;
		}
		for(int i=0;i<(x+1)/2;i++) {
			out.print(y+" ");
		}
		call(x/2,y*2);
	}

	static void sort(int[] a) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
	}

	static long gcd(long a, long b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	static long ncr(int n, int r, long p) {
		if (r > n)
			return 0l;
		if (r > n - r)
			r = n - r;

		long C[] = new long[r + 1];

		C[0] = 1;

		for (int i = 1; i <= n; i++) {

			for (int j = Math.min(i, r); j > 0; j--)
				C[j] = (C[j] + C[j - 1]) % p;
		}
		return C[r] % p;
	}

	public long power(long x, long y, long p) {
		long res = 1;
		// out.println(x+" "+y);
		x = x % p;
		if (x == 0)
			return 0;

		while (y > 0) {
			if ((y & 1) == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}

	static Throwable uncaught;

	BufferedReader in;
	FastScanner sc;
	PrintWriter out;

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			sc = new FastScanner(in);
			solve();
		} catch (Throwable uncaught) {
			Solution.uncaught = uncaught;
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) throws Throwable {
		Thread thread = new Thread(null, new Solution(), "", (1 << 26));
		thread.start();
		thread.join();
		if (Solution.uncaught != null) {
			throw Solution.uncaught;
		}
	}

}

class FastScanner {

	BufferedReader in;
	StringTokenizer st;

	public FastScanner(BufferedReader in) {
		this.in = in;
	}

	public String nextToken() throws Exception {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}

	public int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}

	public int[] readArray(int n) throws Exception {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	public long nextLong() throws Exception {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws Exception {
		return Double.parseDouble(nextToken());
	}

}