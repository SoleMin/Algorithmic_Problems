import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FilterInputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jenish
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        F2SameSumBlocksHard solver = new F2SameSumBlocksHard();
        solver.solve(1, in, out);
        out.close();
    }

    static class F2SameSumBlocksHard {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.scanLong();
            }


            HashMap<Long, ArrayList<pair>> hm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                long sum = 0;
                for (int j = i; j < n; j++) {
                    sum += arr[j];
                    if (hm.containsKey(sum)) {
                        hm.get(sum).add(new pair(i + 1, j + 1));
                    } else {
                        hm.put(sum, new ArrayList<>());
                        hm.get(sum).add(new pair(i + 1, j + 1));
                    }
                }
            }


            long maxi_sum = -1;
            long sum = 0;
            for (Map.Entry<Long, ArrayList<pair>> k : hm.entrySet()) {
                Collections.sort(k.getValue(), new Comparator<pair>() {

                    public int compare(pair o1, pair o2) {
                        return o1.r - o2.r;
                    }
                });

                int count = k.getValue().size() > 0 ? 1 : 0;
                int index = 0;
                for (int i = 1; i < k.getValue().size(); i++) {
                    if (k.getValue().get(i).l > k.getValue().get(index).r) {
                        count++;
                        index = i;
                    }
                }


                if (count > maxi_sum) {
                    maxi_sum = count;
                    sum = k.getKey();
                }
            }

            out.println(maxi_sum);
            ArrayList<pair> tt = hm.get(sum);
            Collections.sort(tt, new Comparator<pair>() {

                public int compare(pair o1, pair o2) {
                    return o1.r - o2.r;
                }
            });


            out.println(tt.size() > 0 ? (tt.get(0).l + " " + tt.get(0).r) : (" "));
            int index = 0;
            for (int i = 1; i < tt.size(); i++) {
                if (tt.get(i).l > tt.get(index).r) {
                    out.println(tt.get(i).l + " " + tt.get(i).r);
                    index = i;
                }
            }


        }

        class pair {
            int l;
            int r;

            public pair(int l, int r) {
                this.l = l;
                this.r = r;
            }

        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int INDEX;
        private BufferedInputStream in;
        private int TOTAL;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (INDEX >= TOTAL) {
                INDEX = 0;
                try {
                    TOTAL = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TOTAL <= 0) return -1;
            }
            return buf[INDEX++];
        }

        public int scanInt() {
            int I = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    I *= 10;
                    I += n - '0';
                    n = scan();
                }
            }
            return neg * I;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

        public long scanLong() {
            long I = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    I *= 10;
                    I += n - '0';
                    n = scan();
                }
            }
            return neg * I;
        }

    }
}

