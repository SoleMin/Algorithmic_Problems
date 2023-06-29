import java.io.*;
import java.util.*;

/**
 * @author def
 * @version 1.0
 */
public class B {

    public static void main(String[] args) throws IOException {
        new B().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String s = in.readLine();
            int pr = s.indexOf('R');
            int pc = s.indexOf('C');
            if (pr == 0 && pc > 1 && Character.isDigit(s.charAt(1))) {
                int r = Integer.parseInt(s.substring(1, pc));
                int c = Integer.parseInt(s.substring(pc + 1, s.length()));
                out.println(i2s(c) + r);
            } else {
                int i = 0;
                while (!Character.isDigit(s.charAt(i))) ++i;
                out.println("R" + Integer.parseInt(s.substring(i, s.length())) + "C" + s2i(s.substring(0, i)));
            }
        }

        out.close();
    }

    int s2i(String s) {
        int r = 0;
        for (int i = 0; i < s.length(); ++i) {
            r = r * 26 + (s.charAt(i) - 'A' + 1);
        }
        return r;
    }

    String i2s(int i) {
        StringBuffer s = new StringBuffer();
        while (i > 0) {
            i -= 1;
            s.append((char)('A' + (i % 26)));
            i /= 26;
        }
        return s.reverse().toString();
    }

    BufferedReader in;
    PrintWriter out;
}
