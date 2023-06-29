import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(line);
			int N = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			boolean[] chk = new boolean[N];
			for (int i = 1; i < N; i++) {
				int abs = Math.abs(A[i] - A[i - 1]);
				if (0 < abs && abs < N) {
					chk[abs] = true;
				}
			}
			boolean jolly = true;
			for (int i = 1; i < N; i++) {
				jolly &= chk[i];
			}
			out.append(jolly ? "Jolly\n" : "Not jolly\n");
		}
		
		System.out.print(out);
		br.close();
	}
}