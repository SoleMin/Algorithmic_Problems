import java.io.*;
import java.util.*;

public class History {
	static final int INF = (int)1E9;
	static final double EPS = 1E-9;
	static final long MOD = INF + 9;
	
	static long powmod(long p) {
		long res = 1;
		long d = 2;
		while (p > 0) {
			if (p % 2 == 1) {
				res = (res * d) % MOD;
				p--;
			}
			else {
				d = (d * d) % MOD;
				p /= 2;
			}
		}
		return res % MOD;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		long n = in.nextLong();
		long m = in.nextLong();
		long k = in.nextLong();
		
		long ans = 0;
		
		long t = (k - 1) * (n - m);
		
		if (t <= m) {
			n -= k * (n - m);
			
			long g = n / k;
			
			ans = 2 * k * (powmod(g) - 1) + n % k;
			
			ans = (ans + t) % MOD;
		}
		else {
			ans = m;
		}
		
		System.out.println(ans % MOD);
	}
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
    	return Long.parseLong(next());
    };
}