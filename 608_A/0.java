import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		FastReader reader = new FastReader();
		int n = reader.nextInt();
		int s = reader.nextInt();
		int[][] mat = new int[n][2];
		for (int i = 0; i < n; ++i) {
			int j = 0;
			for (String st : reader.nextLine().split("\\s+"))
				mat[i][j++] = Integer.parseInt(st);
		}
		reader.close();
		int time = s - mat[n - 1][0];
		if (time < mat[n - 1][1])
			time += mat[n - 1][1] - time;
		for (int i = n - 2; i >= 0; --i) {
			time += mat[i + 1][0] - mat[i][0];
			if (time < mat[i][1])
				time += mat[i][1] - time;
		}
		System.out.println(time + mat[0][0]);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine().trim());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine().trim();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		int[] readArray(int size) {
			int[] ar = new int[size];
			int i = 0;
			try {
				for (String s : br.readLine().trim().split("\\s+"))
					ar[i++] = Integer.parseInt(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return ar;
		}

		void close() {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}