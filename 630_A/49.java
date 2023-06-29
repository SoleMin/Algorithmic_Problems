import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {
	
	public static void main(String[] args) {
		try (final Scanner sc = new Scanner(System.in)) {
			System.out.println(25);
		}
	}
	
	public static class Scanner implements Closeable {
		private BufferedReader br;
		private StringTokenizer tok;

		public Scanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		private void getLine() {
			try {
				while (!hasNext()) {
					tok = new StringTokenizer(br.readLine());
				}
			} catch (IOException e) { /* ignore */
			}
		}

		private boolean hasNext() {
			return tok != null && tok.hasMoreTokens();
		}

		public String next() {
			getLine();
			return tok.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}

		public void close() {
			try {
				br.close();
			} catch (IOException e) { /* ignore */
			}
		}
	}
}
