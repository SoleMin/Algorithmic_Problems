
//package A;

import java.util.Scanner;

public class Solution {
    Scanner in = new Scanner(System.in);
    void run() throws Exception {
        int tests = in.nextInt();
        while (tests > 0) {
            --tests;
            int a = in.nextInt();
            int b = in.nextInt();
            int res = 0;
            while (a > 0 && b > 0) {
                if (a >= b) {
                    res += a / b;
                    a %= b;
                }
                else {
                    res += b / a;
                    b %= a;
                }
            }
            System.out.println(res);
        }
    }
    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
