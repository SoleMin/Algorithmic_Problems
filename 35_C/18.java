import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution {

    BufferedReader in;
    StringTokenizer st;
    PrintWriter out;

    int n, m, k;
    int[] x, y;

    char[] qx = new char[4000000], qy = new char[4000000];
    int b, e;

    char[][] d;

    int[] dx = { -1, 0, 1, 0 }, dy = { 0, -1, 0, 1 };

    void bfs() {
        b = e = 0;
        for (int i = 0; i < d.length; i++) {
            Arrays.fill(d[i], (char)(1 << 14));
        }
        for (int i = 0; i < k; ++i) {
            qx[e] = (char) x[i];
            qy[e++] = (char) y[i];
            d[x[i]][y[i]] = 0;
        }
        for (; b < e; ++b) {
            int x = qx[b];
            int y = qy[b];
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m)
                    if (d[nx][ny] > d[x][y] + 1) {
                        d[nx][ny] = (char) (d[x][y] + 1);
                        qx[e] = (char) nx;
                        qy[e++] = (char) ny;
                    }
            }
        }
    }

    void solve() throws IOException {
        n = ni();
        m = ni();
        k = ni();
        x = new int[k];
        y = new int[k];
        for (int i = 0; i < k; ++i) {
            x[i] = ni() - 1;
            y[i] = ni() - 1;
        }
        d = new char[n][m];
        bfs();
        int x = -1, y = -1, last = -1;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (d[i][j] > last) {
                    last = d[i][j];
                    x = i;
                    y = j;
                }
        ++x;
        ++y;
        out.println(x + " " + y);
    }

    public Solution() throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new FileReader("input.txt"));
        out = new PrintWriter("output.txt");
        solve();
        in.close();
        out.close();
    }

    String nline() throws IOException {
        return in.readLine();
    }

    String ns() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(nline());
        }
        return st.nextToken();
    }

    int ni() throws IOException {
        return Integer.valueOf(ns());
    }

    long nl() throws IOException {
        return Long.valueOf(ns());
    }

    double nd() throws IOException {
        return Double.valueOf(ns());
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }
}
