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

        void Solve(InputReader in, PrintWriter out) {
            int n = in.NextInt();
            double r = in.NextInt();
            double[] x = new double[n];
            for (int i = 0; i < n; i++) x[i] = in.NextInt();
            double[] y = new double[n];
            for (int i = 0; i < n; i++) {
                double maxY = r;
                for (int j = 0; j < i; j++) {
                    if (Math.abs(x[i] - x[j]) <= 2 * r) {
                        double currentY = Math.sqrt((2 * r) * (2 * r) - (x[i] - x[j]) * (x[i] - x[j])) + y[j];
                        maxY = Math.max(maxY, currentY);
                    }
                }
                y[i] = maxY;
            }
            out.print(y[0]);
            for (int i = 1; i < n; i++) {
                out.print(" " + y[i]);
            }
            out.println();
        }

        static int GetMax(int[] ar) {
            int max = Integer.MIN_VALUE;
            for (int a : ar) {
                max = Math.max(max, a);
            }
            return max;
        }

        static int GetMin(int[] ar) {
            int min = Integer.MAX_VALUE;
            for (int a : ar) {
                min = Math.min(min, a);
            }
            return min;
        }

        static long GetSum(int[] ar) {
            long s = 0;
            for (int a : ar) s += a;
            return s;
        }

        static int[] GetCount(int[] ar) {
            return GetCount(ar, GetMax(ar));
        }

        static int[] GetCount(int[] ar, int maxValue) {
            int[] dp = new int[maxValue + 1];
            for (int a : ar) {
                dp[a]++;
            }
            return dp;
        }

        static class InputReader {
            BufferedReader reader;
            StringTokenizer tokenizer;

            InputReader(InputStream stream) {
                reader = new BufferedReader(new InputStreamReader(stream), 32768);
                tokenizer = null;
            }

            String Next() {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    try {
                        tokenizer = new StringTokenizer(reader.readLine(), " \t\n\r\f,");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                return tokenizer.nextToken();
            }

            int NextInt() {
                return Integer.parseInt(Next());
            }

            long NextLong() {
                return Long.parseLong(Next());
            }

            double NextDouble() {
                return Double.parseDouble(Next());
            }

            int[] NextIntArray(int n) {
                return NextIntArray(n, 0);
            }

            int[] NextIntArray(int n, int offset) {
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = NextInt() - offset;
                }
                return a;
            }

            int[][] NextIntMatrix(int n, int m) {
                return NextIntMatrix(n, m, 0);
            }

            int[][] NextIntMatrix(int n, int m, int offset) {
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
