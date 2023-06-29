import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.System.out;
import static java.util.Collections.*;
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	static boolean LOCAL = System.getSecurityManager() == null;
	Scanner in = new Scanner(System.in);
	private int[] B;
	private int[] A;
	private int n;
	private int m;

	void run() {
		n = in.nextInt();
		m = in.nextInt();
		A = new int[m];
		B = new int[m];
		for (int i = 0; i < m; i++) {
			A[i] = in.nextInt() - 1;
			B[i] = in.nextInt() - 1;
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			ans = min(ans, solve(i));
		}
		out.println(ans);
	}
	int solve(int x) {
		int ans = 3 * (n - 1)  + 1 + m;
		V[] vs = new V[n * 2];
		for (int i = 0; i < vs.length; i++) vs[i] = new V();
		for (int i = 0; i < m; i++) {
			if (A[i] == x || B[i] == x) ans -= 2;
			else vs[A[i]].connect(vs[n + B[i]]);
		}
		return ans - 2 * bipartiteMatching(vs);
	}
	class V extends ArrayList<V> {
		V pair;
		boolean used;
		void connect(V v) {
			add(v);
			v.add(this);
		}
	}
	int bipartiteMatching(V[] vs) {
		int match = 0;
		for (V v : vs) if (v.pair == null) {
			for (V u : vs) u.used = false;
			if (dfs(v)) match++;
		}
		return match;
	}
	boolean dfs(V v) {
		v.used = true;
		for (V u : v) {
			V w = u.pair;
			if (w == null || !w.used && dfs(w)) {
				v.pair = u;
				u.pair = v;
				return true;
			}
		}
		return false;
	}
	void debug(Object... os) {
		System.err.println(deepToString(os));
	}

	public static void main(String[] args) {
		if (LOCAL) {
			try {
				System.setIn(new FileInputStream("./../../in.txt"));
				// System.setOut(new PrintStream("./../../out"));
			} catch (Throwable e) {
				LOCAL = false;
			}
		}
		long start = 0;
		if (LOCAL)
			start = System.nanoTime();
		new Main().run();
		if (LOCAL)
			System.err.printf("[Time : %.6f s]%n",
					(System.nanoTime() - start) * 1e-9);
	}
}

class Scanner {
	BufferedReader br;
	StringTokenizer st;

	Scanner(InputStream in) {
		br = new BufferedReader(new InputStreamReader(in));
		eat("");
	}

	void eat(String s) {
		st = new StringTokenizer(s);
	}

	String nextLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	boolean hasNext() {
		while (!st.hasMoreTokens()) {
			String s = nextLine();
			if (s == null)
				return false;
			eat(s);
		}
		return true;
	}

	String next() {
		hasNext();
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}
}