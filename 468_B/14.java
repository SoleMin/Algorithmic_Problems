import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public void solve(int testNumber, FastScanner in, PrintWriter out) {
		int n = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		List<Clause> clauses = new ArrayList<Clause>();
		int[] p = new int[n];
		Map<Integer, Integer> id = new HashMap<>();
		for (int i = 0; i < n; i++) {
			p[i] = in.nextInt();
			id.put(p[i], i);
		}
		// var[i] = true means p[i] \in A
		for (int i = 0; i < n; i++) {
			int x = p[i];
			Integer j = id.get(a - x);
			if (j == null) {
				// var[i] is false
				clauses.add(new Clause(i, i, true, false));
			} else {
				clauses.add(new Clause(i, j, true, true));
				clauses.add(new Clause(j, i, false, false));
			}

			j = id.get(b - x);
			if (j == null) {
				// var[i] is true
				clauses.add(new Clause(i, i, false, true));
			} else {
				clauses.add(new Clause(i, j, false, false));
				clauses.add(new Clause(j, i, true, true));
			}
		}
		SAT2Solver solver = new SAT2Solver(n);
		if (!solver.solve(clauses)) {
			out.println("NO");
			return;
		}
		out.println("YES");
		for (int i = 0; i < n; i++) {
			if (i > 0) {
				out.print(" ");
			}
			if (solver.isTrue[i]) {
				out.print(0);
			} else {
				out.print(1);
			}
		}
		out.println();
	}

	class Clause {
		int v1, v2;
		boolean neg1, neg2;

		// Example: (x=>!y) is translated to Clause(x, y, true, false)
		Clause(int v1, int v2, boolean pos1, boolean pos2) {
			this.v1 = v1;
			this.v2 = v2;
			this.neg1 = !pos1;
			this.neg2 = !pos2;
		}
	}

	class SAT2Solver {
		List<Integer>[] g;
		boolean[] isTrue;
		int n;

		int numComps;
		int[] low;
		int[] vis;
		int[] comp;
		boolean[] onStack;
		int[] stack;
		int sp;
		int globalTime;

		SAT2Solver(int n) {
			this.n = n;
			isTrue = new boolean[2 * n];
			vis = new int[2 * n];
			low = new int[2 * n];
			stack = new int[2 * n];
			comp = new int[2 * n];
			onStack = new boolean[2 * n];
			g = new List[2 * n];
		}

		public boolean solve(List<Clause> clauses) {
			for (int i = 0; i < 2 * n; i++) {
				g[i] = new ArrayList<Integer>();
			}
			for (Clause clause : clauses) {
				int v1 = clause.v1;
				int v2 = clause.v2;
				boolean neg1 = clause.neg1;
				boolean neg2 = clause.neg2;
				if (neg1) {
					v1 = negate(v1);
				}
				if (neg2) {
					v2 = negate(v2);
				}
				//g[negate(v1, n)].add(v2);
				//g[negate(v2, n)].add(v1);
				g[v1].add(v2);
			}
			Arrays.fill(vis, -1);
			Arrays.fill(onStack, false);
			sp = 0;
			globalTime = 0;
			numComps = 0;
			for (int i = 0; i < 2 * n; i++) {
				if (vis[i] < 0) {
					dfsTarjan(i);
				}
			}
			int[] firstInComp = new int[numComps];
			Arrays.fill(firstInComp, -1);
			int[] nextSameComp = new int[2 * n];
			for (int i = 0; i < 2 * n; i++) {
				int c = comp[i];
				nextSameComp[i] = firstInComp[c];
				firstInComp[c] = i;
			}
			List<Integer>[] invertedCompEdges = new List[numComps];
			for (int i = 0; i < numComps; i++) {
				invertedCompEdges[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < 2*n; i++) {
				for (int j : g[i]) {
					invertedCompEdges[comp[j]].add(comp[i]);
				}
			}
			boolean[] compIsTrue = new boolean[numComps];
			Arrays.fill(compIsTrue, true);
			for (int c = 0; c < numComps; c++) {
				if (!compIsTrue[c]) {
					continue;
				}
				for (int i = firstInComp[c]; i >= 0; i = nextSameComp[i]) {
					int nc = comp[negate(i)];
					if (c == nc) {
						return false;
					}
				}
				for (int i = firstInComp[c]; i >= 0; i = nextSameComp[i]) {
					int nc = comp[negate(i)];
					dfsReject(nc, invertedCompEdges, compIsTrue);
				}
			}
			for (int i = 0; i < 2 * n; i++) {
				isTrue[i] = compIsTrue[comp[i]];
			}
			for (int i = 0; i < n; i++) {
				if (isTrue[i] && isTrue[negate(i)]) {
					throw new AssertionError();
				}
				if (!isTrue[i] && !isTrue[negate(i)]) {
					return false;
				}
			}
			return true;
		}

		private int negate(int i) {
			return i + (i < n ? n : -n);
		}

		private void dfsReject(int c, List<Integer>[] invertedCompEdges, boolean[] compIsTrue) {
			if (!compIsTrue[c]) {
				return;
			}
			compIsTrue[c] = false;
			for (int p : invertedCompEdges[c]) {
				dfsReject(p, invertedCompEdges, compIsTrue);
			}
		}

		void dfsTarjan(int v) {
			vis[v] = globalTime;
			low[v] = globalTime;
			++globalTime;
			stack[sp++] = v;
			onStack[v] = true;
			for (int u : g[v]) {
				if (vis[u] < 0) {
					dfsTarjan(u);
					if (low[v] > low[u]) {
						low[v] = low[u];
					}
				} else if (onStack[u] && low[v] > vis[u]) {
					low[v] = vis[u];
				}
			}
			if (low[v] == vis[v]) {
				while (true) {
					int u = stack[--sp];
					onStack[u] = false;
					comp[u] = numComps;
					if (u == v) {
						break;
					}
				}
				++numComps;
			}
		}

	}



}

class FastScanner {

	private BufferedReader in;
	private StringTokenizer st;

	public FastScanner(InputStream stream) {
		in = new BufferedReader(new InputStreamReader(stream));
	}

	public String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				String rl = in.readLine();
				if (rl == null) {
					return null;
				}
				st = new StringTokenizer(rl);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return st.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

}

