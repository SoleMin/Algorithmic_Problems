import java.io.*;
import java.util.*;

class Main {
	static List<Integer>[] G;
	
	public static List<Integer> bfs(int S, int E) {
		List<Integer> ret = new ArrayList<>();
		if (S == E) {
			ret.add(S);
			return ret;
		}
		int[] par = new int[G.length];
		Arrays.fill(par, -1);
		par[S] = S;
		Queue<Integer> q = new LinkedList<>();
		q.offer(S);
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int y : G[x]) {
				if (par[y] == -1) {
					par[y] = x;
					q.offer(y);
				}
			}
		}
		if (par[E] == -1) {
			return null;
		}
		ret.add(E);
		while (S != E) {
			E = par[E];
			ret.add(E);
		}
		Collections.reverse(ret);
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		List<String> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0;; i++) {
			String line = br.readLine();
			if (line.length() == 0) {
				break;
			}
			if (map.containsKey(line)) {
				i--;
				continue;
			}
			list.add(line);
			map.put(line, i);
		}
		G = new List[list.size()];
		for (int i = 0; i < G.length; i++) {
			G[i] = new ArrayList<>();
		}
		for (int i = 0; i < G.length; i++) {
			String str = list.get(i);
			StringBuilder sb = new StringBuilder(str);
			for (int j = 0; j < sb.length(); j++) {
				for (char k = 97; k < 123; k++) {
					if (str.charAt(j) == k) {
						continue;
					}
					sb.setCharAt(j, k);
					Integer val = map.get(sb.toString());
					if (val != null) {
						G[i].add(val);
					}
				}
				sb.setCharAt(j, str.charAt(j));
			}
		}
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(line);
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			Integer val1 = map.get(str1);
			Integer val2 = map.get(str2);
			if (str1.length() != str2.length() || val1 == null || val2 == null) {
				out.append("No solution.\n\n");
				continue;
			}
			List<Integer> res = bfs(val1, val2);
			if (res == null) {
				out.append("No solution.\n\n");
			} else {
				for (int x : res) {
					out.append(list.get(x)).append('\n');
				}
				out.append('\n');
			}
		}
		out.deleteCharAt(out.length() - 1);
		
		System.out.print(out);
		
		br.close();
	}
}