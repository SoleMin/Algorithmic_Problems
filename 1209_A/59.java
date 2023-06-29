// package cf1209;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Random;

public class CFA {
    private static final String INPUT = "8\n" +
            "7 6 5 4 3 2 2 3\n";
    private static final int MOD = 1_000_000_007;

    private PrintWriter out;
    private FastScanner sc;

    public static void main(String[] args) {
        new CFA().run();
    }

    public void run() {
        sc = new FastScanner(oj ? System.in : new ByteArrayInputStream(INPUT.getBytes()));
        out = new PrintWriter(System.out);

        long s = System.currentTimeMillis();
        solve();
        out.flush();
        tr(System.currentTimeMillis() - s + "ms");
    }

    static class Color {
        int nr;
        boolean used;

        public Color(int nr) {
            this.nr = nr;
        }
    }

    private void solve() {
        int n = sc.nextInt();
        Color[] a = new Color[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Color(sc.nextInt());
        }
        Arrays.sort(a, Comparator.comparingInt(c -> c.nr));

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i].used) continue;
            ans++;

            for (int j = i+1; j < n; j++) {
                if (a[j].nr % a[i].nr == 0) {
                    a[j].used = true;
                }
            }
        }
        out.println(ans);
    }

//********************************************************************************************
//********************************************************************************************
//********************************************************************************************

    static class SolutionFailedException extends Exception {
        int code;

        public SolutionFailedException(int code) {
            this.code = code;
        }
    }

    int [] sort(int [] a) {
        final int SHIFT = 16, MASK = (1 << SHIFT) - 1, SIZE = (1 << SHIFT) + 1;
        int n = a.length, ta [] = new int [n], ai [] = new int [SIZE];
        for (int i = 0; i < n; ai[(a[i] & MASK) + 1]++, i++);
        for (int i = 1; i < SIZE; ai[i] += ai[i - 1], i++);
        for (int i = 0; i < n; ta[ai[a[i] & MASK]++] = a[i], i++);
        int [] t = a; a = ta; ta = t;
        ai = new int [SIZE];
        for (int i = 0; i < n; ai[(a[i] >> SHIFT) + 1]++, i++);
        for (int i = 1; i < SIZE; ai[i] += ai[i - 1], i++);
        for (int i = 0; i < n; ta[ai[a[i] >> SHIFT]++] = a[i], i++);
        return ta;
    }

    private static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    /**
     * If searched element doesn't exist, returns index of first element which is bigger than searched value.<br>
     * If searched element is bigger than any array element function returns first index after last element.<br>
     * If searched element is lower than any array element function returns index of first element.<br>
     * If there are many values equals searched value function returns first occurrence.<br>
     */
    private static int lowerBound(long[] arr, long key) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (key <= arr[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return arr[lo] < key ? lo + 1 : lo;
    }

    /**
     * Returns index of first element which is grater than searched value.
     * If searched element is bigger than any array element, returns first index after last element.
     */
    private static int upperBound(long[] arr, long key) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (key >= arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return arr[lo] <= key ? lo + 1 : lo;
    }

    private static int ceil(double d) {
        int ret = (int) d;
        return ret == d ? ret : ret + 1;
    }

    private static int round(double d) {
        return (int) (d + 0.5);
    }

    private static int gcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }

    private static long gcd(long a, long b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.longValue();
    }

    private int[] readIntArray(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextInt();
        }
        return res;
    }

    private long[] readLongArray(int n) {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextLong();
        }
        return res;
    }

    @SuppressWarnings("unused")
    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (isEndline(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }

    }

    private boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    private void tr(Object... o) {
        if (!oj) System.out.println(Arrays.deepToString(o));
    }
}