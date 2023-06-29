//package info.stochastic;

import java.io.*;
import java.util.*;

public class C {
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
            int r = in.nextInt();

            int x[] = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
            }

            double ans[] = new double[n];
            ans[0] = r;
            int index = 1;

            for (int i = 1; i < n; i++) {
                double maxY = r;
                for (int j = 0; j < index; j++) {
                    int xDist = Math.abs(x[i] - x[j]);
                    if (xDist <= r * 2) {
                        double cur = Math.sqrt((r * 2)*(r * 2) - xDist * xDist) + ans[j];
                        //out.println(cur);
                        maxY = Math.max(maxY, cur);
                    }
                }
                //out.println();
                ans[i] = maxY;
                index++;
            }

            for (int i = 0; i < n; i++) {
                out.print(ans[i] + " ");
            }

        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
