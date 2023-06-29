import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;


public class A {
	
	private long pow(long num, long pow, long mod) {
		if (pow <= 0) {
			return 1;
		}
		if ((pow & 1) != 0) {
			return (num * pow(num, pow-1, mod)) % mod;
		}
		else {
			long tmp = pow(num, pow>>1, mod) % mod;
			return (tmp*tmp)%mod;
		}
	}
	
	public void run() {
		long MOD = 1000000009;
		long n = nextInt();
		long m = nextInt();
		long k = nextInt();
		
		long critical = n/k;
		if (n-critical >= m) {
			out.println(m);
		}
		else {
			long doubles = m - (n-critical);
			long ans = (pow(2, doubles + 1, MOD) - 2 + MOD)%MOD;
			ans = (ans * k)%MOD;
			ans = (ans + (m-(doubles*k)))%MOD;
			out.println(ans);
		}
		out.flush();
	}
	
	private static BufferedReader br = null;
	private static StringTokenizer stk = null;
	private static PrintWriter out = null;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		(new A()).run();
	}
	
	private void loadLine() {
		try {
			stk = new StringTokenizer(br.readLine());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int nextInt() {
		while (stk==null || !stk.hasMoreElements()) loadLine();
		return Integer.parseInt(stk.nextToken());
	}
	
	private long nextLong() {
		while (stk==null || !stk.hasMoreElements()) loadLine();
		return Long.parseLong(stk.nextToken());
	}
	
	private double nextDouble() {
		while (stk==null || !stk.hasMoreElements()) loadLine();
		return Double.parseDouble(stk.nextToken());
	}
	
	private String nextWord() {
		while (stk==null || !stk.hasMoreElements()) loadLine();
		return (stk.nextToken());
	}
	
}
