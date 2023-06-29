
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 111118315581
 *
 * @author pttrung
 */
public class C {

    static Point hand;
    static int n;
    static Point[] data;
    static int[] next;
    static int[] dp;
    static int[][] pre;

    public static void main(String[] args) {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        // System.out.println(1 << 24);
        hand = new Point(in.nextInt(), in.nextInt());
        n = in.nextInt();
        data = new Point[n];
        for (int i = 0; i < n; i++) {
            data[i] = new Point(in.nextInt(), in.nextInt());
        }
        pre = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pre[i][j] = distance(data[i], data[j]);
            }
        }


        next = new int[1 << n];
        dp = new int[1 << n];
        Arrays.fill(dp, -1);

        out.println(cal(0));


        int start = 0;

        do {
            int m = next[start];
            int val = m - start;
            out.print(0 + " ");
            for (int i = 0; i < n; i++) {
                if (((1 << i) & val) != 0) {
                    out.print((i + 1) + " ");
                }
            }
            // out.print(0 + " ")  ;
            start = m;
        } while (start != (1 << n) - 1);
        out.println(0);
        out.close();
    }

    public static int cal(int mask) {
        if ((1 << n) - 1 == mask) {
            //  System.out.println(mask);
            return 0;
        }
        if (dp[mask] != -1) {
            return dp[mask];
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (((1 << i) & mask) == 0) {
                int dist = distance(hand, data[i]);
              
                for (int j = i + 1; j < n; j++) {
                    if (((1 << j) & mask) == 0) {
                        //System.out.println(i + " " + j);
                        int temp = dist + distance(hand, data[j]) + pre[i][j] + cal(mask | (1 << i) | (1 << j));
                        //System.out.println(temp);
                        if (temp < result) {
                            result = temp;
                            next[mask] = (mask | (1 << i) | (1 << j));
                        }
                        
                    }
                }
             
                    int temp = 2 * dist + cal(mask | (1 << i));
                    if (temp < result) {
                        result = temp;
                        next[mask] = (mask | (1 << i));
                    }
             
                break;
            }

        }
        dp[mask] = result;
        return result;
    }

    static int distance(Point a, Point b) {
        int total = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
        return total;
    }

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    static class Scanner {

        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            // System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {

            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        public boolean endLine() {
            try {
                String next = br.readLine();
                while (next != null && next.trim().isEmpty()) {
                    next = br.readLine();
                }
                if (next == null) {
                    return true;
                }
                st = new StringTokenizer(next);
                return st.hasMoreTokens();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}
