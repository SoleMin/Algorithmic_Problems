import java.io.*;
import java.util.*;

public class TaskE {

    static int[][] transpose(int[][] a, int n, int m) {
        int[][] t = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                t[j][i] = a[i][j];
            }
        }

        return t;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader(System.in);
//        FastReader in = new FastReader(new FileInputStream("input.txt"));
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));


        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] a = new int[n + 1][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = in.nextInt();
                    a[n][j] = Math.max(a[n][j], a[i][j]);
                }
            }

            a = transpose(a, n, m);

            Arrays.sort(a, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int max1 = 0;
                    for (int i = 0; i < o1.length; i++) {
                        max1 = Math.max(max1, o1[i]);
                    }

                    int max2 = 0;
                    for (int i = 0; i < o2.length; i++) {
                        max2 = Math.max(max2, o2[i]);
                    }

                    return max2 - max1;
                }
            });

            a = transpose(a, m, n);

            int[] dp = new int[1 << n];

            for (int i = 0; i < Math.min(n, m); i++) {
                int[] best = new int[1 << n];

                for (int j = 1; j < (1 << n); j++) {
                    for (int k = 0; k < n; k++) {
                        int sum = 0;
                        for (int l = 0; l < n; l++) {
                            if ((j & (1 << l)) != 0)
                                sum += a[(l + k) % n][i];
                        }
                        best[j] = Math.max(best[j], sum);
                    }
                }

                int[] dp1 = dp.clone();

                for (int j = 0; j < (1 << n); j++) {
                    for (int k = j; k > 0; k = (k - 1) & j) {
                        dp[j] = Math.max(dp[j], dp1[k ^ j] + best[k]);
                    }
                }
            }

            out.println(dp[(1 << n) - 1]);
        }





        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        Double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }
    }
}
