import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(A);
			int ans = 0;
			for (int i = 0; i < N; i++) {
				ans += Math.abs(A[i] - A[N / 2]);
			}
			out.append(ans).append('\n');
		}
		
		System.out.print(out);
		
		br.close();
	}
}