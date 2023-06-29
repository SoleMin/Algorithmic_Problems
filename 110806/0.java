import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int[] A;
	static char[] S, T;
	static boolean reachable;
	
	public static void solve(int idx) {
		if (idx == N - 1) {
			if (A[4 * T[N - 2] + 2 * T[N - 1] + T[0]] == S[N - 1]
					&& A[4 * T[N - 1] + 2 * T[0] + T[1]] == S[0]) {
				reachable = true;
			}
			return;
		}
		int x = 4 * T[idx - 1] + 2 * T[idx];
		for (char i = 0; i < 2; i++) {
			if (A[x + i] == S[idx]) {
				T[idx + 1] = i;
				solve(idx + 1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(line);
			int id = Integer.parseInt(st.nextToken());
			A = new int[8];
			for (int i = 0; i < 8; i++) {
				A[i] = (id >> i) & 1;
			}
			N = Integer.parseInt(st.nextToken());
			S = st.nextToken().toCharArray();
			for (int i = 0; i < N; i++) {
				S[i] -= 48;
			}
			T = new char[N];
			reachable = false;
			for (int i = 0; i < 8; i++) {
				if (S[1] == A[i]) {
					for (int j = 0; j < 3; j++) {
						T[j] = (char)((i >> (2 - j)) & 1);
					}
					solve(2);
				}
			}
			out.append(reachable ? "REACHABLE\n" : "GARDEN OF EDEN\n");
		}
		
		System.out.print(out);
		
		br.close();
	}
}