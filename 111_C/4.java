import java.io.*;
import java.util.*;

public class Main
{
	static final boolean _DEBUG = false;

	private static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner(BufferedReader _br) {
			br = _br;
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
					return "";
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

	static MyScanner   scan;
	static PrintWriter out;

	static int debugCount = 0;
	static void debug(String msg) {
		if (_DEBUG && debugCount < 200) {
			out.println(msg);
			out.flush();
			debugCount++;
		}
	}
	
    public static void main (String args[]) throws IOException {
//    	scan = new MyScanner(new BufferedReader(new FileReader("test.in")));
    	scan = new MyScanner(new BufferedReader(new InputStreamReader(System.in)));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Main inst = new Main();
        inst.execute();
        out.close();
    }
    
    int N, M, pow;
    int[] counts;
    int[][][] dp;
    
    void execute() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	if (N < M) {
    		int temp = N;
    		N = M;
    		M = temp;
    	}
    	pow = 1<<M;
    	counts = new int[pow];
    	dp = new int[N][pow][pow];
    	for (int[][] i : dp) {
    		for (int[] j : i) {
    			Arrays.fill(j, -1);
    		}
    	}
    	for (int i = 0; i < pow; i++) {
    		counts[i] = Integer.bitCount(i);
        	dp[0][i][0] = counts[i];
    	}
    	int spiders = Integer.MAX_VALUE;
    	for (int y = 0; y < N-1; y++) {
    		for (int i = 0; i < pow; i++) {
    			for (int j = 0; j < pow; j++) {
    				if (dp[y][i][j] == -1) {
    					continue;
    				}
    				for (int k = 0; k < pow; k++) {
    					if (((i|(i<<1)|(i>>1)|j|k)&(pow-1))==(pow-1)) {
    						int value = dp[y][i][j] + counts[k];
    						if (dp[y+1][k][i] == -1 || dp[y+1][k][i] > value) {
    							dp[y+1][k][i] = value;
    						}
    					}
    				}
    			}
    		}
    	}
//    	for (int i = 0; i < N; i++) {
//        	System.out.println(Arrays.deepToString(dp[i]));
//    	}
    	for (int i = 0; i < pow; i++) {
    		for (int j = 0; j < pow; j++) {
    			if (dp[N-1][i][j] != -1 && ((i|(i<<1)|(i>>1)|j)&(pow-1))==(pow-1)) {
    				spiders = Math.min(spiders, dp[N-1][i][j]);
//    				System.out.println(spiders+" "+i+" "+j);
    			}
    		}
    	}
    	out.println((N*M)-spiders);
    }
}
