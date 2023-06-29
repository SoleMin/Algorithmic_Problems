import java.io.*;
import java.util.*;

public class Main {
	static int[] par;

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		par[y] = x;
	}

	public static int find(int x) {
		return par[x] == x ? x : (par[x] = find(par[x]));
	}

	public static double square(double x) {
		return x * x;
	}

	static class Edge implements Comparable<Edge> {
		int u, v;
		double w;

		Edge(int u, int v, double w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		public int compareTo(Edge e) {
			return Double.compare(w, e.w);
		}
	}

	public static void main(String[] args) throws Exception {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			double[] x = new double[N];
			double[] y = new double[N];
			for (int i = 0; i < N; i++) {
				x[i] = Double.parseDouble(in.next());
				y[i] = Double.parseDouble(in.next());
			}
			par = new int[N];
			for (int i = 0; i < N; i++) {
				par[i] = i;
			}
			List<Edge> E_list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					E_list.add(new Edge(i, j, Math.sqrt(square(x[i] - x[j]) + square(y[i] - y[j]))));
				}
			}
			Collections.sort(E_list);
			double ans = 0;
			for (Edge e : E_list) {
				if (find(e.u) == find(e.v)) {
					continue;
				}
				union(e.u, e.v);
				ans += e.w;
			}
			out.append(String.format("%.2f\n\n", ans));
		}
		out.deleteCharAt(out.length() - 1);

		System.out.print(out);
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer st;

		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(nextLine());
			}
			return st.nextToken();
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}