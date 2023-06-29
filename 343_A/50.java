
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

import static java.lang.Math.*;

public class Solution implements Runnable {

	public long gcd(long a, long b) {
		long tmp;
		while (b > 0) {
			a %= b;
			tmp = a;
			a = b;
			b = tmp;
		}
		return a;
	}
	
	public void solve() throws Exception {
		long a = sc.nextLong();
		long b = sc.nextLong();
		long ans = 0;
		long k = 0;
		if (a == 1 || b == 1) {
			out.println(max(a, b));
			return;
		}
		while (a > 1 && b > 1) {
			if (a > b) {
				k = a / b;
				ans += k;
				a -= (k * b);				
			} else {
				k = b / a;
				ans += k;
				b -= (k * a);
			}
			k = gcd(a, b);
			a /= k;
			b /= k;
		}
		if (a == 1)
			ans += b;
		else
			ans += a;
		out.println(ans);
	}
	
	static Throwable throwable;
	
	BufferedReader in;
	PrintWriter out;
	FastScanner sc;
	
	public static void main(String[] args) throws Throwable {
		Thread thread = new Thread(null, new Solution(), "", (1 << 26));
		thread.start();
		thread.join();
		if (throwable != null) {
			throw throwable;
		}
	}
	
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			sc = new FastScanner(in);
			solve();
		} catch (Throwable throwable) {
			this.throwable = throwable;			
		} finally {
			out.close();
		}		
	}

}

class FastScanner {
	BufferedReader reader;
	StringTokenizer strTok;
	
	public FastScanner(BufferedReader reader) {
		this.reader = reader;
	}
	
	public String nextToken() throws Exception {
		while (strTok == null || !strTok.hasMoreTokens()) {
			strTok = new StringTokenizer(reader.readLine());
		}
		return strTok.nextToken();
	}
	
	public int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}
	
	public long nextLong() throws Exception {
		return Long.parseLong(nextToken());
	}
	
	public double nextDouble() throws Exception {
		return Double.parseDouble(nextToken());
	}
}
