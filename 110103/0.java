import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			int[] A = new int[N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				A[i] = Integer.parseInt(str.substring(0, str.length() - 3).concat(str.substring(str.length() - 2)));
			}
			Arrays.sort(A);
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += A[i];
			}
			int avg = sum / N;
			int cnt = N - sum % N;
			int ans = 0;
			for (int i = 0; i < N; i++) {
				if (i < cnt) {
					ans += Math.abs(avg - A[i]);
				} else {
					ans += Math.abs(avg + 1 - A[i]);
				}
			}
			ans /= 2;
			out.append(String.format("$%d.%02d\n", ans / 100, ans % 100));
		}
		
		System.out.print(out);
		br.close();
	}
}