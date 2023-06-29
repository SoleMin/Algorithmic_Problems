
import java.util.*;

public class Main {

    static Scanner cin = new Scanner(System.in);
    private int xs, ys, n;
    private int[] x, y;

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    class Item implements Comparable<Item> {

        int w, h, idx;

        Item(int w, int h, int idx) {
            this.w = w;
            this.h = h;
            this.idx = idx;
        }

        @Override
        public int compareTo(Item o) {
            if (this.w == o.w) {
                return this.h - o.h;
            }
            return this.w - o.w;
        }
    }

    private void run() throws Exception {
        xs = cin.nextInt();
        ys = cin.nextInt();
        n = cin.nextInt();
        x = new int[n + 1];
        y = new int[n + 1];
        for (int i = 0; i < n; i++) {
            x[i] = cin.nextInt();
            y[i] = cin.nextInt();
        }
        int[] res = new int[1 << n];
        Arrays.fill(res, Integer.MAX_VALUE);
        int[] ds = new int[n];
        for (int i = 0; i < n; i++) {
            ds[i] = (x[i] - xs) * (x[i] - xs) + (y[i] - ys) * (y[i] - ys);
        }
        int[][] d = new int[n + 1][n + 1];
        int[] tr = new int[1 << n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
            }
        }
        //----------------------
        res[0] = 0;
        for (int i = 1; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) != 0) {
                    if (res[i - (1 << j)] + 2 * ds[j] < res[i]) {
                        res[i] = res[i - (1 << j)] + 2 * ds[j];
                        tr[i] = i - (1 << j);
                    }
                    for (int k = j + 1; k < n; k++) {
                        if (((i >> k) & 1) != 0) {
                            if (res[i - (1 << j) - (1 << k)] + ds[k] + ds[j] + d[k][j] < res[i]) {
                                res[i] = res[i - (1 << j) - (1 << k)] + ds[k] + ds[j] + d[k][j];
                                tr[i] = i - (1 << j) - (1 << k);
                            }
                        }
                    }
                    break;
                }
            }
        }
        System.out.println(res[(1 << n) - 1]);
        int now = (1 << n) - 1;
        while (now != 0) {
            System.out.print("0 ");
            int dif = now - tr[now];
            for (int i = 0; i < n && dif != 0; i++) {
                if (((dif >> i) & 1) != 0) {
                    System.out.print((i + 1) + " ");
                    dif -= (1 << i);
                }
            }
            now=tr[now];
        }
        System.out.print("0");
    }
}
