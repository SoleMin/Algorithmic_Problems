import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author khokharnikunj8
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            BigInteger ans = new BigInteger("0");
            long val, index, index1, index2;
            long sum[] = new long[n];
            val = in.scanInt();
            HashMap<Long, Integer> hs = new HashMap<>();
            hs.put(val, 1);
            sum[0] = val;
            for (int i = 1; i < n; i++) {
                val = in.scanInt();
                sum[i] += sum[i - 1];
                sum[i] += val;
                if (!hs.containsKey(val)) hs.put(val, 0);
                hs.put(val, hs.get(val) + 1);

                ans = ans.add(BigInteger.valueOf(((i + 1) * val) - sum[i]));
                index = (hs.containsKey(val + 1)) ? hs.get(val + 1) : 0;
                index1 = (hs.containsKey(val - 1)) ? hs.get(val - 1) : 0;
                index2 = (hs.containsKey(val)) ? hs.get(val) : 0;
                ans = ans.subtract(BigInteger.valueOf(((index + index1 + index2) * val) - ((index * (val + 1)) + (index1 * (val - 1)) + (index2 * (val)))));
            }
            out.println(ans);


        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int index;
        private BufferedInputStream in;
        private int total;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (index >= total) {
                index = 0;
                try {
                    total = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (total <= 0) return -1;
            }
            return buf[index++];
        }

        public int scanInt() {
            int integer = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                }
            }
            return neg * integer;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}

