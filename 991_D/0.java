//package albert.codeforces.bishwock991d;

import java.util.Scanner;

public class Solution {
    static int[][][] coords =
            {
                    {{0, 0}, {1, 0}, {1, -1}},
                    {{0, 0}, {1, 0}, {0, -1}},
                    {{0, -1}, {1, -1}, {1, 0}},
                    {{0, -1}, {1, -1}, {0, 0}}
            };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = new String[2];
        input[0] = scan.nextLine();
        input[1] = scan.nextLine();
        System.out.println(solve(input));

        /*String[] input = {"0XXX0",
                          "00000"};*/
    }

    static int solve(String[] input) {
        int n = input[0].length();
        int[][] dp = new int[n + 1][3];

        for (int i = 2; i <= n; i++) {
            int j = i - 1;
            if (coordsGood(j, coords[0], input)) {
                dp[i][0] = Math.max(dp[i][0], Math.max(dp[i - 2][0], dp[i - 1][1]) + 1);
            }
            if (coordsGood(j, coords[1], input)) {
                dp[i][0] = Math.max(dp[i][0], Math.max(dp[i - 2][0], dp[i - 1][2]) + 1);
            }
            if (coordsGood(j, coords[2], input)) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 2][0] + 1);
                dp[i][2] = dp[i - 2][0] + 1;
            }
            if (coordsGood(j, coords[3], input)) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 2][0] + 1);
                dp[i][1] = dp[i - 2][0] + 1;
            }
            dp[i][0] = Math.max(dp[i][0], dp[i - 1][0]);
        }
        int max = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
        return max;
    }

    static boolean coordsGood(int j, int[][] coords, String[] input) {
        boolean ans = true;
        for (int[] coord : coords) {
            ans = ans && (input[coord[0]].charAt(j + coord[1]) == '0');
        }
        return ans;
    }
}
