import java.io.*;
import java.util.*;

public class CF387D {
	static class A {
		ArrayList<Integer> list = new ArrayList<>();
		int u, v, d;
	}
	static int INF = Integer.MAX_VALUE;
	static boolean bfs(A[] aa, int n) {
		LinkedList<Integer> queue = new LinkedList<>();
		for (int u = 1; u <= n; u++)
			if (aa[u].v > 0)
				aa[u].d = INF;
			else {
				aa[u].d = 0;
				queue.addLast(u);
			}
		aa[0].d = INF;
		while (!queue.isEmpty()) {
			int u = queue.removeFirst();
			if (aa[u].d + 1 == aa[0].d)
				break;
			for (int v : aa[u].list) {
				int w = aa[v].u;
				if (aa[w].d == INF) {
					aa[w].d = aa[u].d + 1;
					queue.addLast(w);
				}
			}
		}
		return aa[0].d != INF;
	}
	static boolean dfs(A[] aa, int n, int u) {
		if (u == 0)
			return true;
		for (int v : aa[u].list) {
			int w = aa[v].u;
			if (aa[w].d == aa[u].d + 1 && dfs(aa, n, w)) {
				aa[u].v = v;
				aa[v].u = u;
				return true;
			}
		}
		aa[u].d = INF;
		return false;
	}
	static int matchings(A[] aa, int n) {
		int cnt = 0;
		while (bfs(aa, n))
			for (int u = 1; u <= n; u++)
				if (aa[u].v == 0 && dfs(aa, n, u))
					cnt++;
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] eu = new int[m];
		int[] ev = new int[m];
		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(br.readLine());
			eu[j] = Integer.parseInt(st.nextToken());
			ev[j] = Integer.parseInt(st.nextToken());
		}
		A[] aa = new A[n + 1];
		int min = m + n * 3;
		for (int ctr = 1; ctr <= n; ctr++) {
			boolean loop = false;
			boolean[] ci = new boolean[n + 1];
			boolean[] co = new boolean[n + 1];
			for (int i = 0; i <= n; i++)
				aa[i] = new A();
			int m_ = 0;
			for (int j = 0; j < m; j++) {
				int u = eu[j];
				int v = ev[j];
				if (u == ctr && v == ctr)
					loop = true;
				else if (u == ctr && v != ctr)
					ci[v] = true;
				else if (u != ctr && v == ctr)
					co[u] = true;
				else {
					aa[u].list.add(v);
					m_++;
				}
			}
			int cnt = loop ? 0 : 1;
			for (int i = 1; i <= n; i++)
				if (i != ctr) {
					if (!ci[i])
						cnt++;
					if (!co[i])
						cnt++;
				}
			int m2 = matchings(aa, n);
			cnt += (m_ - m2) + (n - 1 - m2);
			if (min > cnt)
				min = cnt;
		}
		System.out.println(min);
	}
}
