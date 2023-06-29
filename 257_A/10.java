//package Round_159;

import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class a {

	void solve() throws Exception {
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i<n; i++){
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		int sum = 0;
		if (k >= m){
			out.println(0);
			return;
		}
		sum = a[n-1] + k - 1;
		int j = 1;
		for (int i = n-2; i >=0 && sum < m; i--, j++){
			sum += a[i] - 1;
		}
		if (sum < m){
			out.println(-1);
		}else{
			out.println(j);
		}
	}

	FastScanner in;
	PrintWriter out;

	String input = "";
	String output = "";

	void run() {
		try {
			if (input.length() > 0) {
				in = new FastScanner(new BufferedReader(new FileReader(input)));
			} else
				in = new FastScanner(new BufferedReader(new InputStreamReader(
						System.in)));
			if (output.length() > 0)
				out = new PrintWriter(new FileWriter(output));
			else
				out = new PrintWriter(System.out);

			solve();

			out.flush();
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			out.flush();
			out.close();
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) {
		new a().run();
	}

	class FastScanner {
		BufferedReader bf;
		StringTokenizer st;

		public FastScanner(BufferedReader bf) {
			this.bf = bf;
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(bf.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public String nextLine() throws IOException {
			return bf.readLine();
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

	}

}
