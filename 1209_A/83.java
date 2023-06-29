import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class A {
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] color = new int[n];
		for (int i = 0; i<n; i++) {
			arr[i]  =sc.nextInt();
		}
		Arrays.sort(arr);
		int counter = 1;
		for (int i = 0; i<n; i++) {
			if (color[i]!= 0) continue;
			for (int j = i;j<n; j++) {
				if (color[j]!= 0) continue;
				else if (arr[j]%arr[i] == 0) color[j] = counter;
			}
			counter++;
		}
	//	System.out.println(Arrays.toString(color));
		int max = 0;
		for (int i = 0; i<n; i++) {
			max = Math.max(max, color[i]);
		}
		System.out.println(max);
	}
	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public FastScanner() {
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

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}
	public static void main (String[] args) throws Exception {
		new A().run();
	}
}