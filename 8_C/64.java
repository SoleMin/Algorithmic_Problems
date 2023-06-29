import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LookingForOrder {
	static int[][] pos;
	static int[] dp;
	static int[] nextstate;
	static int[][] dist;
	static int r;
	static int v;

	static void print(int mask) {
		if (mask < v) {
			int c = 0;
			int x = mask ^ nextstate[mask];
			for (int i = 0; i < dist.length - 1; i++) {
				if((x & (1<<i))>0) {
					System.out.print(i+1 + " ");
					c++;
				}
			}
			System.out.print("0 ");
			print(nextstate[mask]);
		}
	}

	static int distace(int x1, int x2, int y1, int y2) {
		return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
	}

	static int solve(int mask) {
		if (mask == v) {
			nextstate[mask] = r;

			return 0;
		}
		if (nextstate[mask] != 0) {
			return dp[mask];
		}

		dp[mask] = (int) 1e9;
		for (int i = 1; i < pos.length; i++) {
			int u = (1 << (i - 1));
			int z = mask | u;
			if ((mask & u) == 0) {
				int x = 2 * dist[i][0] + solve(z);
				if (dp[mask] > x) {
					dp[mask] = x;
					nextstate[mask] = z;
				}

				for (int j = 1; j < pos.length; j++) {
					int m = (1 << j - 1);
					int y = z | m;
					if ((z & m) == 0) {
						x = dist[i][0] + solve(y) + dist[i][j] + dist[j][0];

						if (dp[mask] > x) {
							dp[mask] = x;
							nextstate[mask]= y;
						}

					}
				}
				break;
			}
		}
		return dp[mask];
	}

	public static void main(String[] args) {
		InputReader0 in = new InputReader0(System.in);
		int x = in.nextInt(), y = in.nextInt();
		int n = in.nextInt();
		r = 1 << n;
		v = r - 1;
		dp = new int[r];
		nextstate = new int[r];
		pos = new int[n + 1][2];
		pos[0][0] = x;
		pos[0][1] = y;
		for (int i = 1; i < pos.length; i++) {
			pos[i][0] = in.nextInt();
			pos[i][1] = in.nextInt();
		}
		dist = new int[n + 1][n + 1];
		for (int i = 0; i < dist.length; i++) {
			for (int j = i + 1; j < dist.length; j++) {
				dist[i][j] = dist[j][i] = distace(pos[i][0], pos[j][0], pos[i][1], pos[j][1]);
			}
		}

		System.out.println(solve(0));
		System.out.print("0 ");
		print(0);
	}

}

class InputReader0 {
	BufferedReader reader;
	StringTokenizer tokenizer;

	public InputReader0(InputStream stream) {
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

	public long nextLong() {
		return Long.parseLong(next());
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

}