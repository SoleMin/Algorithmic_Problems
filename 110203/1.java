import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int P = Integer.parseInt(br.readLine());
			int[] H = new int[P];
			for (int i = 0; i < P; i++) {
				H[i] = Integer.parseInt(br.readLine());
			}
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if (i % 7 == 0 || i % 7 == 6) {
					continue;
				}
				for (int j = 0; j < P; j++) {
					if (i % H[j] == 0) {
						ans++;
						break;
					}
				}
			}
			out.append(ans).append('\n');
		}
		
		System.out.print(out);
		br.close();
	}
}