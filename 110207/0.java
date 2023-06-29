import java.io.*;
import java.util.*;

class Main {
	static class Team implements Comparable<Team> {
		int x, y, z;
		
		Team(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public int compareTo(Team t) {
			return y == t.y ? z == t.z ? x - t.x : z - t.z : t.y - y;
		}
		
		public String toString() {
			return x + " " + y + " " + z;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		br.readLine();
		while (T-- > 0) {
			int[][] A = new int[101][10];
			int[] B = new int[101];
			int[] C = new int[101];
			boolean[] D = new boolean[101];
			while (true) {
				String line = br.readLine();
				if (line == null || line.length() == 0) {
					break;
				}
				StringTokenizer st = new StringTokenizer(line);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				char L = st.nextToken().charAt(0);
				D[x] = true;
				if (A[x][y] == -1) {
					continue;
				}
				if (L == 'C') {
					B[x]++;
					C[x] += A[x][y] * 20 + z;
					A[x][y] = -1;
				} else if (L == 'I') {
					A[x][y]++;
				}
			}
			List<Team> list = new ArrayList<>();
			for (int i = 1; i < 101; i++) {
				if (D[i]) {
					list.add(new Team(i, B[i], C[i]));
				}
			}
			Collections.sort(list);
			for (Team t : list) {
				out.append(t).append('\n');
			}
			out.append('\n');
		}
		out.deleteCharAt(out.length() - 1);
		
		System.out.print(out);
		br.close();
	}
}