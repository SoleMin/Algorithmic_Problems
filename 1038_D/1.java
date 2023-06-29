import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class Contest {

	static final Random random = new Random();
	static PrintWriter out = new PrintWriter(System.out);
//	Scanner sc = new Scanner(new File("src/input.txt"));

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n == 1) {
			System.out.println(sc.nextLong());
			return;
		}
		
		long ans = 0, minval = Long.MAX_VALUE;
		boolean pos = false, neg = false;
		for(int i = 0;i < n;i++) {
			long a = sc.nextLong();
			minval = Math.min(minval, Math.abs(a));
			ans += Math.abs(a);
			pos |=(a>=0);
			neg |= (a < 0);
		}
		
		if(pos && neg) {
			out.println(ans);
		}else
			out.println(ans - 2*minval);

		out.flush();
	}

	static void Arrayssort(int[] a) {
		int n = a.length;// shuffle, then sort
		for (int i = 0; i < n; i++) {
			int oi = random.nextInt(n);
			int temp = a[oi];
			a[oi] = a[i];
			a[i] = temp;
		}
		java.util.Arrays.sort(a);
	}

	private static class Scanner {
		public BufferedReader reader;
		public StringTokenizer st;

		public Scanner(InputStream file) throws FileNotFoundException {
			reader = new BufferedReader(new InputStreamReader(file));
			st = null;
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String line = reader.readLine();
					if (line == null)
						return null;
					st = new StringTokenizer(line);
				} catch (Exception e) {
					throw (new RuntimeException());
				}
			}
			return st.nextToken();
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

		public String nextLine() throws IOException {
			return reader.readLine();
		}
	}

}