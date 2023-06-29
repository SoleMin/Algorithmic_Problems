import java.io.*;
import java.util.*;
public class B {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		int k = in.nextInt();
		
		long numCandies = 1;
		int turns = 1, add = 2;
		while (numCandies < k) {
			++turns;
			numCandies += add++;
		}
		int res = 0;
		if (numCandies > k) {
			turns += (numCandies-k);
			res += (numCandies-k);
			numCandies = k;
		}
		
		if (turns == n) {
			System.out.println(res);
		}
		else {
			while (turns != n) {
				res += add;
				turns += add++ + 1;
			}
			System.out.println(res);
		}
		
	}

	static class InputReader {
		public BufferedReader br;
		public StringTokenizer st;
		
		public InputReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = null;
		}
		
		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}