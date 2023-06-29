import java.io.*;
import java.util.*;

public class C {
	public static void main(String[] args) throws Exception {
		File in = new File("input.txt"), out = new File("output.txt");
		Scanner s;
		PrintWriter pw;
		if (in.exists()) {
			s = new Scanner(in);
			pw = new PrintWriter(out);
		} else {
			s = new Scanner(System.in);
			pw = new PrintWriter(System.out);
		}
		int n = s.nextInt(), m = s.nextInt();
		int k = s.nextInt();
		List<int[]> list = new ArrayList<int[]>();
		for (int t = 0; t < k; ++t) {
			list.add(new int[] { s.nextInt() - 1, s.nextInt() - 1 });
		}
		int max = 0, mi = 1, mj = 1;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				int min = Integer.MAX_VALUE;
				for (int[] p : list) {
					min = Math.min(min, Math.abs(i - p[0]) + Math.abs(j - p[1]));
				}
				if (min > max) {
					max = Math.max(max, min);
					mi = i + 1;
					mj = j + 1;
				}
			}
		}
		pw.println(mi + " " + mj);
		pw.close();
	}
}
