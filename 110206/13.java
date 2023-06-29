import java.io.*;
import java.util.*;

class Graph {
	ArrayList<ArrayList<Integer>> adj;
	Graph(int n) {
		adj = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
	}
	
	void addEdge(int x, int y) {
	if (!adj.get(x).contains(y)) {
		adj.get(x).add(y);
	}
}
	
	
}
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int l = 0; l < t; l++) {
			System.out.printf("Scenario %d\n", l + 1);
			String[] pn = br.readLine().split(" ");
			int p = Integer.parseInt(pn[0]);
			int n = Integer.parseInt(pn[1]);
			String[] pap = new String[p];
			HashMap<String, Integer> hm = new HashMap<>();
			for (int i = 0; i < p; i++) {
				pap[i] = br.readLine();
			}
			hm.put("Erdos, P.", 0);
			int cntn = 1;
			String[][] aut = new String[p][];
			for (int i = 0; i < p; i++) {
				aut[i] = pap[i].substring(0, pap[i].indexOf(":")).replace(".,", ".@").split("@");

			for (int j = 0; j < aut[i].length; j++, cntn++) {
				aut[i][j] = aut[i][j].trim();
				if (hm.putIfAbsent(aut[i][j], cntn) != null) {
					cntn--;
				}
			}
		}
		Graph gp = new Graph(hm.size());
		for (int i = 0; i < aut.length; i++) {
			for (int j = 0; j < aut[i].length; j++) {
				for (int k = 0; k < aut[i].length; k++) {
					gp.addEdge(hm.get(aut[i][j]), hm.get(aut[i][k]));
				}
			}
		}

		int[] dis = new int[hm.size()];
		bfs(gp.adj, hm.size(), 0, dis);
		String[] name = new String[n];
		for (int i = 0; i < n; i++) {
			name[i] = br.readLine();
		}
		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i] + " " + (dis[hm.get(name[i])] > 0 ? dis[hm.get(name[i])] : "infinity"));
		}
	}
}
	
	
	static void bfs(ArrayList<ArrayList<Integer>> Al, int n, int v, int[] dis) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n];
		q.add(v);
		int cnt = 0;
		int qs = 1;
		int lv = 1;
		while(!q.isEmpty()) {
			v = q.poll();
			cnt++;
			Iterator<Integer> it = Al.get(v).listIterator();
			while (it.hasNext()) {
				int w = it.next();
				if (visited[w] == false) {
					visited[w] = true;
					dis[w] = lv;
					q.add(w);
				}
			}
			if (cnt == qs) {
				qs = q.size();
				cnt = 0;
				lv++;
			}
		}
	}
}