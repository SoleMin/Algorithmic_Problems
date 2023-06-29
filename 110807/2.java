import java.io.*;
import java.util.*;

class Main {
	static final int[] ANS_ARR = { 0, 1, 2, 1, 0, 2, 3, 2, 0, 0, 1, 0, 0, 3, 4, 3, 0, 4, 5, 4, 0 };
	static final long ANS_X = arrToLong(ANS_ARR);
	static final int[][] dist = {
		{ 0, 1, 1, 3, 3, 3 },
		{ 1, 0, 2, 2, 3 },
		{ 1, 2, 0, 2, 4, 4 },
		{ 2, 0, 1, 3, 4 },
		{ 0, 3, 1, 1, 5, 5 },
		{ 2, 1, 0, 4, 3 },
		{ 1, 2, 2, 0, 4, 4 },
		{ 1, 2, 0, 3, 2 },
		{ 0, 1, 3, 1, 3, 3 },
		{ 0, 2, 1, 2, 1 },
		{ 1, 0, 2, 2, 2, 2 },
		{ 0, 1, 2, 1, 2 },
		{ 0, 1, 3, 3, 1, 3 },
		{ 1, 2, 3, 0, 2 },
		{ 1, 2, 4, 4, 0, 2 },
		{ 2, 3, 4, 0, 1 },
		{ 0, 3, 5, 5, 1, 1 },
		{ 2, 4, 3, 1, 0 },
		{ 1, 2, 4, 4, 2, 0 },
		{ 1, 3, 2, 2, 0 },
		{ 0, 1, 3, 3, 3, 1 }
	};
	static int[] A = new int[21];
	static int[] B = new int[21];
	static long ans_path;
	static int ans_len;
	
	static class State implements Comparable<State> {
		long x, path;
		int g, h;
		
		State(long x, long path, int g, int h) {
			this.x = x;
			this.path = path;
			this.g = g;
			this.h = h;
		}
		
		public int compareTo(State s) {
			return g + h == s.g + s.h ? Long.compare(path, s.path) : g + h - (s.g + s.h);
		}
	}
	
	public static long arrToLong(int[] A) {
		long x = 0;
		for (int i = 0; i < 21; i++) {
			x = (x << 3) + A[i];
		}
		return x;
	}
	
	public static void longToArr(long x, int[] A) {
		for (int i = 20; i >= 0; i--) {
			A[i] = (int)(x & 7);
			x >>= 3;
		}
	}
	
	public static int calc_h(int[] A) {
		int h = 0;
		for (int i = 0; i < 21; i++) {
			h = Math.max(h, dist[i][A[i]]);
		}
		return h;
	}
	
	public static void solve(long x, long path, int g, int h, int prev, int prev_cnt) {
		if (x == ANS_X) {
			ans_path = Math.min(ans_path, path);
			ans_len = Math.min(ans_len, g);
			return;
		}
		if (ans_path < path || ans_len <= g + h) {
			return;
		}
		for (int q = 1; q < 5; q++) {
			if ((q == (prev + 1) % 4 + 1 && prev_cnt > 0) || (q == prev && prev_cnt == 3)) {
				continue;
			}
			longToArr(x, A);
			System.arraycopy(A, 0, B, 0, 21);
			switch (q) {
				case 1:
					for (int i = 0; i < 12; i++) {
						B[i] = A[(i + 10) % 12];
					}
					break;
				case 2:
					for (int i = 9; i < 21; i++) {
						B[i] = A[(i + 5) % 12 + 9];
					}
					break;
				case 3:
					for (int i = 0; i < 12; i++) {
						B[i] = A[(i + 2) % 12];
					}
					break;
				case 4:
					for (int i = 9; i < 21; i++) {
						B[i] = A[(i + 1) % 12 + 9];
					}
					break;
			}
			long y = arrToLong(B);
			solve(y, 10 * path + q, g + 1, calc_h(B), q, prev == q ? prev_cnt + 1 : 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 21; i++) {
				A[i] = Integer.parseInt(st.nextToken()) / 2;
			}
			ans_path = Long.MAX_VALUE;
			ans_len = 17;
			solve(arrToLong(A), 0, 0, calc_h(A), -1, 0);
			if (ans_path == Long.MAX_VALUE) {
				System.out.println("NO SOLUTION WAS FOUND IN 16 STEPS");
			} else if (ans_path == 0) {
				System.out.println("PUZZLE ALREADY SOLVED");
			} else {
				System.out.println(ans_path);
			}
		}
		
		br.close();
	}
}