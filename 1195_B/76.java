import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Xinyi Tao
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskBR574D2 solver = new TaskBR574D2();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskBR574D2 {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            long n = in.nextLong();
            long k = in.nextLong();
            long r = (long) (Math.sqrt(9 + 8 * (n + k)) - 3) / 2;
            out.println(n - r);
        }

    }
}

