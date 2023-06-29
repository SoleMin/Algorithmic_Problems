import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

import static java.lang.Math.*;

public class Main {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    public static void main(String[] args) {
        new Main().run();
        // Sworn to fight and die
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int levtIndex, int rightIndex) {
        final int MAGIC_VALUE = 50;
        if (levtIndex < rightIndex) {
            if (rightIndex - levtIndex <= MAGIC_VALUE) {
                insertionSort(a, levtIndex, rightIndex);
            } else {
                int middleIndex = (levtIndex + rightIndex) / 2;
                mergeSort(a, levtIndex, middleIndex);
                mergeSort(a, middleIndex + 1, rightIndex);
                merge(a, levtIndex, middleIndex, rightIndex);
            }
        }
    }

    private static void merge(int[] a, int levtIndex, int middleIndex,
                              int rightIndex) {
        int length1 = middleIndex - levtIndex + 1;
        int length2 = rightIndex - middleIndex;
        int[] levtArray = new int[length1];
        int[] rightArray = new int[length2];
        System.arraycopy(a, levtIndex, levtArray, 0, length1);
        System.arraycopy(a, middleIndex + 1, rightArray, 0, length2);
        for (int k = levtIndex, i = 0, j = 0; k <= rightIndex; k++) {
            if (i == length1) {
                a[k] = rightArray[j++];
            } else if (j == length2) {
                a[k] = levtArray[i++];
            } else {
                a[k] = levtArray[i] <= rightArray[j] ? levtArray[i++]
                        : rightArray[j++];
            }
        }
    }

    private static void insertionSort(int[] a, int levtIndex, int rightIndex) {
        for (int i = levtIndex + 1; i <= rightIndex; i++) {
            int current = a[i];
            int j = i - 1;
            while (j >= levtIndex && a[j] > current) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = current;
        }
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }



    class LOL implements Comparable<LOL> {

        int x;
        int y;



        public LOL(int x, int y) {
            this.x = x;
            this.y = y;

        }

        @Override
        public int compareTo(LOL o) {

            return (x - o.x); // ---->
            //return o.x * o.y - x * y; // <----
        }

    }

    class LOL2 implements Comparable<LOL2> {

        int x;
        int y;
        int z;



        public LOL2(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(LOL2 o) {

            return (z - o.z); // ---->
            //return o.x * o.y - x * y; // <----
        }

    }

    class test implements Comparable<test> {

        long x;
        long y;



        public test(long x, long y) {
            this.x = x;
            this.y = y;

        }

        @Override
        public int compareTo(test o) {
            //int compareResult = Long.compare(y, o.y); // ---->

            //if (compareResult != 0) {
            //    return -compareResult;
            //}

            int compareResult = Long.compare(x, o.x);

            if (compareResult != 0) {
                return compareResult;
            }

            return Long.compare(y, o.y);

            //return o.x * o.y - x * y; // <----
        }

    }

    class data {
        String name;
        String city;

        data(String name, String city) {
            this.city = city;
            this.name = name;
        }
    }

    class Point {
        double x;
        double y;


        Point(double x, double y) {
            this.x = x;
            this.y = y;

        }

        double distance(Point temp) {
            return Math.sqrt((x - temp.x) * (x - temp.x) + (y - temp.y) * (y - temp.y));
        }

        double sqrDist(Point temp) {
            return ((x - temp.x) * (x - temp.x) + (y - temp.y) * (y - temp.y));
        }

        Point rotate(double alpha) {
            return new Point(x * cos(alpha) - y * sin(alpha), x * sin(alpha) + y * cos(alpha));
        }

        void sum(Point o) {
            x += o.x;
            y += o.y;
        }

        void scalarProduct(int alpha) {
            x *= alpha;
            y *= alpha;
        }

    }

    class Line {
        double a;
        double b;
        double c;

        Line(Point A, Point B) {
            a = B.y - A.y;
            b = A.x - B.x;
            c = -A.x * a - A.y * b;
        }
        Line(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

      Point intersection(Line o) {
            double det = a * o.b - b * o.a;
            double det1 = -c * o.b + b * o.c;
            double det2 = -a * o.c + c * o.a;
            return new Point(det1 / det, det2 / det);
        }
    }

 /*   class Plane {
        double a;
        double b;
        double c;
        double d;

        Plane (Point fir, Point sec, Point thi) {
            double del1 = (sec.y - fir.y) * (thi.z - fir.z) - (thi.y - fir.y) * (sec.z - fir.z);
            double del2 = (thi.x - fir.x) * (sec.z - fir.z) - (thi.z - fir.z) * (sec.x - fir.x);
            double del3 = (thi.y - fir.y) * (sec.x - fir.x) - (thi.x - fir.x) * (sec.y - fir.y);
            a = del1;
            b = del2;
            c = del3;
            d = -fir.x * del1 - fir.y * del2 - fir.z * del3;
        }

        double distance(Point point) {
            return abs(a * point.x + b * point.y + c * point.z + d) / sqrt(a * a + b * b + c * c);
        }


    } */

