
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskB {
    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static StringTokenizer str;
    static String SK;

    static String next() throws IOException {
        while ((str == null) || (!str.hasMoreTokens())) {
            SK = in.readLine();
            if (SK == null)
                return null;
            str = new StringTokenizer(SK);
        }
        return str.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) throws IOException {
        long n = nextLong();
        int k = nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        long sum = (((2 + (long) k)) * ((long) k - 1)) / 2 - ((long) k - 2);
        if (n > sum) {
            System.out.println(-1);
            return;
        } else if (n <= k) {
            System.out.println(1);
            return;
        }

        long cnt = 0;
        long sum2 = 0;
        int index = binSearch(2, k, k, n);

        sum2 = (((long) (index) + k) * (long) (k - index + 1)) / 2 - (long) (k - index);
        cnt = k - index + 1;
        if (sum2 == n) {
            System.out.println(cnt);
            return;
        }
        if (sum2 > n)
            for (int kk = index; kk <= k; kk++) {
                sum2 = (((long) (kk) + k) * (long) (k - kk + 1)) / 2 - (long) (k - kk);
                cnt--;
                if (sum2 <= n) {
                    System.out.println(cnt + 1);
                    return;
                }
            }
        else {
            for (int kk = index - 1; kk >= 2; kk--) {
                sum2 = (((long) (kk) + k) * (long) (k - kk + 1)) / 2 - (long) (k - kk);
                cnt++;
                if (sum2 >= n) {
                    System.out.println(cnt);
                    return;
                }
            }
        }
        System.out.println(-1);
        return;
    }

    static int binSearch(int l, int r, int k, long n) {
        while (true) {
            int mid = l + (r - l) / 2;
            long sum2 = (((long) (mid) + k) * (long) (k - mid + 1)) / 2 - (long) (k - mid);
            if (l >= r || sum2 == n) {
                return mid;
            } else if (sum2 > n) {
                l = mid + 1;
            } else if (sum2 < n) {
                r = mid;
            }
        }
    }
}