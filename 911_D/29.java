import java.io.*;
import java.util.*;

public class Mainn {

	public static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public char nextChar() {
			return next().charAt(0);
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextInt();
			}
			return arr;
		}

		public Integer[] nextIntegerArr(int n) {
			Integer[] arr = new Integer[n];
			for (int i = 0; i < n; i++) {
				arr[i] = new Integer(this.nextInt());
			}
			return arr;
		}

		public int[][] next2DIntArr(int n, int m) {
			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = this.nextInt();
				}
			}
			return arr;
		}

		public int[] nextSortedIntArr(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextInt();
			}
			Arrays.sort(arr);
			return arr;
		}

		public long[] nextLongArr(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextLong();
			}
			return arr;
		}

		public char[] nextCharArr(int n) {
			char[] arr = new char[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextChar();
			}
			return arr;
		}
	}

	public static InputReader scn = new InputReader();
	public static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		// InputStream inputStream = System.in; // Useful when taking input other than
		// console eg file handling // check ctor of inputReader
		// To print in file use this:- out = new PrintWriter("destination of file
		// including extension");

		int n = scn.nextInt(), inv = 0;
		int[] arr = scn.nextIntArr(n);
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(arr[i] > arr[j]) {
					inv++;
				}
			}
		}
		
		int ans = inv % 2;
		
		int m = scn.nextInt();
		while(m-- > 0) {
			int l = scn.nextInt(), r = scn.nextInt();
			
			int change = ((r - l + 1) / 2) % 2;
			
			if(change == 1) {
				ans = 1 - ans;
			}
			
			if(ans == 0) {
				out.println("even");
			} else {
				out.println("odd");
			}
		}
		
		out.close();
	}
}
