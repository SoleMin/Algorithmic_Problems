/**
 * author: derrick20
 * created: 3/20/21 7:13 PM
 */
import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class E2_SquareFreeFast {
    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
//        generate();
        int T = sc.nextInt();
        int MAX = (int) 1e7;
        int[] canonical = new int[MAX + 1];
        canonical[1] = 1;
        for (int factor = 2; factor <= MAX; factor++) {
            if (canonical[factor] == 0) {
                for (int mult = factor; mult <= MAX; mult += factor) {
                    int prev = canonical[mult / factor];
                    if (prev % factor == 0) {
                        canonical[mult] = prev / factor;
                    } else {
                        canonical[mult] = prev * factor;
                    }
                }
            }
        }
        int[] last = new int[MAX + 1];
        while (T-->0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] a = new int[N + 1];
            int[][] dp = new int[2][K + 1];
            int[][] start = new int[2][K + 1];
            int ptr = 0;
            for (int i = 1; i <= N; i++) {
                int nxt = 1 ^ ptr;
                a[i] = canonical[sc.nextInt()];
                for (int k = 0; k <= K; k++) {
                    if (start[ptr][k] > last[a[i]]) {
                        // extend it for free (unique)
                        dp[nxt][k] = dp[ptr][k];
                        start[nxt][k] = start[ptr][k];
                    } else {
                        // start anew
                        dp[nxt][k] = dp[ptr][k] + 1;
                        start[nxt][k] = i;
                    }
                    // Use a change (only if existing segment)
                    if (i > 1 && k > 0 && start[ptr][k - 1] <= last[a[i]]) {
                        // if this cost beats the old cost, or if it has a later start point, it's better.
                        if (dp[ptr][k - 1] < dp[nxt][k] || (dp[ptr][k - 1] == dp[nxt][k] && start[ptr][k - 1] > start[nxt][k])) {
                            dp[nxt][k] = dp[ptr][k - 1];
                            start[nxt][k] = start[ptr][k - 1];
                        }
                    }
                }
//                System.out.println(Arrays.toString(start[nxt]));
//                System.out.println(Arrays.toString(dp[nxt]));
                last[a[i]] = i;
                ptr = nxt;
            }
            for (int v : a) {
                last[v] = 0;
            }
            // always allowed to waste initial changes by starting offset, so mono decr
            out.println(dp[ptr][K]);
        }
        out.close();
    }

    static class FastScanner {
        private int BS = 1 << 16;
        private char NC = (char) 0;
        private byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private BufferedInputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }

        public FastScanner(String s) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
            } catch (Exception e) {
                in = new BufferedInputStream(System.in, BS);
            }
        }

        char getChar() {
            while (bId == size) {
                try {
                    size = in.read(buf);
                } catch (Exception e) {
                    return NC;
                }
                if (size == -1) return NC;
                bId = 0;
            }
            return (char) buf[bId++];
        }

        int nextInt() {
            return (int) nextLong();
        }

        long nextLong() {
            cnt = 1;
            boolean neg = false;
            if (c == NC) c = getChar();
            for (; (c < '0' || c > '9'); c = getChar()) {
                if (c == '-') neg = true;
            }
            long res = 0;
            for (; c >= '0' && c <= '9'; c = getChar()) {
                res = (res << 3) + (res << 1) + c - '0';
                cnt *= 10;
            }
            return neg ? -res : res;
        }

        double nextDouble() {
            boolean neg = false;
            if (c == NC) c = getChar();
            for (; (c < '0' || c > '9'); c = getChar()) {
                if (c == '-') neg = true;
            }
            double cur = nextLong();
            if (c != '.') {
                return neg ? -cur : cur;
            } else {
                double frac = nextLong() / cnt;
                return neg ? -cur - frac : cur + frac;
            }
        }

        String next() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c > 32) {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        String nextLine() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c != '\n') {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        boolean hasNext() {
            if (c > 32) return true;
            while (true) {
                c = getChar();
                if (c == NC) return false;
                else if (c > 32) return true;
            }
        }
    }

    static void ASSERT(boolean assertion, String message) {
        if (!assertion) throw new AssertionError(message);
    }

    static void ASSERT(boolean assertion) {
        if (!assertion) throw new AssertionError();
    }
}