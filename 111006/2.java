import java.io.*;
import java.util.*;

class Main {
	static List<Integer>[] G;
	static int[] discovered;
	static boolean[] chk;
	static int discovered_num;
	
	public static int dfs(int x, boolean root) {
		discovered[x] = ++discovered_num;
		int ret = discovered[x];
		int child = 0;
		for (int y : G[x]) {
			if (discovered[y] == 0) {
				int res = dfs(y, false);
				chk[x] |= !root && discovered[x] <= res;
				ret = Math.min(ret, res);
				child++;
			} else {
				ret = Math.min(ret, discovered[y]);
			}
		}
		chk[x] |= root && child >= 2;
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		for (int tc = 1;; tc++) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			Map<String, Integer> map = new HashMap<>();
			Map<Integer, String> inv = new HashMap<>();
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				map.put(str, map.size());
				inv.put(inv.size(), str);
			}
			G = new List[N];
			for (int i = 0; i < N; i++) {
				G[i] = new ArrayList<>();
			}
			int R = Integer.parseInt(br.readLine());
			while (R-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				int u = map.get(s1);
				int v = map.get(s2);
				G[u].add(v);
				G[v].add(u);
			}
			discovered = new int[N];
			chk = new boolean[N];
			dfs(0, true);
			List<String> ans = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (chk[i]) {
					ans.add(inv.get(i));
				}
			}
			Collections.sort(ans);
			out.append(String.format("City map #%d: %d camera(s) found\n", tc, ans.size()));
			for (String str : ans) {
				out.append(str).append('\n');
			}
			out.append('\n');
		}
		out.deleteCharAt(out.length() - 1);
		
		System.out.print(out);
		
		br.close();
	}
}