

import java.util.Scanner;

public class B {
    static int n;
    static double A;
    static int[] L;
    static int[] B;
    static double max = 0;

    public static void rec(int index, int k) {
        if (k < 0)
            return;
        if (index == n) {
            double prob = 0;
            for (int i = 0; i < (1 << n); i++) {
                double b = 0;
                double temp = 1.0;
                for (int j = 0; j < n; j++) {
                    if (L[j] > 100)
                        return;
                    if ((i & (1 << j)) == 0) {
                        b += B[j];
                        temp *= (100 - L[j]) / 100.0;
                    } else
                        temp *= L[j] / 100.0;
                }
                if (Integer.bitCount(i) * 2 <= n)
                    temp *= A / (A + b);
                prob += temp;

            }
            max = Math.max(max, prob);
            return;
        }
        L[index] += 10;
        rec(index, k - 1);
        L[index] -= 10;
        rec(index + 1, k);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int k = in.nextInt();
        A = in.nextDouble();
        B = new int[n];
        L = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = in.nextInt();
            L[i] = in.nextInt();
        }
        rec(0, k);
        System.out.println(max);
    }
}
