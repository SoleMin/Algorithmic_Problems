import java.io.*;
import java.util.*;

public class CODEFORCES
{
	@SuppressWarnings("rawtypes")
	static InputReader in;
	static PrintWriter out;

	static void solve()
	{
		int n = in.ni();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = in.ni();
		int cnt = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < i; j++)
				if (arr[j] > arr[i])
					cnt++;
		}
		cnt %= 2;
		int m = in.ni();
		while (m-- > 0)
		{
			int l = in.ni(), r = in.ni();
			int fin = r - l + 1;
			fin *= (fin - 1);
			fin >>= 1;
			if ((fin & 1) == 1)
				cnt++;
			cnt %= 2;
			if ((cnt & 1) == 1)
				out.println("odd");
			else
				out.println("even");
		}
	}

	@SuppressWarnings("rawtypes")
	static void soln()
	{
		in = new InputReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.flush();
	}

	static void debug(Object... o)
	{
		System.out.println(Arrays.deepToString(o));
	}

	public static void main(String[] args)
	{
		new Thread(null, new Runnable()
		{
			public void run()
			{
				try
				{
					soln();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}, "1", 1 << 26).start();
	}

	// To Get Input
	// Some Buffer Methods
	static class InputReader<SpaceCharFilter>
	{

		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream)
		{
			this.stream = stream;
		}

		public int snext()
		{
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars)
			{
				curChar = 0;
				try
				{
					snumChars = stream.read(buf);
				} catch (IOException e)
				{
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int ni()
		{
			int c = snext();
			while (isSpaceChar(c))
			{
				c = snext();
			}
			int sgn = 1;
			if (c == '-')
			{
				sgn = -1;
				c = snext();
			}
			int res = 0;
			do
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nl()
		{
			int c = snext();
			while (isSpaceChar(c))
			{
				c = snext();
			}
			int sgn = 1;
			if (c == '-')
			{
				sgn = -1;
				c = snext();
			}
			long res = 0;
			do
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n)
		{
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
			{
				a[i] = ni();
			}
			return a;
		}

		public long[] nextLongArray(int n)
		{
			long a[] = new long[n];
			for (int i = 0; i < n; i++)
			{
				a[i] = nl();
			}
			return a;
		}

		public String readString()
		{
			int c = snext();
			while (isSpaceChar(c))
			{
				c = snext();
			}
			StringBuilder res = new StringBuilder();
			do
			{
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine()
		{
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do
			{
				res.appendCodePoint(c);
				c = snext();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c)
		{
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c)
		{
			return c == '\n' || c == '\r' || c == -1;
		}

		public interface SpaceCharFilter
		{
			public boolean isSpaceChar(int ch);
		}

	}
}