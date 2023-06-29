import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {

	private void solve() throws IOException {
		int n = nextInt();
		int x = nextInt();
		int y = nextInt();
		int c = nextInt();
		
		int lux = x;
		int luy = y + 1;
		
		int rux = x + 1;
		int ruy = y;
		
		int ldx = x - 1;
		int ldy = y;
		
		int rdx = x;
		int rdy = y - 1;
		
		int k = 1;
		int res = 0;
		while (k < c) {
			lux--;
			luy--;
			rux--;
			ruy++;
			rdx++;
			rdy++;
			ldx++;
			ldy--;
			int p = 0;
			p += lu(x - 1, luy, lux, y, n);
			p += ru(x, ruy, rux, y + 1, n);
			p += ld(x, ldy, ldx, y - 1, n);
			p += rd(x + 1, rdy, rdx, y, n);
			k += p;
			res++;
		}
		
		println(res);
	}
	
	private int lu(int x1, int y1, int x2, int y2, int n) {
		if (y1 > 0 && x2 > 0) {
			return x1 - x2 + 1;
		} else if (y1 > 0 && x2 < 1) {
			return x1;
		} else if (y1 < 1 && x2 > 0) {
			return y2;
		} else if (x1 - (1 - y1) > 0) {
			return lu(x1 - (1 - y1), 1, x2, y2, n);
		} else {
			return 0;
		}
	}
	
	private int ru(int x1, int y1, int x2, int y2, int n) {
		if (y1 <= n && x2 > 0) {
			return x1 - x2 + 1;
		} else if (y1 <= n && x2 < 1) {
			return x1;
		} else if (y1 > n && x2 > 0) {
			return n - y2 + 1;
		} else if (x1 - (y1 - n) > 0) {
			return ru(x1 - (y1 - n), n, x2, y2, n);
		} else {
			return 0;
		}
	}
	
	private int ld(int x1, int y1, int x2, int y2, int n) {
		if (y1 > 0 && x2 <= n) {
			return x2 - x1 + 1;
		} else if (y1 > 0 && x2 > n) {
			return n - x1 + 1;
		} else if (y1 < 1 && x2 <= n) {
			return y2;
		} else if (x1 + (1 - y1) <= n) {
			return ld(x1 + (1 - y1), 1, x2, y2, n);
		} else {
			return 0;
		}
	}
	
	private int rd(int x1, int y1, int x2, int y2, int n) {
		if (y1 <= n && x2 <= n) {
			return x2 - x1 + 1;
		} else if (y1 <= n && x2 > n) {
			return n - x1 + 1;
		} else if (y1 > n && x2 <= n) {
			return n - y2 + 1;
		} else if (x1 + (y1 - n) <= n) {
			return rd(x1 + (y1 - n), n, x2, y2, n);
		} else {
			return 0;
		}
	}

	private String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(reader.readLine());
		}
		return st.nextToken();
	}

	@SuppressWarnings("unused")
	private int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	@SuppressWarnings("unused")
	private double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	@SuppressWarnings("unused")
	private long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	@SuppressWarnings("unused")
	private void println(Object o) {
		writer.println(o);
	}

	@SuppressWarnings("unused")
	private void print(Object o) {
		writer.print(o);
	}

	private BufferedReader reader;
	private PrintWriter writer;
	private StringTokenizer st;

	private void run() throws IOException {
		long time = System.currentTimeMillis();
		Locale.setDefault(Locale.US);
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out);
		solve();
		writer.close();
		System.err.println(System.currentTimeMillis() - time);
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
