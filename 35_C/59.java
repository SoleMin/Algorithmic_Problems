import java.io.*;
import java.util.*;
import java.math.*;

public class C implements Runnable {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	Random rnd;
	
	short[] qx, qy;
	boolean[][] used;
	final int[] dx = {1, -1, 0, 0};
	final int[] dy = {0, 0, 1, -1};
	
	void solve() throws IOException {
		int n = nextInt(), m = nextInt();
		
		qx = new short[n * m];
		qy = new short[n * m];
		used = new boolean[n][m];
		
		int k = nextInt(), qs = 0, qt = 0;
		
		for(int i = 0; i < k; i++) {
			int x = nextInt() - 1, y = nextInt() - 1;
			used[x][y] = true;
			qx[qt] = (short) x;
			qy[qt] = (short) y;
			++qt;
		}
		
		int rx = 0, ry = 0;
		
		while(qs < qt) {
			int cx = qx[qs], cy = qy[qs];
			++qs;
			
			rx = cx;
			ry = cy;
			
			for(int z = 0; z < 4; z++) {
				int nx = cx + dx[z], ny = cy + dy[z];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < m && !used[nx][ny]) {
					used[nx][ny] = true;
					qx[qt] = (short) nx;
					qy[qt] = (short) ny;
					++qt;
				}
			}
		}
		
		out.println((rx + 1) + " " + (ry + 1));
	}

	public static void main(String[] args) {
		final boolean oldChecker = false;
		
		if(oldChecker) {
			new Thread(null, new C(), "yarrr", 1 << 24).start();
		} else {
			new C().run();
		}
	}

	public void run() {
		try {
			try {
				in = new BufferedReader(new FileReader("input.txt"));
				out = new PrintWriter(new FileWriter("output.txt"));
			} catch (FileNotFoundException e) {
				in = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			}

			rnd = new Random();

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(42);
		}
	}

	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String line = in.readLine();

			if (line == null) {
				return null;
			}

			st = new StringTokenizer(line);
		}

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
}