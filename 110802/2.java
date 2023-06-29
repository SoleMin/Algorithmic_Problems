import java.io.*;
import java.util.*;

class Main {
	static final int[] dx = { 0, 0, 1, -1 };
	static final int[] dy = { 1, -1, 0, 0 };
	static final String[] dS = { "R", "L", "D", "U" };
	
	static class State implements Comparable<State> {
		long x;
		String path;
		int g, h;
		
		State(long x, String path, int g, int h) {
			this.x = x;
			this.path = path;
			this.g = g;
			this.h = h;
		}
		
		public int compareTo(State s) {
			return g + h - (s.g + s.h);
		}
	}
	
	public static long arrToLong(int[][] A) {
		long x = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				x = (x << 4) + A[i][j];
			}
		}
		return x;
	}
	
	public static void longToArr(long x, int[][] A) {
		for (int i = 3; i >= 0; i--) {
			for (int j = 3; j >= 0; j--) {
				A[i][j] = (int)(x & 15);
				x >>= 4;
			}
		}
	}
	
	public static int calc_h(int[][] A) {
		int h = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (A[i][j] == 0) {
					continue;
				}
				h += Math.abs((A[i][j] - 1) / 4 - i) + Math.abs((A[i][j] - 1) % 4 - j);
			}
		}
		return h;
	}
	
	public static boolean solve(int[][] A) {
		long x = arrToLong(A);
		Queue<State> pq = new PriorityQueue<>();
		pq.offer(new State(x, "", 0, calc_h(A)));
		Map<Long, Integer> map = new HashMap<>();
		map.put(x, 0);
		while (!pq.isEmpty()) {
			State S = pq.poll();
			if (S.h == 0) {
				System.out.println(S.path);
				return true;
			}
			if (map.get(S.x) < S.g) {
				continue;
			}
			longToArr(S.x, A);
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (A[i][j] == 0) {
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if (nx == -1 || nx == 4 || ny == -1 || ny == 4) {
								continue;
							}
							A[i][j] = A[nx][ny];
							A[nx][ny] = 0;
							long y = arrToLong(A);
							if (!map.containsKey(y) || map.get(y) > S.g + 1) {
								State T = new State(y, S.path + dS[k], S.g + 1, calc_h(A));
								if (T.g + T.h <= 45) {
									pq.offer(T);
									map.put(y, S.g + 1);
								}
							}
							A[nx][ny] = A[i][j];
							A[i][j] = 0;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			int[][] A = new int[4][4];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (A[i][j] == 0) {
						cnt += i;
						continue;
					}
					for (int k = i; k < 4; k++) {
						for (int l = k == i ? j + 1 : 0; l < 4; l++) {
							if (A[i][j] > A[k][l] && A[k][l] > 0) {
								cnt++;
							}
						}
					}
				}
			}
			if (cnt % 2 == 0 || !solve(A)) {
				System.out.println("This puzzle is not solvable.");
			}
		}
		
		br.close();
	}
}