import java.io.*;
import java.util.*;

class Main {
	static final int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static final int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		for (int tc = 1;; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) {
				break;
			}
			char[][] grid = new char[N][];
			for (int i = 0; i < N; i++) {
				grid[i] = br.readLine().toCharArray();
			}
			int[][] A = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (grid[i][j] == '*') {
						continue;
					}
					int cnt = 0;
					for (int k = 0; k < 8; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx == -1 || nx == N || ny == -1 || ny == M) {
							continue;
						}
						if (grid[nx][ny] == '*') {
							cnt++;
						}
					}
					A[i][j] = cnt;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (grid[i][j] == '*') {
						continue;
					}
					grid[i][j] = (char)(A[i][j] + 48);
				}
			}
			out.append("Field #").append(tc).append(":\n");
			for (int i = 0; i < N; i++) {
				out.append(grid[i]).append('\n');
			}
			out.append('\n');
		}
		out.deleteCharAt(out.length() - 1);
		
		System.out.print(out);
		br.close();
	}
}