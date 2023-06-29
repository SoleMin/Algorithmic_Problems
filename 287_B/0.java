import java.io.IOException;
import java.util.InputMismatchException;

public class Pipeline {
    public static void main(String[] args) {
        FasterScanner sc = new FasterScanner();
        
        long N = sc.nextLong();
        long K = sc.nextLong();
        
        if (N == 1) {
        	System.out.println(0);
        	return;
        }
        
        long left = 2;
        long rite = K;
        long good = -1;
        while (left <= rite) {
        	long mid = (left + rite) / 2;
        	long max = K * (K + 1) / 2 - mid * (mid - 1) / 2 - (K - mid);
        	if (max >= N) {
        		good = mid;
        		left = mid + 1;
        	} else {
        		rite = mid - 1;
        	}
        }
        System.out.println((good >= 2) ? (K - good + 1) : -1);
    }
    
	public static class FasterScanner {
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = System.in.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public String nextString() {
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

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
	        
	    public int[] nextIntArray(int n) {
	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++) {
	            arr[i] = nextInt();
	        }
	        return arr;
	    }
        
		public long[] nextLongArray(int n) {
		    long[] arr = new long[n];
		    for (int i = 0; i < n; i++) {
		        arr[i] = nextLong();
		    }
		    return arr;
		}

	    private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
	}
}