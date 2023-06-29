import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br;
    public static long MOD = 1000000007;
    public static long tenFive = 100000;
    public static int INF = 100000;

    public static void print(Object x) {
        System.out.println(x + "");
    }
    public static void printArr(long[] x) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < x.length; i++) {
            s.append(x[i] + " ");
        }
        print(s);
    }
    public static void printArr(int[] x) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < x.length; i++) {
            s.append(x[i] + " ");
        }
        print(s);
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
    public static List<Integer> nextInts(int N) throws IOException {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            ret.add(nextInt());
        }
        return ret;
    }

    public static void solve(int a, int b, List<Integer> orig) {
        boolean swap = false;
        if (a > b) {
            swap = true;
            int tmp = a;
            a = b;
            b = tmp;
        }

        List<Integer> nums = new ArrayList<Integer>(orig);
        Collections.sort(nums);
        Collections.reverse(nums);

        Set<Integer> all = new HashSet<Integer>(nums);
        Set<Integer> done = new HashSet<Integer>();
        Set<Integer> inB = new HashSet<Integer>();
        for (int x : nums) {
            if (done.contains(x)) continue;
            if (all.contains(a - x) && !done.contains(a - x)) {
                done.add(x);
                done.add(a - x);
                //print(x + " " + (a - x));
            } else if (all.contains(b - x) && !done.contains(b - x)) {
                done.add(x);
                done.add(b - x);
                inB.add(x);
                inB.add(b - x);
            } else {
                print("NO");
                return;
            }
        }

        print("YES");
        List<Integer> out = new ArrayList<Integer>();
        for (int x : orig) {
            if (inB.contains(x) ^ swap) out.add(1);
            else out.add(0);
        }
        print(join(out, " "));
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = nextInt();
        int a = nextInt();
        int b = nextInt();
        List<Integer> nums = nextInts(n);
        solve(a, b, nums);
    }
}
