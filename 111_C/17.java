
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *
 * @author pttrung
 */
public class C {

    public static double Epsilon = 1e-6;
    public static long x, y, d;
    public static long MOD = 1000000007;
    public static int[][][] dp;
    public static int min, max, need;

    public static void main(String[] args) {

        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();
        min = Math.min(n, m);
        max = (m + n) - min;
        dp = new int[max][1 << min][1 << min];

        for (int[][] temp : dp) {
            for (int[] val : temp) {
                Arrays.fill(val, -1);
            }
        }
        need = (1 << min) - 1;
        //System.out.println(add + total);
        //  System.out.println(min + " " + max);

        out.println(cal(0, 0, 0));

        out.close();

    }

    public static int cal(int index, int last, int lastHold) {

        if (index == max) {
            return 0;
        }
        if (dp[index][lastHold][last] != -1) {
            return dp[index][lastHold][last];
        }
        int result = 0;

        for (int i = 0; i < 1 << min; i++) {
            if ((i | last) == need || (index == 0)) {
              //  System.out.println("PREV " + index + " " + i + " " + last + " " + lastHold);
              //  System.out.println("NEXT " + index + " " + i + " " + (i | lastHold) + " " + i);
                //   System.out.println(Integer.bitCount(i) + " " + i);

//                if (index == 3) {
//                    System.out.println(last + " " + i + " " + match(i, last) + " " + next);
//                }
                if(index + 1 == max && match(i,lastHold)!= need){
                    continue;
                }
                int temp = cal(index + 1, match(i,lastHold), i) + (min - Integer.bitCount(i));
                result = result < temp ? temp : result;

                //  break;
            }
        }
        dp[index][lastHold][last] = result;
        return result;
    }

    public static int match(int mask, int last) {
        int result = last;
        for (int i = 0; i < min; i++) {
            if (((1 << i) & mask) != 0) {
                int a = i - 1;
                int b = i + 1;
                result |= (1 << i);
                if (a >= 0) {
                    result |= (1 << a);
                }
                if (b < min) {
                    result |= (1 << b);
                }
            }
        }
        // System.out.println(mask + " " + result + " " + need);
        return result ;
    }

    public static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long val = pow(a, b / 2);
        if (b % 2 == 0) {
            return val * val % MOD;
        } else {
            return a * (val * val % MOD) % MOD;
        }
    }

    public static void extendEuclid(long a, long b) {
        if (b == 0) {
            x = 1;
            y = 0;
            d = a;
            return;
        }
        extendEuclid(b, a % b);
        long x1 = y;
        long y1 = x - (a / b) * y;
        x = x1;
        y = y1;

    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static class Line {

        double a, b, c;

        Line(double x1, double y1, double x2, double y2) {
            if (Math.abs(x1 - x2) < Epsilon && Math.abs(y1 - y2) < Epsilon) {
                throw new RuntimeException("Two point are the same");
            }
            a = y1 - y2;
            b = x2 - x1;
            c = -a * x1 - b * y1;
        }

        Line(Point x, Point y) {
            this(x.x, x.y, y.x, y.y);
        }

        public Line perpendicular(Point p) {
            return new Line(p, new Point(p.x + a, p.y + b));
        }

        public Point intersect(Line l) {
            double d = a * l.b - b * l.a;
            if (d == 0) {
                throw new RuntimeException("Two lines are parallel");
            }

            return new Point((l.c * b - c * l.b) / d, (l.a * c - l.c * a) / d);
        }
    }

    static void check(Point a, Point b, ArrayList<Point> p, Point[] rec, int index) {
        for (int i = 0; i < 4; i++) {
            int m = (i + index) % 4;
            int j = (i + 1 + index) % 4;
            Point k = intersect(minus(b, a), minus(rec[m], rec[j]), minus(rec[m], a));
            if (k.x >= 0 && k.x <= 1 && k.y >= 0 && k.y <= 1) {
                Point val = new Point(k.x * minus(b, a).x, k.x * minus(b, a).y);
                p.add(add(val, a));
                // System.out.println(a + " " + b + " " + rec[i] + " " + rec[j]);
                // System.out.println(add(val, a));
            }
        }
    }

    static Point intersect(Point a, Point b, Point c) {
        double D = cross(a, b);
        if (D != 0) {
            return new Point(cross(c, b) / D, cross(a, c) / D);
        }
        return null;
    }

    static Point convert(Point a, double angle) {
        double x = a.x * cos(angle) - a.y * sin(angle);
        double y = a.x * sin(angle) + a.y * cos(angle);
        return new Point(x, y);
    }

    static Point minus(Point a, Point b) {
        return new Point(a.x - b.x, a.y - b.y);
    }

    static Point add(Point a, Point b) {
        return new Point(a.x + b.x, a.y + b.y);
    }

    static double cross(Point a, Point b) {
        return a.x * b.y - a.y * b.x;
    }

    static class Point {

        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point: " + x + " " + y;
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
