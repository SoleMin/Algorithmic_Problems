
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;
import static java.lang.Math.*;
public class Main implements Runnable
{
    boolean multiiple = false;

    void solve() throws Exception
    {
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(sc.nextInt());
        Collections.sort(list);
        int ans = 0;
        while (!list.isEmpty())
        {
            ans++;
            int next = list.get(0);
            for (int i = list.size() - 1; i >= 1; i--)
            {
                if (list.get(i) % next == 0)
                    list.remove(i);
            }
            list.remove(0);
        }

        System.out.println(ans);
    }

    @Override
    public void run()
    {
        try
        {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            sc = new FastScanner(in);
            if (multiiple)
            {
                int q = sc.nextInt();
                for (int i = 0; i < q; i++)
                    solve();
            }
            else
                solve();
        }
        catch (Throwable uncaught)
        {
            Main.uncaught = uncaught;
        }
        finally
        {
            out.close();
        }
    }

    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Main(), "", (1 << 26));
        thread.start();
        thread.join();
        if (Main.uncaught != null) {
            throw Main.uncaught;
        }
    }

    static Throwable uncaught;
    BufferedReader in;
    FastScanner sc;
    PrintWriter out;
}

class FastScanner
{
    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in)
    {
        this.in = in;
    }

    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }

}