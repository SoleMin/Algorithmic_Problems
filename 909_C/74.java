
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Wolfgang Beyer
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

    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long MOD = 1000000007;

            long[] current = new long[n + 3];
            //long[] sum = new long[n + 3];
            current[0] = 1;

            for (int i = 0; i < n - 1; i++) {

                String s = in.next();
                if (s.equals("f")) {
                    for (int j = i + 1; j > 0; j--) {
                        current[j] = current[j - 1];
                        current[j] %= MOD;
                    }
                    current[0] = 0;
                } else {
                    for (int j = i + 1; j >= 0; j--) {
                        //sum[j] = sum[j + 1] + current[j];
                        current[j] = current[j + 1] + current[j];
                        current[j] %= MOD;
                    }
                    //for (int j = 0; j <= i + 1; j++) {
                    //  current[j] =
                    //}
                }
            }
            long result = 0;
            for (int i = 0; i <= n; i++) {
                result += current[i];
                result %= MOD;
            }
            out.println(result);
        }

    }

    static class InputReader {
        private static BufferedReader in;
        private static StringTokenizer tok;

        public InputReader(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            try {
                while (tok == null || !tok.hasMoreTokens()) {
                    tok = new StringTokenizer(in.readLine());
                    //tok = new StringTokenizer(in.readLine(), ", \t\n\r\f"); //adds commas as delimeter
                }
            } catch (IOException ex) {
                System.err.println("An IOException was caught :" + ex.getMessage());
            }
            return tok.nextToken();
        }

    }
}

