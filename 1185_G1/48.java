import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        G1PlaylistForPolycarpEasyVersion solver = new G1PlaylistForPolycarpEasyVersion();
        solver.solve(1, in, out);
        out.close();
    }

    static class G1PlaylistForPolycarpEasyVersion {
        static ArrayList<Integer> list;
        static int n;
        static int req;
        static int mod = (int) 1e9 + 7;
        static int[] dur;
        static int[] genre;
        static Integer[][][] memo;

        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            n = sc.nextInt();
            req = sc.nextInt();
            dur = new int[n];
            genre = new int[n];
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                dur[i] = sc.nextInt();
                genre[i] = sc.nextInt();
            }
            int ans = 0;
            memo = new Integer[1 << n][n + 1][4];
            for (int i = 0; i <= n; i++)
                ans += bf(0, 0, 0, i) % mod;
            pw.print(ans % mod);
        }

        private int bf(int idx, int msk, int before, int max) {
            if (idx == max) {
                int sum = 0;
                for (int x : list)
                    sum += x;
                if (sum == req)
                    return 1;
                return 0;
            }
            if (memo[msk][max][before] != null)
                return memo[msk][max][before] % mod;
            int toRet = 0;
            for (int i = 0; i < n; i++) {
                if (genre[i] != before && (msk & 1 << i) == 0) {
                    list.add(dur[i]);
                    toRet += bf(idx + 1, msk | 1 << i, genre[i], max);
                    toRet %= mod;
                    list.remove(list.size() - 1);
                }
            }
            return memo[msk][max][before] = (toRet % mod);
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

