
import java.util.*;
import java.io.*;
import java.math.*;

public class a extends Thread {

	BufferedReader bf;
	PrintWriter out;
	FastScanner in;

	void solve() throws Exception {
		long n = in.nextLong();
		long f[] = new long[2001];
		int i = 2;
		f[0] = 0;
		f[1] = 1;
		while (true){
			f[i] = f[i-1] + f[i-2];
			if (f[i] < n) i++;
			else break;
		}
		if (n == 1) out.println("1 0 0");
		else if (n == 0) out.println("0 0 0");
		else 
		if (i - 3 >= 0) out.println(f[i-2] +" " + f[i-2] + " " +f[i-3]);
		else out.println("I'm too stupid to solve this problem");
	}
	
	public void run() {
		try {
			bf = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			in = new FastScanner(bf);
			solve();
			out.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			out.close();
		}
	}

	public static void main(String args[]) {
		new a().start();
	}

	class FastScanner {
		BufferedReader bf;
		StringTokenizer st;

		public FastScanner(BufferedReader bf) {
			this.bf = bf;
		}

		public String nextToken() throws Exception {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(bf.readLine());
			}
			return st.nextToken();
		}

		public int nextInt() throws Exception {
			return Integer.parseInt(nextToken());
		}

		public long nextLong() throws Exception {
			return Long.parseLong(nextToken());
		}

		public Double nextDouble() throws Exception {
			return Double.parseDouble(nextToken());
		}

		public BigInteger nextBigInteger() throws Exception {
			return new BigInteger(nextToken());
		}
	}
}