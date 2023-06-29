import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.copyOf;
import static java.util.Arrays.deepToString;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class C {
	static int[] dx = new int[] { 0, 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 0, -1, 0, 1 };
	static int[][] g;
	static int ans;

	static void fill() {
		cache[1][1] = 0;
		cache[1][1] = 0;
		cache[2][1] = 1;
		cache[1][2] = 1;
		cache[2][2] = 2;
		cache[2][2] = 2;
		cache[3][1] = 2;
		cache[1][3] = 2;
		cache[3][2] = 4;
		cache[2][3] = 4;
		cache[3][3] = 6;
		cache[3][3] = 6;
		cache[4][1] = 2;
		cache[1][4] = 2;
		cache[4][2] = 5;
		cache[2][4] = 5;
		cache[4][3] = 8;
		cache[3][4] = 8;
		cache[4][4] = 12;
		cache[4][4] = 12;
		cache[5][1] = 3;
		cache[1][5] = 3;
		cache[5][2] = 7;
		cache[2][5] = 7;
		cache[5][3] = 11;
		cache[3][5] = 11;
		cache[5][4] = 14;
		cache[4][5] = 14;
		cache[5][5] = 18;
		cache[5][5] = 18;
		cache[6][1] = 4;
		cache[1][6] = 4;
		cache[6][2] = 8;
		cache[2][6] = 8;
		cache[6][3] = 13;
		cache[3][6] = 13;
		cache[6][4] = 17;
		cache[4][6] = 17;
		cache[6][5] = 22;
		cache[5][6] = 22;
		cache[6][6] = 26;
		cache[6][6] = 26;
		cache[7][1] = 4;
		cache[1][7] = 4;
		cache[7][2] = 10;
		cache[2][7] = 10;
		cache[7][3] = 15;
		cache[3][7] = 15;
		cache[7][4] = 21;
		cache[4][7] = 21;
		cache[7][5] = 26;
		cache[5][7] = 26;
		cache[8][1] = 5;
		cache[1][8] = 5;
		cache[8][2] = 11;
		cache[2][8] = 11;
		cache[8][3] = 17;
		cache[3][8] = 17;
		cache[8][4] = 24;
		cache[4][8] = 24;
		cache[8][5] = 29;
		cache[5][8] = 29;
		cache[9][1] = 6;
		cache[1][9] = 6;
		cache[9][2] = 13;
		cache[2][9] = 13;
		cache[9][3] = 20;
		cache[3][9] = 20;
		cache[9][4] = 26;
		cache[4][9] = 26;
		cache[10][1] = 6;
		cache[1][10] = 6;
		cache[10][2] = 14;
		cache[2][10] = 14;
		cache[10][3] = 22;
		cache[3][10] = 22;
		cache[10][4] = 30;
		cache[4][10] = 30;
		cache[11][1] = 7;
		cache[1][11] = 7;
		cache[11][2] = 16;
		cache[2][11] = 16;
		cache[11][3] = 24;
		cache[3][11] = 24;
		cache[12][1] = 8;
		cache[1][12] = 8;
		cache[12][2] = 17;
		cache[2][12] = 17;
		cache[12][3] = 26;
		cache[3][12] = 26;
		cache[13][1] = 8;
		cache[1][13] = 8;
		cache[13][2] = 19;
		cache[2][13] = 19;
		cache[13][3] = 29;
		cache[3][13] = 29;
		cache[14][1] = 9;
		cache[1][14] = 9;
		cache[14][2] = 20;
		cache[2][14] = 20;
		cache[15][1] = 10;
		cache[1][15] = 10;
		cache[15][2] = 22;
		cache[2][15] = 22;
		cache[16][1] = 10;
		cache[1][16] = 10;
		cache[16][2] = 23;
		cache[2][16] = 23;
		cache[17][1] = 11;
		cache[1][17] = 11;
		cache[17][2] = 25;
		cache[2][17] = 25;
		cache[18][1] = 12;
		cache[1][18] = 12;
		cache[18][2] = 26;
		cache[2][18] = 26;
		cache[19][1] = 12;
		cache[1][19] = 12;
		cache[19][2] = 28;
		cache[2][19] = 28;
		cache[20][1] = 13;
		cache[1][20] = 13;
		cache[20][2] = 29;
		cache[2][20] = 29;
		cache[21][1] = 14;
		cache[1][21] = 14;
		cache[22][1] = 14;
		cache[1][22] = 14;
		cache[23][1] = 15;
		cache[1][23] = 15;
		cache[24][1] = 16;
		cache[1][24] = 16;
		cache[25][1] = 16;
		cache[1][25] = 16;
		cache[26][1] = 17;
		cache[1][26] = 17;
		cache[27][1] = 18;
		cache[1][27] = 18;
		cache[28][1] = 18;
		cache[1][28] = 18;
		cache[29][1] = 19;
		cache[1][29] = 19;
		cache[30][1] = 20;
		cache[1][30] = 20;
		cache[31][1] = 20;
		cache[1][31] = 20;
		cache[32][1] = 21;
		cache[1][32] = 21;
		cache[33][1] = 22;
		cache[1][33] = 22;
		cache[34][1] = 22;
		cache[1][34] = 22;
		cache[35][1] = 23;
		cache[1][35] = 23;
		cache[36][1] = 24;
		cache[1][36] = 24;
		cache[37][1] = 24;
		cache[1][37] = 24;
		cache[38][1] = 25;
		cache[1][38] = 25;
		cache[39][1] = 26;
		cache[1][39] = 26;
		cache[40][1] = 26;
		cache[1][40] = 26;
	}

	static void go(int n, int m, long used, long left) {
		// debug(Long.toBinaryString(used) + " " + Long.toBinaryString(left));
		if (left == 0) {
			ans = max(ans, n * m - Long.bitCount(used));
			return;
		}
		if (n * m - Long.bitCount(used) <= ans)
			return;
		int who = Long.numberOfTrailingZeros(left);
		// debug(who);
		for (int w : g[who]) {
			long nused = used | (1L << w);
			long nleft = left;
			for (int v : g[w]) {
				nleft &= ~(1L << v);
			}
			go(n, m, nused, nleft);
		}
	}

	static int solve(int n, int m) throws Exception {
		ans = 0;
		g = new int[n * m][];
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				int[] w = new int[5];
				int cnt = 0;
				for (int dir = 0; dir < 5; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
						w[cnt++] = ny * m + nx;
					}
				}
				g[y * m + x] = copyOf(w, cnt);
			}
		}
		go(n, m, 0, (1L << (n * m)) - 1);
		return ans;
	}

	static int[][] cache;

	public static void main(String[] args) {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			// debug(solve(1, 4));
			// debug(solve(6, 6));

			// debug(solve(7,5) == solve(5,7));
//			PrintWriter out2 = new PrintWriter("file.txt");
//			//
			cache = new int[41][41];
			fill();
//			//
//			for (int i = 1; i <= 40; i++) {
//				for (int j = 1; j <= i; j++) {
//					if (i * j <= 40) {
//						int k = solve(i, j);
//						out2.printf("cache[%d][%d] = %d;\n", i, j, k);
//						out2.printf("cache[%d][%d] = %d;\n", j, i, k);
//
//						cache[i][j] = solve(i, j);
//						debug(i + " " + j);
//					}
//				}
//			}
//			out2.close();

			 int n = nextInt();
			 int m = nextInt();
			 //int res = solve(n, m);
			 out.println(cache[n][m]);

			// for (int i = 1; i <= 5; i++) {
			// for (int j = 1; j <= 5; j++) {
			// assert(solve(i, j) == cache[i][j]);
			// //debug(i + " " + j + " " + solve(i, j));
			// }
			// }

			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;
	static long launchTimer;

	static void debug(Object... o) {
		System.err.println(deepToString(o));
	}

	static void setTime() {
		launchTimer = System.currentTimeMillis();
	}

	static void printTime() {
		System.err.println(System.currentTimeMillis() - launchTimer);
	}

	static void printMemory() {
		System.err.println((Runtime.getRuntime().totalMemory() - Runtime
				.getRuntime().freeMemory()) / 1000 + "kb");
	}

	static boolean hasMoreTokens() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			String line = in.readLine();
			if (line == null) {
				return false;
			}
			tok = new StringTokenizer(line);
		}
		return true;
	}

	static String next() throws IOException {
		return hasMoreTokens() ? tok.nextToken() : null;
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static BigInteger nextBig() throws IOException {
		return new BigInteger(next());
	}
}
