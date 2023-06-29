import java.io.*;
import java.math.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws Exception {
        new B().solve(System.in, System.out);
        // new FileInputStream(new File("input.txt")),
        // new PrintStream(new FileOutputStream(new File("output.txt"))));
    }

    void solve(InputStream _in, PrintStream out) throws IOException {
        // BufferedReader in = new BufferedReader(new InputStreamReader(_in));
        // String[] sp;
        Scanner sc = new Scanner(_in);

        long n = sc.nextLong();
        long x = sc.nextLong() - 1;
        long y = sc.nextLong() - 1;
        long c = sc.nextLong();

        long ub = 2 * n;
        long lb = -1;
        while (lb + 1 < ub) {
            long k = (lb + ub) / 2;

            long l, u, r, d;
            l = Math.max(0, x - k);
            u = Math.max(0, y - k);
            r = Math.min(n - 1, x + k);
            d = Math.min(n - 1, y + k);

            long ss = 0;
            // lu
            long lu = x - (k - (y - u));
            if (l < lu) {
                long a = lu - l;
                ss += a * (a + 1) / 2;
            }
            // ld
            long ld = x - (k - (d - y));
            if (l < ld) {
                long a = ld - l;
                ss += a * (a + 1) / 2;
            }
            // ru
            long ru = x + (k - (y - u));
            if (ru < r) {
                long a = r - ru;
                ss += a * (a + 1) / 2;
            }
            // rd
            long rd = x + (k - (d - y));
            if (rd < r) {
                long a = r - rd;
                ss += a * (a + 1) / 2;
            }

            long cc = (r + 1 - l) * (d + 1 - u) - ss;

            if (c <= cc) {
                // ok
                ub = k;
            } else {
                // ng
                lb = k;
            }
        }
        out.println(ub);
    }
}

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
