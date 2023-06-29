import java.io.*;
import java.util.*;

public class Main implements Runnable {
	
	class Segment {
		int l, r;
		Segment(int l, int r) {
			this.l = l;
			this.r = r;
		}
		@Override
		public boolean equals(Object obj) {
			Segment o = (Segment)obj;
			return l == o.l && r == o.r;
		}
		@Override
		public int hashCode() {
			return 1000 * l + r;
		}
	}

	public void _main() throws IOException {
		int n = nextInt();
		int t = nextInt();
		int[] x = new int[n];
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = nextInt();
			a[i] = nextInt();
		}		
		Set<Segment> set = new HashSet<Segment>();
		for (int i = 0; i < n; i++) {
			int l = 2 * x[i] + a[i];
			int r = 2 * x[i] + a[i] + 2 * t;
			boolean ok = true;
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				int L = Math.max(l, 2 * x[j] - a[j]);
				int R = Math.min(r, 2 * x[j] + a[j]);				
				if (L < R) {
					ok = false;
					break;
				}
			}
			if (ok)
				set.add(new Segment(l, r));
			
			l = 2 * x[i] - a[i] - 2 * t;
			r = 2 * x[i] - a[i];			
			ok = true;
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				int L = Math.max(l, 2 * x[j] - a[j]);
				int R = Math.min(r, 2 * x[j] + a[j]);
				if (L < R) {
					ok = false;
					break;
				}
			}
			if (ok)
				set.add(new Segment(l, r));
		}
		out.print(set.size());
	}

	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer st;

	private String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String rl = in.readLine();
			if (rl == null)
				return null;
			st = new StringTokenizer(rl);
		}
		return st.nextToken();
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	private double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public static void main(String[] args) {
		new Thread(new Main()).start();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			_main();

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(202);
		}
	}

}
