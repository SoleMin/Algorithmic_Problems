import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;



public class LittleGirlAndXor {
    static long L, R;
    static Long[][][][][] dp = new Long[64][2][2][2][2];
    public static long go(int index, int low1, int high1, int low2, int high2) {
        if (index == -1) {
            return 0;
        }
        if (dp[index][low1][high1][low2][high2] != null)
            return dp[index][low1][high1][low2][high2];
        int bit1 = (L & (1L << index)) == 0 ? 0 : 1;
        int bit2 = (R & (1L << index)) == 0 ? 0 : 1;
        long res = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int nl1 = low1, nh1 = high1, nl2 = low2, nh2 = high2;
                boolean can = true;
                if (low1 == 0) {
                    if (i == bit1) {
                        nl1 = 0;
                    } else if (i < bit1) {
                        can = false;
                    } else if (i > bit1) {
                        nl1 = 1;
                    }
                }
                if (high1 == 0) {
                    if (i == bit2) {
                        nh1 = 0;
                    } else if (i < bit2) {
                        nh1 = 1;
                    } else if (i > bit2) {
                        can = false;
                    }
                }
                if (low2 == 0) {
                    if (j == bit1) {
                        nl2 = 0;
                    } else if (j < bit1) {
                        can = false;
                    } else if (j > bit1) {
                        nl2 = 1;
                    }
                }
                if (high2 == 0) {
                    if (j == bit2) {
                        nh2 = 0;
                    } else if (j < bit2) {
                        nh2 = 1;
                    } else if (j > bit2) {
                        can = false;
                    }
                }
                if (can){
                    long xor = i^j;
                    res = Math.max(res, (xor<<index)+go(index - 1, nl1, nh1, nl2, nh2));
                }
            }
        }
        return dp[index][low1][high1][low2][high2] = res;
    }
    public static void main(String[] args) {
        InputReader r = new InputReader(System.in);
        L = r.nextLong();
        R = r.nextLong();
        System.out.println(go(63,0,0,0,0));
    }
    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
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
    }
}
