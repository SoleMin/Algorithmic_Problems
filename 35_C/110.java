import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author zodiacLeo
 */
public class Main
{
    public static void main(String[] args)
    {
        InputStream inputStream;
        try
        {
            inputStream = new FileInputStream("input.txt");
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        OutputStream outputStream;
        try
        {
            outputStream = new FileOutputStream("output.txt");
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        FastScanner in = new FastScanner(inputStream);
        FastPrinter out = new FastPrinter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC
    {
        public void solve(int testNumber, FastScanner in, FastPrinter out)
        {
            int n = in.nextInt();
            int m = in.nextInt();
            int p = in.nextInt();
            int[] x = new int[p];
            int[] y = new int[p];
            for (int i = 0; i < p; i++)
            {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }

            int X = x[0];
            int Y = y[0];
            int D = -1;
            for (int dx = 1; dx <= n; dx++)
            {
                int x1 = dx;
                int y1 = 1;
                int xx = 0;
                int yy = 0;
                int minD = Integer.MAX_VALUE;
                for (int j = 0; j < p; j++)
                {
                    int d = Math.abs(x1 - x[j]) + Math.abs(y1 - y[j]);
                    if (d < minD)
                    {
                        minD = d;
                        xx = x1;
                        yy = y1;
                    }
                }
                if (D < minD && minD != 0 && minD != Integer.MAX_VALUE)
                {
                    D = minD;
                    X = xx;
                    Y = yy;
                }
            }
            for (int dx = 1; dx <= n; dx++)
            {
                int x1 = dx;
                int y1 = m;
                int xx = 0;
                int yy = 0;
                int minD = Integer.MAX_VALUE;
                for (int j = 0; j < p; j++)
                {
                    int d = Math.abs(x1 - x[j]) + Math.abs(y1 - y[j]);
                    if (d < minD)
                    {
                        minD = d;
                        xx = x1;
                        yy = y1;
                    }
                }
                if (D < minD && minD != 0 && minD != Integer.MAX_VALUE)
                {
                    D = minD;
                    X = xx;
                    Y = yy;
                }
            }
            for (int dy = 1; dy <= m; dy++)
            {
                int x1 = 1;
                int y1 = dy;
                int xx = 0;
                int yy = 0;
                int minD = Integer.MAX_VALUE;
                for (int j = 0; j < p; j++)
                {
                    int d = Math.abs(x1 - x[j]) + Math.abs(y1 - y[j]);
                    if (d < minD)
                    {
                        minD = d;
                        xx = x1;
                        yy = y1;
                    }
                }
                if (D < minD && minD != 0 && minD != Integer.MAX_VALUE)
                {
                    D = minD;
                    X = xx;
                    Y = yy;
                }
            }
            for (int dy = 1; dy <= m; dy++)
            {
                int x1 = n;
                int y1 = dy;
                int xx = 0;
                int yy = 0;
                int minD = Integer.MAX_VALUE;
                for (int j = 0; j < p; j++)
                {
                    int d = Math.abs(x1 - x[j]) + Math.abs(y1 - y[j]);
                    if (d < minD)
                    {
                        minD = d;
                        xx = x1;
                        yy = y1;
                    }
                }
                if (D < minD && minD != 0 && minD != Integer.MAX_VALUE)
                {
                    D = minD;
                    X = xx;
                    Y = yy;
                }
            }

            for (int i = 1; i <= Math.min(m, n); i++)
            {
                int x1 = i;
                int y1 = i;
                int xx = 0;
                int yy = 0;
                int minD = Integer.MAX_VALUE;
                for (int j = 0; j < p; j++)
                {
                    int d = Math.abs(x1 - x[j]) + Math.abs(y1 - y[j]);
                    if (d < minD)
                    {
                        minD = d;
                        xx = x1;
                        yy = y1;
                    }
                }
                if (D < minD && minD != 0 && minD != Integer.MAX_VALUE)
                {
                    D = minD;
                    X = xx;
                    Y = yy;
                }
            }
            for (int i = 1, ii = m; i <= n && ii >= 1; i++, ii--)
            {
                int x1 = i;
                int y1 = ii;
                int xx = 0;
                int yy = 0;
                int minD = Integer.MAX_VALUE;
                for (int j = 0; j < p; j++)
                {
                    int d = Math.abs(x1 - x[j]) + Math.abs(y1 - y[j]);
                    if (d < minD)
                    {
                        minD = d;
                        xx = x1;
                        yy = y1;
                    }
                }
                if (D < minD && minD != 0 && minD != Integer.MAX_VALUE)
                {
                    D = minD;
                    X = xx;
                    Y = yy;
                }
            }
            out.println(X + " " + Y);
        }

    }

    static class FastScanner
    {
        public BufferedReader br;
        public StringTokenizer st;

        public FastScanner(InputStream is)
        {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public FastScanner(File f)
        {
            try
            {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }

        public String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                String s = null;
                try
                {
                    s = br.readLine();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        public int nextInt()
        {
            return Integer.parseInt(next());
        }

    }

    static class FastPrinter extends PrintWriter
    {
        public FastPrinter(OutputStream out)
        {
            super(out);
        }

        public FastPrinter(Writer out)
        {
            super(out);
        }

    }
}

