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
        double ans = 0;
        int[] candy;
        int[] b;
        int[] l;
        int[] curLoyal;
        int n;
        int k;
        int A;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            k = in.nextInt();
            A = in.nextInt();
            b = new int[n];
            l = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
                l[i] = in.nextInt();
            }
            candy = new int[n];
            curLoyal = new int[n];
            comb(0, k);
            out.println(ans);
        }

        void comb(int ind, int unusedCandy) {
            if (ind == n) {
                for (int i = 0; i < n; i++) {
                    curLoyal[i] = Math.min(candy[i] * 10 + l[i], 100);
                }
                calc();
            } else {
                for (int i = 0; i <= unusedCandy; i++) {
                    candy[ind] = i;
                    comb(ind + 1, unusedCandy - i);
                }
            }
        }

        void calc() {
            double res = 0;
            int allBits = (1 << n) - 1;
            for (int vote = 0; vote <= allBits; vote++) {
                double curProb = 1;
                int sumPower = A;
                int enemyCnt = 0;
                for (int voteInd = 0; voteInd < n; voteInd++) {
                    if ((vote & (1 << voteInd)) == 0) {
                        curProb *= 100 - curLoyal[voteInd];
                        sumPower += b[voteInd];
                        enemyCnt++;
                    } else {
                        curProb *= curLoyal[voteInd];
                    }
                    curProb /= 100;
                }
                if (2 * enemyCnt >= n) {
                    curProb *= A;
                    curProb /= sumPower;
                }
                res += curProb;
            }
            ans = Math.max(ans, res);
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer stt;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public String next() {
            while (stt == null || !stt.hasMoreTokens()) {
                stt = new StringTokenizer(nextLine());
            }
            return stt.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

