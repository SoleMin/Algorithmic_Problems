import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author phantom11
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            int r = in.nextInt();
            int i, j;
            BigDecimal initial = new BigDecimal(10);
            initial = initial.pow(100);
            int x[] = new int[N];
            BigDecimal y[] = new BigDecimal[N];
            Arrays.fill(y, initial);
            for (i = 0; i < N; i++) {
                x[i] = in.nextInt();
            }
            for (i = 0; i < N; i++) {
                BigDecimal y2 = new BigDecimal(r);
                for (j = 0; j < i; j++) {
                    if (Math.abs(x[i] - x[j]) <= 2 * r) {
                        double xDiff = x[i] - x[j];
                        xDiff *= xDiff;
                        xDiff = 4 * r * r - xDiff;
                        xDiff = Math.sqrt(xDiff);
                        BigDecimal yNew = new BigDecimal(xDiff);
                        yNew = yNew.add(y[j]);
                        if (yNew.compareTo(y2) > 0) {
                            y2 = yNew;
                        }
                    }
                }
                y[i] = y2;
            }
            for (i = 0; i < N; i++) {
                out.print(y[i] + " ");
            }
        }

    }

    static class InputReader {
        BufferedReader in;
        StringTokenizer tokenizer = null;

        public InputReader(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            try {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(in.readLine());
                }
                return tokenizer.nextToken();
            } catch (IOException e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void close() {
            writer.close();
        }

    }
}

