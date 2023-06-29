import java.util.*;
public class Main {
    public static class Pair implements Comparable<Pair> {
        int k, x;
        public Pair(int k) {
            this.k = k;
        }
        public void update(int x) {
            this.x = Math.max(this.x, x);
        }
        public int compareTo(Pair other) {
            if (x != other.x) {
                return other.x - x;
            }
            return k - other.k;
        }
    }
    public static int sum(int[] arr) {
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return sum;
    }
    public static int[] join(int[] a, int[] b) {
        int n = a.length;
        int[] best = new int[n];
        int sum = 0;
        for (int shift = 0; shift < n; shift++) {
            int[] curr = new int[n];
            for (int i = 0; i < n; i++) {
                curr[i] = Math.max(a[i], b[(i + shift) % n]);
            }
            int now = sum(curr);
            if (now > sum) {
                sum = now;
                best = curr;
            }
        }
        return best;
    }
    public static int n;
    public static int[] pow;
    public static int[][] dp, real;
    public static void calc(int mask) {
        int[] best = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & pow[i]) != 0) {
                int to = mask ^ pow[i];
                int[] init = new int[n];
                for (int j = 0; j < n; j++) {
                    init[j] = real[j][i];
                }
                int[] curr = join(dp[to], init);
                int s = sum(curr);
                if (s > sum) {
                    sum = s;
                    best = curr;
                }
            }
        }
        dp[mask] = best;
    }
    public static void main(String[] args) {
        pow = new int[15];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = pow[i - 1] * 2;
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            n = in.nextInt();
            int m = in.nextInt();
            int[][] arr = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[j][k] = in.nextInt();
                }
            }
            Pair[] best = new Pair[m];
            for (int j = 0; j < m; j++) {
                best[j] = new Pair(j);
                for (int k = 0; k < n; k++) {
                    best[j].update(arr[k][j]);
                }
            }
            Arrays.sort(best);
            real = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < Math.min(n, m); k++) {
                    real[j][k] = arr[j][best[k].k];
                }
            }
            dp = new int[1 << n][];
            Stack<Integer>[] min = new Stack[n + 1];
            for (int j = 0; j <= n; j++) {
                min[j] = new Stack<>();
            }
            for (int j = 0; j < dp.length; j++) {
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if ((j & pow[k]) != 0) {
                        cnt++;
                    }
                }
                min[cnt].add(j);
            }
            for (int j = 0; j < min.length; j++) {
                for (int x : min[j]) {
                    if (j == 0) {
                        dp[x] = new int[n];
                    } else {
                        calc(x);
                    }
                }
            }
            System.out.println(sum(dp[dp.length - 1]));
        }
    }
}