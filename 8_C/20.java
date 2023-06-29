import java.util.Arrays;
import java.util.Scanner;

/**
 * @author vstepanov on 3/29/2017.
 */
public class Main {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            int bx = in.nextInt();
            int by = in.nextInt();
            int n = in.nextInt();
            int[][] xy = new int[n][2];
            int[] res = new int[1 << n];
            int[] last = new int[1 << n];
            for (int i = 0; i < n; i++) {
                xy[i] = new int[]{in.nextInt(), in.nextInt()};
            }
            int[] ds = new int[n];
            for (int i = 0; i < ds.length; i++) {
                ds[i] = time(xy[i][0], xy[i][1], bx, by);
            }
            int[][] d = new int[n][n];
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < d.length; j++) {
                    d[i][j] = time(xy[i][0], xy[i][1], xy[j][0], xy[j][1]);
                }
            }
            Arrays.fill(res, Integer.MAX_VALUE);
            res[0] = 0;
            for (int i = 0; i < (1 << n); i++) {
                for (int j = 0; j < n; j++) {
                    if ((i & mask(j)) != 0) {
                        if (res[i - mask(j)] + 2*ds[j] < res[i]) {
                            res[i] = res[i - mask(j)] + 2*ds[j];
                            last[i] = i - mask(j);
                        }
                        for (int k = j + 1; k < n; k++) {
                            if ((i & mask(k)) != 0) {
                                if (res[i - mask(k) - mask(j)] + ds[j] + ds[k] + d[j][k] < res[i]) {
                                    res[i] = res[i - mask(k) - mask(j)] + ds[j] + ds[k] + d[j][k];
                                    last[i] = i - mask(j) - mask(k);
                                }
                            }
                        }
                        break;
                    }
                }
            }

            int cur = (1 << n) - 1;
            System.out.println(res[cur]);
            int k = cur;
            while (k != 0) {
                System.out.print("0 ");
                int diff = k - last[k];
                for (int i = 0; i < n && diff != 0; i++) {
                    if (((diff >> i) & 1) != 0) {
                        System.out.print((i + 1) + " ");
                        diff -= (1 << i);
                    }
                }
                k = last[k];
            }
            System.out.println("0");
        }
    }

    static int mask(int i) {
        return 1 << i;
    }

    static int time(int x, int y, int x1, int y1) {
        return (x - x1)*(x - x1) + (y - y1)*(y - y1);
    }
}