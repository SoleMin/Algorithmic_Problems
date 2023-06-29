import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new Main().run(in, out);
        out.close();
    }

    public static long mod = 17352642619633L;

    void run(FastScanner in, PrintWriter out) {

        int N = in.nextInt();
        int K = in.nextInt();
        int mask = (1<<K)-1;

        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = in.nextInt();

        int[] p = new int[N];
        p[0] = a[0];
        for (int i = 1; i < N; i++) {
            p[i] = p[i-1]^a[i];
        }

        HashMap<Integer, Long> cnt = new HashMap<>();
        cnt.put(0, 1L);
        for (int i = 0; i < N; i++) {
            p[i] = Math.min(p[i], p[i]^mask);
            cnt.put(p[i], cnt.getOrDefault(p[i], 0L)+1);
        }

        long total = ((long)N)*(N+1)/2;

        for (long sameCount : cnt.values()) {
            // change half of them
            // number of bad pairs is choosing among the same values

            long p1 = sameCount/2 + (sameCount%2);
            long p2 = sameCount/2;

            total -= (p1*(p1-1))/2;
            total -= (p2*(p2-1))/2;

        }
        out.println(total);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
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
    }
}
