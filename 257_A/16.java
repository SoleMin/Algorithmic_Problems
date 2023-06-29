//package A;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();
        Arrays.sort(a);
        
        int res = 0, p = n - 1;
        while (k < m && p >= 0) {
            ++res;
            k += a[p] - 1;
            --p;
        }
        if (k >= m)
            System.out.println(res);
        else
            System.out.println("-1");
    }
}
