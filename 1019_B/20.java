import java.io.*;
import java.util.*;

public class Main {

    private static final long MOD = 998244353;

    static int[] readArray(int size, InputReader in, boolean subOne) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = in.nextInt() + (subOne ? -1 : 0);
        }
        return a;
    }

    static long[] readLongArray(int size, InputReader in) {
        long[] a = new long[size];
        for (int i = 0; i < size; i++) {
            a[i] = in.nextLong();
        }
        return a;
    }

    static void sortArray(int[] a) {
        Random random = new Random();

        for (int i = 0; i < a.length; i++) {
            int randomPos = random.nextInt(a.length);
            int t = a[i];
            a[i] = a[randomPos];
            a[randomPos] = t;
        }
        Arrays.sort(a);
    }


    public static void main(String[] args) throws FileNotFoundException {
//        InputReader in = new InputReader(new FileInputStream("input.txt"));
//        PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("milkvisits.out")));
//
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = in.nextInt();
        if (n / 2 % 2 != 0) {
            out.println("! -1");
            out.flush();
            out.close();
            return;
        }

        int[] a = new int[n];
        Arrays.fill(a, Integer.MAX_VALUE);

        int l1 = 0;
        int r1 = l1 + n / 2;

        int l2 = r1;
        int r2 = n;

        int ans = -1;

        while (true) {
            getValue(in, out, a, l1);
            getValue(in, out, a, r1);

            getValue(in, out, a, l2);
            getValue(in, out, a, r2 % n);

            if (a[l1] == a[l2]) {
                ans = l1;
                break;
            }
            if (a[r1] == a[r2 % n]) {
                ans = r1;
                break;
            }

            int m1 = (l1 + r1) / 2;
            getValue(in, out, a, m1);

            int m2 = (l2 + r2) / 2;
            getValue(in, out, a, m2);

            if (a[m1] == a[m2]) {
                ans = m1;
                break;
            }

            if ((a[l1] <= a[m1] && a[l2] <= a[m2]) || (a[l1] >= a[m1] && a[l2] >= a[m2])) {
                if (a[l1] <= a[l2] && a[m1] >= a[m2]) {
                    r1 = m1;
                    r2 = m2;
                    continue;
                }

                if (a[l1] >= a[l2] && a[m1] <= a[m2]) {
                    r1 = m1;
                    r2 = m2;
                    continue;
                }
            }

            if (a[l1] <= a[m1] && a[l2] >= a[m2] && a[l1] <= a[l2] && a[m1] >= a[m2]){
                r1 = m1;
                r2 = m2;
                continue;
            }

            if (a[l1] >= a[m1] && a[l2] <= a[m2] && a[l1] >= a[l2] && a[m1] <= a[m2]){
                r1 = m1;
                r2 = m2;
                continue;
            }

            l1 = m1;
            l2 = m2;
        }
        out.println("! " + (ans + 1));

        out.close();
    }

    private static void getValue(InputReader in, PrintWriter out, int[] a, int l) {
        if (a[l] == Integer.MAX_VALUE) {
            out.println("? " + (l + 1));
            out.flush();
            a[l] = in.nextInt();
        }
    }


    private static boolean check(long x, long s, long a, List<Long> divA) {
        int ind = binSearchRight(divA, x, 0, divA.size());
        if (ind >= 0 && ind < divA.size()) {
            long y = a / divA.get(ind);
            return y <= s / x;
        }
        return false;
    }

    static int binSearchRight(List<Long> list, long key, int start, int end) {
        int l = start - 1;
        int r = end;
        while (l < r - 1) {
            int m = (l + r) / 2;
            if (list.get(m) <= key) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    private static void outputArray(int[] ans, PrintWriter out, boolean addOne) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            long an = ans[i] + (addOne ? 1 : 0);
            str.append(an).append(' ');
        }
        out.println(str);
    }

    private static void outputArray(List<Integer> ans, PrintWriter out, boolean addOne) {
        StringBuilder str = new StringBuilder();
        for (int j = 0; j < ans.size(); j++) {
            long i = ans.get(j);
            long an = i + (addOne ? 1 : 0);
            str.append(an);
            if (j < ans.size() - 1) {
                str.append(' ');
            }
        }
        out.println(str);
//        out.flush();
    }

    private static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextString() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
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

        public char nextChar() {
            return next().charAt(0);
        }

        public String nextWord() {
            return next();
        }

        private List<Integer>[] readTree(int n) {
            return readGraph(n, n - 1);
        }

        private List<Integer>[] readGraph(int n, int m) {
            List<Integer>[] result = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                result[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = nextInt() - 1;
                int v = nextInt() - 1;
                result[u].add(v);
                result[v].add(u);
            }
            return result;
        }

        private Map<Integer, Long>[] readWeightedGraph(int n, int m) {
            Map<Integer, Long>[] result = new HashMap[n];
            for (int i = 0; i < n; i++) {
                result[i] = new HashMap<>();
            }
            for (int i = 0; i < m; i++) {
                int u = nextInt() - 1;
                int v = nextInt() - 1;
                long w = nextLong();
                result[u].put(v, Math.min(w, result[u].getOrDefault(v, Long.MAX_VALUE)));
                result[v].put(u, Math.min(w, result[v].getOrDefault(u, Long.MAX_VALUE)));
            }
            return result;
        }

    }
}