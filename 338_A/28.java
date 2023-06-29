import java.io.*;
import java.util.*;

public class A {
	long mod = (long)(1e+9+9);
	long pow(long a,long b) {
		long mul = a;
		long res = 1;
		while (b > 0) {
			if (b %2 == 1) {
				res = (res*mul)%mod;
			}
			mul = (mul*mul)%mod;
			b/=2;
		}
		return res;
	}

	void solve() throws IOException {
		long n = nextLong();
		long m = nextLong();
		long k = nextLong();
		long l = -1;
		long r = m / k;
		while (l < r - 1) {
			long mid = (l+r)/2;
			long leftOk = m - mid*k;
			long leftPos = n - mid*k;
			long cgroups = (leftOk + (k-2)) / (k-1);
			long positions = leftOk+cgroups-1;
			if (positions <= leftPos) {
				r = mid;
			} else {
				l = mid;
			}
		}
		long res = pow(2,r+1);
		res = (res - 2 + mod) %mod;
		res = (res*k) % mod;
		res = (res+m-r*k) %mod;
		out.println(res);
		
		
		
		
	}

	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		new A().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String temp = in.readLine();
			if (temp == null) {
				return null;
			}
			st = new StringTokenizer(temp);
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

}
