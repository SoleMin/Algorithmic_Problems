import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.Arrays;
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
        private final static int[] dx = {-1, 0, +1, 0};
        private final static int[] dy = {0, +1, 0, -1};
        private final static int WHITE = 123456789;

        public void solve(int testNumber, FastScanner in, FastPrinter out)
        {
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++)
            {
                Arrays.fill(map[i], WHITE);
            }

            int k = in.nextInt();

            int qh = 0;
            int qt = 0;
            int[] q = new int[((int) 7e6)];
            for (int i = 0; i < k; i++)
            {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                map[x][y] = 0;
                q[qh++] = x * m + y;
            }

            int d = 0;
            int X = q[0] / m;
            int Y = q[0] % m;
            while (qt < qh)
            {
                int pos = q[qt++];
                int x = pos / m;
                int y = pos % m;
                for (int i = 0; i < 4; i++)
                {
                    int xx = x + dx[i];
                    int yy = y + dy[i];
                    if (isValid(xx, n) && isValid(yy, m) && map[xx][yy] == WHITE)
                    {
                        map[xx][yy] = map[x][y] + 1;
                        q[qh++] = (xx * m) + yy;
                        if (d < map[xx][yy])
                        {
                            d = map[xx][yy];
                            X = xx;
                            Y = yy;
                        }
                    }
                }
            }
//        for (int i = 0; i < n; i++)
//        {
//            for (int j = 0; j < m; j++)
//            {
//                out.print(map[i][j] + " ");
//            }
//            out.println();
//        }
            out.println((X + 1) + " " + (Y + 1));
        }

        private boolean isValid(int x, int X)
        {
            return x >= 0 && x < X;
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

