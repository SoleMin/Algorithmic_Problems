

import java.util.*;

public class B {

    static int[] loyality;
    static int[] level;
    static int mid;
    static int a, n;
    static double sol;

    public static void getMax(int idx, int rem) {
        if (idx == loyality.length) {
            double pos = 0;
            for (int i = 0; i < (1 << n); i++)
                pos += solve(i);
            sol = Math.max(sol, pos);
            return;
        }
        int cur = loyality[idx];
        int r = 0;
        while (r + cur <= 10 && r <= rem) {
            loyality[idx] = cur + r;
            getMax(idx + 1, rem - r);
            r++;
        }
        loyality[idx] = cur;
    }

    public static double solve(int mask) {
        int c = 0;
        int sum = 0;
        double b = 1;
        for (int i = 0; i < n; i++) {
            if (((1 << i) | mask) == mask) {
                c++;
                b *= (loyality[i] / 10.0);
            } else {
                sum += level[i];
                b *= (1 - (loyality[i] / 10.0));
            }
        }
        if (c >= mid)
            return b;
        return b * (a * 1.0) / (a + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();
        a = sc.nextInt();
        level = new int[n];
        loyality = new int[n];
        for (int i = 0; i < n; i++) {
            level[i] = sc.nextInt();
            loyality[i] = sc.nextInt() / 10;
        }
        mid = (n/2) +1;
        sol = 0;
        getMax(0, k);
        System.out.println(sol);
    }
}
