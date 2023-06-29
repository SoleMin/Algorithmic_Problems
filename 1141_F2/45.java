
import java.io.*;
import java.util.*;

public class Q3 {

    static class Pair {
        int a;
        int b;

        Pair(int p, int q) {
            a = p;
            b = q;
        }
    }

    public static void main(String[] args) {

        InputReader in = new InputReader();
        int N = in.nextInt();
        int arr[] = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = in.nextInt();

        HashMap<Integer, ArrayList<Pair>> name = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += arr[j];
                if (name.get(sum) == null)
                    name.put(sum, new ArrayList());

                name.get(sum).add(new Pair(i+1, j+1));
            }
        }

        HashSet<Pair> ans = new HashSet<>();

        for (ArrayList<Pair> n : name.values()) {
            Collections.sort(n, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if (Integer.compare(o1.b, o2.b) == 0)
                        return Integer.compare(o1.a, o2.a);
                    return Integer.compare(o1.b, o2.b);
                }
            });


            HashSet<Pair> temp = new HashSet<>();
            temp.add(n.get(0));
            int num = 1;
            int r = n.get(0).b;

            for (int i = 1; i < n.size(); i++) {

                if (n.get(i).a > r) {
                    num++;
                    r = n.get(i).b;
                    temp.add(n.get(i));
                }
            }


            if (num > ans.size())
                ans = temp;
        }

        System.out.println(ans.size());
        for (Pair val : ans)
            System.out.println(val.a + " " + val.b);


    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public int[] shuffle(int[] arr) {
            Random r = new Random();
            for (int i = 1, j; i < arr.length; i++) {
                j = r.nextInt(i);
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }
            return arr;
        }

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
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

        public char nextChar() {
            return next().charAt(0);
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

        public int[] nextIntArr(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = this.nextInt();
            }
            return arr;
        }

        public Integer[] nextIntegerArr(int n) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++)
                arr[i] = new Integer(this.nextInt());

            return arr;
        }

        public int[][] next2DIntArr(int n, int m) {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = this.nextInt();
                }
            }
            return arr;
        }

        public int[] nextSortedIntArr(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = this.nextInt();
            }
            Arrays.sort(arr);
            return arr;
        }

        public long[] nextLongArr(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = this.nextLong();
            }
            return arr;
        }

        public char[] nextCharArr(int n) {
            char[] arr = new char[n];
            for (int i = 0; i < n; i++) {
                arr[i] = this.nextChar();
            }
            return arr;
        }


        public static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        public static int[] uwiSieve(int n) {
            if (n <= 32) {
                int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
                for (int i = 0; i < primes.length; i++) {
                    if (n < primes[i]) {
                        return Arrays.copyOf(primes, i);
                    }
                }
                return primes;
            }

            int u = n + 32;
            double lu = Math.log(u);
            int[] ret = new int[(int) (u / lu + u / lu / lu * 1.5)];
            ret[0] = 2;
            int pos = 1;

            int[] isp = new int[(n + 1) / 32 / 2 + 1];
            int sup = (n + 1) / 32 / 2 + 1;

            int[] tprimes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
            for (int tp : tprimes) {
                ret[pos++] = tp;
                int[] ptn = new int[tp];
                for (int i = (tp - 3) / 2; i < tp << 5; i += tp)
                    ptn[i >> 5] |= 1 << (i & 31);
                for (int i = 0; i < tp; i++) {
                    for (int j = i; j < sup; j += tp)
                        isp[j] |= ptn[i];
                }
            }

            // 3,5,7
            // 2x+3=n
            int[] magic = {0, 1, 23, 2, 29, 24, 19, 3, 30, 27, 25, 11, 20, 8, 4, 13, 31, 22, 28, 18, 26, 10, 7, 12, 21, 17,
                    9, 6, 16, 5, 15, 14};
            int h = n / 2;
            for (int i = 0; i < sup; i++) {
                for (int j = ~isp[i]; j != 0; j &= j - 1) {
                    int pp = i << 5 | magic[(j & -j) * 0x076be629 >>> 27];
                    int p = 2 * pp + 3;
                    if (p > n)
                        break;
                    ret[pos++] = p;
                    for (int q = pp; q <= h; q += p)
                        isp[q >> 5] |= 1 << (q & 31);
                }
            }

            return Arrays.copyOf(ret, pos);
        }

        public static int[] radixSort(int[] f) {
            return radixSort(f, f.length);
        }

        public static int[] radixSort(int[] f, int n) {
            int[] to = new int[n];
            {
                int[] b = new int[65537];
                for (int i = 0; i < n; i++) b[1 + (f[i] & 0xffff)]++;
                for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
                for (int i = 0; i < n; i++) to[b[f[i] & 0xffff]++] = f[i];
                int[] d = f;
                f = to;
                to = d;
            }
            {
                int[] b = new int[65537];
                for (int i = 0; i < n; i++) b[1 + (f[i] >>> 16)]++;
                for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
                for (int i = 0; i < n; i++) to[b[f[i] >>> 16]++] = f[i];
                int[] d = f;
                f = to;
                to = d;
            }
            return f;
        }
    }

}


// for(Map.Entry<Integer,Integer> Test: map.entrySet()){
//            int Key=Test.getKey();
//            int val=Test.getValue();
//        }



