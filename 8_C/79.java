import java.util.Arrays;
import java.util.Scanner;

public class LookingForOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int bx = in.nextInt();
        int by = in.nextInt();
        in.nextLine();
        int n = in.nextInt();
        int[][] objects = new int[n][2];
        for (int i = 0; i < n; i++) {
            objects[i][0] = in.nextInt();
            objects[i][1] = in.nextInt();
        }

        int[] cs = new int[n];
        for (int i = 0; i < n; i++) {
            cs[i] = 2 * time(objects[i], new int[] { bx, by });
        }

        int[][] cd = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cd[j][i] = cd[i][j] = time(objects[i], new int[] { bx, by }) + time(objects[j], new int[] { bx, by }) + time(objects[i], objects[j]);
            }
        }

        int maxMask = 1 << n;
        int[] dp = new int[maxMask];
        int[] path = new int[maxMask];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int g = 1; g < maxMask; g++) {
            int min = Integer.MAX_VALUE;
            int minPath = 0;
            int h = 31;
            while ((g & (1 << h)) == 0)
                h--;
            h++;
            int l = 0;
            while ((g & (1 << l)) == 0)
                l++;
            if ((g & 1 << l) > 0) {
                int oneleft = g ^ (1 << l);
                int t = cs[l] + dp[oneleft];
                if (t < min) {
                    min = t;
                    minPath = oneleft;
                }
                for (int j = l + 1; j < h; j++) {
                    if ((oneleft & 1 << j) > 0) {
                        int twoleft = oneleft ^ (1 << j);
                        t = cd[l][j] + dp[twoleft];
                        if (t < min) {
                            min = t;
                            minPath = twoleft;
                        }
                    }
                }
            }
            dp[g] = min;
            path[g] = minPath;
        }

        System.out.println(dp[maxMask - 1]);

        int previous = maxMask - 1;
        int pathElt = path[previous];
        System.out.print("0 ");
        while (previous > 0) {
            int bits = previous - pathElt;
            int h = 31;
            while ((bits & (1 << h)) == 0)
                h--;
            int l = 0;
            while ((bits & (1 << l)) == 0)
                l++;
            String el = h == l ? "" + (h + 1) : (h + 1) + " " + (l + 1);
            System.out.print(el + " " + 0 + " ");
            previous = pathElt;
            pathElt = path[pathElt];
        }
        System.out.println();

    }

    static int time(int[] a, int[] b) {
        int x = b[0] - a[0];
        int y = b[1] - a[1];
        return x * x + y * y;
    }
}
