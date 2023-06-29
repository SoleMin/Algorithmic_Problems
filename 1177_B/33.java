import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	static final int MAX_N = 1000010;
	static final int INF = 0x3f3f3f3f;
	static final int mod = 1000000007;


	public static void main(String[] args) throws IOException {
		initReader(System.in);


//		int T = nextInt();
//		for (int i = 1; i <= T; i++)
			solve();

		pw.flush();
	}


	/*******************************************************************************************************************************/


	public static void solve() throws IOException {
		while (hasNext()) {
			long n = nextLong() - 1;

			long k = 1, x = 9;
			while (n - k * x >= 0) {
				n -= k * x;
				k += 1;
				x *= 10;
			}

			if (n == 0)
				pw.println(1);
			else {
				long num = x / 9 + n / k;
				String s = String.valueOf(num);
				pw.println(s.charAt((int) (n % k)));
			}
		}
	}




	/*******************************************************************************************************************************/

	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static PrintWriter pw;

	public static void initReader(InputStream input) throws IOException {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

//		reader = new BufferedReader(new FileReader("ate.in"));
//		tokenizer = new StringTokenizer("");
//		printWriter = new PrintWriter(new BufferedWriter(new FileWriter("ate.out")));
	}

	public static boolean hasNext() {
		try {
			while (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	public static String nextLine() {
		try {
			return reader.readLine();
		} catch (Exception e) {
			return null;
		}
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public static char nextChar() throws IOException {
		return next().charAt(0);
	}

	static class Pair {
		char first;
		boolean second;

		public Pair(char first, boolean second) {
			// TODO Auto-generated constructor stub

			this.first = first;
			this.second = second;
		}


		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "(" + this.first + ", " + this.second + ")";
		}
	}
}


	  	 	 	   	 	      	 		 	  	 	