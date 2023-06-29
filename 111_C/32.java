import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author AlexFetisov
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        if (n > m) {
            int t = m;
            m = n;
            n = t;
        }
//        if (n == 1) {
//            out.println(m - ((m + 2) / 3));
//        } else if (n == 2) {
//            int cur = 2;
//            for (int i = 2; i <= m; ++i) {
//                if (i % 2 == 0 && i > 2) {
//                    ++cur;
//                }
//            }
//            out.println(n * m - cur);
//        } else {
            f = new int[n][m];
            res = Integer.MAX_VALUE;
            cur = 0;
            step = 1;
            numFree = n * m;
            rec(0, 0);
            out.println(n * m - res);
//        }
    }

    private void rec(int x, int y) {
        if (numFree == 0) {
            res = Math.min(res, cur);
            return;
        }
        if (x >= n) return;
        if (y >= m) {
            rec(x + 1, 0);
            return;
        }
        if (f[x][y] != 0) {
            rec(x, y + 1);
            return;
        }

        put(x, y);
        rec(x, y + 1);
        remove(x, y);

        if (isValid(x + 1, y)) {
            put(x + 1, y);
            rec(x, y + 1);
            remove(x + 1, y);
        }

        if (isValid(x, y + 1)) {
            put(x, y + 1);
            rec(x, y + 1);
            remove(x, y + 1);
        }
    }

    private void put(int x, int y) {
        for (int i = 0; i < 5; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny)) {
                if (f[nx][ny] == 0) {
                    --numFree;
                    f[nx][ny] = step;
                }
            }
        }
        ++step;
        ++cur;
    }

    private void remove(int x, int y) {
        --step;
        for (int i = 0; i < 5; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny)) {
                if (f[nx][ny] == step) {
                    ++numFree;
                    f[nx][ny] = 0;
                }
            }
        }
        --cur;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    int n, m;
    int[] dx = new int[] {-1, 0, 1, 0, 0};
    int[] dy = new int[] {0, 1, 0, -1, 0};

    int step;
    int numFree;
    int cur;
    int res;
    int[][] f;
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer stt;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String nextLine() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            return null;
        }
    }

    public String nextString() {
        while (stt == null || !stt.hasMoreTokens()) {
            stt = new StringTokenizer(nextLine());
        }
        return stt.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextString());
    }

}

