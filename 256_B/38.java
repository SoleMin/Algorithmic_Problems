import java.io.*;
import java.util.*;

public class BBi implements Runnable {
	public static void main(String[] args) {
		new Thread(new BBi()).run();
	}

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer in;
	PrintWriter out = new PrintWriter(System.out);

	public String nextToken() throws IOException {
		while (in == null || !in.hasMoreTokens()) {
			in = new StringTokenizer(br.readLine());
		}

		return in.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	int n, x, y;

	public long count(long z) {
		long total = 0;

		long[][] c = new long[][] { { x, y }, { y, n - x + 1 },
				{ n - x + 1, n - y + 1 }, { n - y + 1, x } };

		for (int i = 0; i < c.length; i++) {
			long inside = z;

			for (int j = 0; j < c[i].length; j++) {
				if (z > c[i][j]) {
					total += Math.min(z - c[i][j], c[i][1 - j]) * c[i][j];
					inside -= (z - c[i][j]);
				}
			}

			if (z > c[i][0] && z > c[i][1]) {
				total -= Math.min(z - c[i][0], c[i][1])
						* Math.min(z - c[i][1], c[i][0]);
			}

			if (inside > 0)
				total += inside * (inside + 1) / 2;
		}

		for (int i = 0; i < c.length; i++) {
			total -= Math.min(z, c[i][0]);
		}

		return total + 1;
	}

	public long solve(int n, int x, int y, long c) throws IOException {
		this.n = n;
		this.x = x;
		this.y = y;
		
		long l = 0;
		long r = 2L * n + 2;
		while (r - l > 1) {
			long z = (l + r) / 2;

			if (c <= count(z)) {
				r = z;
			} else {
				l = z;
			}
		}

		return r - 1;
	}

	public void run() {
		try {
			out.println(solve(nextInt(), nextInt(), nextInt(), nextLong()));
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
