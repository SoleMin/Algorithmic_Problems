import java.io.*;
import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.fill;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class Main {
	public static void main(String[] args) throws IOException {
//		try {
//			if (new File("input.txt").exists())
//				System.setIn(new FileInputStream("input.txt"));
//		} catch (SecurityException e) {}
		
//		long time1 = System.currentTimeMillis();
		new Main().run();
//		checkMemory();
//		long time2 = System.currentTimeMillis();
//		System.err.println((time2 - time1) + " ms");
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");
	
	int vNum;
	int eNum;
	boolean[][] g;
	
	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		vNum = nextInt();
		eNum = nextInt();
		g = new boolean [vNum][vNum];
		for (int e = 0; e < eNum; e++) {
			int u = nextInt() - 1;
			int v = nextInt() - 1;
			g[u][v] = g[v][u] = true;
		}
		
//		for (int v = 7; v <= 11; v++) {
//			genFullGraph(v);
//			if (naiveDP() != optimizedDP())
//				System.err.println("Error on " + v);
//		}
		
		out.println(optimizedDP());
		
		out.close();
	}
	
	/*************************************************************** 
	 * Test
	 **************************************************************/
	long naiveDP() {
		long[] count = new long [vNum + 1];
		int size = 1 << vNum;
		long[][] dp = new long [size][vNum];
		for (int begin = 0; begin < vNum; begin++) {
			for (long[] row : dp) fill(row, 0L);
			dp[1 << begin][begin] = 1L;
			for (int mask = 0; mask < size; mask++) {
				int len = Integer.bitCount(mask);
				for (int v = 0; v < vNum; v++) {
					long cval = dp[mask][v];
					if (cval == 0L) continue;
					if (g[v][begin]) count[len] += cval;
					for (int nv = 0; nv < vNum; nv++) {
						if (g[v][nv]) {
							int nmask = mask | (1 << nv);
							if (nmask != mask)
								dp[nmask][nv] += cval;
						}
					}
				}
			}
		}
		long ret = 0L;
		for (int len = 3; len <= vNum; len++) {
			if (count[len] % (len * 2) != 0) System.err.println("ERROR!");
			ret += count[len] / len / 2;
		}
		return ret;
	}
	
	long optimizedDP() {
		long[] count = new long [vNum + 1];
		long[][] dp = new long [1 << vNum][vNum];
		for (int last = vNum - 1; last >= 0; last--) {
			int size = 1 << last;
			for (int mask = 0; mask < size; mask++)
				fill(dp[mask], 0, last, 0L);
			for (int nv = 0; nv < last; nv++)
				if (g[last][nv]) dp[1 << nv][nv] = 1L;
			for (int mask = 0; mask < size; mask++) {
				int len = Integer.bitCount(mask) + 1;
				for (int v = 0; v < last; v++) {
					long cval = dp[mask][v];
					if (cval == 0L) continue;
					if (g[v][last]) count[len] += cval;
					for (int nv = 0; nv < last; nv++) {
						if (g[v][nv]) {
							int nmask = mask | (1 << nv);
							if (nmask != mask)
								dp[nmask][nv] += cval;
						}
					}
				}
			}
		}
		long ret = 0L;
		for (int len = 3; len <= vNum; len++) {
			if (count[len] % 2 != 0) System.err.println("ERROR!");
			ret += count[len] >> 1;
		}
		return ret;
	}
	
	void genFullGraph(int vNum) {
		this.vNum = vNum;
		this.eNum = vNum * (vNum - 1) / 2;
		g = new boolean [vNum][vNum];
		for (int i = 0; i < vNum; i++)
			for (int j = i + 1; j < vNum; j++)
				g[i][j] = g[j][i] = true;
				
	}
	
	/*************************************************************** 
	 * Utility
	 **************************************************************/
	static long b2mb(long b) {
		return b >> 20;
	}
	
	static void checkMemory() {
		System.err.println(b2mb(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) + "/" + b2mb(Runtime.getRuntime().totalMemory()) + " MB");
	}
	
	/*************************************************************** 
	 * Input 
	 **************************************************************/
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
