import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	final static int mod = 1_000_000_007;

	public static void main(String[] args) throws Exception {

		STDIN scan = new STDIN();
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = scan.nextInt();
		boolean even = true;
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
			for(int j = 0; j < i; j++)
				if(a[i] < a[j]) even = !even;
		}
		int q = scan.nextInt();
		while(q-- > 0) {
			int l = scan.nextInt(), r = scan.nextInt();
			int len = r - l + 1;
			int permutations = len * (len - 1) / 2;
			if(permutations % 2 != 0) even = !even;
			pw.println(even ? "even" : "odd");
		}
		
		pw.flush();
	}
		
	static class STDIN {
		BufferedReader br;
		StringTokenizer st;

		public STDIN() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = null;
		}

		boolean hasNext() throws Exception {
			if (!st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.hasMoreTokens();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws Exception {
			return br.readLine();
		}
	}
}