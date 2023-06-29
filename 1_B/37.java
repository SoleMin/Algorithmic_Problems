import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Round1TaskB implements Runnable {
    static PrintWriter pw = null;
    static BufferedReader br = null;
    StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));
        (new Thread(new Round1TaskB())).start();
    }

    void nline() {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
        }
    }

    int ni() {
        while (st == null || !st.hasMoreTokens())
            nline();
        return Integer.valueOf(st.nextToken());
    }

    double nd() {
        while (st == null || !st.hasMoreTokens())
            nline();
        return Double.valueOf(st.nextToken());
    }

    long nl() {
        while (st == null || !st.hasMoreTokens())
            nline();
        return Long.valueOf(st.nextToken());
    }

    String nwrd() {
        while (st == null || !st.hasMoreTokens())
            nline();
        return st.nextToken();
    }

    String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
        }
        return null;
    }

    boolean isDigit(char c) {
        if (c <= '9' && c >= '0')
            return true;
        return false;
    }
    
    void rec(int t, int length) {
        if (length == 0) {
            return;
        }
        rec(t / 26, length - 1);
        pw.print((char) ('A' + (t % 26)));
    }

    void RC(int i, int j) {
        int num = 0;
        for (int t = i; t < j; t++) {
            num = num * 10 + format[t] - '0';
        }
        int len = 0, base = 1, total = 0;
        while (true) {
            base *= 26;
            total += base;
            len++;
            if (num <= total)
                break;
        }
        num -= total / 26;
        rec(num, len);
    }

    void BC(int i, int j) {
        int total = 0, base = 1, rest = 0;
        for (int k = i; k< j; k++) {
            total += base;
            base *= 26;
            rest = rest * 26 + format[k] - 'A';
        }
        pw.print(total + rest);
    }

    char format[];

    public void solve() {
        format = nwrd().toCharArray();
        int L = format.length;
        for (int i = 0; i < L - 1; i++) {
            if (isDigit(format[i]) && (format[i + 1] == 'C')) {
                RC(i + 2, L);
                for (int j = 1; j <= i; j++) {
                    pw.print(format[j]);
                }
                pw.println();
                return;
            }
        }
        for (int i = 0; i < L; i++) {
            if (isDigit(format[i])) {
                pw.print('R');
                for (int j = i; j < L; j++) {
                    pw.print(format[j]);
                }
                pw.print('C');
                BC(0, i);
                pw.println();
                return;
            }
        }
    }
    public void run() {
        int n = ni();
        while (n-- > 0) {
            solve();
        }
        pw.close();
    }

}
