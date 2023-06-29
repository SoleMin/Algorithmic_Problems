import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new Main().run(in, out);
        out.close();
    }

    public static long mod = 17352642619633L;

    void run(FastScanner in, PrintWriter out) {
        // kth digit
        long K = in.nextLong();

        // which number encompasses the Kth digit

        long lo = 1;
        long hi = (long)1e12+1;

        while (lo < hi) {
            long m = (lo+hi)>>1;
            long d = numDigitsLte(m);
            if (d <= K) {
                lo = m+1;
            } else {
                hi = m;
            }
        }

        // 123[1]1391 = m digits
        long numDigits = numDigitsLte(lo);
        if (numDigitsLte(lo-1) == K) {
            out.println((((lo-1)%10)+10)%10);
        } else {
            int offset = (int)(numDigits-K);

            // out.print(lo + " ");
            List<Long> digits = new ArrayList<>();
            while (lo > 0) {
                digits.add(lo%10);
                lo /= 10;
            }
            // backwards
            // before : 1[2]3456
            // in list: 6543[2]1
            // offset = 4
            out.println(digits.get(offset));

        }
    }

    static long[] dig = new long[15];
    static {
        for (int i = 1; i < dig.length; i++) {
            dig[i] = 9 * (long)Math.pow(10, i-1) * i;
        }

        for (int i = 1; i < dig.length; i++) {
            dig[i] += dig[i-1];
        }
    }

    long numDigitsLte(long m) {
        if (m <= 9) return m;

        int numDigits = 0;
        long M = m;
        while (M > 0) {
            numDigits++;
            M /= 10;
        }

        long ret = dig[numDigits-1];
        ret += (m-(long)Math.pow(10, numDigits-1)+1)*numDigits;
        return ret;

        // digits below
        // 9 + 90 + 900
        // [1-9], [10-99], [100-999]
        // 9, 90*2, 900*3, ...
        // 9999..

        // 9138
        // [1-1000), [1000,9138]
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
