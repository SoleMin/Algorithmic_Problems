import java.io.*;
import java.util.*;

class Main {
	static int N, cnt;
	static boolean[] dig;
	
	public static void solve(int x, int y, int z, int K) {
		if (y == K) {
			cnt++;
			return;
		} else if (x == 2 * N - 1) {
			return;
		}
		solve(x + 1, y, z, K);
		if (x % 2 == z) {
			return;
		}
		int to = N - Math.abs(x - N + 1);
		for (int i = 0; i < to; i++) {
			int v = Math.abs(x - N + 1) + 2 * i;
			if (!dig[v]) {
				dig[v] = true;
				solve(x + 1, y + 1, z, K);
				dig[v] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			if (N == 0 && K == 0) {
				break;
			}
			if (2 * N - 1 < K) {
				out.append("0\n");
				continue;
			}
			dig = new boolean[2 * N - 1];
			long ans = 0;
			for (int i = 0; i <= K; i++) {
				solve(0, 0, 1, i);
				int x = cnt;
				cnt = 0;
				solve(0, 0, 0, K - i);
				int y = cnt;
				cnt = 0;
				ans += x * y;
			}
			out.append(ans).append('\n');
		}
		
		System.out.print(out);
		
		br.close();
	}
}