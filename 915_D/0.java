//package contests.c915;

import java.io.*;
import java.util.*;

public class C915D implements Runnable {

    private void solve() throws Exception {
        int n = i(), m = i();
        List<Set<Integer>> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            int u = i() - 1, v = i() - 1;
            a.get(u).add(v);
        }

        int[] cycle = getCycle(a);
        if (cycle==null) {
            System.out.println("YES");
            return;
        }

        boolean canBeAcyclyc = false;
        for (int i = 0; i < cycle.length; i++) {
            int u = cycle[i];
            int v;
            if (i < cycle.length - 1) {
                v = cycle[i + 1];
            } else {
                v = cycle[0];
            }

            a.get(u).remove(v);

            if (getCycle(a) == null) {
                canBeAcyclyc = true;
                break;
            }

            a.get(u).add(v);
        }

        if (canBeAcyclyc) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private int[] getCycle(List<Set<Integer>> a) {
        int n = a.size();
        boolean[] visited = new boolean[n];

        int[] cycle = null;
        for (int i = 0; i < n; i++) {
            Set<Integer> current = new HashSet<>();
            List<Integer> backtrack = new ArrayList<>();
            cycle = dfs(i, a, visited, current, backtrack);
            if (cycle != null) break;
        }
        return cycle;
    }

    int[] dfs(Integer e, List<Set<Integer>> a, boolean[] visited, Set<Integer> current, List<Integer> backtrack) {
        if (visited[e]) {
            if (current.contains(e)) {
                var result = new ArrayList<Integer>();
                for (int i = backtrack.indexOf(e); i < backtrack.size(); i++) {
                    result.add(backtrack.get(i));
                }
                return result.stream().mapToInt(i -> i).toArray();
            }
            return null;
        }

        visited[e] = true;
        current.add(e);
        backtrack.add(e);

        for (Integer v : a.get(e)) {
            int[] result = dfs(v, a, visited, current, backtrack);
            if (result != null)
                return result;
        }

        current.remove(e);
        backtrack.remove(backtrack.size() - 1);

        return null;
    }

