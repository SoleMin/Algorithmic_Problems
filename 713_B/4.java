import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br;
    public static long MOD = 1000000007;

    public static void print(Object x) {
        System.out.println(x + "");
    }
    public static String join(Collection<?> x, String space) {
        if (x.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Object elt : x) {
            if (first) first = false;
            else sb.append(space);
            sb.append(elt);
        }
        return sb.toString();
    }

    public static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            st = new StringTokenizer(line.trim());
        }
        return st.nextToken();
    }
    public static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public static long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    // Finds smallest rectangle containing something along 1 dimension.
    public static long[] search(long[] none, long[] some) throws IOException {
        long[] med = new long[4];
        for (int i = 0; i < 4; i++) {
            if (Math.abs(none[i] - some[i]) == 1) {
                return some;
            }
            med[i] = (none[i] + some[i]) / 2;
        }

        int ans = query(med);

        if (ans > 0) return search(none, med);
        else return search(med, some);
    }

    public static int query(long[] query) throws IOException {
        print("? " + arr(query));
        System.out.flush();

        int ans = nextInt();
        if (contains(query)) ans -= 1;

        return ans;
    }

    public static boolean contains(long[] search) {
        if (rect1 == null) return false;
        if (search[0] > rect1[0]) return false;
        if (search[1] > rect1[1]) return false;
        if (search[2] < rect1[2]) return false;
        if (search[3] < rect1[3]) return false;
        return true;
    }

    public static String arr(long[] x) {
        return x[0] + " " + x[1] + " " + x[2] + " " + x[3];
    }
    public static long[] find() throws IOException {
        long[] d0 = {1, 1, 1, 1};
        long[] some = {1, 1, n, n};
        if (query(d0) > 0) {
            return d0;
        }
//        print("   " + arr(some));
        long[] none = {1, 1, n, 1};
        if (query(none) > 0) some = none;
        else some = search(none, some);

//        print("   " + arr(some));
        none = new long[] {1, 1, 1, some[3]};
        if (query(none) > 0) some = none;
        else some = search(none, some);

//        print("   " + arr(some));
        none = new long[] {1, some[3], some[2], some[3]};
        if (query(none) > 0) some = none;
        else some = search(none, some);

//        print("   " + arr(some));
        none = new long[] {some[2], some[1], some[2], some[3]};
        if (query(none) > 0) some = none;
        else some = search(none, some);
        return some;
    }

    public static long[] rect1 = null;
    public static long[] rect2 = null;
    public static long n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = nextLong();

        rect1 = find();
        rect2 = find();
        print("! " + arr(rect1) + " "
                   + arr(rect2));
        System.out.flush();
    }
}
