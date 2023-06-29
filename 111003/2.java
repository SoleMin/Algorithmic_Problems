import java.io.*;
import java.util.*;

class Main {
	static final int INF = Integer.MAX_VALUE / 2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		br.readLine();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int F = Integer.parseInt(st.nextToken());
			int I = Integer.parseInt(st.nextToken());
			boolean[] chk = new boolean[I];
			while (F-- > 0) {
				int x = Integer.parseInt(br.readLine()) - 1;
				chk[x] = true;
			}
			int[][] d = new int[I][I];
			for (int i = 0; i < I; i++) {
				Arrays.fill(d[i], INF);
				d[i][i] = 0;
			}
			while (true) {
				String line = br.readLine();
				if (line == null || line.length() == 0) {
					break;
				}
				st = new StringTokenizer(line);
				int u = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken()) - 1;
				int w = Integer.parseInt(st.nextToken());
				d[u][v] = d[v][u] = w;
			}
			for (int k = 0; k < I; k++) {
				for (int i = 0; i < I; i++) {
					for (int j = 0; j < I; j++) {
						d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
					}
				}
			}
			int[] A = new int[I];
			Arrays.fill(A, INF);
			for (int i = 0; i < I; i++) {
				for (int j = 0; j < I; j++) {
					if (chk[j]) {
						A[i] = Math.min(A[i], d[i][j]);
					}
				}
			}
			int max = INF;
			int ans = 0;
			for (int i = 0; i < I; i++) {
				int now_max = 0;
				for (int j = 0; j < I; j++) {
					now_max = Math.max(now_max, Math.min(A[j], d[i][j]));
				}
				if (max > now_max) {
					max = now_max;
					ans = i;
				}
			}
			out.append(ans + 1).append("\n\n");
		}
		out.deleteCharAt(out.length() - 1);
		
		System.out.print(out);
		
		br.close();
	}
}