import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			final int N = sc.nextInt();
			
			String[] ins = new String[N];
			for(int i = 0; i < N; i++){
				ins[i] = sc.next();
			}
			
			final long MOD = 1000000007;
			long[] DP = new long[N];
			long[] nextDP = new long[N];
			
			DP[0] = 1;
			
			for(int i = 1; i < N; i++){
				Arrays.fill(nextDP, 0);
				if("f".equals(ins[i - 1])){
					for(int j = 0; j < N - 1; j++){
						nextDP[j + 1] += DP[j];
						nextDP[j + 1] %= MOD;
					}
				}else{
					for(int j = N - 1; j >= 0; j--){
						nextDP[j] += DP[j];
						nextDP[j] %= MOD;
						
						if(j < N - 1){
							nextDP[j] += nextDP[j + 1];
							nextDP[j] %= MOD;
						}
					}
				}
				
				{
					long[] tmp = DP;
					DP = nextDP;
					nextDP = tmp;
				}
			}
			
			long answer = 0;
			for(int i = 0; i < N; i++){
				answer += DP[i];
				answer %= MOD;
			}
			
			System.out.println(answer);
		}
	}

	public static class Scanner implements Closeable {
		private BufferedReader br;
		private StringTokenizer tok;

		public Scanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		private void getLine() {
			try {
				while (!hasNext()) {
					tok = new StringTokenizer(br.readLine());
				}
			} catch (IOException e) { /* ignore */
			}
		}

		private boolean hasNext() {
			return tok != null && tok.hasMoreTokens();
		}

		public String next() {
			getLine();
			return tok.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}

		public void close() {
			try {
				br.close();
			} catch (IOException e) { /* ignore */
			}
		}
	}
}
