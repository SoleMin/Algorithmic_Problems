import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong() - 1, k = sc.nextLong() - 1;

        int a = 0;
        if ((k + 1) * k / 2 < n) {
            System.out.println(-1);
            return;
        }
        while (n > 0 && k > 0) {
            long min = go(n, k);
            a += (k - min + 1);
            n -= (k + min) * (k - min + 1) / 2;
            k = Math.min(min - 1, n);
        }

        if (n == 0)
            System.out.println(a);
        else
            System.out.println(-1);

    }

    static long go(long n, long k) {
        long low = 1, high = k;

        while (low + 1 < high) {
            long mid = (low + high) / 2;

            if ((k + mid) * (k - mid + 1) / 2 <= n) {
                high = mid;
            } else
                low = mid;

        }
        return high;
    }

}
