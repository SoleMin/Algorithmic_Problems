import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import java.awt.*;

public class PracticeProblem
{
    /*
     * This FastReader code is taken from GeeksForGeeks.com
     * https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
     *
     * The article was written by Rishabh Mahrsee
     */
    public static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException
        {
            br = new BufferedReader(new FileReader(new File("input.txt")));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static FastReader in;
    public static PrintWriter out;
    public static final int INF = Integer.MAX_VALUE;
    public static int n, m;

    public static final int[] dr = {-1, 0, 0, +1};
    public static final int[] dc = {0, -1, +1, 0};

    public static void main(String[] args) throws FileNotFoundException
    {
        in = new FastReader();
        out = new PrintWriter(new File("output.txt"));
        solve();
        out.close();
    }

    private static void solve()
    {
        n = in.nextInt();
        m = in.nextInt();
        int k = in.nextInt();

        int[][] timeToBurn = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(timeToBurn[i], INF);

        for (int i = 0; i < k; i++)
        {
            int r = in.nextInt() - 1;
            int c = in.nextInt() - 1;
            for (int j = 0; j < n; j++)
            {
                for (int l = 0; l < m; l++)
                {
                    timeToBurn[j][l] = min(timeToBurn[j][l], abs(r - j) + abs(c - l));
                }
            }
        }
        int max = -1;
        Point p = null;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (timeToBurn[i][j] > max)
                {
                    max = timeToBurn[i][j];
                    p = new Point(i, j);
                }
            }
        }

        out.println((p.x + 1) + " " + (p.y + 1));
    }

}