import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * @author khokharnikunj8
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                new Main().solve();
            }
        }, "1", 1 << 26).start();
    }

    void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ACodehorsesTShirts solver = new ACodehorsesTShirts();
        solver.solve(1, in, out);
        out.close();
    }

    static class ACodehorsesTShirts {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            ArrayList<String>[] arrayLists = new ArrayList[5];
            ArrayList<String>[] arrayLists1 = new ArrayList[5];
            for (int i = 0; i < 5; i++) {
                arrayLists[i] = new ArrayList<>();
                arrayLists1[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                String s = in.scanString();
                arrayLists[s.length()].add(s);
            }
            for (int i = 0; i < n; i++) {
                String s = in.scanString();
                arrayLists1[s.length()].add(s);
            }
            long ans = 0;
            for (int i = 0; i < 5; i++) {
                for (int diff = 0; diff < 5; diff++) {

                    for (int j = 0; j < arrayLists[i].size(); j++) {
                        int min = Integer.MAX_VALUE;
                        int index = -1;
                        for (int k = 0; k < arrayLists1[i].size(); k++) {
                            int tt = 0;
                            for (int l = 0; l < i; l++)
                                if (arrayLists[i].get(j).charAt(l) != arrayLists1[i].get(k).charAt(l)) tt++;
                            if (tt < min) {
                                min = tt;
                                index = k;
                            }

                        }
                        if (min == diff) {
                            arrayLists1[i].remove(index);
                            ans += min;
                        }
                    }
                }
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

        public String scanString() {
            int c = scan();
            if (c == -1) return null;
            while (isWhiteSpace(c)) c = scan();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = scan();
            } while (!isWhiteSpace(c));
            return res.toString();
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}

