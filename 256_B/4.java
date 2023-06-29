//package codeforces.cf156;
import java.io.*;
import java.util.Arrays;

public class ProblemB {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

    long[] readInts() throws IOException {
        String[] strings = reader.readLine().split(" ");
        long[] ints = new long[strings.length];
        for(int i = 0; i < ints.length; i++) {
            ints[i] = Long.parseLong(strings[i]);
        }
        return ints;
    }

    long foo(long a) {
        return a > 0 ? a * a : 0;
    }
    long boo(long a) {
        return a <= 0 ? 0 : a * (a + 1) / 2;
    }

    void solve() throws IOException {
        long[] tt = readInts();
        long n = tt[0];
        long x = tt[1];
        long y = tt[2];
        long c = tt[3];
        long lo = -1, hi = 2 * 1000 * 1000 * 1000 + 2;
//        hi = 5;
        while(hi - lo > 1) {
            long m = (lo + hi) / 2;
            long s = 2 * m * m + 2 * m + 1;
            s -= foo(m - x + 1) + foo(m - y + 1) + foo(x + m - n) + foo(y + m - n);
            s += boo(m + 1 - (n + 1 + n + 1 - x - y)) + boo(m + 1 - (n + 1 - x + y)) + boo(m + 1 - (n + 1 - y + x))
                    + boo(m + 1 - (x + y));
            if(s < c) lo = m;
            else hi = m;
        }
        writer.println(hi);
        writer.flush();
    }

    public static void main(String[] args) throws IOException{
        new ProblemB().solve();
    }
}
