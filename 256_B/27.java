import java.io.*;
import java.util.*;

public class MrBenderAndSquare {
	
	static long n, x, y, c;

	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio(System.in);
		n = io.getLong();
		x = io.getLong();
		y = io.getLong();
		c = io.getLong();
//		for (int i = 0; i < 10; i++) io.println(f(i));
//		io.println();
		long lo = 0;
		long hi = c;
		while (lo < hi) {
			long mid = lo + (hi - lo) / 2;
			if (f(mid) >= c) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		io.println(lo);
		io.close();
	}
	
	static long f(long t) {
		long res = 0;
		// Sides
		long left = Math.max(0, t - (x - 1));
		res -= left*left;
		long right = Math.max(0, t - (n - x));
		res -= right*right;
		long up = Math.max(0, t - (y - 1));
		res -= up*up;
		long down = Math.max(0, t - (n - y));
		res -= down*down;
		// Middle
		res += 1 + 2*t*(t+1);
		// Corners
		long upLeft = Math.max(0, t - (x + y) + 1);
		long upRight = Math.max(0, t - (n - x + 1 + y) + 1);
		long downLeft = Math.max(0, t - (x + n - y + 1) + 1);
		long downRight = Math.max(0, t - (n - x + 1 + n - y + 1) + 1);
		res += upLeft * (upLeft + 1) / 2;
		res += upRight * (upRight + 1) / 2;
		res += downLeft * (downLeft + 1) / 2;
		res += downRight * (downRight + 1) / 2;
		return res;
	}

	static class Kattio extends PrintWriter {
		public Kattio(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
		}
		public Kattio(InputStream i, OutputStream o) {
			super(new BufferedOutputStream(o));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public boolean hasMoreTokens() {
			return peekToken() != null;
		}

		public int getInt() {
			return Integer.parseInt(nextToken());
		}

		public double getDouble() { 
			return Double.parseDouble(nextToken());
		}

		public long getLong() {
			return Long.parseLong(nextToken());
		}

		public String getWord() {
			return nextToken();
		}



		private BufferedReader r;
		private String line;
		private StringTokenizer st;
		private String token;

		private String peekToken() {
			if (token == null) 
				try {
					while (st == null || !st.hasMoreTokens()) {
						line = r.readLine();
						if (line == null) return null;
						st = new StringTokenizer(line);
					}
					token = st.nextToken();
				} catch (IOException e) { }
				return token;
		}

		private String nextToken() {
			String ans = peekToken();
			token = null;
			return ans;
		}
	}

}
