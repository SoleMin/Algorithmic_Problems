import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author ZYCSwing
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int[] a = new int[n];

            BigInteger sum = new BigInteger("0");
            for (int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
                long tmp = ((long) (2 * i + 1 - n)) * a[i];
                sum = sum.add(BigInteger.valueOf(tmp));
            }

            Map<Integer, Integer> cnt = new HashMap<>();

            for (int i = n - 1; i >= 0; --i) {
                if (cnt.containsKey(a[i] + 1)) {
                    sum = sum.subtract(BigInteger.valueOf(cnt.get(a[i] + 1)));
                }
                if (cnt.containsKey(a[i] - 1)) {
                    sum = sum.add(BigInteger.valueOf(cnt.get(a[i] - 1)));
                }
                if (cnt.containsKey(a[i])) {
                    cnt.put(a[i], cnt.get(a[i]) + 1);
                } else {
                    cnt.put(a[i], 1);
                }
            }

            out.println(sum);
        }

    }
}

