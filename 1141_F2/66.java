
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

public class Q6 {

    public static void main(String[] args) {
        InputReader s = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = 1;
//        t = s.nextInt();
        nexttest:
        while (t-- > 0) {
            int n = s.nextInt();
            int a[] = s.nextIntArray(n);

            HashMap<Integer, List<Pair>> sets = new HashMap<>();
            int pre[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                pre[i] = a[i - 1] + pre[i - 1];
            }

            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j++) {
                    final Integer key = pre[j] - pre[i - 1];
                    if (!sets.containsKey(key)) {
                        sets.put(key, new ArrayList<>());
                    }

                    sets.get(key).add(new Pair(i, j));
                }
            }
//            System.out.println(sets);
            int ans = 0;
            List<Pair> answer = new ArrayList<>();
            int[] ansNextPos = new int[1];
            boolean[] ansTaken = new boolean[1];
            for (List<Pair> intervals : sets.values()) {

                Collections.sort(intervals);
                int[] nextPos = new int[intervals.size()];
                boolean[] taken = new boolean[intervals.size()];

                int[] dp = new int[intervals.size()];
                dp[intervals.size() - 1] = 1;
                taken[intervals.size() - 1] = true;
                nextPos[intervals.size() - 1] = -1;

                for (int i = intervals.size() - 2; i >= 0; i--) {
                    dp[i] = dp[i + 1];
                    taken[i] = false;
                    nextPos[i] = i + 1;

                    int ll = i + 1;
                    int rr = intervals.size();

                    while (ll < rr) {
                        int mid = ll + rr;
                        mid /= 2;
                        if (intervals.get(mid).x > intervals.get(i).y) {
                            rr = mid;
                        } else {
                            ll = mid + 1;
                        }
                    }
                    if (ll < intervals.size()) {
                        if (dp[i] < 1 + dp[ll]) {
                            dp[i] = Math.max(dp[i], 1 + dp[ll]);
                            taken[i] = true;
                            nextPos[i] = ll;
                        }
                    }
                }

                if (dp[0] > ans) {
                    ans = dp[0];
                    answer = intervals;
                    ansNextPos = nextPos;
                    ansTaken = taken;
                }
            }


            out.println(ans);
            int cur = 0;
            while (cur != -1) {
                if (ansTaken[cur]) {
                    out.println(answer.get(cur));
                }
                cur = ansNextPos[cur];
            }
        }

        out.close();
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        @Override
        public String toString() {
            return x + " " + y;
        }

        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(final Pair o) {
            return this.x - o.x;
        }
    }

    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}


