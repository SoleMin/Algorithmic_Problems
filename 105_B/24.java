import java.awt.Point;
import java.util.Scanner;

public class p105b {
    static int[] b, l;
    static int n;
    static int A;
    static boolean[] masks;
    static double max;

    public static double work(int index, int k, int mask) {
        if (index == n) {
            if (Integer.bitCount(mask) * 2 <= n) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if (((1 << i) & mask) == 0) {
                        sum += b[i];
                    }
                }
                return (A * 1.0) / (A * 1.0 + sum);
            }
            return 1;
        }
        double max = 0;
        int to = Math.min(k, (100 - l[index]) / 10);

        for (int i = to; i >= 0; i--) {
            double loy = l[index] + i * 10;

            double b = ((100.0 - loy) / 100.0) * work(index + 1, k - i, mask);

            double a = (loy / 100.0)
                    * work(index + 1, k - i, (mask | (1 << index)));

            max = Math.max(max, a + b);
        }
        return max;
    }

    public static void rec(int index, int k) {
        if (k == -1)
            return;
        if (index == n) {
            double tot = 0;
            for (int i = 0; i < 1 << n; i++) {
                double temp = 1.0;
                int bb = 0;
                for (int j = 0; j < n; j++) {
                    if(l[j]>100)
                        return;
                    if (((1 << j) & i) != 0) {
                        temp *= (l[j] * 1.0 / 100.0);
                    } else {
                        bb += b[j];
                        temp *= ((100.0 - l[j]) / 100.0);
                    }
                }
                if (Integer.bitCount(i) * 2 <= n) {
                    temp *= (A * 1.0) / (A * 1.0 + bb);
                }
                tot += temp;
            }
            max = Math.max(max, tot);
            return;
        }
        l[index] += 10;
        rec(index, k - 1);
        l[index] -= 10;
        rec(index + 1, k);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int k = in.nextInt();

        A = in.nextInt();

        b = new int[n];
        l = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
            l[i] = in.nextInt();
        }
        masks = new boolean[1 << n];

        max = 0;
        rec(0, k);
        System.out.println(max);
    }
}

/*
 * 5 3 100 23 70 80 30 153 70 11 80 14 90
 */
