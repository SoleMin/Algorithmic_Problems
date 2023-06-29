
import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class BetaRound23_A implements Runnable {

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
		new Thread(new BetaRound23_A()).start();
	}

	void solve() throws IOException {
		char[] s = in.readLine().toCharArray();
		int n = s.length;
		for (int ans = n - 1; ans >= 1; ans--) {
			for (int i = 0; i < n - ans + 1; i++) {
				for (int j = i + 1; j < n - ans + 1; j++) {
					int count = 0;
					for (int k = 0; k < ans; k++) {
						if (s[i + k] == s[j + k]) count++;
						else break;
					}
					if (count == ans) {
						out.print(ans);
						return;
					}
				}
			}
		}
		out.print(0);
	}
	
}
