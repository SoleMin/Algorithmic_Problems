import java.io.*;
import java.util.*;

public class Pr468B {
	public static void main(String[] args) throws IOException {
		new Pr468B().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out, true);
		solve();
		out.flush();
	}

	int[] which;
	boolean[] was;
	int[] pa;
	int[] pb;

	void dfs(int i, boolean fa) {
		was[i] = true;
		if (fa) {
			if (pa[i] == -1) {
				out.println("NO");
				out.flush();
				System.exit(0);
			}
			which[i] = 0;
			which[pa[i]] = 0;
			if (pb[pa[i]] != -1 && !was[pb[pa[i]]]) {
				dfs(pb[pa[i]], fa);
			}
		} else {
			if (pb[i] == -1) {
				out.println("NO");
				out.flush();
				System.exit(0);
			}
			which[i] = 1;
			which[pb[i]] = 1;
			if (pa[pb[i]] != -1 && !was[pa[pb[i]]]) {
				dfs(pa[pb[i]], fa);
			}
		}
	}

	void solve() throws IOException {
		int n = nextInt();
		int a = nextInt();
		int b = nextInt();
		int[] p = new int[n];
		HashMap<Integer, Integer> allNums = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			p[i] = nextInt();
			if (p[i] >= Math.max(a, b)) {
				out.println("NO");
				return;
			}
			allNums.put(p[i], i);
		}
		pa = new int[n];
		pb = new int[n];
		Arrays.fill(pa, -1);
		Arrays.fill(pb, -1);
		which = new int[n];
		Arrays.fill(which, -1);
		for (int i = 0; i < n; i++) {
			if (pa[i] == -1 && allNums.containsKey(a - p[i])) {
				pa[i] = allNums.get(a - p[i]);
				pa[pa[i]] = i;
			}
			if (pb[i] == -1 && allNums.containsKey(b - p[i])) {
				pb[i] = allNums.get(b - p[i]);
				pb[pb[i]] = i;
			}
			if (pa[i] == -1 && pb[i] == -1) {
				out.println("NO");
				return;
			}
		}
		was = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!was[i] && pa[i] == -1) {
				dfs(i, false);
			} else if (!was[i] && pb[i] == -1) {
				dfs(i, true);
			}
		}
		for (int i = 0; i < n; i++) {
			if (!was[i]) {
				dfs(i, true);
			}
		}
		out.println("YES");
		for (int i = 0; i < n; i++) {
			out.print(which[i] + " ");
		}
	}
}
