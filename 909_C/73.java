import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        TaskC.InputReader in = new TaskC.InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.Solve(in, out);
        out.close();
    }


    static class TaskC {

        private long mod = 1_000_000_007;
        private int n;
        private boolean[] s;

        public void Solve(InputReader in, PrintWriter out) {
            n = in.NextInt();
            s = new boolean[n];
            for (int i = 0; i < n; i++) {
                String ss = in.Next();
                s[i] = ss.charAt(0) == 'f';
            }
            if (s[n - 1]) {
                out.println(0);
                return;
            }
            long[] dpSum = new long[n + 1], lastDpSum = new long[n + 1];
            for (int i = 0; i <= n; i++) {
                lastDpSum[i] = i + 1;
            }
            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    if (!s[i]) {
                        dpSum[j] = lastDpSum[j];
                    } else {
                        dpSum[j] = lastDpSum[j + 1] - lastDpSum[j];
                    }
                    if (j != 0) {
                        dpSum[j] += dpSum[j - 1];
                    }
                    dpSum[j] %= mod;
                    while (dpSum[j] < 0) dpSum[j] += mod;

                }
                long[] temp = dpSum;
                dpSum = lastDpSum;
                lastDpSum = temp;
            }
            out.println(lastDpSum[0]);
        }

        public static int GetMax(int[] ar) {
            int max = Integer.MIN_VALUE;
            for (int a : ar) {
                max = Math.max(max, a);
            }
            return max;
        }

        public static int GetMin(int[] ar) {
            int min = Integer.MAX_VALUE;
            for (int a : ar) {
                min = Math.min(min, a);
            }
            return min;
        }

        public static long GetSum(int[] ar) {
            long s = 0;
            for (int a : ar) s += a;
            return s;
        }

        public static int[] GetCount(int[] ar) {
            return GetCount(ar, GetMax(ar));
        }

        public static int[] GetCount(int[] ar, int maxValue) {
            int[] dp = new int[maxValue + 1];
            for (int a : ar) {
                dp[a]++;
            }
            return dp;
        }

        static class InputReader {
            public BufferedReader reader;
            public StringTokenizer tokenizer;

            public InputReader(InputStream stream) {
                reader = new BufferedReader(new InputStreamReader(stream), 32768);
                tokenizer = null;
            }

            public String Next() {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    try {
                        tokenizer = new StringTokenizer(reader.readLine(), " \t\n\r\f,");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                return tokenizer.nextToken();
            }

            public int NextInt() {
                return Integer.parseInt(Next());
            }

            public long NextLong() {
                return Long.parseLong(Next());
            }

            public double NextDouble() {
                return Double.parseDouble(Next());
            }

            public int[] NextIntArray(int n) {
                return NextIntArray(n, 0);
            }

            public int[] NextIntArray(int n, int offset) {
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = NextInt() - offset;
                }
                return a;
            }

            public int[][] NextIntMatrix(int n, int m) {
                return NextIntMatrix(n, m, 0);
            }

            public int[][] NextIntMatrix(int n, int m, int offset) {
                int[][] a = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        a[i][j] = NextInt() - offset;
                    }
                }
                return a;
            }
        }
    }
}
