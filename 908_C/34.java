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
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputScanner in = new InputScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputScanner in, PrintWriter out) {
            int[] arr = in.readIntArr();
            int n = arr[0];
            int r = arr[1];

            int[] x = in.readIntArr();
            for (int i = 0; i < n; i++) {
                x[i] += 999;
            }

            double[] h = new double[n];
            int dsk[] = new int[3000];
            Arrays.fill(dsk, -1);

            for (int i = 0; i < r; i++) {
                dsk[x[0] + i] = 0;
                dsk[x[0] - i - 1] = 0;
            }
            int rs = 4 * r * r;

            h[0] = r;


            for (int i = 1; i < n; i++) {
                double ch = r;
                for (int j = 0; j < r; j++) {

                    if (dsk[x[i] + j] != -1) {
                        int ind = dsk[x[i] + j];
                        int diff = x[ind] - x[i];
                        int diffs = diff * diff;
                        int hs = rs - diffs;
                        ch = Math.max(ch, h[ind] + Math.sqrt(hs));
                    }

                    if (dsk[x[i] - j - 1] != -1) {
                        int ind = dsk[x[i] - j - 1];
                        int diff = x[ind] - x[i];
                        int diffs = diff * diff;
                        int hs = rs - diffs;
                        ch = Math.max(ch, h[ind] + Math.sqrt(hs));
                    }


                }
                if (x[i] + r < 3000) {
                    if (dsk[x[i] + r] != -1) {
                        ch = Math.max(ch, h[dsk[x[i] + r]]);
                    }
                }
                if (x[i] - r - 1 > 0) {
                    if (dsk[x[i] - r - 1] != -1) {
                        ch = Math.max(ch, h[dsk[x[i] - r - 1]]);
                    }
                }
                for (int j = 0; j < r; j++) {
                    dsk[x[i] + j] = i;
                    dsk[x[i] - j - 1] = i;
                }
                h[i] = ch;

            }

            for (int i = 0; i < n; i++) {
                out.print(h[i] + " ");
            }
            out.println();

        }

    }

    static class InputScanner {
        BufferedReader br;

        public InputScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));

        }

        String readLine() {
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;

        }

        public String[] readStringArr() {

            return readLine().split(" ");

        }

        public int[] readIntArr() {
            String[] str = readStringArr();
            int arr[] = new int[str.length];
            for (int i = 0; i < arr.length; i++)
                arr[i] = Integer.parseInt(str[i]);
            return arr;
        }

    }
}

