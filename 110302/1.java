import java.io.*;
import java.util.*;

class Main {
	static final int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static final int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] grid = new char[N][];
			for (int i = 0; i < N; i++) {
				grid[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					grid[i][j] |= 32;
				}
			}
			int K = Integer.parseInt(br.readLine());
			kkk: while (K-- > 0) {
				char[] word = br.readLine().toLowerCase().toCharArray();
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						for (int k = 0; k < 8; k++) {
							int nx = i + dx[k] * (word.length - 1);
							int ny = j + dy[k] * (word.length - 1);
							if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
								continue;
							}
							boolean flag = true;
							for (int l = 0; l < word.length; l++) {
								if (grid[i + l * dx[k]][j + l * dy[k]] != word[l]) {
									flag = false;
									break;
								}
							}
							if (flag) {
								out.append(i + 1).append(' ').append(j + 1).append('\n');
								continue kkk;
							}
						}
					}
				}
			}
			out.append('\n');
		}
		out.deleteCharAt(out.length() - 1);
		
		System.out.print(out);
		
		br.close();
	}
}