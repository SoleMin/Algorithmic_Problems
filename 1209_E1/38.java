import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author null
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Input in = new Input(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, Input in, PrintWriter out) {
            try {
                int kt = in.readInt();
                for (int nt = 0; nt < kt; nt++) {
                    int n = in.readInt();
                    int m = in.readInt();
                    int[][] a = new int[m][n];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            a[j][i] = in.readInt();
                        }
                    }

                    Arrays.sort(a, (x, y) -> {
                        int xMax = 0;
                        for (int i = 0; i < x.length; i++) {
                            xMax = Math.max(xMax, x[i]);
                        }
                        int yMax = 0;
                        for (int i = 0; i < y.length; i++) {
                            yMax = Math.max(yMax, y[i]);
                        }
                        return Integer.compare(-xMax, -yMax);
                    });

                    int ans = 0;
                    int[] s = new int[4];
                    for (s[0] = 0; s[0] < n; s[0]++) {
                        for (s[1] = 0; s[1] < n; s[1]++) {
                            for (s[2] = 0; s[2] < n; s[2]++) {
                                for (s[3] = 0; s[3] < n; s[3]++) {
                                    int cur = 0;
                                    for (int i = 0; i < n; i++) {
                                        int max = 0;
                                        for (int j = 0; j < Math.min(m, n); j++) {
                                            max = Math.max(max, a[j][(i + s[j]) % n]);
                                        }
                                        cur += max;
                                    }
                                    ans = Math.max(cur, ans);
                                }
                            }
                        }
                    }

                    out.println(ans);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    static class Input {
        public final BufferedReader reader;
        private String line = "";
        private int pos = 0;

        public Input(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        private boolean isSpace(char ch) {
            return ch <= 32;
        }

        public String readWord() throws IOException {
            skip();
            int start = pos;
            while (pos < line.length() && !isSpace(line.charAt(pos))) {
                pos++;
            }
            return line.substring(start, pos);
        }

        public int readInt() throws IOException {
            return Integer.parseInt(readWord());
        }

        private void skip() throws IOException {
            while (true) {
                if (pos >= line.length()) {
                    line = reader.readLine();
                    pos = 0;
                }
                while (pos < line.length() && isSpace(line.charAt(pos))) {
                    pos++;
                }
                if (pos < line.length()) {
                    return;
                }
            }
        }

    }
}