    public void run() {
        long start = System.currentTimeMillis();

        try {
            solve();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
        }

        if (!isOj)
            System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public static void main(String[] args) throws Exception {
        new C915D().run();
    }

    InputStream inputStream;
    FastWriter out;

    private C915D() {
        this(System.in, System.out);
    }

    public C915D(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.out = new FastWriter(outputStream);
    }

    //@formatter:off
    private final byte[] inbuf = new byte[1024];
    private int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = inputStream.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private char c() { return (char) skip(); }
    private char[] ca(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }
    private char[][] caa(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ca(m);
        return map;
    }

    private int i() { return (int) l(); }
    private int[] ia(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i();
        return a;
    }
    private int[][] iaa(int n, int m) {
        int[][] map = new int[n][];
        for (int i = 0; i < n; i++) map[i] = ia(m);
        return map;
    }
    private int[][] iaaT(int n, int m) {
        int[][] map = new int[m][];
        for (int i = 0; i < m; i++) map[i] = new int[n];
        for (int i = 0; i < n; i++) {
            int[] t = ia(m);
            for (int j = 0; j < m; j++) map[j][i] = t[j];
        }
        return map;
    }

    private long l() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    private long[] la(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = l();
        return a;
    }

    private double d() { return Double.parseDouble(s()); }

    private String s() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    //@formatter:on

    public static class FastWriter {
        private static final int BUF_SIZE = 1 << 13;
        private final byte[] buf = new byte[BUF_SIZE];
        private final OutputStream out;
        private int ptr = 0;
        private boolean isFirst = true;

        public FastWriter(OutputStream os) {
            this.out = os;
        }

        private FastWriter write(byte b) {
            buf[ptr++] = b;
            if (ptr == BUF_SIZE)
                innerflush();
            return this;
        }

        private FastWriter write(char c) {
            return write((byte) c);
        }

        private FastWriter write(char[] s) {
            for (char c : s) {
                buf[ptr++] = (byte) c;
                if (ptr == BUF_SIZE) innerflush();
            }
            return this;
        }

        private FastWriter write(String s) {
            s.chars().forEach(c -> {
                buf[ptr++] = (byte) c;
                if (ptr == BUF_SIZE) innerflush();
            });
            return this;
        }

        public static int countDigits(int l) {
            if (l >= 1000000000) return 10;
            if (l >= 100000000) return 9;
            if (l >= 10000000) return 8;
            if (l >= 1000000) return 7;
            if (l >= 100000) return 6;
            if (l >= 10000) return 5;
            if (l >= 1000) return 4;
            if (l >= 100) return 3;
            if (l >= 10) return 2;
            return 1;
        }

        private FastWriter write(int x) {
            if (x == Integer.MIN_VALUE) {
                return write((long) x);
            }
            if (ptr + 12 >= BUF_SIZE) innerflush();
            if (x < 0) {
                write((byte) '-');
                x = -x;
            }
            int d = countDigits(x);
            for (int i = ptr + d - 1; i >= ptr; i--) {
                buf[i] = (byte) ('0' + x % 10);
                x /= 10;
            }
            ptr += d;
            return this;
        }

        public static int countDigits(long l) {
            if (l >= 1000000000000000000L) return 19;
            if (l >= 100000000000000000L) return 18;
            if (l >= 10000000000000000L) return 17;
            if (l >= 1000000000000000L) return 16;
            if (l >= 100000000000000L) return 15;
            if (l >= 10000000000000L) return 14;
            if (l >= 1000000000000L) return 13;
            if (l >= 100000000000L) return 12;
            if (l >= 10000000000L) return 11;
            if (l >= 1000000000L) return 10;
            if (l >= 100000000L) return 9;
            if (l >= 10000000L) return 8;
            if (l >= 1000000L) return 7;
            if (l >= 100000L) return 6;
            if (l >= 10000L) return 5;
            if (l >= 1000L) return 4;
            if (l >= 100L) return 3;
            if (l >= 10L) return 2;
            return 1;
        }

        private FastWriter write(long x) {
            if (x == Long.MIN_VALUE) {
                return write("" + x);
            }
            if (ptr + 21 >= BUF_SIZE) innerflush();
            if (x < 0) {
                write((byte) '-');
                x = -x;
            }
            int d = countDigits(x);
            for (int i = ptr + d - 1; i >= ptr; i--) {
                buf[i] = (byte) ('0' + x % 10);
                x /= 10;
            }
            ptr += d;
            return this;
        }

        private FastWriter write(double x, int precision) {
            if (x < 0) {
                write('-');
                x = -x;
            }
            x += Math.pow(10, -precision) / 2;
            //		if(x < 0){ x = 0; }
            write((long) x).write(".");
            x -= (long) x;
            for (int i = 0; i < precision; i++) {
                x *= 10;
                write((char) ('0' + (int) x));
                x -= (int) x;
            }
            return this;
        }

        public FastWriter writeDelimeter() {
            if (isFirst) {
                isFirst = false;
            } else {
                write(' ');
            }
            return this;
        }

        public FastWriter writeNewline() {
            write('\n');
            isFirst = true;
            return this;
        }

        private void innerflush() {
            try {
                out.write(buf, 0, ptr);
                ptr = 0;
            } catch (IOException e) {
                throw new RuntimeException("innerflush");
            }
        }

        public void flush() {
            innerflush();
            try {
                out.flush();
            } catch (IOException e) {
                throw new RuntimeException("flush");
            }
        }

        public void close() {
            writeNewline();
            flush();
        }
    }

    //@formatter:off
    private void w(int x) { out.writeDelimeter().write(x); }
    private void w(long x) { out.writeDelimeter().write(x); }
    private void w(double x) { out.writeDelimeter().write(x, 16); }
    private void lnw(int x) { out.writeNewline().write(x); }
    private void lnw(long x) { out.writeNewline().write(x); }

    private static int log(int a) {
        if (a <= 0) throw new RuntimeException("log(a): a <= 0");
        return Integer.SIZE - 1 - Integer.numberOfLeadingZeros(a);
    }
    private static int log(long a) {
        if(a <= 0) throw new RuntimeException("log(a): a <= 0");
        return Long.SIZE - 1 - Long.numberOfLeadingZeros(a);
    }
    private static int max(int a, int b) {return Math.max(a, b);}
    private static long max(long a, long b) {return Math.max(a, b);}
    private static int min(int a, int b) {return Math.min(a, b);}
    private static int min(int a, int b, int c) {return min(a, min(b, c));}
    private static int min(int... x) {if (x.length == 1) return x[0]; if (x.length == 2) return min(x[0], x[1]); if (x.length == 3) return min(x[0], min(x[1], x[2])); int min = x[0]; for (int i = 1; i < x.length; ++i) if (x[i] < min) min = x[i]; return min;}
    private static long min(long a, long b) {return Math.min(a, b);}
    private static long min(long a, long b, long c) {return min(a, min(b, c));}
    private static long min(long... x) {if (x.length == 1) return x[0]; if (x.length == 2) return min(x[0], x[1]); if (x.length == 3) return min(x[0], min(x[1], x[2])); long min = x[0]; for (int i = 1; i < x.length; ++i) if (x[i] < min) min = x[i]; return min;}
    private static int pow(int a, int b) {if (a == 0) return 0; int r = 1; while (b > 0) {if ((b & 1) > 0) r *= a; a *= a; b >>= 1;} return r;}
    private static long pow(long a, int b) {if (a == 0) return 0; long r = 1; while (b > 0) {if ((b & 1) > 0) r *= a; a *= a; b >>= 1;} return r;}
    //@formatter:on

    private final boolean isOj = System.getProperty("ONLINE_JUDGE") != null;
}
