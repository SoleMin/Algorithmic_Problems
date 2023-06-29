import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author MaxHeap
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, FastReader in, OutputWriter out) {
            int n = in.nextInt();
            double r = in.nextInt();
            double[] x = new double[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextDouble();
            }
            double[] ans = new double[n];
            ans[0] = r;
            for (int i = 1; i < n; i++) {
                ans[i] = r;
                double maxY = 0;
                for (int j = 0; j < i; j++) {
                    if (Math.abs(x[j] - x[i]) <= 2.0 * r) {
                        double y = ans[j] + Math.sqrt(4 * r * r - (x[j] - x[i]) * (x[j] - x[i]));
                        ans[i] = Math.max(ans[i], y);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (i > 0) out.print(" ");
                out.printf("%.8f", ans[i]);
            }
        }

    }

    static class FastReader {
        BufferedReader reader;
        StringTokenizer st;

        public FastReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) {
                        return null;
                    }
                    st = new StringTokenizer(line);
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream os, boolean autoFlush) {
            super(os, autoFlush);
        }

        public OutputWriter(Writer out) {
            super(out);
        }

        public OutputWriter(Writer out, boolean autoFlush) {
            super(out, autoFlush);
        }

        public OutputWriter(String fileName) throws FileNotFoundException {
            super(fileName);
        }

        public OutputWriter(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
            super(fileName, csn);
        }

        public OutputWriter(File file) throws FileNotFoundException {
            super(file);
        }

        public OutputWriter(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
            super(file, csn);
        }

        public OutputWriter(OutputStream out) {
            super(out);
        }


        public void flush() {
            super.flush();
        }


        public void close() {
            super.close();
        }

    }
}

