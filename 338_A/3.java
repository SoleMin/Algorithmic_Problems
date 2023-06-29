import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class CFFF {
	static PrintWriter out;
	static final int oo = 987654321;
	static final long mod = (long)(1e9)+9;
	public static void main(String[] args) {
		MScanner sc = new MScanner();
		out = new PrintWriter(System.out);

		long N = sc.nextLong();
		long M = sc.nextLong();
		long K = sc.nextLong();
		
		if(M<=N-N/K)
			out.println(M);
		else{
			long ans = (fastModExpo(2,M-(N-N%K)/K*(K-1)-N%K+1,mod)-2)*K+M-(M-(N-N%K)/K*(K-1)-N%K)*K;
			out.println((mod+ans)%mod);
		}		
		out.close();
	}
	static long fastModExpo(int base, long pow, long mod) {
		if (pow == 0) 
			return 1L;
		if ((pow & 1) == 1)
			return (base*fastModExpo(base, pow - 1,mod))%mod;
		long temp = fastModExpo(base, pow / 2, mod);
		return (temp*temp)%mod;
	}

	static class MScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public MScanner() {
			stream = System.in;
			// stream = new FileInputStream(new File("dec.in"));

		}

		int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] nextInt(int N) {
			int[] ret = new int[N];
			for (int a = 0; a < N; a++)
				ret[a] = nextInt();
			return ret;
		}

		int[][] nextInt(int N, int M) {
			int[][] ret = new int[N][M];
			for (int a = 0; a < N; a++)
				ret[a] = nextInt(M);
			return ret;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		long[] nextLong(int N) {
			long[] ret = new long[N];
			for (int a = 0; a < N; a++)
				ret[a] = nextLong();
			return ret;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		double[] nextDouble(int N) {
			double[] ret = new double[N];
			for (int a = 0; a < N; a++)
				ret[a] = nextDouble();
			return ret;
		}

		String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		String[] next(int N) {
			String[] ret = new String[N];
			for (int a = 0; a < N; a++)
				ret[a] = next();
			return ret;
		}

		String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}

		String[] nextLine(int N) {
			String[] ret = new String[N];
			for (int a = 0; a < N; a++)
				ret[a] = nextLine();
			return ret;
		}

	}
}
