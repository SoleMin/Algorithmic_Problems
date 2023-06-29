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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            long n = in.nextLong();
            long st = 1, en = n, ans = 0, len = 0;
            while (st <= en) {
                long mid = (st + en) / 2;
                long have = 0;
                int curLen = Long.toString(mid).length();
                long bef = 0;
                for (int i = 1; i < curLen; i++) {
                    long cur = 0;
                    for (int j = 1; j <= i; j++) {
                        cur *= 10;
                        cur += 9;
                    }
                    have += i * (cur - bef);
                    bef = cur;
                }
                have += curLen * (mid - bef);
                if (have < n) {
                    ans = mid;
                    len = have;
                    st = mid + 1;
                } else
                    en = mid - 1;
            }
            String s = Long.toString(ans + 1);
            for (int i = 0; i < s.length(); i++) {
                if (len + i + 1 == n) {
                    out.print(s.charAt(i));
                    return;
                }
            }
        }

    }
}

