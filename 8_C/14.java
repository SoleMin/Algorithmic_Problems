import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LookingForOrder {
	static final int INF = (int)1e9;
	static Point a[];
	static Point o;
	static int n;
	static int dp[];
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);

		o = new Point(sc.nextInt(), sc.nextInt());
		n = sc.nextInt();
		a = new Point[n];
		for (int i = 0; i < n; i++)
			a[i] = new Point(sc.nextInt(), sc.nextInt());
		
		dp = new int[(1 << n) + 5];
		Arrays.fill(dp, -1);
		out.println(rec(0));
		out.print(0 + " ");
		path(0);
		out.println();
		
		out.flush();
		out.close();
	}
	
	static void path(int msk) {
		if (msk == (1 << n) - 1) return;
		
		int optimal = rec(msk);
		for (int i = 0; i < n; i++) {
			if ((msk & (1 << i)) == 0) {
				if (rec(msk | (1 << i)) + 2 * o.dist(a[i]) == optimal) {
					out.print((i + 1) + " " + 0 + " ");
					path(msk | (1 << i));
					return;
				}
				
				for (int j = 0; j < n; j++) 
					if (rec(msk | (1 << i) | (1 << j)) + o.dist(a[i]) + a[i].dist(a[j]) + a[j].dist(o) == optimal) {
						out.print((i + 1) + " " + (j + 1) + " " + 0 + " ");
						path(msk | (1 << i) | (1 << j));
						return;
					}
				break;
			}
		}
	}

	static int rec(int msk) {
		if (msk == (1 << n) - 1) return 0;
		if (dp[msk] != -1) return dp[msk];
		
		int ans = INF;
		for (int i = 0; i < n; i++) {
			if ((msk & (1 << i)) == 0) {
				ans = Math.min(ans, rec(msk | (1 << i)) + 2 * o.dist(a[i]));
				for (int j = 0; j < n; j++) {
					if (i == j) continue;
					if ((msk & (1 << j)) == 0) 
						ans = Math.min(ans, rec(msk | (1 << i) | (1 << j)) + o.dist(a[i]) + a[i].dist(a[j]) + a[j].dist(o));
				}
				break;
			}
		}
		
		return dp[msk] = ans;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int dist(Point p) {
			return (x - p.x) * (x - p.x) + (y - p.y) * (y - p.y);
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(FileReader f) {
			br = new BufferedReader(f);
		}

		public Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean Ready() throws IOException {
			return br.ready();
		}

		public void waitForInput(long time) {
			long ct = System.currentTimeMillis();
			while(System.currentTimeMillis() - ct < time) {};
		}

	}

}