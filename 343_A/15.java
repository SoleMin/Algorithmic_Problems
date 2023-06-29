import java.io.*;
import java.util.*;

public class Main {
	boolean eof;

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	public String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return "-1";
			}
		}
		return st.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(nextToken());
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;

	void run() throws IOException {
		InputStream input = System.in;
		PrintStream output = System.out;
		try {
			File f = new File("trips.in");
			if (f.exists() && f.canRead()) {
				input = new FileInputStream(f);
				output = new PrintStream("trips.out");
			}
		} catch (Throwable e) {
		}
		br = new BufferedReader(new InputStreamReader(input));
		out = new PrintWriter(output);
		solve();
		br.close();
		out.close();
	}

	class Pair implements Comparable<Pair> {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Pair p) {
			if (x > p.x) {
				return 1;
			} else if (x < p.x) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	long ans;
	
	void nod(long a, long b){
		if (a == 0 || b == 0){
			
		} else if (a > b){
			ans += a / b;
			nod(a % b, b);
		} else {
			ans += b / a;
			nod(a, b % a);
		}
	}
	
	void solve() {
		long a = nextLong(), b = nextLong();
		ans = 0;
		nod(a, b);
		out.println(ans);
	}

}