import java.io.*;
import java.util.*;

// :%s/Cbeta35/"name"/
// if (debug) 

public class Cbeta35 {
	public static void main(String[] args) { new Cbeta35(); }
	Scanner in;
	PrintWriter out;

	int t;
	int n, m, k, oo;
	int[][] grid;

	boolean debug = !true, multi = !true;

	Cbeta35() {
		if (multi) t = in.nextInt();
		do {
			if (multi) if (z(t--)) break;

			try {
				in = new Scanner(new File("input.txt"));
				out = new PrintWriter(new File("output.txt"));
			}
			catch (Exception e) {
				in = new Scanner(System.in);
				out = new PrintWriter(System.out);
			}

			n = in.nextInt();
			m = in.nextInt();
			k = in.nextInt();

			oo = n + m + 1;
			grid = new int[n][m];
			for (int i = 0; i < n; i++)
				Arrays.fill(grid[i], oo);
			for (int i = 0; i < k; i++) {
				int x = in.nextInt() - 1;
				int y = in.nextInt() - 1;
				for (int j = 0; j < n; j++)
					for (int kk = 0; kk < m; kk++) {
						int dx = j - x < 0 ? x - j : j - x;
						int dy = kk - y < 0 ? y - kk : kk - y;
						grid[j][kk] = min(grid[j][kk], dx + dy);
					}
			}

			int x = 0, y = 0;
			int max = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					if (max < grid[i][j]) {
						max = grid[i][j];
						x = i; y = j;
					}
			out.printf("%d %d%n", x + 1, y + 1);

		} while (debug || multi);
		out.close();
	}

	

	int min(int a, int b) { if (a < b) return a; return b; }	
	int max(int a, int b) { if (a > b) return a; return b; }	
	long min(long a, long b) { if (a < b) return a; return b; }	
	long max(long a, long b) { if (a > b) return a; return b; }	

	boolean z(int x) { if (x == 0) return true; return false; }	
	boolean z(long x) { if (x == 0) return true; return false; }	

	void sort(int[] arr) {
		int szArr = arr.length;
		Random r = new Random();
		for (int i = 0; i < szArr; i++) {
			int j = r.nextInt(szArr);
			arr[i] = arr[j]^(arr[i]^(arr[j] = arr[i]));
		}
		Arrays.sort(arr);
	}

	class FS {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens()) {
				try { st = new StringTokenizer(br.readLine()); }
				catch (Exception e) {}
			} return st.nextToken();
		}
		int nextInt() { return Integer.parseInt(next()); }
		long nextLong() { return Long.parseLong(next()); }
		double nextDouble() { return Double.parseDouble(next()); }
	}
}
