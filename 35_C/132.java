
import java.awt.Point;
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class BetaRound35_C implements Runnable {

	final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	void init() throws IOException {
		in = new BufferedReader(new FileReader("input.txt"));
		out = new PrintWriter("output.txt");
	}

	String readString() throws IOException {
		while (!tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	int readInt() throws IOException {
		return Integer.parseInt(readString());
	}

	@Override
	public void run() {
		try {
			long t1 = System.currentTimeMillis();
			init();
			solve();
			out.close();
			long t2 = System.currentTimeMillis();
			System.err.println("Time = " + (t2 - t1));
		} catch (Exception e) {
			e.printStackTrace(System.err);
			System.exit(-1);
		}
	}

	public static void main(String[] args) {
		new Thread(new BetaRound35_C()).start();
	}
	
	void solve() throws IOException {
		int n = readInt();
		int m = readInt();
		int k = readInt();
		Queue<Point> q = new ArrayDeque<Point>();
		boolean[][] visited = new boolean[n + 2][m + 2];
		for (int j = 0; j < m + 2; j++) {
			visited[0][j] = true;
			visited[n + 1][j] = true;
		}
		for (int i = 0; i < n + 2; i++) {
			visited[i][0] = true;
			visited[i][m + 1] = true;
		}
		for (int i = 0; i < k; i++) {
			int x = readInt();
			int y = readInt();
			q.add(new Point(x, y));
			visited[x][y] = true;
		}
		
		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();
			int x = p.x, y = p.y;
			if (!visited[x + 1][y]) {
				q.add(new Point(x + 1, y));
				visited[x + 1][y] = true;
			}
			if (!visited[x - 1][y]) {
				q.add(new Point(x - 1, y));
				visited[x - 1][y] = true;
			}
			if (!visited[x][y + 1]) {
				q.add(new Point(x, y + 1));
				visited[x][y + 1] = true;
			}
			if (!visited[x][y - 1]) {
				q.add(new Point(x, y - 1));
				visited[x][y - 1] = true;
			}
		}
		out.print(p.x + " " + p.y);
	}
	
}
