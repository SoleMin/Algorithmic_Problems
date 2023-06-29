import java.io.*;
import java.util.*;

public class C {

	void run() throws IOException {
		int n = ni(), m = ni(), k = ni(), q = n * m, h = 0, t = 0, inf = 123456;
		int[] x = new int[q], y = new int[q];
		int[][] d = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				d[i][j] = inf;
		for (int i = 0; i < k; i++) {
			int u = ni() - 1, v = ni() - 1;
			d[u][v] = 0;
			x[t] = u;
			y[t] = v;
			t++;
		}
		if (k < q)
			while (t != h) {
				int u = x[h], v = y[h];
				int l = d[u][v] + 1;
				h++;
				if (u > 0 && d[u - 1][v] > l) {
					d[u - 1][v] = l;
					x[t] = u - 1;
					y[t] = v;
					t++;
				}
				if (u < n - 1 && d[u + 1][v] > l) {
					d[u + 1][v] = l;
					x[t] = u + 1;
					y[t] = v;
					t++;
				}
				if (v > 0 && d[u][v - 1] > l) {
					d[u][v - 1] = l;
					x[t] = u;
					y[t] = v - 1;
					t++;
				}
				if (v < m - 1 && d[u][v + 1] > l) {
					d[u][v + 1] = l;
					x[t] = u;
					y[t] = v + 1;
					t++;
				}
			}
		int max = 0, tx = 0, ty = 0;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (d[i][j] > max) {
					max = d[i][j];
					tx = i;
					ty = j;

				}
		pw.print(1 + tx + " " + (1 + ty));
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	int ni() throws IOException {
		return Integer.parseInt(next());
	}

	String nl() throws IOException {
		return br.readLine();
	}

	PrintWriter pw;
	BufferedReader br;
	StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader _br = new BufferedReader(new FileReader(new File("input.txt")));
		PrintWriter _pw = new PrintWriter(new FileWriter(new File("output.txt")));
		new C(_br, _pw).run();
		_br.close();
		_pw.close();
	}

	public C(BufferedReader _br, PrintWriter _pw) {
		br = _br;
		pw = _pw;
	}
}
