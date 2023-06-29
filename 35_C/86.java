import java.io.*;
import java.util.*;

public class Main {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    
    long MAX = 100000L, MOD = 1000000007L, INF = (long) 1e18;
    
    boolean isValid(int x, int y, int n, int m){
        return x>=0 && y>=0 && x<n && y<m;
    }
    
    void solve(int TC) throws Exception {
        helper hp = new helper(MOD, (int)MAX);
        hp.initIO("input.txt", "output.txt");
        int n = hp.nextInt(), m = hp.nextInt();
        boolean[][] a = new boolean[n][m];
        int k = hp.nextInt();
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i=0;i<k;i++){
            int x = hp.nextInt() - 1;
            int y = hp.nextInt() - 1;
            a[x][y] = true;
            q.add(new int[]{x,y});
        }
        int lastX = 0,lastY = 0;
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        while(!q.isEmpty()){
            int[] X = q.pollFirst();
            for(int i=0;i<4;i++){
                int x = X[0] + dx[i];
                int y = X[1] + dy[i];
                if(isValid(x,y,n,m) && !a[x][y]){
                    a[x][y] = true;
                    lastX = x;
                    lastY = y;
                    q.add(new int[]{x,y});
                }
            }
        }
        hp.println((lastX+1) + " " + (lastY+1)); hp.flush();
    }
    
    boolean TestCases = false;
    public static void main(String[] args) throws Exception { new Main().run(); }
    
    void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
    static void dbg(Object... o){System.err.println(Arrays.deepToString(o));}
    
    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        int T = TestCases ? ni() : 1;
        for(int t=1;t<=T;t++) solve(t);
        out.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }
    
    void p(Object o) { out.print(o); }
    void pn(Object o) { out.println(o); }
    void pni(Object o) { out.println(o);out.flush(); }
    double PI = 3.141592653589793238462643383279502884197169399;
    
    int ni() {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-') {
            minus = true;
            b = readByte();
        }
        while(true) {
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    
    long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-') {
            minus = true;
            b = readByte();
        }
        while(true) {
            if(b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    
    double nd() { return Double.parseDouble(ns()); }
    char nc() { return (char)skip(); }
    
    int BUF_SIZE = 1024 * 8;
    byte[] inbuf = new byte[BUF_SIZE];
    int lenbuf = 0, ptrbuf = 0;
    
    int readByte() {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        } return inbuf[ptrbuf++];
    }
    
    boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
    
    String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))) {
            sb.appendCodePoint(b); b = readByte();
        } return sb.toString();
    }
    
    char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        } return n == p ? buf : Arrays.copyOf(buf, p);
    }
    
    void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}


class helper {
    final long MOD;
    final int MAXN;
    final Random rnd;

    public helper(long mod, int maxn) {
        MOD = mod;
        MAXN = maxn;
        rnd = new Random();
    }
	
    static final int BUFSIZE = 1 << 20;
    static byte[] buf;
    static int index, total;
    static InputStream in;
    static BufferedWriter bw;


    public void initIO(InputStream is, OutputStream os) {
        try {
            in = is;
            bw = new BufferedWriter(new OutputStreamWriter(os));
            buf = new byte[BUFSIZE];
        } catch (Exception e) {
        }
    }

    public void initIO(String inputFile, String outputFile) {
        try {
            in = new FileInputStream(inputFile);
            bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(outputFile)));
            buf = new byte[BUFSIZE];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private int scan() throws Exception {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0)
                return -1;
        }
        return buf[index++];
    }

    public String next() throws Exception {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan())
            sb.append((char) c);
        return sb.toString();
    }

    public int nextInt() throws Exception {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+')
            c = scan();
        for (; c >= '0' && c <= '9'; c = scan())
            val = (val << 3) + (val << 1) + (c & 15);
        return neg ? -val : val;
    }

    public long nextLong() throws Exception {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+')
            c = scan();
        for (; c >= '0' && c <= '9'; c = scan())
            val = (val << 3) + (val << 1) + (c & 15);
        return neg ? -val : val;
    }
    
    public long pow(long base, long exp, long MOD) {
        base %= MOD;
        long ret = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) ret = ret * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return ret;
    }
    
    public void println(Object a) throws Exception {
        bw.write(a.toString()+"\n");
    }
    public void print(Object a) throws Exception {
        bw.write(a.toString());
    }
    public void flush() throws Exception {
        bw.flush();
    }
    
    public static int[] sieve;
    public static ArrayList<Integer> primes;
    
    public void setSieve() {
        primes = new ArrayList<>();
        sieve = new int[MAXN];
        int i, j;
        for (i = 2; i < MAXN; ++i)
            if (sieve[i] == 0) {
                primes.add(i);
                for (j = i; j < MAXN; j += i) {
                    sieve[j] = i;
                }
            }
    }
}
