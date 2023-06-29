/**
 * Created by IntelliJ IDEA.
 * User: piyushd
 * Date: 3/26/11
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */


public class TaskB {

    int[] levels;
    int[] loyalty;

    int n, k, A;
    double ans = Double.NEGATIVE_INFINITY;

    void rec(int ix, int sweets, int[] loyalty) {
        if (ix == n) {

            double nres = 0.0;
            for(int mask = 0; mask < (1<<n); mask++) {

                double res = 1.0, totalStrength = 0;
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) > 0) {
                        res *= loyalty[i] / 100.0;
                    } else {
                        res *= 1.0 - (loyalty[i]/ 100.0);
                        totalStrength += levels[i];
                    }
                }

                int bitCount = Integer.bitCount(mask);
                if(bitCount > n / 2) {
                    nres += res;
                }
                else {
                    nres += res * (A) / (A + totalStrength);
                }

            }
            ans = Math.max(ans, nres);
            return;
        }

        for (int j = 0; j <= sweets; j++) {
            if (loyalty[ix] + 10 * j > 100) break;
            int[] nloyalty = loyalty.clone();
            nloyalty[ix] += 10 * j;
            rec(ix + 1, sweets - j, nloyalty);
        }
    }

    void run() {
        n = nextInt();
        k = nextInt();
        A = nextInt();
        levels = new int[n];
        loyalty = new int[n];
        for (int i = 0; i < n; i++) {
            levels[i] = nextInt();
            loyalty[i] = nextInt();
        }

        rec(0, k, loyalty);
        System.out.println(ans);
    }

    int nextInt() {
        try {
            int c = System.in.read();
            if (c == -1) return c;
            while (c != '-' && (c < '0' || '9' < c)) {
                c = System.in.read();
                if (c == -1) return c;
            }
            if (c == '-') return -nextInt();
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = System.in.read();
            } while ('0' <= c && c <= '9');
            return res;
        } catch (Exception e) {
            return -1;
        }
    }

    long nextLong() {
        try {
            int c = System.in.read();
            if (c == -1) return -1;
            while (c != '-' && (c < '0' || '9' < c)) {
                c = System.in.read();
                if (c == -1) return -1;
            }
            if (c == '-') return -nextLong();
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = System.in.read();
            } while ('0' <= c && c <= '9');
            return res;
        } catch (Exception e) {
            return -1;
        }
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String next() {
        try {
            StringBuilder res = new StringBuilder("");
            int c = System.in.read();
            while (Character.isWhitespace(c))
                c = System.in.read();
            do {
                res.append((char) c);
            } while (!Character.isWhitespace(c = System.in.read()));
            return res.toString();
        } catch (Exception e) {
            return null;
        }
    }

    String nextLine() {
        try {
            StringBuilder res = new StringBuilder("");
            int c = System.in.read();
            while (c == '\r' || c == '\n')
                c = System.in.read();
            do {
                res.append((char) c);
                c = System.in.read();
            } while (c != '\r' && c != '\n');
            return res.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        new TaskB().run();
    }
}
