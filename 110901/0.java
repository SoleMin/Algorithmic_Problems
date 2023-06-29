import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
class Main {
	static int N;
	static List<Integer>[] G;
	static int[] C;
	static boolean bicolorable;
	
	public static void dfs(int x, int c) {
		C[x] = c;
		for (int y : G[x]) {
			if (C[y] == 0) {
				dfs(y, 3 - c);
			} else if (C[y] == c) {
				bicolorable = false;
				break;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			int M = Integer.parseInt(br.readLine());
			G = new List[N];
			for (int i = 0; i < N; i++) {
				G[i] = new ArrayList<>();
			}
			while (M-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				G[u].add(v);
				G[v].add(u);
			}
			C = new int[N];
			bicolorable = true;
			dfs(0, 1);
			out.append(bicolorable ? "BICOLORABLE.\n" : "NOT BICOLORABLE.\n");
		}
		
		System.out.print(out);
		
		br.close();
	}
}