    class record implements Comparable<record> {
        String city;
        Long score;

        public record(String name, Long score) {
            this.city = name;
            this.score = score;
        }

        @Override
        public int compareTo(record o) {
            if (o.city.equals(city)) {
                return 0;
            }

            if (score.equals(o.score)) {
                return 1;
            }

            if (score > o.score) {
                return 666;
            } else {
                return -666;
            }

            //return Long.compare(score, o.score);

        }

    }

    public long gcd(long a, long b) {
        if (a == 0 || b == 0) return max(a, b);

        if (a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }

    boolean prime(long n) {
        if (n == 1) return false;
        for (int i = 2; i <= sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public int sum(long n) {
        int s = 0;

        while (n > 0) {
            s += (n % 10);
            n /= 10;
        }

        return s;

    }

 /*   public void simulation(int k) {
        long ans = 0;
        int start = 1;
        for (int i = 0; i < k; i++) {
            start *= 10;
        }
        for (int i = start/10; i < start; i++) {
            int locAns = 0;
            for (int j = start/10; j < start; j++) {
                if  (sum(i + j) == sum(i) + sum(j) ) {
                    ans += 1;
                    locAns += 1;
                } else {
                    //.println(i + "!!!" + j);
                }
            }
            //out.println(i + " " + locAns);
        }
        out.println(ans);
    }*/




    ArrayList<Integer> primes;
    boolean[] isPrime;

    public void getPrimes (int n) {
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
                if (1l * i * i <= n) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
    }




    public long binPowMod(long a, long b, long mod) {
        if (b == 0) {
            return 1 % mod;
        }

        if (b % 2 != 0) {
            return ((a % mod) * (binPowMod(a, b - 1, mod) % mod)) % mod;
        } else {
            long temp = binPowMod(a, b / 2, mod) % mod;
            long ans = (temp * temp) % mod;
            return ans;

        }
    }


    int type[];
    boolean vis[];

    HashMap<Integer, HashSet<Integer>> g;

    int componentNum[];

  /*  void dfs(int u, int numOfComponent) {
        vis[u] = true;
        componentNum[u] = numOfComponent;

        for (Integer v: g.get(u)) {
            if (!vis[v]) {
                dfs(v, numOfComponent);
            }
        }
    } */

    int p[];

    int find(int x) {
        if (x == p[x]) {
            return x;
        }

        return p[x] = find(p[x]);
    }

    boolean merge(int x, int y) {
        x = find(x);
        y = find(y);
        if (p[x] == p[y]) {
            return false;
        }
        p[y] = x;
        return true;
    }

    class Trajectory {
        double x0;
        double y0;
        double vx;
        double vy;


        Trajectory(double vx, double vy, double x0, double y0) {
            this.vx = vx;
            this.vy = vy;

            this.x0 = x0;
            this.y0 = y0;
        }

        double y (double x) {
            return y0 + (x - x0) * (vy / vx) - 5 * (x - x0) * (x - x0) / (vx * vx);
        }

        double der(double x) {
            return (vy / vx) - 10 * (x - x0) / (vx * vx);
        }


    }

    int s;
    int n;
    int m;
    boolean isVisited[][];
    char[][] maze;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    void dfs(int x, int y) {
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int currX = x + dx[i];
            int currY = y + dy[i];

            if (maze[currX][currY] == '.' && !isVisited[currX][currY]) {
                dfs(currX, currY);
            }

        }



    }




    public void solve() throws IOException {

        n = readInt();
        m = readInt();

        maze = new char[n + 2][m + 2];

        for (int i = 0; i < n + 2; i++) {
            maze[i][0] = '#';
            maze[i][m + 1] = '#';
        }

        for (int j = 0; j < m + 2; j++) {
            maze[0][j] = '#';
            maze[n + 1][j] = '#';
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                maze[i][j] = '.';
            }
        }

        int[][] dist = new int[n + 2][m + 2];

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        ArrayDeque<Integer> xValues = new ArrayDeque<Integer>();
        ArrayDeque<Integer> yValues = new ArrayDeque<Integer>();

        int k = readInt();
        for (int i = 0; i < k; i++) {
            int currX = readInt();
            int currY = readInt();
            xValues.add(currX);
            yValues.add(currY);
            dist[currX][currY] = 0;
        }



        while(!xValues.isEmpty()) {
            int x = xValues.poll();
            int y = yValues.poll();

            for (int i = 0; i < 4; i++) {
                int currX = x + dx[i];
                int currY = y + dy[i];

                if (maze[currX][currY] == '.' && dist[currX][currY] > dist[x][y] + 1) {
                    dist[currX][currY] = dist[x][y] + 1;
                    xValues.add(currX);
                    yValues.add(currY);
                }

            }

        }

        int maxDist = 0;
        int indexX = 0;
        int indexY = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dist[i][j] >= maxDist) {
                    maxDist = dist[i][j];
                    indexX = i;
                    indexY = j;
                }
            }
        }

        out.print(indexX + " " + indexY);





    }



}