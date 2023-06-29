import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Dzmitry Paulenka
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long n = in.nextLong();
        long k = in.nextLong();
        if (n == 1) {
            out.println(0);
            return;
        }
        if (k * (k - 1) < 2 * (n - 1)) {
            out.println(-1);
            return;
        }

        long sq2 = 4 * k * k - 4 * k + 1 - 4 * (2 * n - 2);
        double sqrt = Math.sqrt(sq2);
        long sq = (long) sqrt;
        if ((sq + 1) * (sq + 1) == sq2) {
            sq = sq + 1;
        } else if ((sq - 1) * (sq - 1) == sq2) {
            sq = sq - 1;
        }

        if (sq*sq == sq2) {
            long kmin = (sq + 3) / 2;
            out.println(k - kmin + 1);
        } else {
            long km = Math.max(2, (long) ((sqrt + 3) / 2.0) - 2);
            while (((km + k - 2)*(k - km + 1) >= 2*(n-1))) {
                ++km;
            }
            out.println(k - km + 2);
        }
    }
}
