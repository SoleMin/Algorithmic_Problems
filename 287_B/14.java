/**
 * Created with IntelliJ IDEA.
 * User: yuantian
 * Date: 3/24/13
 * Time: 2:18 AM
 * Copyright (c) 2013 All Right Reserved, http://github.com/tyuan73
 */

import java.util.*;

public class Pipeline {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();
        long k = in.nextLong();

        if (n == 1) {
            System.out.println(0);
            return;
        }
        if (k >= n) {
            System.out.println(1);
            return;
        }

        long total = (k + 2) * (k - 1) / 2 - (k - 2);
        if (total < n) {
            System.out.println(-1);
            return;
        }

        int i = 2, j = (int) k;
        while (i <= j) {
            int m = (i + j) / 2;
            total = (k + m) * (k - m + 1) / 2 - (k - m);
            if (total == n) {
                System.out.println(k - m + 1);
                return;
            }
            if (total < n)
                j = m - 1;
            else
                i = m + 1;
        }
        System.out.println(k-i+2);
    }
}
