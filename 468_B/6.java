
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 4 4
 * 1 5 3 4
 * 1 2
 * 1 3
 * 2 3
 * 3 3
 *
 *
 * @author pttrung
 */
public class A {

    public static long Mod = (long) (1e9 + 7);
    public static long[][] dp;

    public static void main(String[] args) throws FileNotFoundException {

        PrintWriter out = new PrintWriter(System.out);
        Scanner in = new Scanner();
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] data = new int[n];
        int[]u = new int[n];
        int[]s = new int[n];
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i = 0; i < n; i++){
            u[i] = i;
            data[i] = in.nextInt();
            map.put(data[i], i);
        }        
        boolean ok = true;
        boolean[]check = new boolean[n];
        for(int i = 0; i < n; i++){
            if(map.containsKey(a - data[i])){
                u[find(i, u)]= u[find(map.get(a- data[i]), u)];
                s[i] |= 1;
            }
            if(map.containsKey(b - data[i])){
                u[find(i, u)]= u[find(map.get(b- data[i]), u)];
                s[i] |= 2;
            }
            
        }
        int[]g = new int[n];
        Arrays.fill(g,3);
        for(int i = 0;  i< n; i++){
            if(s[i] == 0){
                ok = false;
                break;
            }
            g[find(i, u)] &= s[i];
            if(g[find(i,u)] == 0){
                ok = false;
                break;
            }
        }
        //System.out.println(Arrays.toString(g));
        if(ok){
            out.println("YES");
            for(int i = 0; i < n; i++){
                if((g[find(i,u)] & 1) == 0){
                    out.print(1 + " ");
                }else{
                    out.print(0 + " ");
                }
            }
        }else{
            out.println("NO");
        }

        out.close();
    }
    
    static int find(int index, int[]u){
        if(index != u[index]){
            return u[index] = find(u[index], u);
        }
        return index;
    }

    public static long pow(int a, int b, long mod) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        long v = pow(a, b / 2, mod);
        if (b % 2 == 0) {
            return (v * v) % mod;
        } else {
            return (((v * v) % mod) * a) % mod;
        }
    }

    public static int[][] powSquareMatrix(int[][] A, long p) {
        int[][] unit = new int[A.length][A.length];
        for (int i = 0; i < unit.length; i++) {
            unit[i][i] = 1;
        }
        if (p == 0) {
            return unit;
        }
        int[][] val = powSquareMatrix(A, p / 2);
        if (p % 2 == 0) {
            return mulMatrix(val, val);
        } else {
            return mulMatrix(A, mulMatrix(val, val));
        }

    }

    public static int[][] mulMatrix(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                long temp = 0;
                for (int k = 0; k < A[0].length; k++) {

                    temp += ((long) A[i][k] * B[k][j] % Mod);
                    temp %= Mod;
                }
                temp %= Mod;
                result[i][j] = (int) temp;
            }
        }

        return result;
    }

    public static boolean nextPer(int[] data) {
        int i = data.length - 1;
        while (i > 0 && data[i] < data[i - 1]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = data.length - 1;
        while (data[j] < data[i - 1]) {
            j--;
        }
        int temp = data[i - 1];
        data[i - 1] = data[j];
        data[j] = temp;
        Arrays.sort(data, i, data.length);
        return true;




    }

    static class FT {

        int[] data;

        FT(int n) {
            data = new int[n];
        }

        void update(int index, int val) {
            // System.out.println("UPDATE INDEX " + index);
            while (index < data.length) {
                data[index] += val;
                index += index & (-index);

                //    System.out.println("NEXT " +index);
            }
        }

        int get(int index) {
            //  System.out.println("GET INDEX " + index);
            int result = 0;
            while (index > 0) {
                result += data[index];
                index -= index & (-index);
                // System.out.println("BACK " + index);
            }
            return result;
        }
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    static long pow(long a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        long val = pow(a, b / 2);
        if (b % 2 == 0) {

            return val * val % Mod;
        } else {
            return (val * val % Mod) * a % Mod;
        }
    }

//    static Point intersect(Point a, Point b, Point c) {
//        double D = cross(a, b);
//        if (D != 0) {
//            return new Point(cross(c, b) / D, cross(a, c) / D);
//        }
//        return null;
//    }
//
//    static Point convert(Point a, double angle) {
//        double x = a.x * cos(angle) - a.y * sin(angle);
//        double y = a.x * sin(angle) + a.y * cos(angle);
//        return new Point(x, y);
//    }
    static Point minus(Point a, Point b) {
        return new Point(a.x - b.x, a.y - b.y);
    }
//
//    static Point add(Point a, Point b) {
//        return new Point(a.x + b.x, a.y + b.y);
//    }
//

    /**
     * Cross product ab*ac
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    static double cross(Point a, Point b, Point c) {
        Point ab = new Point(b.x - a.x, b.y - a.y);
        Point ac = new Point(c.x - a.x, c.y - a.y);
        return cross(ab, ac);
    }

    static double cross(Point a, Point b) {
        return a.x * b.y - a.y * b.x;
    }

    /**
     * Dot product ab*ac;
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    static long dot(Point a, Point b, Point c) {
        Point ab = new Point(b.x - a.x, b.y - a.y);
        Point ac = new Point(c.x - a.x, c.y - a.y);
        return dot(ab, ac);
    }

    static long dot(Point a, Point b) {
        long total = a.x * b.x;
        total += a.y * b.y;
        return total;
    }

    static double dist(Point a, Point b) {
        long total = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
        return Math.sqrt(total);
    }

    static long norm(Point a) {
        long result = a.x * a.x;
        result += a.y * a.y;
        return result;
    }

    static double dist(Point a, Point b, Point x, boolean isSegment) {
        double dist = cross(a, b, x) / dist(a, b);
        // System.out.println("DIST " + dist);

        if (isSegment) {
            Point ab = new Point(b.x - a.x, b.y - a.y);

            long dot1 = dot(a, b, x);
            long norm = norm(ab);
            double u = (double) dot1 / norm;
            if (u < 0) {
                return dist(a, x);
            }

            if (u > 1) {
                return dist(b, x);
            }
        }
        return Math.abs(dist);




    }

    static long squareDist(Point a, Point b) {
        long x = a.x - b.x;
        long y = a.y - b.y;
        return x * x + y * y;
    }

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" + "x=" + x + ", y=" + y + '}';
        }
    }

    static class Scanner {

        BufferedReader br;
        StringTokenizer st;

        public Scanner() throws FileNotFoundException {
            //System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            br = new BufferedReader(new InputStreamReader(System.in));
            //br = new BufferedReader(new FileReader(new File("A-large (2).in")));
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
