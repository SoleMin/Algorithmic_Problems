import java.io.*;
import java.util.*;

class Main {
	static List<List<Edge>> G;
	static Map<String, Integer> map;
	
	static class Edge {
		int to, w;
		
		Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}
	
	public static int init(String S) {
		int x = map.size() * 13;
		map.put(S, x);
		for (int i = 0; i < 13; i++) {
			List<Edge> list = new ArrayList<>();
			list.add(new Edge(x + (i + 1) % 13, i == 12 ? 1 : 0));
			G.add(list);
		}
		return x;
	}
	
	public static int bfs(String c1, String c2) {
		Integer S = map.get(c1);
		Integer E = map.get(c2);
		if (S == null || E == null) {
			return -1;
		}
		int[] d = new int[G.size()];
		Arrays.fill(d, -1);
		d[S] = 0;
		Deque<Integer> dq = new LinkedList<>();
		dq.offer(S);
		while (!dq.isEmpty()) {
			int x = dq.poll();
			for (Edge e : G.get(x)) {
				if (d[e.to] == -1) {
					d[e.to] = d[x] + e.w;
					if (e.w == 1) {
						dq.offerLast(e.to);
					} else {
						dq.offerFirst(e.to);
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 13; i++) {
			if (d[E + i] == -1) {
				continue;
			}
			min = Math.min(min, d[E + i]);
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int M = Integer.parseInt(br.readLine());
			G = new ArrayList<>();
			map = new HashMap<>();
			while (M-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String c1 = st.nextToken();
				String c2 = st.nextToken();
				int t1 = Integer.parseInt(st.nextToken());
				int t2 = Integer.parseInt(st.nextToken());
				t1 = (t1 + 6) % 24;
				t2 = t1 + t2;
				if (t1 > 12 || t2 > 12) {
					continue;
				}
				Integer u = map.get(c1);
				if (u == null) {
					u = init(c1);
				}
				Integer v = map.get(c2);
				if (v == null) {
					v = init(c2);
				}
				G.get(u + t1).add(new Edge(v + t2, 0));
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			String E = st.nextToken();
			int d = bfs(S, E);
			out.append("Test Case ").append(tc).append(".\n");
			if (d == -1) {
				out.append("There is no route Vladimir can take.\n");
			} else {
				out.append("Vladimir needs ").append(d).append(" litre(s) of blood.\n");
			}
		}
		
		System.out.print(out);
		
		br.close();
	}
}