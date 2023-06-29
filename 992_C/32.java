import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {

    long mod = (long) (1e9 + 7);

    void solve() throws Throwable {
        long x = readLong(), k = readLong();
        if (x == 0) {
            System.out.println(0);
            return;
        }
        long r = solveFast(x, k);
        //long r2 = solveSlow(x, k) % mod;
        System.out.println(r);
        //System.out.println(r2);
    }

    private long solveSlow(long x, long k) {
        List<Long> a = new ArrayList<>();
        a.add(x);
        for (int i = 0; i < k; i++) {
            dodouble(a);
            a = eat(a);
        }
        dodouble(a);
        long sum = 0;
        for (Long v : a) {
            sum = (sum + v) % mod;
        }
        return sum * rev(a.size(), mod) % mod;
    }

    private List<Long> eat(List<Long> a) {
        List<Long> r = new ArrayList<>();
        for (Long v : a) {
            r.add(v);
            r.add((v - 1 + mod) % mod);
        }
        return r;
    }

    private void dodouble(List<Long> a) {
        for (int i = 0; i < a.size(); i++) {
            a.set(i, a.get(i) * 2 % mod);
        }
    }

    private long solveFast(long x, long k) {
        long n = binpow(2, k, mod);
        long ma = (binpow(2, k + 1, mod) * (x % mod)) % mod;
        long mi = (ma - n * 2 + 2 + mod * 100) % mod;
        return ((ma + mi) * rev(2, mod)) % mod;
    }

    private long rev(long a, long mod) {
        return binpow(a, mod - 2, mod);
    }

    //-------------------------------------------------

    final boolean ONLINE_JUDGE = !new File("input.txt").exists();

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok;

    public void run() {
        Runnable run = () -> {
            try {
                long startTime = System.currentTimeMillis();
                Locale.setDefault(Locale.US);
                if (ONLINE_JUDGE) {
                    in = new BufferedReader(new InputStreamReader(System.in));
                    out = new PrintWriter(System.out);
                } else {
                    in = new BufferedReader(new FileReader("input.txt"));
                    out = new PrintWriter("output.txt");
                }
                tok = new StringTokenizer("");
                solve();
                in.close();
                out.close();
                long endTime = System.currentTimeMillis();
                long totalMemory = Runtime.getRuntime().totalMemory();
                long freeMemory = Runtime.getRuntime().freeMemory();
                System.err.println();
                System.err.println("Time = " + (endTime - startTime) + " ms");
                //System.err.println("Memory = " + ((totalMemory - freeMemory) / 1024) + " KB");
            } catch (Throwable e) {
                e.printStackTrace(System.err);
                System.exit(-1);
            }
        };
        new Thread(null, run, "run", 256 * 1024 * 1024).start();
        min(0, 0);
    }

    String readString() {
        while (!tok.hasMoreTokens()) {
            String line;
            try {
                line = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (line == null) return null;
            tok = new StringTokenizer(line);
        }
        return tok.nextToken();
    }

    int readInt() {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    void debug(Object... o) {
        if (!ONLINE_JUDGE) {
            System.err.println(Arrays.deepToString(o));
        }
    }

    /*long binpow(long a, long n) {
        long r = 1;
        while (n > 0) {
            if ((n & 1) > 0) {
                r *= a;
            }
            a *= a;
            n /= 2;
        }
        return r;
    }/**/

    long binpow(long a, long n, long mod) {
        long r = 1;
        while (n > 0) {
            if ((n & 1) > 0) {
                r = (r * a) % mod;
            }
            a = (a * a) % mod;
            n /= 2;
        }
        return r;
    }/**/

    static long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    private long[] readLongArray(int n) throws IOException {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = readLong();
        }
        return a;
    }

    public static void main(String[] args) {
        new Main().run();
    }
}