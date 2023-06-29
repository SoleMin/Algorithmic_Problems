import java.io.*;
import java.util.*;

public class Main {

    static final int primeCount = 452;
    static final int[] prime = new int[primeCount];

    static void build_prime() {
        boolean[] notPrime = new boolean[3200];
        for (int i = 2; i < 3200; i++) {
            if (notPrime[i]) continue;
            for (int j = i * i; j < 3200; j += i) {
                notPrime[j] = true;
            }
        }

        int count = 0;
        for (int i = 2; i < 3200; i++) {
            if (notPrime[i]) continue;

            prime[count++] = i;
        }
    }

    private static void run(Reader in, PrintWriter out) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = getReal(in.nextInt());
        }

        int[] pre = new int[n];
        for (int i = 0; i < n; i++) pre[i] = -1;

        TreeMap<Integer, Integer> exist = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            Integer result = exist.get(a[i]);
            if (result != null) {
                pre[i] = result;
            }
            exist.put(a[i], i);
        }

        int[][] left = new int[m + 1][n];
        for (int i = 0; i <= m; i++) {
            int start = 0;
            PriorityQueue<Integer> inSame = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                if (pre[j] >= start) {
                    inSame.add(pre[j]);

                    if (inSame.size() > i) {
                        start = inSame.poll() + 1;
                    }
                }
                left[i][j] = start;
            }
        }

        int[][] dp = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= j; k++) {
                    if (left[k][i] == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[left[k][i] - 1][j - k] + 1);
                    }
                }
            }
        }

        out.println(dp[n - 1][m]);
    }

    static int getReal(int x) {
        int result = 1;
        for (int i = 0; i < primeCount; i++) {
            if (x % prime[i] == 0) {
                int count = 0;
                while (x % prime[i] == 0) {
                    count++;
                    x /= prime[i];
                }
                if (count % 2 == 1) {
                    result *= prime[i];
                }
            }
        }
        result *= x;
        return result;
    }

    public static void main(String[] args) throws IOException {
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        build_prime();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            run(in, out);
        }

        out.flush();
        in.close();
        out.close();
    }

    static class Reader {
        BufferedReader reader;
        StringTokenizer st;

        Reader(InputStreamReader stream) {
            reader = new BufferedReader(stream, 32768);
            st = null;
        }

        void close() throws IOException {
            reader.close();
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}