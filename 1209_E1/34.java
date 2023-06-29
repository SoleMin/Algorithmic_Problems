import java.io.*;
import java.util.*;

public class E
{
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tok;

    public void go() throws IOException
    {
        StringTokenizer tok = new StringTokenizer(in.readLine());
        int zzz = Integer.parseInt(tok.nextToken());
        for (int zz = 0; zz < zzz; zz++)
        {
            ntok();
            int n = ipar();
            int m = ipar();
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++)
            {
                ntok();
                mat[i] = iapar(m);
            }
            long[][] dp = new long[1 << n][m+1];
            for (int i = 0; i < 1 << n; i++)
            {
                dp[i][m] = -1000000000;
            }
            dp[(1 << n) - 1][m] = 0;
            for (int i = m-1; i >= 0; i--)
            {
                for (int e = 0; e < 1 << n; e++)
                {
                    dp[e][i] = dp[e][i+1];
                    for (int w = 0; w < 1 << n; w++)
                    {
                        if ((e & w) == 0)
                        {
                            dp[e][i] = Math.max(dp[e][i], best(w, mat, i) + dp[e|w][i+1]);
                        }
                    }
                }
            }
            // for (long[] arr : dp)
            // {
            //     out.println(Arrays.toString(arr));
            // }
            out.println(dp[0][0]);
        }

        out.flush();
        in.close();
    }

    public long best(int mask, int[][] mat, int col)
    {
        long max = 0;
        for (int t = 0; t < mat.length; t++)
        {
            long sum = 0;
            int mk = mask;
            for (int i = 0; i < mat.length; i++)
            {
                if (mk % 2 == 1)
                {
                    sum += mat[i][col];
                }
                mk /= 2;
            }
            max = Math.max(max, sum);
            cycle(mat, col);
        }
        return max;
    }

    public void cycle(int[][] mat, int col)
    {
        int temp = mat[0][col];
        for (int i = 0; i < mat.length-1; i++)
        {
            mat[i][col] = mat[i+1][col];
        }
        mat[mat.length-1][col] = temp;
    }

    public void ntok() throws IOException
    {
        tok = new StringTokenizer(in.readLine());
    }

    public int ipar()
    {
        return Integer.parseInt(tok.nextToken());
    }

    public int[] iapar(int n)
    {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = ipar();
        }
        return arr;
    }

    public long lpar()
    {
        return Long.parseLong(tok.nextToken());
    }

    public long[] lapar(int n)
    {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = lpar();
        }
        return arr;
    }

    public double dpar()
    {
        return Double.parseDouble(tok.nextToken());
    }

    public String spar()
    {
        return tok.nextToken();
    }

    public static void main(String[] args) throws IOException
    {
        new E().go();
    }
}
