/**
 * JUDGE_ID : 104262PN
 * User     : Денис
 * Date     : 09.05.11
 * Time     : 22:48
 * ICQ      : 785625
 * Email    : popokus@gmail.com
 */

import java.io.*;

public class s11_d {
    public static void main(String[] args) throws IOException {
        new s11_d().run();
    }

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    String nextString() throws IOException {
        in.nextToken();
        return (String) in.sval;
    }

    StreamTokenizer in;
    Writer writer;
    Reader reader;

    void run() throws IOException {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        reader = oj ? new InputStreamReader(System.in, "ISO-8859-1") : new FileReader("input/is11_d.txt");
        writer = new OutputStreamWriter(System.out, "ISO-8859-1");
        in = new StreamTokenizer(new BufferedReader(reader));
        PrintWriter out = new PrintWriter(writer);
        int n = nextInt();
        int e = nextInt();
        boolean[][] is = new boolean[n + 1][n + 1];
        for (int i = 0; i < e;i++) {
            int a = nextInt() - 1;
            int b = nextInt() - 1;
            is[a][b] = true;
            is[b][a] = true;
        }
        // calculating dp
        long[] am = new long[n + 1];
                long[][] ways = new long[1 << (n - 1)][n];
                for (int start = 0; start < n; ++start) {
                    for (int mask = 0; mask < (1 << (n - start - 1)); ++mask)
                        for (int last = start; last < n; ++last) {
                            ways[mask][last - start] = 0;
                        }
                    ways[1 >> 1][0] = 1;
                    for (int mask = 1; mask < (1 << (n - start)); mask += 2) {
                        int cnt = 0;
                        int tmp = mask;
                        while (tmp > 0) {
                            ++cnt;
                            tmp = tmp & (tmp - 1);
                        }
                        for (int last = start; last < n; ++last)
                            if (ways[mask >> 1][last - start] > 0) {
                                long amm = ways[mask >> 1][last - start];
                                for (int i = start; i < n; ++i)
                                    if ((mask & (1 << (i - start))) == 0 && is[last][i]) {
                                        ways[(mask | (1 << (i - start))) >> 1][i - start] += amm;
                                    }
                                if (is[last][start])
                                    am[cnt] += ways[mask >> 1][last - start];
                            }
                    }
                }
                long res = 0;
                for (int cnt = 3; cnt <= n; ++cnt) {
                    if (am[cnt] % (2) != 0)
                        throw new RuntimeException();
                    res += am[cnt] / (2);
                }
        out.println(res);
        out.flush();
        out.close();
    }
}
