import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {


	static ArrayList<Integer> statements;
	static final int MOD = (int) 1e9 + 7;

	static int[][] memo;

	static int solve(int i, int c) {
		if(i == statements.size())
			return 1;
		if(memo[i][c] != -1)
			return memo[i][c];

		long ans = solve(i + 1, c + statements.get(i));
		if(c > 0)
			ans += solve(i, c - 1);
		return memo[i][c] = (int) (ans % MOD);

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt();
		statements = new ArrayList<>();

		char[] c = new char[n];
		for (int i = 0; i < n; i++) {
			c[i] = sc.next().charAt(0);
		}

		if(c[0] == 's')
			statements.add(0);
		else
			statements.add(1);

		for (int i = 1; i < n; i++) {
			if(c[i - 1] == 'f') {
				if(c[i] == 'f')
					statements.set(statements.size() - 1, statements.get(statements.size() - 1) + 1);
			}else {

				if(c[i] == 's')
					statements.add(0);
				else
					statements.add(1);
			}
		}


		memo = new int[statements.size()][n + 1];

		for(int[] a : memo)
			Arrays.fill(a, -1);
		out.println(solve(0, 0));
		out.flush();
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String file) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}