import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        int[][] dr = new int[][]{{0, 0, 0, -1}, {0, 0, -1, 0}, {0, 1, 0, 0}, {1, 0, 0, 0}};
        int[][] dd = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        PrintWriter out;
        InputReader in;
        int[] re1;
        int[] re2;
        int N;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            N = in.nextInt();
            int r[] = new int[]{1, 1, N, N};

            this.out = out;
            this.in = in;

            re1 = new int[]{1, 1, 1, 1};
            re2 = new int[]{2, 1, 2, 1};

            //probuje najpierw lewa sciane

            int fr[] = moveSide(r, dr[2], dd[2]);
            int sr[] = subtract(r, fr);
            if (!validSeparation(sr)) {
                fr = moveSide(r, dr[1], dd[1]);
                sr = subtract(r, fr);
            }

            fr = boundary(fr);
            sr = boundary(sr);

            out.println(String.format("! %d %d %d %d %d %d %d %d", fr[0], fr[1], fr[2], fr[3], sr[0], sr[1], sr[2], sr[3]));
        }

        private boolean validSeparation(int[] sr) {
            if (!validRectangle(sr)) return false;
            out.println(String.format("? %d %d %d %d", sr[0], sr[1], sr[2], sr[3]));
            out.flush();
            return in.nextInt() == 1;
        }

        private boolean validRectangle(int[] sr) {
            for (int i = 0; i < 4; i++) {
                if (sr[i] < 1 || sr[i] > N) return false;
            }
            return true;
        }

        private int[] boundary(int[] r) {
            for (int d = 0; d < 4; d++) {
                r = moveSide(r, dr[d], dd[d]);
            }
            return r;
        }

        private int[] subtract(final int[] r, final int[] fr) {
            if (r[1] == fr[1]) {
                //jesli lewy dolny taki sam to ucieto horyzontalnie od gory
                return new int[]{fr[2] + 1, r[1], r[2], r[3]};
            }
            //else ucieto wertykalnie od lewej
            return new int[]{r[0], r[1], r[2], fr[1] - 1};
        }

        private int[] moveSide(final int[] rect, final int[] factors, final int[] widths) {
            int width = Math.abs(rect[widths[0]] - rect[widths[1]]);

            int lo = -1, hi = width + 1;

            while (lo + 1 < hi) {
                int m = lo + (hi - lo) / 2;
                int qr[] = new int[4];
                for (int d = 0; d < 4; d++) qr[d] = rect[d] + factors[d] * m;
                int ans = query(qr);
                if (ans != 0) {
                    lo = m;
                } else {
                    hi = m;
                }
            }

            int ans_rect[] = new int[4];
            for (int d = 0; d < 4; d++) ans_rect[d] = rect[d] + factors[d] * lo;

            return ans_rect;
        }

        private int query(final int[] qr) {
            int ans = 0;
            out.println(String.format("? %d %d %d %d", qr[0], qr[1], qr[2], qr[3]));
            out.flush();

            ans = in.nextInt();

//        if (contains(qr, re1)) ans++;
//        if (contains(qr, re2)) ans++;
            return ans;
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

