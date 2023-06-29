import java.io.*;
import java.util.*;

public class A {

    void run() throws IOException {
        int n = ni();
        int m = ni();
        int k = ni();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = ni() - 1;
        Arrays.sort(a);
        int ans = 0;
        if (m > k) {
            m -= k - 1;
            for (int i = n - 1; i >= 0; i--) {
                ans++;
                m -= a[i];          
                if (m < 2)
                    break;

            }
            if (m > 1)
                ans = -1;
        }
        pw.print(ans);
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    int ni() throws IOException {
        return Integer.parseInt(next());
    }

    String nl() throws IOException {
        return br.readLine();
    }

    PrintWriter pw;
    BufferedReader br;
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        long timeout = System.currentTimeMillis();
        boolean CF = System.getProperty("ONLINE_JUDGE") != null;
        PrintWriter _pw = new PrintWriter(System.out);
        BufferedReader _br = new BufferedReader(CF ? new InputStreamReader(System.in) : new FileReader(new File("in.txt")));
        new A(_br, _pw).run();
        if (!CF) {
            _pw.println();
            _pw.println(System.currentTimeMillis() - timeout);
        }
        _br.close();
        _pw.close();
    }

    public A(BufferedReader _br, PrintWriter _pw) {
        br = _br;
        pw = _pw;
    }
}
