import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            long n = in.nextLong();
            long s = in.nextLong();
            long ans = 0;
            long i = 0;
            for (i = s; i <= n; i++) {
                long t = i - sum(i);
                if (t >= s) {
                    if (i % 10 == 9) {
                        break;
                    }
                    ans++;
                }
            }
            if (n >= s) {
                out.println(ans - i + n + 1);
            } else {
                out.println(0);
            }
        }

        static long sum(long a) {
            long sum = 0;
            while (a != 0) {
                sum += (a % 10);
                a /= 10;
            }
            return sum;
        }

    }
}

