import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            int r = in.scanInt(), temp;
            double max1;
            double high[] = new double[1002];
            for (int i = 0; i < n; i++) {
                temp = in.scanInt();
                max1 = high[temp] + ((high[temp] == 0) ? r : +(2 * r));
                for (int j = temp - 1; j > temp - (2 * r) && j > 0; j--) {
                    if (high[j] == 0) continue;
                    max1 = Math.max(max1, high[j] + Math.sqrt((4 * r * r) - ((temp - j) * (temp - j))));
                }
                for (int j = temp + 1; j <= 1000 && j < temp + (2 * r); j++) {
                    if (high[j] == 0) continue;
                    max1 = Math.max(max1, high[j] + Math.sqrt((4d * r * r) - (((j - temp) * (j - temp)))));
                }
                if (temp - (2 * r) > 0) max1 = Math.max(high[temp - (2 * r)], max1);
                if (temp + (2 * r) <= 1000) max1 = Math.max(high[temp + (2 * r)], max1);
                high[temp] = max1;
                out.print(max1 + " ");

            }
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

