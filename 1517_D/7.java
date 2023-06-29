import java.io.*;
import java.util.*;

public final class Solution {


    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();
    static long mod = (long) 1e9 + 7;
    static Pair[] moves = new Pair[]{new Pair(-1, 0), new Pair(1, 0), new Pair(0, -1), new Pair(0, 1)};

    //6 3
    //2 3 10 7 5 14
    //1 6
    //2 4
    //3 5

    public static void main(String[] args) {

        int n = i();
        int m = i();
        int k = i();

        int[][] a = new int[n][m - 1];
        for (int i = 0; i < n; i++) {
            a[i] = input(m - 1);
        }

        int[][] b = new int[n - 1][m];
        for (int i = 0; i < n - 1; i++) {
            b[i] = input(m);
        }

        if (k % 2 > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    out.print(-1 + " ");
                }
                out.println();
            }
            out.flush();
            return;
        }

        int[][][] f = new int[n][m][k / 2 + 1];

        for (int s = 1; s <= k / 2; s++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int ans = -1;

                    if (j > 0) {
                        ans = f[i][j - 1][s - 1] + a[i][j - 1];
                    }
                    if (i > 0) {
                        int t = f[i - 1][j][s - 1] + b[i - 1][j];
                        ans = ans == -1 ? t : Math.min(ans, t);
                    }
                    if (i < n - 1) {
                        int t = f[i + 1][j][s - 1] + b[i][j];
                        ans = ans == -1 ? t : Math.min(ans, t);
                    }
                    if (j < m - 1) {
                        int t = f[i][j + 1][s - 1] + a[i][j];
                        ans = ans == -1 ? t : Math.min(ans, t);
                    }

                    f[i][j][s] = ans;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(f[i][j][k / 2] * 2 + " ");
            }
            out.println();
        }
        out.flush();
    }

    static int sd(long i) {
        int d = 0;
        while (i > 0) {
            d += i % 10;
            i = i / 10;
        }
        return d;
    }

    static Set<Integer> getFactors(int x) {
        Set<Integer> res = new HashSet<>();

        if (x <= 3) {
            res.add(x);
        } else {
            int t = x;
            for (int f = 2; f <= x / 2; f++) {
                if (t == 1) {
                    break;
                }
                if (t % f == 0) {
                    res.add(f);
                    while (t % f == 0) {
                        t = t / f;
                    }
                }
            }

            if (t > 1) {
                res.add(t);
            }
        }
        return res;
    }


    static int lower(long A[], long x) {
        int l = -1, r = A.length;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (A[m] >= x) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    static int upper(long A[], long x) {
        int l = -1, r = A.length;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (A[m] <= x) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    static void swap(int A[], int a, int b) {
        int t = A[a];
        A[a] = A[b];
        A[b] = t;
    }

    static int lowerBound(int A[], int low, int high, int x) {
        if (low > high) {
            if (x >= A[high]) {
                return A[high];
            }
        }

        int mid = (low + high) / 2;

        if (A[mid] == x) {
            return A[mid];
        }

        if (mid > 0 && A[mid - 1] <= x && x < A[mid]) {
            return A[mid - 1];
        }

        if (x < A[mid]) {
            return lowerBound(A, low, mid - 1, x);
        }

        return lowerBound(A, mid + 1, high, x);
    }


    static long pow(long a, long b) {
        long pow = 1;
        long x = a;
        while (b != 0) {
            if ((b & 1) != 0) {
                pow = (pow * x) % mod;
            }
            x = (x * x) % mod;
            b /= 2;
        }
        return pow;
    }

    static boolean isPrime(long N) {
        if (N <= 1) {
            return false;
        }
        if (N <= 3) {
            return true;
        }
        if (N % 2 == 0 || N % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= N; i = i + 6) {
            if (N % i == 0 || N % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    static void print(char A[]) {
        for (char c : A) {
            out.print(c);
        }
        out.println();
    }

    static void print(boolean A[]) {
        for (boolean c : A) {
            out.print(c + " ");
        }
        out.println();
    }

    static void print(int A[]) {
        for (int c : A) {
            out.print(c + " ");
        }
        out.println();
    }

    static void print(long A[]) {
        for (long i : A) {
            out.print(i + " ");
        }
        out.println();

    }

    static void print(List<Integer> A) {
        for (int a : A) {
            out.print(a + " ");
        }
    }

    static int i() {
        return in.nextInt();
    }

    static long l() {
        return in.nextLong();
    }

    static String s() {
        return in.nextLine();
    }

    static int[] input(int N) {
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }
        return A;
    }

    static long[] inputLong(int N) {
        long A[] = new long[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = in.nextLong();
        }
        return A;
    }

    static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }

    static long GCD(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }

}

class SegmentTree {

    long[] t;

    public SegmentTree(int n) {
        t = new long[n + n];
        Arrays.fill(t, Long.MIN_VALUE);
    }

    public long get(int i) {
        return t[i + t.length / 2];
    }

    public void add(int i, long value) {
        i += t.length / 2;
        t[i] = value;
        for (; i > 1; i >>= 1) {
            t[i >> 1] = Math.max(t[i], t[i ^ 1]);
        }
    }

    // max[a, b]
    public long max(int a, int b) {
        long res = Long.MIN_VALUE;
        for (a += t.length / 2, b += t.length / 2; a <= b; a = (a + 1) >> 1, b = (b - 1) >> 1) {
            if ((a & 1) != 0) {
                res = Math.max(res, t[a]);
            }
            if ((b & 1) == 0) {
                res = Math.max(res, t[b]);
            }
        }
        return res;
    }
}

class Pair {

    int i, j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }


}
