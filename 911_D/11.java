import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {

	static PrintWriter out;
	static InputReader ir;

	static void solve() {
		int n=ir.nextInt();
		int[] a=ir.nextIntArray(n);
		int m=ir.nextInt();
		long ret=mergeSort(a,0,n)%2;
		int p,q;
		for(int i=0;i<m;i++){
			p=ir.nextInt()-1;
			q=ir.nextInt()-1;
			if((q-p)%4==1||(q-p)%4==2)
				ret^=1;
			f(ret);
		}
	}

	public static void f(long a){
		if(a==0){
			out.println("even");
		}
		else
			out.println("odd");
	}
	public static long mergeSort(int[] a, int left, int right) {
        long cnt = 0;
        if (left + 1 < right) {
            int mid = (left + right) / 2;
            cnt += mergeSort(a, left, mid);
            cnt += mergeSort(a, mid, right);
            cnt += merge(a, left, mid, right);
        }

        return cnt;
    }

    public static long merge(int[] a, int left, int mid, int right) {
        long cnt = 0;
        int n1 = mid - left;
        int n2 = right - mid;
        int[] l = new int[n1 + 1];
        int[] r = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            l[i] = a[left + i];
        }
        for (int i = 0; i < n2; i++) {
            r[i] = a[mid + i];
        }
        l[n1] = Integer.MAX_VALUE;
        r[n2] = Integer.MAX_VALUE;

        for (int i = 0, j = 0, k = left; k < right; k++) {
            if (l[i] <= r[j]) {
                a[k] = l[i];
                i++;
            } else {
                a[k] = r[j];
                j++;
                cnt += n1 - i;
            }
        }

        return cnt;
    }

	public static void main(String[] args) throws Exception {
		ir = new InputReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.flush();
	}

	static class InputReader {

		private InputStream in;
		private byte[] buffer = new byte[1024];
		private int curbuf;
		private int lenbuf;

		public InputReader(InputStream in) {
			this.in = in;
			this.curbuf = this.lenbuf = 0;
		}

		public boolean hasNextByte() {
			if (curbuf >= lenbuf) {
				curbuf = 0;
				try {
					lenbuf = in.read(buffer);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (lenbuf <= 0)
					return false;
			}
			return true;
		}

		private int readByte() {
			if (hasNextByte())
				return buffer[curbuf++];
			else
				return -1;
		}

		private boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		private void skip() {
			while (hasNextByte() && isSpaceChar(buffer[curbuf]))
				curbuf++;
		}

		public boolean hasNext() {
			skip();
			return hasNextByte();
		}

		public String next() {
			if (!hasNext())
				throw new NoSuchElementException();
			StringBuilder sb = new StringBuilder();
			int b = readByte();
			while (!isSpaceChar(b)) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		public int nextInt() {
			if (!hasNext())
				throw new NoSuchElementException();
			int c = readByte();
			while (isSpaceChar(c))
				c = readByte();
			boolean minus = false;
			if (c == '-') {
				minus = true;
				c = readByte();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = res * 10 + c - '0';
				c = readByte();
			} while (!isSpaceChar(c));
			return (minus) ? -res : res;
		}

		public long nextLong() {
			if (!hasNext())
				throw new NoSuchElementException();
			int c = readByte();
			while (isSpaceChar(c))
				c = readByte();
			boolean minus = false;
			if (c == '-') {
				minus = true;
				c = readByte();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = res * 10 + c - '0';
				c = readByte();
			} while (!isSpaceChar(c));
			return (minus) ? -res : res;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public long[] nextLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public char[][] nextCharMap(int n, int m) {
			char[][] map = new char[n][m];
			for (int i = 0; i < n; i++)
				map[i] = next().toCharArray();
			return map;
		}
	}
}