import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KeyboardPurchase {
    static final int INF = 1000000000;
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out, false);
        int N = in.nextInt(), M = in.nextInt();
        String str = in.next();
        int[][] count = new int[M][M];
        for (int i = 1; i < N; i++) {
            char c1 = str.charAt(i - 1), c2 = str.charAt(i);
            count[c1 - 'a'][c2 - 'a']++;
            count[c2 - 'a'][c1 - 'a']++;
        }
        int[] dp = new int[(1 << M)];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int mask = 1; mask < (1 << M); mask++) {
            int slow = 0;
            for (int i = 0; i < M; i++) {
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < M; j++) {
                        if ((mask & (1 << j)) == 0) {
                            slow += count[i][j];
                        }
                    }
                }
            }
            for (int i = 0; i < M; i++) {
                if ((mask & (1 << i)) != 0) {
                    dp[mask] = Math.min(dp[mask], slow + dp[mask ^ (1 << i)]);
                }
            }
        }
        out.println(dp[(1 << M) - 1]);
        out.close();
        System.exit(0);
    }
    static class InputReader {
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
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        public String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}