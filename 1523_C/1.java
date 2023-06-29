import java.io.*;
import java.util.*;

/*
1
4
1
1
2
3

*/
public class CompressionandExpansion {
    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int T = in.nextInt();
        outer: for (int tt = 0; tt < T; tt++) {
            int N = in.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }
            StringBuilder prev = new StringBuilder("" + A[0]);
            StringBuilder newPrev = new StringBuilder(prev);
            out.println(newPrev);
            int prevLook = A[0];
            ArrayDeque<Integer> vals = new ArrayDeque<>();
            ArrayList<Integer> vals0 = new ArrayList<>();
            vals.add(A[0]);
            for (int i = 1; i < N; i++) {
                if (A[i] == 1) {
                    vals.add(1);
                } else {
                    while (A[i] != vals.peekLast() + 1)
                        vals.pollLast();
                    int inc = vals.pollLast();
                    vals.add(inc + 1);
                }
                StringBuilder ans = new StringBuilder();
                int sz = vals.size();
                int ii = 0;
                for (int val : vals) {
                    ans.append(val);
                    if (ii != sz - 1) {
                        ans.append('.');
                    }
                    ii++;
                }
                out.println(ans);
            }
        }
        out.close();
    }

    private static final class FastScanner {
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
    
        private char getChar() {
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
    
        public int nextInt() {
            return (int) nextLong();
        }
    
        public int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }
    
        public long[] nextLongs(int N) {
            long[] res = new long[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextLong();
            }
            return res;
        }
    
        public long nextLong() {
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
    
        public double nextDouble() {
            double cur = nextLong();
            return c != '.' ? cur : cur + nextLong() / cnt;
        }
    
        public double[] nextDoubles(int N) {
            double[] res = new double[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextDouble();
            }
            return res;
        }
    
        public String next() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c > 32) {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }
    
        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c != '\n') {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }
    
        public boolean hasNext() {
            if (c > 32) return true;
            while (true) {
                c = getChar();
                if (c == NC) return false;
                else if (c > 32) return true;
            }
        }
    }
}
