//package timus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.Writer;
import java.math.BigInteger;
import java.util.Arrays;

public class Abra {
    public static void main(String[] args) throws IOException {
        new Abra().run();
    }

    StreamTokenizer in;
    PrintWriter out;
    boolean oj;

    void init() throws IOException {
        oj = System.getProperty("ONLINE_JUDGE") != null;
        Reader reader = oj ? new InputStreamReader(System.in) : new FileReader(
                "input.txt");
        Writer writer = oj ? new OutputStreamWriter(System.out)
                : new FileWriter("output.txt");
        in = new StreamTokenizer(new BufferedReader(reader));
        out = new PrintWriter(writer);
    }

    void run() throws IOException {
        long beginTime = System.currentTimeMillis();
        init();
        solve();
        out.flush();
    }

    void printMem() {
        if (!oj) {
            System.out.println("Memory used = "
                    + (Runtime.getRuntime().totalMemory() - Runtime
                            .getRuntime().freeMemory()));
        }
    }

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    String nextString() throws IOException {
        in.nextToken();
        return in.sval;
    }

    double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }

    long deg(long x, long y) {
        long a = x;
        for (long i = 2; i <= y; i++) {
            a *= x;
        }
        return a;
    }

    long fact(long x) {
        long a = 1;
        for (long i = 2; i <= x; i++) {
            a *= i;
        }
        return a;
    }

    long digitSum(String x) {
        long a = 0;
        for (int i = 0; i < x.length(); i++) {
            a += x.codePointAt(i) - 48;
        }
        return a;
    }

    long digitSum(long x) {
        long a = 0;
        while (x > 0) {
            a += x % 10;
            x /= 10;
        }
        return a;
    }

    long digitMul(long x) {
        long a = 1;
        while (x > 0) {
            a *= x % 10;
            x /= 10;
        }
        return a;
    }
    
    int digitCubesSum(int x) {
        int a = 0;
        while (x > 0) {
            a += (x % 10) * (x % 10) * (x % 10);
            x /= 10;
        }
        return a;
    }

    double pif(double ax, double ay, double bx, double by) {
        return Math.sqrt((ax - bx) * (ax - bx) + (ay - by) * (ay - by));
    }

    double getPosPart(double x) {
        if (x <= 0)
            return 0;
        else
            return x;
    }

    double max(double x, double y) {
        if (x > y)
            return x;
        else
            return y;
    }

    long gcd(long a, long b) {
        if (a < b) {
            long c = b;
            b = a;
            a = c;
        }
        while (a % b != 0) {
            a = a % b;
            if (a < b) {
                long c = b;
                b = a;
                a = c;
            }
        }
        return b;
    }

    int gcd(int a, int b) {
        if (a < b) {
            int c = b;
            b = a;
            a = c;
        }
        while (a % b != 0) {
            a = a % b;
            if (a < b) {
                int c = b;
                b = a;
                a = c;
            }
        }
        return b;
    }

    long lcm(long a, long b) throws IOException {
        return a * b / gcd(a, b);
    }

    int lcm(int a, int b) throws IOException {
        return a * b / gcd(a, b);
    }

    int countOccurences(String x, String y) {
        int a = 0, i = 0;
        while (true) {
            i = y.indexOf(x);
            if (i == -1)
                break;
            a++;
            y = y.substring(i + 1);
        }
        return a;
    }

    int[] primes;

    int findPrimes(int x) {
        boolean[] forErato = new boolean[x];
        primes = new int[x];
        int l = 0, j = 0;
        for (int i = 2; i < x; i++) {
            if (forErato[i])
                continue;
            l++;
            primes[l] = i;
            j = i * 2;
            while (j < x) {
                forErato[j] = true;
                j += i;
            }
        }
        return l;
    }

    int rev(int x) {
        int a = 0;
        while (x > 0) {
            a = a * 10 + x % 10;
            x /= 10;
        }
        return a;
    }

    class myDate {
        int d, m, y;

        public myDate(int da, int ma, int ya) {
            d = da;
            m = ma;
            y = ya;
        }

        int[] ml = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        void inc() {
            if ((d == 31) && (m == 12)) {
                y++;
                d = 1;
                m = 1;
            } else {
                if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
                    ml[1] = 29;
                }
                if (d == ml[m - 1]) {
                    m++;
                    d = 1;
                } else
                    d++;
            }
        }
    }

    int partition(int n, int l, int m) {// n - sum, l - length, m - every part
        // <= m
        if (n < l)
            return 0;
        if (n < l + 2)
            return 1;
        if (l == 1)
            return 1;
        int c = 0;
        for (int i = Math.min(n - l + 1, m); i >= (n + l - 1) / l; i--) {
            c += partition(n - i, l - 1, i);
        }
        return c;
    }
    
    String s;
    int l;
    
    void solve() throws IOException {
        s = nextString();
        l = s.length();
        int max = 0;
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                if (countOccurences(s.substring(i, j), s) > 1)
                    if (j - i > max) max = j - i;
            }
        }
        out.println(max);
    }
}