import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;

public class E46A
{
	public static void main(String[] args)
	{
		FastScanner in = new FastScanner(System.in);
		String[] sizes = {"XXXS", "XXS", "XS", "S", "M", "L", "XL", "XXL", "XXXL"};
		int n = in.nextInt();
		HashMap<String, Integer> a = new HashMap<>();
		HashMap<String, Integer> b = new HashMap<>();
		for (String s : sizes) {
			a.put(s, 0);
			b.put(s, 0);
		}
		for (int i = 0; i < n; i++) {
			String s = in.next();
			a.put(s, a.get(s) + 1);
		}
		for (int i = 0; i < n; i++) {
			String s = in.next();
			b.put(s, b.get(s) + 1);
		}
		for (String s : sizes) {
			int cut = Math.min(a.get(s), b.get(s));
			a.put(s, a.get(s) - cut);
			b.put(s, b.get(s) - cut);
		}
		int changes = 0;
		for (String s : sizes)
			changes += a.get(s);
		System.out.println(changes);
	}
	
	/**
	 * Source: Matt Fontaine
	 */
	public static class FastScanner
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastScanner(InputStream stream)
		{
			this.stream = stream;
		}

		int read()
		{
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars)
			{
				curChar = 0;
				try
				{
					numChars = stream.read(buf);
				} catch (IOException e)
				{
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c)
		{
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c)
		{
			return c == '\n' || c == '\r' || c == -1;
		}

		public int nextInt()
		{
			return Integer.parseInt(next());
		}

		public long nextLong()
		{
			return Long.parseLong(next());
		}

		public double nextDouble()
		{
			return Double.parseDouble(next());
		}

		public String next()
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do
			{
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine()
		{
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do
			{
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}
}