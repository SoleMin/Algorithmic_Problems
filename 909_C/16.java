import java.util.*;
import java.io.*;

public class c implements Runnable{
	int N;
	int[] arr;
	public static void main(String[] args) { new Thread(null, new c(), "", 1<<27).start(); } public void run() {
		arr = new int[N = nextInt()];
		for(int n=0;n<N;n++) {
//			System.out.println(n+" s");
			if(nextString().charAt(0) == 'f') {
				arr[n] = 1;
			}
		}
		long[][] dp = new long[N+1][N+1];
		dp[0][0] = 1;
		for(int i = 0; i < N; i++) {
			// if this is an s
			if(arr[i] == 0) {
				// transition from the one directly above and everything to the right of that
				// for each dp space. using cumulative sums will make this easier
				long sum = 0;
				for(int j = N; j >= 0; j--) {
					sum += dp[i][j];
					sum %= 1_000_000_007L;
					dp[i+1][j] += sum;
					dp[i+1][j] %= 1_000_000_007L;
				}
			}
			// otherwise, this is an f
			else {
				// transition from the spot on the top left
				for(int j = 1; j <= N; j++) {
					dp[i+1][j] += dp[i][j-1];
					dp[i+1][j] %= 1_000_000_007L;
				}
			}
		}
		
		// answer is the sum of the last row
		long ans = 0;
		for(long l : dp[N-1]) ans = (ans + l) % 1_000_000_007;
		System.out.println(ans);
	}
	

	// fast scanner stuff
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String[] line = null; int line_ptr = 0;
	void read() {
		try {
			line = br.readLine().split(" ");
		}
		catch(IOException ioe) {
			System.err.println("bad input");
			line = null;
		}
	}
	void ensure() {
		while(line == null || line.length <= line_ptr) {
			read();
			line_ptr = 0;
		}
	}
	int nextInt() {
		ensure();
		return Integer.parseInt(line[line_ptr++]);
	}
	long nextLong() {
		ensure();
		return Integer.parseInt(line[line_ptr++]);
	}
	String nextString() {
		ensure();
		return line[line_ptr++];
	}
}