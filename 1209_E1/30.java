import java.util.*;
public class Main {
    public static int n, m;
    public static int[][] arr;
    public static class Item implements Comparable<Item> {
        int i, x;
        public Item(int i, int x) {
            this.i = i;
            this.x = x;
        }
        public int compareTo(Item other) {
            if (x == other.x) {
                return i - other.i;
            }
            return other.x - x;
        }
    }
    public static int calc(int[] cols, int k, String mask) {
        if (k == cols.length) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                int max = 0;
                for (int j = 0; j < cols.length; j++) {
                    int shift = mask.charAt(j) - '0';
                    max = Math.max(max, arr[(shift + i) % n][cols[j]]);
                }
                res += max;
            }
            return res;
        } else {
            int best = 0;
            for (int i = 0; i < n; i++) {
                best = Math.max(best, calc(cols, k + 1, mask + i));
            }
            return best;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            n = in.nextInt();
            m = in.nextInt();
            arr = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[j][k] = in.nextInt();
                }
            }
            Item[] max = new Item[m];
            for (int j = 0; j < m; j++) {
                max[j] = new Item(j, 0);
                for (int k = 0; k < n; k++) {
                    max[j].x = Math.max(max[j].x, arr[k][j]);
                }
            }
            Arrays.sort(max);
            int[] cols = new int[Math.min(n, m)];
            for (int j = 0; j < cols.length; j++) {
                cols[j] = max[j].i;
            }
            System.out.println(calc(cols, 0, ""));
        }
    }
}