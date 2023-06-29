import java.io.*;
import java.util.*;

public class A
{
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tok;

    public void go() throws IOException
    {
        ntok();
        int n = ipar();
        ArrayList<Integer> list = new ArrayList<>();
        ntok();
        for (int i = 0; i < n; i++)
        {
            list.add(ipar());
        }
        Collections.sort(list);
        HashSet<Integer> set = new HashSet<>();
        for (int x : list)
        {
            boolean add = true;
            for (int y : set)
            {
                if (x % y == 0)
                {
                    add = false;
                    break;
                }
            }
            if (add)
            {
                set.add(x);
            }
        }
        out.println(set.size());

        out.flush();
        in.close();
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
        new A().go();
    }
}
