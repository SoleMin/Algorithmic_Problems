import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			br.readLine();
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(A);
			if (N == 1) {
				out.append(A[0]).append("\n\n");
				continue;
			}
			int ans = A[1];
			for (int i = N - 1; i > 2; i -= 2) {
				ans += A[i] + A[0] + Math.min(A[i - 1] + A[0], 2 * A[1]);
			}
			if (N % 2 == 1) {
				ans += A[0] + A[2];
			}
			out.append(ans).append("\n\n");
		}
		out.deleteCharAt(out.length() - 1);
		
		System.out.print(out);
		
		br.close();
	}
}