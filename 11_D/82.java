import java.io.*;
import java.text.*;
import java.math.*;
import java.util.*;

public class Main {

    private StreamTokenizer in;
    private BufferedWriter out;

    public void solve() throws Exception {
        int n = nextInt(), m = nextInt();
        int[] ss = new int[n];
        for (int i=0; i<m; i++)
        {
            int a = nextInt(), b = nextInt();
            a--;b--;
            ss[a]|=1<<b;
            ss[b]|=1<<a;
        }
        long[][] res = new long[n][1<<n];
        int[] cnt = new int[1<<n], first = new int[1<<n];
        for (int i=0; i<n; i++)
        {
            res[i][1<<i] = 1;
            first[1<<i] = i;
            cnt[1<<i] = 1;
        }
        long ans = 0;
        for (int mask = 0; mask<1<<n; mask++)
        {
            for (int last = first[mask]; last<n; last++)
            {
                if (res[last][mask]==0)
                    continue;
                if (cnt[mask]>2)
                {
                    if ((ss[last]&(1<<first[mask]))!=0)
                        ans+=res[last][mask];
                }
                int m2 = (~mask) & ss[last];
                for (int next = first[mask]+1; next<n; next++)
                {
                    if ((m2&(1<<next))==0) continue;
                    int mask2 = mask|1<<next;
                    res[next][mask2]+=res[last][mask];
                    cnt[mask2] = cnt[mask]+1;
                    first[mask2] = first[mask];
                }
            }
        }
        ans/=2;
        out.write(ans+"\n");
    }
    
    public int nextInt() throws Exception
    {
        in.nextToken();
        return (int)in.nval;
    }

    public void run() {
        try {
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            out = new BufferedWriter(new OutputStreamWriter(System.out));
            solve();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}