import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Code implements Runnable {

    public static void main(String[] args) throws IOException {
        new Thread(new Code()).start();
    }

    private void solve() throws IOException {
        int n = nextInt(), m = nextInt();
        if(n > m) {
            n ^= m;
            m ^= n;
            n ^= m;
        }

        int[][][] dp = new int[41][64][64];
        for(int i = 0; i < 41; ++i)
            for(int j = 0; j < 64; ++j)
                for(int k = 0; k < 64; ++k) dp[i][j][k] = Integer.MAX_VALUE / 2;

        for(int i = 0; i < 64; ++i) dp[0][0][i] = countBit(i);

        for(int i = 1; i <= m; ++i) {
            for(int cur = 0; cur < 64; ++cur) {
                for(int next = 0; next < 64; ++next) {
                    for(int prev = 0; prev < 64; ++prev) {
                        if(!isBad(prev, cur, next, n)) {
                            dp[i][cur][next] = min(dp[i][cur][next], dp[i - 1][prev][cur] + countBit(next));
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 64; ++i) ans = min(ans, dp[m][i][0]);

        writer.println(n * m - ans);
    }

    private boolean isBit(int bits, int pos) {
        return pos < 0 ? false : ((bits & (1 << pos)) != 0);
    }

    private boolean isBad(int prev, int cur, int next, int count) {
        for(int i = 0; i < count; ++i)
            if(!(isBit(cur, i - 1) || isBit(cur, i) || isBit(cur, i + 1) || isBit(prev, i) || isBit(next, i)))  return true;
        return false;
    }

    private int countBit(int bits) {
        int ans = 0;
        for(int i = 0; i < 6; ++i)  ans += (bits & (1 << i)) > 0 ? 1 : 0;
        return ans;
    }

    private class Pair<E extends Comparable, V extends Comparable> implements Comparable<Pair<E, V>> {
        public Pair(E first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair<E, V> obj) {
            if(first == obj.first)  return second.compareTo(obj.second);
            return first.compareTo(obj.first);
        }

        @Override
        public boolean equals(Object obj) {
            Pair other = (Pair)obj;
            return first.equals(other.first) && second.equals(other.second);
        }

        public E first;
        public V second;
    }

    @Override
    public void run() {
        try {
            if(in.equals(""))   reader = new BufferedReader(new InputStreamReader(System.in));
            else    reader = new BufferedReader(new FileReader(in));

            if(out.equals(""))  writer = new PrintWriter(new OutputStreamWriter(System.out));
            else    writer = new PrintWriter(new FileWriter(out));
            solve();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private float nextFloat() throws IOException {
        return Float.parseFloat(nextToken());
    }

    private String nextToken() throws IOException {
        while(st == null || !st.hasMoreTokens())    st = new StringTokenizer(reader.readLine());
        return st.nextToken();
    }

    private String in = "", out = "";
    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer st;
}