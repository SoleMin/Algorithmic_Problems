
import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class BetaRound15_A implements Runnable {

	final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	void init() throws IOException {
		if (ONLINE_JUDGE) {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		} else {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
		}
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
		new Thread(new BetaRound15_A()).start();
	}

	class House implements Comparable<House> {
		int left, right;
		House(int left, int right) {
			this.left = left;
			this.right = right;
		}
		@Override
		public int compareTo(House h) {
			return this.left - h.left;
		}
	}
	
	int getAns(House h1, House h2, int t) {
		int d = h2.left - h1.right;
		if (d < t) return 0;
		if (d == t) return 1;
		return 2;
	}
	
	void solve() throws IOException {
		int n = readInt();
		int t = readInt() * 2;
		House[] h = new House[n];
		for (int i = 0; i < n; i++) {
			int c = readInt() * 2;
			int b = readInt();
			h[i] = new House(c - b, c + b);
		}
		Arrays.sort(h);
		int ans = 2;
		for (int i = 1; i < n; i++) {
			ans += getAns(h[i - 1], h[i], t);
		}
		out.print(ans);
	}
}
