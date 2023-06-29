import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			br.readLine();
			int N = Integer.parseInt(br.readLine());
			int[] T = new int[N];
			int[] S = new int[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				T[i] = Integer.parseInt(st.nextToken());
				S[i] = Integer.parseInt(st.nextToken());
			}
			int[] A = new int[N];
			for (int i = 0; i < N; i++) {
				A[i] = i;
			}
			for (int i = N - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (T[A[j]] * S[A[j + 1]] > T[A[j + 1]] * S[A[j]]) {
						int tmp = A[j];
						A[j] = A[j + 1];
						A[j + 1] = tmp;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				out.append(A[i] + 1).append(' ');
			}
			out.setCharAt(out.length() - 1, '\n');
			out.append('\n');
		}
		out.deleteCharAt(out.length() - 1);
		
		System.out.print(out);
		
		br.close();
	}
}