import java.util.Scanner;

public class D {
    static long[][][] dp;
    static int[][] hor, ver;
    static int n, m;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static boolean isValid (int row, int col) {
        return row >= 0 && col >= 0 && row < n && col < m;
    }

    public static void minCost (int row, int col, int k) {
        if (k == 0)
            return;
        if (k == 2) {
            long min = Long.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                if (isValid(row + dir[i][0], col + dir[i][1])) {
                    if ((row + dir[i][0]) == row) {
                        if ((col + dir[i][1]) > col) {
                            min = Math.min(min, hor[row][col]);
                        } else {
                            min = Math.min(min, hor[row][col - 1]);
                        }
                    } else {
                        if ((row + dir[i][0]) > row) {
                            min = Math.min(min, ver[row][col]);
                        } else {
                            min = Math.min(min, ver[row - 1][col]);
                        }
                    }
                }
            }
            dp[row][col][k] = 2 * min;
            return;
        }
        if (dp[row][col][k] != Long.MAX_VALUE)
            return;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (isValid(row + dir[i][0], col + dir[i][1])) {
                if (k >= 4) {
                    minCost(row + dir[i][0], col + dir[i][1], k - 2);
                    int edge = 0;
                    if ((row + dir[i][0]) == row) {
                        if ((col + dir[i][1]) > col) {
                            edge = hor[row][col];
                        } else {
                            edge = hor[row][col - 1];
                        }
                    } else {
                        if ((row + dir[i][0]) > row) {
                            edge = ver[row][col];
                        } else {
                            edge = ver[row - 1][col];
                        }
                    }
                    min = Math.min(min, 2 * edge + dp[row + dir[i][0]][col + dir[i][1]][k - 2]);
                }
            }
        }
        dp[row][col][k] = min;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        int k = input.nextInt();
        hor = new int[n][m - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                hor[i][j] = input.nextInt();
            }
        }
        ver = new int[n - 1][m];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                ver[i][j] = input.nextInt();
            }
        }
        if (k % 2 != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(-1 + " ");
                }
                System.out.println("");
            } 
        } else {
            dp = new long[n][m][k + 1];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    for (int x = 0; x <= k; x++) {
                        dp[i][j][x] = Long.MAX_VALUE;
                    }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    minCost(i, j, k);
                    System.out.print(dp[i][j][k] + " ");
                }
                System.out.println("");
            }
        }
        
        input.close();
    }
}
