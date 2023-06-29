//package baobab;

import java.io.*;
import java.util.*;

public class C {

    public static void main(String[] args) {
        CIO io = new CIO();
        try {
            Csolver solver = new Csolver(io);
            solver.solve();
        } finally {
            io.close();
        }
    }

}

class Csolver {
    CIO io;

    public Csolver(CIO io) {
        this.io = io;
    }

    public void solve() {
        int n = io.nextInt();
        String input = io.next();
        int[] count = new int[1000];
        int pokemonsInRange = 0;
        int answer = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        for (; b < n ; b++) {
            char end = input.charAt(b);
            if (count[end] == 0) {
                pokemonsInRange++;
                answer = Integer.MAX_VALUE;
            }
            count[end]++;
            while (count[input.charAt(a)] > 1) {
                count[input.charAt(a)]--;
                a++;
            }
            answer = Math.min(answer, b-a+1);
        }
        io.println(answer);
    }

    private static class Pair implements Comparable<Pair> {
        int id;
        long val;

        public Pair(long val, int id) {
            this.val = val;
            this.id = id;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.val < o.val) return -1;
            if (this.val > o.val) return 1;
            return this.id - o.id;
        }
    }

    private List<Integer>[] toGraph(CIO io, int n) {
        List<Integer>[] g = new ArrayList[n+1];
        for (int i=1; i<=n; i++) g[i] = new ArrayList<>();
        for (int i=1; i<=n-1; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            g[a].add(b);
            g[b].add(a);
        }
        return g;
    }
}

class CIO extends PrintWriter {
    private InputStreamReader r;
    private static final int BUFSIZE = 1 << 15;
    private char[] buf;
    private int bufc;
    private int bufi;
    private StringBuilder sb;

    public CIO() {
        super(new BufferedOutputStream(System.out));
        r = new InputStreamReader(System.in);

        buf = new char[BUFSIZE];
        bufc = 0;
        bufi = 0;
        sb = new StringBuilder();
    }

    private void fillBuf() throws IOException {
        bufi = 0;
        bufc = 0;
        while(bufc == 0) {
            bufc = r.read(buf, 0, BUFSIZE);
            if(bufc == -1) {
                bufc = 0;
                return;
            }
        }
    }

    private boolean pumpBuf() throws IOException {
        if(bufi == bufc) {
            fillBuf();
        }
        return bufc != 0;
    }

    private boolean isDelimiter(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == '\f';
    }

    private void eatDelimiters() throws IOException {
        while(true) {
            if(bufi == bufc) {
                fillBuf();
                if(bufc == 0) throw new RuntimeException("IO: Out of input.");
            }

            if(!isDelimiter(buf[bufi])) break;
            ++bufi;
        }
    }

    public String next() {
        try {
            sb.setLength(0);

            eatDelimiters();
            int start = bufi;

            while(true) {
                if(bufi == bufc) {
                    sb.append(buf, start, bufi - start);
                    fillBuf();
                    start = 0;
                    if(bufc == 0) break;
                }

                if(isDelimiter(buf[bufi])) break;
                ++bufi;
            }

            sb.append(buf, start, bufi - start);

            return sb.toString();
        } catch(IOException e) {
            throw new RuntimeException("IO.next: Caught IOException.");
        }
    }

    public int nextInt() {
        try {
            int ret = 0;

            eatDelimiters();

            boolean positive = true;
            if(buf[bufi] == '-') {
                ++bufi;
                if(!pumpBuf()) throw new RuntimeException("IO.nextInt: Invalid int.");
                positive = false;
            }

            boolean first = true;
            while(true) {
                if(!pumpBuf()) break;
                if(isDelimiter(buf[bufi])) {
                    if(first) throw new RuntimeException("IO.nextInt: Invalid int.");
                    break;
                }
                first = false;

                if(buf[bufi] >= '0' && buf[bufi] <= '9') {
                    if(ret < -214748364) throw new RuntimeException("IO.nextInt: Invalid int.");
                    ret *= 10;
                    ret -= (int)(buf[bufi] - '0');
                    if(ret > 0) throw new RuntimeException("IO.nextInt: Invalid int.");
                } else {
                    throw new RuntimeException("IO.nextInt: Invalid int.");
                }

                ++bufi;
            }

            if(positive) {
                if(ret == -2147483648) throw new RuntimeException("IO.nextInt: Invalid int.");
                ret = -ret;
            }

            return ret;
        } catch(IOException e) {
            throw new RuntimeException("IO.nextInt: Caught IOException.");
        }
    }

    public long nextLong() {
        try {
            long ret = 0;

            eatDelimiters();

            boolean positive = true;
            if(buf[bufi] == '-') {
                ++bufi;
                if(!pumpBuf()) throw new RuntimeException("IO.nextLong: Invalid long.");
                positive = false;
            }

            boolean first = true;
            while(true) {
                if(!pumpBuf()) break;
                if(isDelimiter(buf[bufi])) {
                    if(first) throw new RuntimeException("IO.nextLong: Invalid long.");
                    break;
                }
                first = false;

                if(buf[bufi] >= '0' && buf[bufi] <= '9') {
                    if(ret < -922337203685477580L) throw new RuntimeException("IO.nextLong: Invalid long.");
                    ret *= 10;
                    ret -= (long)(buf[bufi] - '0');
                    if(ret > 0) throw new RuntimeException("IO.nextLong: Invalid long.");
                } else {
                    throw new RuntimeException("IO.nextLong: Invalid long.");
                }

                ++bufi;
            }

            if(positive) {
                if(ret == -9223372036854775808L) throw new RuntimeException("IO.nextLong: Invalid long.");
                ret = -ret;
            }

            return ret;
        } catch(IOException e) {
            throw new RuntimeException("IO.nextLong: Caught IOException.");
        }
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

}