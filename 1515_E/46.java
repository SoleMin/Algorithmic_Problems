import java.io.*;
import java.util.*;

public class E {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		readInput();
		out.close();
	}
	
	static long[][] dp;
	static int n;
	static long m;
	

	static long pow(long b, long e) {
		if (e== 0) return 1;
		long r= pow(b,e/2);
		r = r * r % m;
		if ((e&1)==1) return r *b%m;
		return r;
	}
	
	static long modinv(long a) {return pow(a,m-2);}
	
	static long solve(int len, int num) {
		if (len == -1 && num == -1) return 1;
		if (num < 0 || len <= 0) return 0;
		if (dp[len][num] == -1) {
			dp[len][num] = 0;
			for (int i = 0; i < len; i++) {
				if (i == 1) continue;
				long sol = pow[len-i-1]*solve(i-1,num-1)%m;
				sol = sol * faci[len-i]% m;
				dp[len][num] += sol;
				dp[len][num] %= m;
			}
			
		}
		return dp[len][num];
	}
	static long[] fac, faci, pow;
	
	public static void readInput() throws IOException {
		// br = new BufferedReader(new FileReader(".in"));
		// out = new PrintWriter(new FileWriter(".out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		fac = new long[500];
		pow = new long[500];
		faci = new long[fac.length];
		fac[0] = pow[0] = 1;
		faci[0] = modinv(fac[0]);
		for (int i = 1; i < fac.length; i++) {
			fac[i] = fac[i-1]*i%m;
			faci[i] = modinv(fac[i]);
			pow[i] = pow[i-1] * 2 % m;
		}
		dp = new long[n+1][n+1];
		for (long[] a: dp) Arrays.fill(a, -1);
		// Number of ways to make a segment of length x is 2^(x-1)
		// DP: Given position I.
		long ans =0 ;
		for (int i = 0 ; i <= n/2+1; i++) {
			//System.out.println(i + ": " + solve(n,i) + " " + (n-i) + " " + (i));
			long sol = solve(n,i) * fac[n-i];
			sol %= m;
			ans += sol;
		}
		out.println(ans%m);
	}
}
