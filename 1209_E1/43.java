import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main2 {

    static long mod = 998244353;
    static FastScanner scanner;

    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
            result.append("\n");
        }
        System.out.print(result.toString());
    }



    static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        PriorityQueue<WithIdx2> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                queue.add(new WithIdx2(scanner.nextInt(), i, j));
            }
        }

        if (n <= 3) {
            int res = 0;
            for (int k = 0; k < n; k++) {
                res += queue.poll().val;
            }
            result.append(res);
        } else {

            List<WithIdx2> a = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                if (!queue.isEmpty()) a.add(queue.poll());
            }
            int[] offsets = new int[m];
            best = -1;
            Arrays.fill(offsets, -100);
            put(0, a, offsets, new int[4]);
            result.append(best);
        }
    }

    static int best = -1;

    static void put(int current, List<WithIdx2> vals, int[] offsets, int[] rows) {
        if (current == vals.size()) {
            for (int i = 0; i < rows.length; i++) if (rows[i] == 0) return;
            int sum = IntStream.of(rows).sum();
            best = Math.max(best, sum);
            return;
        }
        for (int row = 0; row < 4; row++) {
            if (rows[row] == 0) {
                WithIdx2 c = vals.get(current);
                if (offsets[c.y] == -100) {
                    rows[row] = c.val;
                    offsets[c.y] = row - c.x;
                    put(current + 1, vals, offsets, rows);
                    rows[row] = 0;
                    offsets[c.y] = -100;
                } else {
                    int bind = c.x + offsets[c.y];
                    if (bind < 0) bind += 4;
                    if (bind >= 4) bind -= 4;
                    if (row == bind) {
                        rows[row] = c.val;
                        put(current + 1, vals, offsets, rows);
                        rows[row] = 0;
                    }
                }
            }
        }
        put(current + 1, vals, offsets, rows);
    }

    static class WithIdx2 implements Comparable<WithIdx2>{
        int x, y, val;

        public WithIdx2(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(WithIdx2 o) {
            return -Integer.compare(val, o.val);
        }
    }



    static class WithIdx implements Comparable<WithIdx>{
        int val, idx;

        public WithIdx(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(WithIdx o) {
            return Integer.compare(val, o.val);
        }
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        int[] nextIntArray(int n) {
            int[] res = new int[n];
            for (int i = 0; i < n; i++) res[i] = nextInt();
            return res;
        }

        long[] nextLongArray(int n) {
            long[] res = new long[n];
            for (int i = 0; i < n; i++) res[i] = nextLong();
            return res;
        }

        String[] nextStringArray(int n) {
            String[] res = new String[n];
            for (int i = 0; i < n; i++) res[i] = nextToken();
            return res;
        }
    }

    static class PrefixSums {
        long[] sums;

        public PrefixSums(long[] sums) {
            this.sums = sums;
        }

        public long sum(int fromInclusive, int toExclusive) {
            if (fromInclusive > toExclusive) throw new IllegalArgumentException("Wrong value");
            return sums[toExclusive] - sums[fromInclusive];
        }

        public static PrefixSums of(int[] ar) {
            long[] sums = new long[ar.length + 1];
            for (int i = 1; i <= ar.length; i++) {
                sums[i] = sums[i - 1] + ar[i - 1];
            }
            return new PrefixSums(sums);
        }

        public static PrefixSums of(long[] ar) {
            long[] sums = new long[ar.length + 1];
            for (int i = 1; i <= ar.length; i++) {
                sums[i] = sums[i - 1] + ar[i - 1];
            }
            return new PrefixSums(sums);
        }
    }

    static class ADUtils {
        static void sort(int[] ar) {
            Random rnd = ThreadLocalRandom.current();
            for (int i = ar.length - 1; i > 0; i--)
            {
                int index = rnd.nextInt(i + 1);
                // Simple swap
                int a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
            Arrays.sort(ar);
        }

        static void reverse(int[] arr) {
            int last = arr.length / 2;
            for (int i = 0; i < last; i++) {
                int tmp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = tmp;
            }
        }

        static void sort(long[] ar) {
            Random rnd = ThreadLocalRandom.current();
            for (int i = ar.length - 1; i > 0; i--)
            {
                int index = rnd.nextInt(i + 1);
                // Simple swap
                long a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
            Arrays.sort(ar);
        }
    }

    static class MathUtils {
        static long[] FIRST_PRIMES = {
                2,     3,      5,      7,     11,     13,     17,     19,     23,     29,
                31,     37,     41,     43,     47,     53,     59,     61,     67,     71,
                73,     79,     83,     89  ,   97 ,    101,    103,    107,    109,    113,
                127,    131,    137,    139,    149,    151,    157,    163,    167,    173,
                179,    181,    191,    193,    197,    199,    211,    223,    227,    229,
                233,    239,    241,    251,    257,    263,    269,    271,    277,    281,
                283,    293,    307,    311,    313,    317,    331,    337,    347,    349,
                353,    359,    367,    373,    379,    383,    389,    397,    401,    409,
                419,    421,    431,    433,    439,    443,    449,    457,    461,    463,
                467,    479,    487,    491,    499,    503,    509,    521,    523,    541,
                547,    557,    563,    569,    571,    577,    587,    593,    599,    601,
                607,    613,    617,    619,    631,    641,    643,    647,    653,    659,
                661,    673,    677,    683,    691,    701,    709,    719,    727,    733,
                739,    743,    751,    757,    761,    769,    773,    787,    797,    809,
                811,    821,    823,    827,    829,    839,    853,    857,    859,    863,
                877,    881,    883,    887,    907,    911,    919,    929,    937,    941,
                947,    953,    967,    971,    977,    983,    991,    997,   1009,   1013,
                1019,   1021,   1031,   1033,   1039,   1049,   1051};

        static long[] primes(int to) {
            long[] all = new long[to + 1];
            long[] primes = new long[to + 1];
            all[1] = 1;
            int primesLength = 0;
            for (int i = 2; i <= to; i ++) {
                if (all[i] == 0) {
                    primes[primesLength++] = i;
                    all[i] = i;
                }
                for (int j = 0; j < primesLength && i * primes[j] <= to && all[i] >= primes[j]; j++) {
                    all[(int) (i * primes[j])] = primes[j];
                }
            }
            return Arrays.copyOf(primes, primesLength);
        }

        static long modpow(long b, long e, long m) {
            long result = 1;

            while (e > 0) {
                if ((e & 1) == 1) {
                    /* multiply in this bit's contribution while using modulus to keep
                     * result small */
                    result = (result * b) % m;
                }
                b = (b * b) % m;
                e >>= 1;
            }

            return result;
        }

        static long submod(long x, long y, long m) {
            return (x - y + m) % m;
        }
    }
}

/*
1
4 2
5 7 6 2 2 5 3 6
 */