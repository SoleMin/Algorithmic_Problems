import java.io.*;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br;
    PrintWriter pw;
    StringTokenizer st;
    long mod = (long) (1e9 + 7);

    public static void main(String[] args) {
        (new Main()).run();
    }

    void solve() throws IOException {
        int n = nextInt();
        boolean p[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            String s = nextToken();
            if (s.charAt(0) == 'f') p[i] = true;
        }
        long d[][] = new long[n][n];
        d[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (p[i - 1]) {
                d[i][0] = 0;
                for (int j = 1; j < n; j++) {
                    d[i][j] = d[i - 1][j - 1];
                }
            } else {
                long sum = 0;
                for (int j = n - 1; j >= 0; j--) {
                    sum += d[i - 1][j];
                    sum %= mod;
                    d[i][j] = sum;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += d[n - 1][i];
            sum %= mod;
        }
        pw.print(sum);
    }

    void run() {
        try {
//            br = new BufferedReader(new FileReader("divljak.in"));
//            pw = new PrintWriter(new BufferedWriter(new FileWriter("divljak.out")));
//            br = new BufferedReader(new FileReader("input.txt"));
//            pw = new PrintWriter(new FileWriter("output.txt"));
            br = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(new OutputStreamWriter(System.out));

            solve();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    class h {
        int ans;
        int last;

        public h() {
            last = -1;
            ans = 0;
        }
    }
}