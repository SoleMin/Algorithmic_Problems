import java.io.*;
import java.util.*;
import java.util.function.IntPredicate;

import static java.lang.Math.*;

public class Main {
    FastScanner in;
    PrintWriter out;

    static final String FILE = "";

    public static final int TEST = 0;

    class Interact {
        Rect a, b;

        public Interact(int x11, int y11, int x12, int y12, int x21, int y21, int x22, int y22) {
            a = new Rect(x11, y11, x12, y12);
            b = new Rect(x21, y21, x22, y22);
        }

        int query(int x1, int y1, int x2, int y2) {
            int ans = 0;
            if (x1 <= a.x1 && x2 >= a.x2 && y1 <= a.y1 && y2 >= a.y2)
                ans++;
            if (x1 <= b.x1 && x2 >= b.x2 && y1 <= b.y1 && y2 >= b.y2)
                ans++;
            return ans;
        }
    }
    Interact interact;

    class Rect {
        int x1, y1, x2, y2;

        public Rect() {
        }

        public Rect(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public String toString() {
            return x1 + " " + y1 + " " + x2 + " " + y2;
        }
    }

    int calls;

    int query(int x1, int y1, int x2, int y2, Rect rect) {
        calls++;
        if (calls >= 190)
            throw new RuntimeException();

        if (TEST == 0) {
            out.println("? " + x1 + " " + y1 + " " + x2 + " " + y2);
            out.flush();
            int ans = in.nextInt();
            if (x1 <= rect.x1 && x2 >= rect.x2 && y1 <= rect.y1 && y2 >= rect.y2)
                ans--;
            return ans;
        } else {
            int ans = interact.query(x1, y1, x2, y2);
            if (x1 <= rect.x1 && x2 >= rect.x2 && y1 <= rect.y1 && y2 >= rect.y2)
                ans--;
            return ans;
        }
    }

    static int binarySearchFirstTrue(IntPredicate predicate, int fromInclusive, int toInclusive) {
        int a = fromInclusive, b = toInclusive;
        while (a != b) {
            int la = a, lb = b;
            int mid = (a + b) / 2;
            if (predicate.test(mid))
                b = mid;
            else
                a = mid;
            if (la == a && lb == b) {
                if (predicate.test(a))
                    b = a;
                else
                    a = b;
            }
        }
        return a;
    }

    static int binarySearchLastTrue(IntPredicate predicate, int fromInclusive, int toInclusive) {
        int a = fromInclusive, b = toInclusive;
        while (a != b) {
            int la = a, lb = b;
            int mid = (a + b) / 2;
            if (predicate.test(mid))
                a = mid;
            else
                b = mid;
            if (la == a && lb == b) {
                if (predicate.test(b))
                    a = b;
                else
                    b = a;
            }
        }
        return a;
    }

    static Rect rect;

    void test() {
        Random random = new Random(13);
        for (int test = 0; test < 1000; test++) {

        }
    }

    void solve() {
        rect = new Rect();

        if (TEST == 0) {
            int n = in.nextInt();
            List<Rect> list = new ArrayList<>();
            for (int r = 0; r < 2; r++) {
                int x2 = binarySearchFirstTrue(i -> query(1, 1, i, n, rect) >= 1, 1, n);
                int x1 = binarySearchLastTrue(i -> query(i, 1, x2, n, rect) >= 1, 1, x2);
                int y2 = binarySearchFirstTrue(i -> query(x1, 1, x2, i, rect) >= 1, 1, n);
                int y1 = binarySearchLastTrue(i -> query(x1, i, x2, y2, rect) >= 1, 1, y2);
                rect = new Rect(x1, y1, x2, y2);
                list.add(rect);
            }
            out.println("! " + list.get(0) + " " + list.get(1));
            out.flush();
        } else {
            int n = in.nextInt();
            int x11 = in.nextInt(), y11 = in.nextInt(), x12 = in.nextInt(), y12 = in.nextInt();
            int x21 = in.nextInt(), y21 = in.nextInt(), x22 = in.nextInt(), y22 = in.nextInt();
            interact = new Interact(x11, y11, x12, y12, x21, y21, x22, y22);
            List<Rect> list = new ArrayList<>();
            for (int r = 0; r < 2; r++) {
                int x2 = binarySearchFirstTrue(i -> query(1, 1, i, n, rect) >= 1, 1, n);
                int x1 = binarySearchLastTrue(i -> query(i, 1, x2, n, rect) >= 1, 1, x2);
                int y2 = binarySearchFirstTrue(i -> query(x1, 1, x2, i, rect) >= 1, 1, n);
                int y1 = binarySearchLastTrue(i -> query(x1, i, x2, y2, rect) >= 1, 1, y2);
                rect = new Rect(x1, y1, x2, y2);
                list.add(rect);
            }
            out.println("! " + list.get(0) + " " + list.get(1));
            out.flush();
        }
    }

    public void run() {
        if (FILE.equals("")) {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
        } else {
            try {
                in = new FastScanner(new FileInputStream(FILE +
                        ".in"));
                out = new PrintWriter(new FileOutputStream(FILE +
                        ".out"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        solve();
        out.close();
    }

    public static void main(String[] args) {
        (new Main()).run();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }
    }

}