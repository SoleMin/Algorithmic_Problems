import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Task2 {

    public static void main(String[] args) throws IOException {

        new Task2().solve();

    }

    //ArrayList<Integer>[] g;

    int mod = 1000000007;

    PrintWriter out;

    int n;
    int m;
    //int[][] a = new int[1000][1000];


    //int cnt = 0;

    long base = (1L << 63);
    long P = 31;

    int[][] a;

    void solve() throws IOException {

        //Reader in = new Reader("in.txt");
        //out = new PrintWriter( new BufferedWriter(new FileWriter("output.txt")) );
        Reader in = new Reader();
        PrintWriter out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)) );

        //BufferedReader br = new BufferedReader( new FileReader("in.txt") );
        //BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int sx = in.nextInt();
        int sy = in.nextInt();

        int n = in.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {

            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }

        int[] dp = new int[1 << n];
        int[] p = new int[1 << n];

        int inf = 1000000000;

        Arrays.fill(dp, inf);
        dp[0] = 0;

        for (int mask = 0; mask < (1 << n) - 1; mask ++) {

            int k = -1;

            if (dp[mask] == inf)
                continue;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) == 0) {

                    k = i;
                    break;
                }
            }

            for (int i = k; i < n; i++) {

                if ((mask & (1 << i)) == 0) {

                    int val = dp[mask] + dist(sx, sy, x[i], y[i]) + dist(sx, sy, x[k], y[k]) + dist(x[i], y[i], x[k], y[k]);

                    if (val < dp[mask | (1 << i) | (1 << k)]) {

                        dp[mask | (1 << i) | (1 << k)] = val;
                        p[mask | (1 << i) | (1 << k)] = mask;
                    }
                }
            }

        }

        out.println(dp[(1 << n) - 1]);

        int cur = (1 << n) - 1;

        out.print(0+" ");

        while (cur != 0) {

            int prev = p[cur];

            for (int i = 0; i < n; i++) {

                if (((cur & (1 << i)) ^ (prev & (1 << i))) != 0)
                    out.print(i+1+" ");
            }


            out.print(0+" ");

            cur = prev;
        }

        out.flush();
        out.close();
    }

    int dist(int x1, int y1, int x2, int y2) {

        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }

    long gcd(long a, long b) {

        if (b == 0)
            return a;

        return gcd(b, a%b);

    }

    class Item {

        int a;
        int b;
        int c;

        Item(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }

    class Pair implements Comparable<Pair>{

        int a;
        int b;

        Pair(int a, int b) {

            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair p) {

            if (b < p.b)
                return 1;

            if (b > p.b)
                return -1;

            return 0;
        }

        //		@Override
        //		public boolean equals(Object o) {
        //			Pair p = (Pair) o;
        //			return a == p.a && b == p.b;
        //		}
        //
        //		@Override
        //		public int hashCode() {
        //			return Integer.valueOf(a).hashCode() + Integer.valueOf(b).hashCode();
        //		}

    }

    class Reader {

        BufferedReader  br;
        StringTokenizer tok;

        Reader(String file) throws IOException {
            br = new BufferedReader( new FileReader(file) );
        }

        Reader() throws IOException {
            br = new BufferedReader( new InputStreamReader(System.in) );
        }

        String next() throws IOException {

            while (tok == null || !tok.hasMoreElements())
                tok = new StringTokenizer(br.readLine());
            return tok.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException {
            return Integer.valueOf(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.valueOf(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.valueOf(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

    }

}