import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        new Solver().run(1);
    }
}

class Solver {

    private BufferedReader reader = null;
    private StringTokenizer st = null;

    private static final long MOD = (long)1e9 + 7;
    private long x, k;

    public void run(int inputType) throws Exception {
        if (inputType == 0)
            reader = new BufferedReader(new FileReader("input.txt"));
        else
            reader = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(reader.readLine());
        x = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());

        if (x == 0) {
            System.out.println(0);
            return;
        }

        long pow = binpow(2, k);
        long m = (2 * x) % MOD;

        m = (m - 1 < 0) ? MOD - 1 : m - 1;

        m = (m * pow) % MOD;
        m = (m + 1) % MOD;

        System.out.println(m);

        reader.close();
    }

    long binpow(long v, long p) {
        long res = 1L;
        while(p > 0) {

            if ((p & 1) > 0)
                res = (res * v) % MOD;

            v = (v * v) % MOD;
            p /= 2;
        }

        return res;
    }
}
