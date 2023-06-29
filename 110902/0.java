import java.io.*;
import java.util.*;

class Main {
	static boolean[] chk;
	static int[] A;
	
	public static int next(int x, int idx, int inc) {
		for (int i = 3; i >= 0; i--) {
			A[i] = x % 10;
			x /= 10;
		}
		A[idx] = (A[idx] + 10 + inc) % 10;
		for (int i = 0; i < 4; i++) {
			x = x * 10 + A[i];
		}
		return x;
	}
	
	public static int bfs(int S, int E) {
		int[] d = new int[10000];
		Arrays.fill(d, -1);
		d[S] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(S);
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j > -2; j -= 2) {
					int y = next(x, i, j);
					if (chk[y] && d[y] == -1) {
						d[y] = d[x] + 1;
						q.offer(y);
					}
				}
			}
		}
		return d[E];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		A = new int[4];
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S, E;
			S = E = 0;
			for (int i = 0; i < 4; i++) {
				S = S * 10 + Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				E = E * 10 + Integer.parseInt(st.nextToken());
			}
			chk = new boolean[10000];
			Arrays.fill(chk, true);
			int N = Integer.parseInt(br.readLine());
			while (N-- > 0) {
				st = new StringTokenizer(br.readLine());
				int x = 0;
				for (int i = 0; i < 4; i++) {
					x = x * 10 + Integer.parseInt(st.nextToken());
				}
				chk[x] = false;
			}
			out.append(bfs(S, E)).append('\n');
		}
		
		System.out.print(out);
		
		br.close();
	}
}