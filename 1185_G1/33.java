import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;

public class Main2 {

    static int mod = 1000000007;
    static FastScanner scanner;


    public static void main(String[] args) {
        scanner = new FastScanner();
        int n = scanner.nextInt();
        int T = scanner.nextInt();

        int[][] songs = new int[n][2];
        for (int i = 0; i < n; i++) {
            songs[i][0] = scanner.nextInt();
            songs[i][1] = scanner.nextInt() - 1;
        }

        int[] mapping = new int[65536];
        int mask = 1;
        for (int k = 0; k < n; k++) {
            for (int i = 1; i < mapping.length; i++) {
                if ((i & mask) != 0) mapping[i] += songs[k][0];
            }
            mask <<= 1;
        }

        int[][][] dp = new int[17][65536][3];
        mask = 1;

        for (int i = 0; i < n; i++) {
            dp[1][mask][songs[i][1]] = 1;
            mask <<= 1;
        }

        for (int i = 1; i < n; i++) {
            mask = 1;
            for (int k = 0; k < n; k++) {
                int cg = songs[k][1];

                int g1,g2;
                if (cg == 0) {g1 = 1; g2 = 2;}
                else if (cg == 1) {g1 = 0; g2 = 2;}
                else {g1 = 0; g2 = 1;}

                for (int j = 1; j < 65536; j++) {
                    if ((j & mask) != 0) continue;
                    dp[i + 1][j | mask][cg] = (dp[i + 1][j | mask][cg] + (dp[i][j][g1] + dp[i][j][g2]) % mod) % mod;
                }
                mask <<= 1;
            }
        }
        int res = 0;
        for (int k = 0; k < 17; k++)
        for (int i = 1; i < 65536; i++) {
            if (mapping[i] == T) res = (res + dp[k][i][0] + dp[k][i][1] + dp[k][i][2]) % mod;
        }
        System.out.println(res);
    }

    static long test(long[] b, long c, int maxSkipped, int startWith) {
        int skipped = 0;
        long lastSkipped = b[0];
        for (int i = startWith; i < b.length; i++) {
            long expected = b[0] + c * (i - skipped);
            if (b[i] != expected) {
                skipped++;
                lastSkipped = b[i];
                if (skipped > maxSkipped) {
                    return Long.MAX_VALUE;
                }
            }
        }
        return lastSkipped;
    }

    static boolean test2(long[] b, long c) {
        for (int i = 1; i < b.length; i++) {
            long expected = b[1] + c * (i - 1);
            if (b[i] != expected) {
                return false;
            }
        }
        return true;
    }

//    5 5
//    1 1 5 2 3


    static class WithIdx implements Comparable<WithIdx> {
        int val;
        int idx;

        public WithIdx(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(WithIdx o) {
            if (val == o.val) {
                return Integer.compare(idx, o.idx);
            }
            return -Integer.compare(val, o.val);
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
