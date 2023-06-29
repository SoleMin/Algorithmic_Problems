import static java.lang.Math.*;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.exit;
import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.fill;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		try {
			if (new File("input.txt").exists())
				System.setIn(new FileInputStream("input.txt"));
		} catch (SecurityException e) {
		}
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new Main().run();
				} catch (Throwable e) {
					e.printStackTrace();
					exit(999);
				}
			}
		}, "1", 1 << 23).start();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");

	int n, m;
	int dp[][][];
	int MV = Integer.MAX_VALUE >> 1;
	int ans = MV;
	
	private void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		n = nextInt();
		m = nextInt();
		if(n < m){ int d = n; n = m; m = d; }
		int M = 1 << m;
		dp = new int[n][M][M];
		for(int a[][] : dp)
			for(int b[] : a)
				fill(b, MV);
		
//		for(int i = 0 ; i < M; i++){
//			int next = (( i | (i << 1) | (i >> 1) ) & (M - 1));
//			if(  next!= (M -1))
//				continue;
//			if(n > 1)
//				dp[0][next][0] = Integer.bitCount(i);
//			else
//				ans = min(ans, Integer.bitCount(i));
//		}
		dp[0][0][0] = 0;
		
		for(int i = 0; i < n; i++)
			for(int m1 = 0; m1 < M; m1++)
				for(int m2 = 0; m2 < M; m2++){
					if(dp[i][m1][m2] == MV)
						continue;
					for(int nm1 = 0; nm1 < M; nm1++)
						for(int nm2 = 0; nm2 < M; nm2++){
							int res1 = m1 | (nm1) | (nm1 << 1) | (nm1 >> 1) | (nm2);
							res1 &= (M - 1);
							
							if(res1 != (M - 1))
								continue;
							
							
							int res2 = m2 | (nm1) | (nm2 << 1) | (nm2 >> 1) | (nm2);
							res2 &= (M - 1);
							
//							if(i == 2 && m1 == 3 && m2 == 2 && nm1 == 0 && nm2 == 0){
//								System.err.println("kek");
//								System.err.println(dp[i][m1][m2]);
//								System.err.println(res1 + " | " + res2);
//								System.err.println(M);
//							}
							
							int next1 = res2 & (M - 1);
							int next2 = nm2 & ( M - 1);
							int over = Integer.bitCount(nm1) + Integer.bitCount(nm2);
							
							if(i < n - 1)
								dp[i+1][next1][next2] = min(dp[i + 1][next1][next2], dp[i][m1][m2] + over);
							else
								if((res1 & (M - 1)) == (M - 1)){
									ans = min(dp[i][m1][m2] + over, ans);
								}
						}
					
				}
//		System.err.println(ans);
		out.println(n * m - ans);
		
		in.close();
		out.close();
	}
	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
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
	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}
	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			st = new StringTokenizer(s);
		}
		return false;
	}
}
