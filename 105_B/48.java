import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	int[] conf, L, B;
	int n, k, A, sz;
	double[] kill;
	double best = 0;
	
	double solv() {
		double res = 0;
		double[] a = new double[n];
		for (int i=0; i<n; i++) 
			a[i] = Math.min(100, L[i]+10*conf[i])/100.0;
		double[] dp1 = new double[sz];
		double[] dp2 = new double[sz];
		dp1[0] = 1;
		for (int i=0; i<n; i++) {
			for (int msk=0; msk<sz; msk++) { 
				dp2[msk] += dp1[msk]*a[i];
				dp2[msk|(1<<i)] += dp1[msk]*(1-a[i]);
			}
			for (int msk=0; msk<sz; msk++) {
				dp1[msk] = dp2[msk]; dp2[msk] = 0;
			}
		}
		/*for (int msk=0; msk<sz; msk++) {
			double p = 1;
			int cnt = 0;
			for (int i=0; i<n; i++)
				if ((msk&(1<<i))>0) {					
					p *= (100-a[i])/100.0;
				} else {
					p *= a[i]/100.0;
					cnt++;
				}
			if (cnt>n/2) res += p; else res += p*kill[msk];
		}
		res /= sz;*/
		
		for (int msk=0; msk<sz; msk++){
			if (n-Integer.bitCount(msk) > n/2) res += dp1[msk]; else res += dp1[msk]*kill[msk]; 
		}
			
		return res;
		
	}
	void gen(int n, int k) {
		if (n==0) {
			conf[0] = k;
			//conf[0] = 2; conf[1] = 1; conf[2] = 3;
			double x = solv();
			if (x>best) best = x;
			return;
			
		}
		for (int i=0; i<=k; i++) {
			conf[n] = i;
			gen(n-1, k-i);
		}
		conf[n] = 0;
	}
	void solve() throws IOException {
		n = nextInt();
		k = nextInt();
		A = nextInt();
		B = new int[n];
		L = new int[n];
		for (int i=0; i<n; i++) {
			B[i] = nextInt();
			L[i] = nextInt();
		}
		sz = 1<<n;
		conf = new int[n];
		kill = new double[sz];
		for (int msk=0; msk<sz; msk++) {
			int sum = 0;
			for (int i=0; i<n; i++)
				if ((msk&(1<<i))>0) {
					sum += B[i];
				}
			kill[msk] = A*1./(A+sum);
		}
		gen(n-1, k);
		out.printf(Locale.US, "%1.9f", best);
		
		
		
		
		
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			// br = new BufferedReader(new FileReader("input.txt"));
			// out = new PrintWriter("output.txt");
			solve();
			br.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(123);
		}
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null)
				return null;
			st = new StringTokenizer(s,", \t");
		}
		return st.nextToken();
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public static void main(String[] args) {
		new Thread(new Main()).start();
	}
}
