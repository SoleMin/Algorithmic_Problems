import javax.print.Doc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class taskB {
    public static void main(String[] args) throws IOException {
        new taskB().run();
    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter writer;
    static String TASK = "";

    void run() throws IOException {
        try {
           // reader = new BufferedReader(new FileReader(TASK + ".in"));
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);
           // writer = new PrintWriter(TASK + ".out");
            tokenizer = null;
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int b[];
    int l[];
    int add[];
    int n, k, A;

    double ans = 0;
    void solve() throws IOException {
        n = nextInt();
        k = nextInt();
        A = nextInt();
        b = new int[n];
        l = new int[n];
        add = new int[n];
        for (int i = 0; i < n; ++i) {
            b[i] = nextInt();
            l[i] = nextInt();
        }

        brute(0, k);

        writer.printf("%.10f", ans);
    }

    private void brute(int pos, int yet) {
        if (pos == n) {
            /*double prob[][] = new double[n + 1][n + 1];
            prob[0][0] = 1;

            for (int i = 1; i <= n; ++i) {
                for (int sayYes = 1; sayYes <= i; ++sayYes) {
                    prob[i][sayYes] = p[i - 1] * prob[i - 1][sayYes - 1];
                }
                for (int sayYes = 0; sayYes <= i; ++sayYes) {
                    prob[i][sayYes] = (1 - p[i - 1]) * prob[i - 1][sayYes];
                }
            }
            double nowYes = 0;
            for (int i = 0; i <= n; ++i) {
                if (i >= (n + 2) / 2 )
                    nowYes += prob[n][i];
            } */

            double p[] = new double[n];
            for (int i = 0; i < n; ++i) {
                p[i] = (l[i] + add[i]) / 100.0;
            }
            double r = 0;
            for (int i =0; i < (1 << n); ++i) {
                double pr =1 ;
                int sm = 0;
                for (int j =0 ; j < n; ++j) {
                    if ((i & (1 << j)) > 0) {
                        pr *= p[j];
                    }  else {
                        pr *= (1 - p[j]);
                        sm += b[j];
                    }
                }
                int c = Integer.bitCount(i);
                if (c >= (n + 2) / 2) {
                    r += pr;
                } else {
                    r += pr * (1.0 * A / (A + sm));
                }
            }
            ans = Math.max(ans, r);
        } else {
            for (int i = 0; i <= yet; ++i) {
                if (l[pos] + 10 * i > 100) continue;
                add[pos] = 10 * i;
                brute(pos + 1, yet - i);
            }
        }
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    BigInteger nextBigInteger() throws IOException {
        return new BigInteger(nextToken());
    }
}