import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Main
{
    /********************************************** a list of common variables **********************************************/
    private MyScanner scan = new MyScanner();
    private PrintWriter out = new PrintWriter(System.out);
    private final double PI = Math.PI;
    private final int INF = (int)(1e9);
    private final double EPS = 1e-6;
    private final int SIZEN = (int)(1e7);
    private final int MOD = (int)(1e9 + 7);
    private final long MODH = 10000000007L, BASE = 10007;
    private final int[] DX = {0, 1, 0, -1}, DY = {-1, 0, 1, 0};
    int n;
    int[] sum;
    int[][] a;

    public void foo1() {
        int n = scan.nextInt();
        int sum = 0;
        int[] a = new int[n];
        for (int i = 0;i < n;++i) {
            a[i] = scan.nextInt();
            sum += a[i];
        }
        int avg = sum * 2 / n;
        for (int i = 0;i < n;++i) {
            if (a[i] == 0) {
                continue;
            }
            for (int j = i + 1;j < n;++j) {
                if (a[i] + a[j] == avg) {
                    a[j] = 0;
                    System.out.println((i + 1) + " " + (j + 1));
                    break;
                }
            }
        }
    }

    public void foo2() {
        int n = scan.nextInt();
        int m = scan.nextInt();
        HashSet<Integer> row = new HashSet<Integer>();
        HashSet<Integer> col = new HashSet<Integer>();
        for (int i = 0;i < m;++i) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            row.add(x);
            col.add(y);
            out.print((long) (n - row.size()) * (n - col.size()) + " ");
        }
    }

    public int getId(char c) {
        return (c >= 'a' && c <= 'z') ? c - 'a': c - 'A' + 26;
    }

    public boolean isOk(int len) {
        for (int i = 0;i + len <= n;++i) {
            boolean flag = true;
            for (int j = 0;j < 52;++j) {
                if (a[i + len][j] - a[i][j] == 0 && sum[j] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public void foo() {
        n = scan.nextInt();
        char[] s = scan.next().toCharArray();
        a = new int[n + 1][52];
        sum = new int[52];
        for (int i = 0;i < n;++i) {
            for (int j = 0;j < 52;++j) a[i + 1][j] = a[i][j];
            ++a[i + 1][getId(s[i])];
            ++sum[getId(s[i])];
        }
        int left = 1, right = n, ans = n;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (isOk(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        out.println(ans);
    }

    public static void main(String[] args)
    {
        Main m = new Main();
        m.foo();
        m.out.close();
    }

    /********************************************** a list of common algorithms **********************************************/
    /**
     * 1---Get greatest common divisor
     * @param a :	first number
     * @param b :	second number
     * @return		greatest common divisor
     */
    public long gcd(long a, long b)
    {
        return 0 == b ? a : gcd(b, a % b);
    }

    /**
     * 2---Get the distance from a point to a line
     * @param x1	the x coordinate of one endpoint of the line
     * @param y1	the y coordinate of one endpoint of the line
     * @param x2	the x coordinate of the other endpoint of the line
     * @param y2	the y coordinate of the other endpoint of the line
     * @param x		the x coordinate of the point
     * @param y		the x coordinate of the point
     * @return		the distance from a point to a line
     */
    public double getDist(long x1, long y1, long x2, long y2, long x, long y)
    {
        long a = y2 - y1;
        long b = x1 - x2;
        long c = y1 * (x2 - x1) - x1 * (y2 - y1);
        return Math.abs(a * x + b * y + c) / Math.sqrt(a * a + b * b);
    }

    /**
     * 3---Get the distance from one point to a segment (not a line)
     * @param x1	the x coordinate of one endpoint of the segment
     * @param y1	the y coordinate of one endpoint of the segment
     * @param x2	the x coordinate of the other endpoint of the segment
     * @param y2	the y coordinate of the other endpoint of the segment
     * @param x		the x coordinate of the point
     * @param y		the y coordinate of the point
     * @return		the distance from one point to a segment (not a line)
     */
    public double ptToSeg(long x1, long y1, long x2, long y2, long x, long y)
    {
        double cross = (x2 - x1) * (x - x1) + (y2 - y1) * (y - y1);
        if(cross <= 0)
        {
            return (x - x1) * (x - x1) + (y - y1) * (y - y1);
        }
        double d = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
        if(cross >= d)
        {
            return (x - x2) * (x - x2) + (y - y2) * (y - y2);
        }
        double r = cross / d;
        double px = x1 + (x2 - x1) * r;
        double py = y1 + (y2 - y1) * r;
        return (x - px) * (x - px) + (y - py) * (y - py);
    }

    /**
     * 4---KMP match, i.e. kmpMatch("abcd", "bcd") = 1, kmpMatch("abcd", "bfcd") = -1.
     * @param t:	String to match.
     * @param p:	String to be matched.
     * @return		if can match, first index; otherwise -1.
     */
    public int kmpMatch(char[] t, char[] p)
    {
        int n = t.length;
        int m = p.length;
        int[] next = new int[m + 1];
        next[0] = -1;
        int j = -1;
        for(int i = 1;i < m;++i)
        {
            while(j >= 0 && p[i] != p[j + 1])
            {
                j = next[j];
            }
            if(p[i] == p[j + 1])
            {
                ++j;
            }
            next[i] = j;
        }
        j = -1;
        for(int i = 0;i < n;++i)
        {
            while(j >= 0 && t[i] != p[j + 1])
            {
                j = next[j];
            }
            if(t[i] == p[j + 1])
            {
                ++j;
            }
            if(j == m - 1)
            {
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     * 5---Get the hash code of a String
     * @param	s:	input string
     * @return	hash code
     */
    public long hash(String s)
    {
        long key = 0, t = 1;
        for(int i = 0;i < s.length();++i)
        {
            key = (key + s.charAt(i) * t) % MODH;
            t = t * BASE % MODH;
        }
        return key;
    }

    /**
     * 6---Get x ^ n % MOD quickly.
     * @param	x:	base
     * @param 	n:	times
     * @return	x ^ n % MOD
     */
    public long quickMod(long x, long n)
    {
        long ans = 1;
        while(n > 0)
        {
            if(1 == n % 2)
            {
                ans = ans * x % MOD;
            }
            x = x * x % MOD;
            n >>= 1;
        }
        return ans;
    }

    /**
     * 7---judge if a point is located inside a polygon
     * @param x0	the x coordinate of the point
     * @param y0	the y coordinate of the point
     * @return true if it is inside the polygon, otherwise false
     */
	/*public boolean contains(double x0, double y0)
	{
		int cross = 0;
		for(int i = 0;i < n;++i)
		{
			double s = x[i + 1] == x[i] ? 100000000 : (double)(y[i + 1] - y[i]) / (x[i + 1] - x[i]);
			boolean b1 = x[i] <= x0 && x0 < x[i + 1];
			boolean b2 = x[i + 1] <= x0 && x0 < x[i];
			boolean b3 = y0 < s * (x0 - x[i]) + y[i];
			if((b1 || b2) && b3) ++cross;
		}
		return cross % 2 != 0;
	}*/

    /**
     * 8---judge if a point is located on the segment
     * @param	x1	the x coordinate of one point of the segment
     * @param	y1	the y coordinate of one point of the segment
     * @param 	x2	the x coordinate of another point of the segment
     * @param 	y2	the y coordinate of another point of the segment
     * @param	x	the x coordinate of the point
     * @param 	y	the y coordinate of the point
     * @return	true if it is located on the segment, otherwise false
     */
    public boolean isOnSeg(long x1, long y1, long x2, long y2, long x, long y)
    {
        return (x - x1) * (y2 - y1) == (x2 - x1) * (y - y1) &&
                x >= Math.min(x1, x2) && x <= Math.max(x1, x2) &&
                y >= Math.min(y1, y2) && y <= Math.max(y1, y2);
    }

    /**
     * 9---get the cross product
     * @param 	p1	point A
     * @param 	p2	point B
     * @param 	p	point O
     * @return	cross product of OA x OB
     */
	/*public long cross(Point p1, Point p2, Point p)
	{
		return (long)(p1.x - p.x) * (p2.y - p.y) - (long)(p2.x - p.x) * (p1.y - p.y);
	}*/

    /**
     * 10---implement topsort and tell if it is possible
     * @return true if it is possible to implement topsort, otherwise false
     */
	/*public boolean topsort()
	{
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder ans = new StringBuilder();
		int[] in = new int[26];
		for(int i = 0;i < 26;++i)
		{
			if(0 == in[i]) 
			{
				ans.append((char)('a' + i));
				q.add(i);
			}
		}
		while(!q.isEmpty())
		{
			int u = q.poll();
			for(int i = 0;i < 26;++i)
			{
				if(map[u][i])
				{
					--in[i];
					if(0 == in[i])
					{
						ans.append((char)('a' + i));
						q.add(i);
					}
				}
			}
		}
		return 26 == ans.length();
	}*/

    class MyScanner
    {
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        BufferedInputStream bis = new BufferedInputStream(System.in);

        public int read()
        {
            if (-1 == numChars)
            {
                throw new InputMismatchException();
            }
            if (curChar >= numChars)
            {
                curChar = 0;
                try
                {
                    numChars = bis.read(buf);
                }
                catch (IOException e)
                {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt()
        {
            int c = read();
            while (isSpaceChar(c))
            {
                c = read();
            }
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do
            {
                if (c < '0' || c > '9')
                {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong()
        {
            int c = read();
            while (isSpaceChar(c))
            {
                c = read();
            }
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do
            {
                if (c < '0' || c > '9')
                {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble()
        {
            int c = read();
            while (isSpaceChar(c))
            {
                c = read();
            }
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.')
            {
                if (c == 'e' || c == 'E')
                {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9')
                {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c & 15;
                c = read();
            }
            if (c == '.')
            {
                c = read();
                double m = 1;
                while (!isSpaceChar(c))
                {
                    if (c == 'e' || c == 'E')
                    {
                        return res * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9')
                    {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c & 15) * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String next()
        {
            int c = read();
            while (isSpaceChar(c))
            {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c)
        {
            return ' ' == c || '\n' == c || '\r' == c || '\t' == c || -1 == c;
        }
    }
}