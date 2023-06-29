import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), i, a[] = new int[N];
            int rev[] = new int[N];
            for (i = 0; i < N; i++) {
                a[i] = in.nextInt();
                rev[N - i - 1] = a[i];
            }
            long[][] inverse = inversions(a, N);
            long[][] revInverse = inversions(rev, N);
            int q = in.nextInt();
            long inversions = inverse[0][N - 1] % 2;
            while (q-- > 0) {
                int left = in.nextInt() - 1, right = in.nextInt() - 1;
                int length = right - left + 1;
                length = length * (length - 1) / 2;
                if (length % 2 == 1) {
                    inversions = 1 - inversions;
                }
                if (inversions % 2 == 0) {
                    out.printLine("even");
                } else {
                    out.printLine("odd");
                }
            }
            //DebugUtils.debug(inverse);
        }

        public long[][] inversions(int a[], int N) {
            int x[][] = new int[N][N];
            int i, j;
            for (i = 0; i < N; i++) {
                for (j = i + 1; j < N; j++) {
                    if (a[i] > a[j]) {
                        x[i][j] = 1;
                    }
                }
            }
            int colSum[][] = new int[N][N];
            for (i = 0; i < N; i++) {
                colSum[0][i] = x[0][i];
                for (j = 1; j < N; j++) {
                    colSum[j][i] = colSum[j - 1][i] + x[j][i];
                }
            }
            long inverse[][] = new long[N][N];
            for (int length = 2; length <= N; length++) {
                j = length - 1;
                i = 0;
                while (j < N) {
                    inverse[i][j] = inverse[i][j - 1] + colSum[i + length - 1][j];
                    if (i > 0) {
                        inverse[i][j] -= colSum[i - 1][j];
                    }
                    i++;
                    j++;
                }
            }
            return inverse;
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

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

