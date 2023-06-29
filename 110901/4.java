import java.io.*;

public class Main {
	private static final int MAX = 200;
	private static int n;
	private static int[][] graph = new int[MAX][MAX];
	private static int[] color = new int[MAX];
	private static boolean solved;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int v1, v2, l;
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					graph[i][j] = 0;
			}
			l = Integer.parseInt(br.readLine());
			for (int i = 0; i < l; i++) {
				line = br.readLine();
				v1 = Integer.parseInt(line.split(" ")[0]);
				v2 = Integer.parseInt(line.split(" ")[1]);
				graph[v1][v2] = 1;
				graph[v2][v1] = 1;
			}
			for (int i = 0; i < n; i++)
				color[i] = 0;
			solved = true;
			dfs(0, 1);
			if (solved)
				System.out.println("BICOLORABLE.");
			else
				System.out.println("NOT BICOLORABLE.");
		}
	}

	public static void dfs(int node, int c) {
		color[node] = c;
		for (int i = 0; i < n && solved; i++) {
			if (graph[node][i] == 0)
				continue;
			if (color[i] == 0)
				dfs(i, c % 2 + 1);
			else {
				if (color[i] == c) {
					solved = false;
					return;
				}
			}
		}
	}

}