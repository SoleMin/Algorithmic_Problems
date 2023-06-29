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
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Input in, PrintWriter out) {
            try {
                int n = in.readInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = in.readInt();
                }
                Arrays.sort(a);
                boolean[] b = new boolean[n];
                int ans = 0;
                while (true) {
                    int x = 0;
                    for (int i = 0; i < n; i++) {
                        if (!b[i] && x == 0) {
                            x = a[i];
                        }
                        if (x != 0 && a[i] % x == 0) {
                            b[i] = true;
                        }
                    }
                    if (x == 0) {
                        break;
                    }
                    ans++;
                }
                out.println(ans);
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

