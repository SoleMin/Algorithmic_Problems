import java.util.InputMismatchException;
import java.io.*;
import java.util.HashMap;

/**
 * Generated by Contest helper plug-in
 * Actual solution is at the bottom
 */
public class Main {
    public static void main(String[] args) {
        InputReader in = new StreamInputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        run(in, out);
    }

    public static void run(InputReader in, PrintWriter out) {
        Solver solver = new SimpleCycles();
        solver.solve(1, in, out);
        Exit.exit(in, out);
    }
}

class StreamInputReader extends InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar, numChars;

    public StreamInputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    @Override
    public void close() {
        try {
            stream.close();
        } catch (IOException ignored) {
        }
    }
}

abstract class InputReader {
    private boolean finished = false;

    public abstract int read();

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }


    public String nextToken() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public abstract void close();
}

interface Solver {
    public void solve(int testNumber, InputReader in, PrintWriter out);
}

class Exit {
    private Exit() {
    }

    public static void exit(InputReader in, PrintWriter out) {
        in.setFinished(true);
        in.close();
        out.close();
    }
}

class SimpleCycles implements Solver {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < m; ++i) {
            int u = in.nextInt();
            int v = in.nextInt();
            --u;
            --v;
            g[u][v] = g[v][u] = true;
        }
        HashMap<Integer, Integer> pointer = new HashMap<Integer, Integer> () ;
        for (int i =0 ; i < n; ++i) {
            pointer.put(1 << i, i);
        }
        long[][] dm = new long[1 << n][n];
        for (int i = 0; i < n; ++i) {
            dm[1 << i][i] = 1;
        }
        for (int i = 0; i < (1 << n); ++i) {
            for (int j = 0; j < n; ++j) {
                if (dm[i][j] == 0) continue;
                int k = pointer.get(i - (i & (i - 1)));
                for (int u = k + 1; u < n; ++u) {
                    if (g[j][u] && (i & (1 << u)) == 0) {
                        dm[i | (1 << u)][u] += dm[i][j];
                    }
                }
            }
        }
        long res = 0;
        for (int i = 0; i < (1 << n); ++i) {
            for (int j = 0; j < n; ++j)
                if (Integer.bitCount(i) >= 3) {

                    int c = pointer.get(i - (i & (i - 1)));
                    if (g[c][j]) res += (long) dm[i][j];
                }
        }
        out.print(res / 2);
    }
}