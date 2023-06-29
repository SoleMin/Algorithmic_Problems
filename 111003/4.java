import java.util.*;
import java.io.*;

public class Main {
	private static final int INF = 999999;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		br.readLine();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] crossroads = new int[m][m];
			for (int i = 0; i < m; i++)
				for (int j = 0; j < m; j++)
					crossroads[i][j] = (i == j) ? 0 : INF;

			boolean[] fireStation = new boolean[m];
			for (int f = 0; f < n; f++)
				fireStation[Integer.parseInt(br.readLine()) - 1] = true;

			while (true) {
				String line = br.readLine();
				if(line == null)
					break;
				st = new StringTokenizer(line);
				if(st.countTokens() == 0)
					break;
				int v1 = Integer.parseInt(st.nextToken()) - 1;
				int v2 = Integer.parseInt(st.nextToken()) - 1;
				int dist = Integer.parseInt(st.nextToken());
				crossroads[v1][v2] = dist;
				crossroads[v2][v1] = dist;

			}

			for (int k = 0; k < m; k++)
				for (int i = 0; i < m; i++)
					for (int j = 0; j < m; j++) {
						crossroads[i][j] = Math.min(crossroads[i][j], crossroads[i][k] + crossroads[k][j]);
					}

			int ans = 1;
			int min = Integer.MAX_VALUE;
			for (int k = 0; k < m; k++)
				if (!fireStation[k]) {
					int currDist = Integer.MIN_VALUE;
					for (int i = 0; i < m; i++) {
						int dist = INF;
						for (int j = 0; j < m; j++)
							if (fireStation[j])
								dist = Math.min(dist, crossroads[i][j]);
						currDist = Math.max(currDist, dist);
					}

					int nextDist = Integer.MIN_VALUE;
					for (int i = 0; i < m; i++) {
						int dist = INF;
						for (int j = 0; j < m; j++)
							if (fireStation[j] || j == k)
								dist = Math.min(dist, crossroads[i][j]);
						nextDist = Math.max(nextDist, dist);
					}
					
					if (nextDist < currDist && nextDist < min) {
						min = nextDist;
						ans = k + 1;
					}
				}
			System.out.println(ans);
			System.out.println();
		}
	}
}