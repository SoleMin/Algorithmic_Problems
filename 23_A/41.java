
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Trung Pham
 */
public class A {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        String val = in.next();
        ArrayList<String> list = new ArrayList();
        for(int i = 0; i < val.length() ; i++){
            list.add(val.substring(i));
        }
        Collections.sort(list);
        int result = 0;
        for(int i = 1; i < list.size() ; i++){
            String other = list.get(i - 1);
            int temp = 0;
            for(int j = 0; j < list.get(i).length() && j < other.length() ; j++){
                if(other.charAt(j) == list.get(i).charAt(j)){
                    temp++;
                }else{
                    break;
                }
            }
            if(temp > result){
                result = temp;
            }
        }
        out.println(result);
        out.close();
    }

    public static int dist(int x0, int y0, int x1, int y1) {
        return (x0 - x1) * (x0 - x1) + (y0 - y1) * (y0 - y1);
    }

    public static boolean isRight(int a, int b, int c) {
        if (a == 0 || b == 0 || c == 0) {
            return false;
        }
        if (a == b + c) {
            return true;
        }
        if (b == a + c) {
            return true;
        }
        if (c == a + b) {
            return true;
        }
        return false;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
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

    static int pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        int val = pow(a, b / 2);
        if (b % 2 == 0) {

            return val * val;
        } else {
            return val * val * a;
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

    static Point add(Point a, Point b) {
        return new Point(a.x + b.x, a.y + b.y);
    }

    static double cross(Point a, Point b) {
        return a.x * b.y - a.y * b.x;
    }

    static class Point {

        int x, y;

        Point(int x, int y) {
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

        public Scanner() throws FileNotFoundException {
            //System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            //   br = new BufferedReader(new FileReader("input.txt"));
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