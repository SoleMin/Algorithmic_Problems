import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	/**
	 * @param args
	 */
	static int N, M;
	static long[] C;
	static int[][] g;
	static long[][] DP;
	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		
		N = r.nextInt();
		M = r.nextInt();
		
		g = new int[N][N];
		
		C = new long[N + 1];
		
		DP = new long[1 << N][N];
		
		for(int k = 0; k < M; k++){
			int i = r.nextInt() - 1;
			int j = r.nextInt() - 1;
			
			g[i][j] = g[j][i] = 1;
		}
		
		for(long[] i : DP)
			Arrays.fill(i, -1);
		
		long ret = 0;
		for(int s = 0; s < N; s++){
			ret += go(s, 1 << s, s);
		}
		
		System.out.println(ret / 2);
	}
	
	private static long go(int s, int m, int e) {
		if(DP[m][e] != -1)return DP[m][e];
		
		long cnt = 0;
		for(int j = s; j < N; j++)if(g[e][j] == 1){
			if((m & (1 << j)) != 0){
				if(s == j && Integer.bitCount(m) >= 3){
					cnt++;
				}
			}else{
				cnt += go(s, m | 1 << j, j);
			}
		}

		return DP[m][e] = cnt;
	}

	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
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
		}
		
		public double nextDouble(){
			return Double.parseDouble(next());
		}
	}
}
