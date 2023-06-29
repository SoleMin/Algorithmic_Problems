import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class A {	
	BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;
    
    long MOD = 1000000009;
    public long mod_add(long n1, long n2){
    	return (n1 + n2) % MOD;
    }    
    public long mod_time(long n1, long n2){
    	return (n1 * n2) % MOD;
    }
    public long mod_power(long a, int k) {
        if (k == 0) return 1;
        if (k % 2 == 0) return mod_power(a * a % MOD, k / 2);
        return a * mod_power(a, k - 1) % MOD;
	}
    
	public void solve() throws IOException {				
		int N = nextInt();
		int M = N - nextInt(); //wrong
		int K = nextInt();
		
		int full = N/K - M;	
		if( full < 0){
			out.println( N - M );return;
		}
		long ans = mod_time( K * 2, mod_power(2, full) - 1 );
//		out.println( full + ", " + ans );
		
		ans = mod_add(ans, N-M-full*K );
		
		out.println( ans );
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new A().run();
	}
	
	public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            out = new PrintWriter(System.out);
            solve();
            reader.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

}
