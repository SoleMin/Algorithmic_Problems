import java.io.*;
import java.util.*;

class Main {
	static final int INF = Integer.MAX_VALUE / 2;
	static List<List<Integer>> G;
	
	public static int[] bfs(Integer S) {
		int[] res = new int[G.size()];
		Queue<Integer> q = new LinkedList<>();
		Arrays.fill(res, INF);
		if (S == null){
			return res;
		}
		res[S] = 0;
		q.offer(S);
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int y : G.get(x)) {
				if (res[y] == INF) {
					res[y] = res[x] + 1;
					q.offer(y);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			out.append("Scenario ").append(tc).append('\n');
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			G = new ArrayList<>();
			Map<String, Integer> map = new HashMap<>();
			while (P-- > 0) {
				String line = br.readLine();
				line = line.substring(0, line.indexOf(".:"));
				String[] name = line.split("\\., ");
				for (int i = 0; i < name.length; i++) {
					name[i] += ".";
					if (!map.containsKey(name[i])) {
						map.put(name[i], map.size());
						G.add(new ArrayList<>());
					}
				}
				for (int i = 0; i < name.length; i++) {
					for (int j = i + 1; j < name.length; j++) {
						int x = map.get(name[i]);
						int y = map.get(name[j]);
						G.get(x).add(y);
						G.get(y).add(x);
					}
				}
			}
			int[] bfs = bfs(map.get("Erdos, P."));
			while (N-- > 0) {
				String name = br.readLine();
				int val = map.containsKey(name) ? bfs[map.get(name)] : INF;
				out.append(name).append(' ').append(val == INF ? "infinity" : val).append('\n');
			}
		}
		
		System.out.print(out);
		br.close();
	}
}