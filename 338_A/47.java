import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class A {
	
	static StringTokenizer st;
	static BufferedReader in;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//		long a = 2;
//		int q = nextInt();
//		long sum = a;
//		int s = q;
//		for (int i = 2; i <= s; i++) {
//			a = a*2+2;
//			sum += a;
//		}
//		System.out.println(sum);
//		System.out.println((4*((long)Math.pow(2, s)-1)-2*s));
		int n = nextInt();
		int m = nextInt();
		int k = nextInt();
		long t = (long)(n-m) * k;
		int mod = (int) (1e9+9);
		long ans = 0;
		int x = m / (k-1);
		if (m % (k-1) != 0)
			x++;
		if (n-m < x-1) {
			int s = (int) (n - t);
			int cnt = s / k;
			ans = BigInteger.valueOf(2).modPow(BigInteger.valueOf(cnt+1), BigInteger.valueOf(mod)).longValue();
			ans = (ans-2+mod) % mod;
//			ans = ans * 4 % mod;
//			ans = (ans-2*cnt+2*mod) % mod;
			ans = ans * k % mod;
			ans = (ans+(long)(k-1) * (n-m) % mod) % mod;
			ans = (ans+s % k) % mod;
		}
		else
			ans = m;
		System.out.println(ans);
		pw.close();
	}
	private static int nextInt() throws IOException{
		return Integer.parseInt(next());
	}
	
	private static long nextLong() throws IOException{
		return Long.parseLong(next());
	}
	
	private static double nextDouble() throws IOException{
		return Double.parseDouble(next());
	}
	
	private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
}
