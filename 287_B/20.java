import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class B176 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        long n = in.nextLong() - 1;
        long k = in.nextLong() - 1;
        if (k * (k + 1) / 2 < n) out.println(-1);
        else if (n == 0) out.println(0);
        else if (n < k) out.println(1);
        else {
            long t = binSearch(n, k, 1, k);
            long ans = k - t + 1;
            if (k * (k + 1) / 2 - t * (t - 1) / 2 != n) ans++;
            out.println(ans);
        }
        out.close();
    }

    private static long binSearch(long n, long k, long from, long to) {
        if (from == to) return from;
        long mid = (from + to) / 2;
        if (k * (k + 1) / 2 - mid * (mid - 1) / 2 > n) return binSearch(n, k, mid + 1, to);
        else return binSearch(n, k, from, mid);
    }
}
