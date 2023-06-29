import java.io.*;
import java.util.*;

public class Main {
	static Scanner in;
	static PrintWriter out;
//	static StreamTokenizer in; static int next() throws Exception {in.nextToken(); return (int) in.nval;}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
//		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

		int n = in.nextInt();

		double[][] p = new double[n][n];
		for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) p[i][j] = in.nextDouble();

		double[] q = new double[1 << n];
		q[(1 << n) - 1] = 1;
		for (int mask = (1 << n) - 1; mask > 0; mask--) {
			int count = 0;

			for (int t = 0; t < n; t++) if (((1 << t) & mask) != 0) count++;
			if (count <= 1) continue;
			count = count*(count - 1)/2;

			for (int t = 0; t < n; t++) if (((1 << t) & mask) != 0)
				for (int s = 0; s < t; s++) if (((1 << s) & mask) != 0) {
					q[mask - (1 << t)] += q[mask] / count * p[s][t];
					q[mask - (1 << s)] += q[mask] / count * p[t][s];
				}
		}

		for (int i = 0; i < n; i++) out.print(q[1 << i] + " ");

		out.close();
	}
}