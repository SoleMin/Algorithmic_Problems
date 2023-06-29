import java.util.*;
import java.io.*;

public class C1523 {
	public static void print(Stack<Integer> st, PrintWriter pw) {
		for (int i = 0; i < st.size(); i++) {
			pw.print(st.get(i));
			if (i != st.size() - 1) {
				pw.print(".");
			}
		}
		pw.println();
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = sc.nextIntArr(n);
			Stack<Integer> st = new Stack<Integer>();
			st.add(arr[0]);
			print(st, pw);
			for (int i = 1; i < n; i++) {
				if (arr[i] == 1) {
					st.add(arr[i]);
				} else {
					while (st.peek() != arr[i] - 1) {
						st.pop();
					}
					st.pop();
					st.add(arr[i]);
				}
				print(st, pw);
			}
		}
		pw.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader f) {
			br = new BufferedReader(f);
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

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(next());
			}
			return arr;
		}

	}

}
