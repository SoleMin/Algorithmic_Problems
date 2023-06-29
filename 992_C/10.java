import java.io.*;
import java.util.*;

public class A992{
	
	long mod = 1000000007L;
	
	private void solve() throws Exception {
		long x = nextLong();
		long k = nextLong();
		if(x == 0) {
			out.println(0);
			return;
		}
		x = x%mod;
		long res = (((x*pow(2,k+1))%mod + (mod-pow(2,k))%mod)%mod+1)%mod;    
		out.println(res);
	}
	
	long pow(long m, long n){
	    long res = 1;
	    while(n > 0){
	        if(n % 2 == 1)res = (res*m)%mod;
	        m = (m*m)%mod;
	        n = n/2;
	    }
	    return res;
	} 
	
	public static void main(String[] args) {
		(new A992()).run();
	}

	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer tokenizer;

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
			out = new PrintWriter(System.out);
			solve();
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	private float nextFloat() throws IOException {
		return Float.parseFloat(nextToken());
	}

	private String nextLine() throws IOException {
		return new String(in.readLine());
	}

	private String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(in.readLine());
		}
		return tokenizer.nextToken();
	}


}

