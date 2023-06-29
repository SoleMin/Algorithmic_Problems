import java.awt.geom.Line2D;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class C488C
{
	public static void main(String[] args)
	{
		FastScanner in = new FastScanner(System.in);
		int[] x1 = new int[4];
		int[] y1 = new int[4];
		int[] x2 = new int[4];
		int[] y2 = new int[4];
		for (int i = 0; i < 4; i++) {
			x1[i] = in.nextInt();
			y1[i] = in.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			x2[i] = in.nextInt();
			y2[i] = in.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (Line2D.linesIntersect(x1[i], y1[i], x1[(i + 1) % 4], y1[(i + 1) % 4], x2[j], y2[j], x2[(j + 1) % 4], y2[(j + 1) % 4])) {
					System.out.println("YES");
					return;
				}
			}
		}
		int rectMinX = Math.min(Math.min(x1[0], x1[1]), x1[2]);
		int rectMaxX = Math.max(Math.max(x1[0], x1[1]), x1[2]);
		int rectMinY = Math.min(Math.min(y1[0], y1[1]), y1[2]);
		int rectMaxY = Math.max(Math.max(y1[0], y1[1]), y1[2]);
		if (x2[0] >= rectMinX && x2[0] <= rectMaxX && y2[0] >= rectMinY && y2[0] <= rectMaxY) {
			System.out.println("YES");
			return;
		}
		int dMinX = Math.min(Math.min(Math.min(x2[0], x2[1]), x2[2]), x2[3]);
		int dMaxX = Math.max(Math.max(Math.max(x2[0], x2[1]), x2[2]), x2[3]);
		int dMinY = Math.min(Math.min(Math.min(y2[0], y2[1]), y2[2]), y2[3]);
		int dMaxY = Math.max(Math.max(Math.max(y2[0], y2[1]), y2[2]), y2[3]);
		double midX = (dMinX + dMaxX) / 2.0;
		double midY = (dMinY + dMaxY) / 2.0;
		int x = x1[0];
		int y = y1[0];
		if (!above(x, y, dMinX, midY, midX, dMinY))
			System.out.println("NO");
		else if (!above(x, y, midX, dMinY, dMaxX, midY))
			System.out.println("NO");
		else if (above(x, y, dMinX, midY, midX, dMaxY))
			System.out.println("NO");
		else if (above(x, y, midX, dMaxY, dMaxX, midY))
			System.out.println("NO");
		else
			System.out.println("YES");
	}
	
	public static boolean above(int x, int y, double x1, double y1, double x2, double y2)
	{
		double a = (y2 - y1) / (x2 - x1);
		double b = y1 - a * x1;
		double yHat = a * x + b;
		return y > yHat;
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