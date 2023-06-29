import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	private static StreamTokenizer in;
	private static PrintWriter out;
	static {
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(
				System.in)));
		out = new PrintWriter(System.out);
	}

	private static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	private static double nextDouble() throws Exception {
		in.nextToken();
		return in.nval;
	}

	private static String nextString() throws Exception {
		in.nextToken();
		return in.sval;
	}

	public static void main(String[] args) throws Exception {
		int n = nextInt(), k = nextInt(), A = nextInt(), r = n + k - 1;
		int[][] s = new int[n][];
		for (int i = 0; i < n; i++) {
			s[i] = new int[] { nextInt(), nextInt() };
		}
		double max = 0;
		int[] prb = new int[n];
		for (int u = (1 << r); u >= 0; u--) {
			// проверим на n-1 единичек
			int ones = 0;
			for (int i = 0; i < r; i++) {
				if ((u & (1 << i)) != 0) {
					ones++;
				}
			}
			if (ones != n - 1) {
				continue;
			}
			// проверили. расставляем массив
			ones = 0;
			int p = 0;
			for (int i = 0; i < r; i++) {
				if ((u & (1 << i)) == 0) {
					ones++;
				} else {
					prb[p] = ones * 10;
					p++;
					ones = 0;
				}
			}
			prb[p] = ones * 10;
			p++;
			ones = 0;
			double sum = 0;
			for (int i = 0; i < n; i++) {
				if (prb[i] > 100 - s[i][1])
					prb[i] = 100 - s[i][1];
				s[i][1] = prb[i] + s[i][1];
			}
			for (int i = (1 << n) - 1; i >= 0; i--) {
				double prob = 1;
				int lvl = 0;
				int kill = 0;
				for (int j = 0; j < n; j++) {
					if ((i & (1 << j)) != 0) {
						prob *= s[j][1] / 100.0;
						kill--;
					} else {
						lvl += s[j][0];
						prob *= (1 - s[j][1] / 100.0);
						kill++;
					}
				}
				if (kill >= 0) {
					sum += prob * ((double) A / (A + lvl));
				} else {
					sum += prob;
				}
			}
			for (int i = 0; i < n; i++) {
				s[i][1] = -prb[i] + s[i][1];
			}
			max = Math.max(max, sum);
		}
		out.println(max);
		out.flush();
	}
}
