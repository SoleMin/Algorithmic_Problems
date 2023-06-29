import java.util.*;
import java.io.*;
import java.math.*;
public class A{

    void solve(){
        int n=ni();
        int P[]=new int[n+1];
        for(int i=1;i<=n;i++) P[i]=ni();
        a=new int[n+1];
        BIT=new long[n+1];
        long cnt=0;


        long p=0;
        for(int i=n;i>=1;i--){
            p+=querry(P[i]);
            if(p>=M) p%=M;
            update(n,P[i],1);
        }
        int d=0;
        if(p%2==0) d=1;
        int m=ni();
        while(m-->0){
            int l=ni(),r=ni();
            long sz=r-l+1;
            sz=(sz*(sz-1))/2;
            if(d==1 && sz%2==0) d=1;
            else if(d==1 && sz%2!=0) d=0;
            else if(d==0 && sz%2==0) d=0;
            else if(d==0 && sz%2!=0) d=1;
            if(d==1) pw.println("even");
            else pw.println("odd");
        }
    }
    int a[];
    long BIT[];
    void update(int n,int x,int val){
        a[x]=val;
        for(;x<=n;x+=(x&-x)) BIT[x]+=val;
    }
    long querry(int x){
        long ans=0;
        for(;x>0;x-=(x&-x)) ans+=BIT[x];
        return ans;

    }

    static long d, x, y;
    static void extendedEuclid(long A, long B) {
        if(B == 0) {
            d = A;
            x = 1;
            y = 0;
        }
        else {
            extendedEuclid(B, A%B);
            long temp = x;
            x = y;
            y = temp - (A/B)*y;
        }
    }
    static long modInverse(long A, long M)
    {
        extendedEuclid(A,M);
        return (x%M+M)%M;
    }
    long M=(long)1e9+7;
    InputStream is;
    PrintWriter pw;
    String INPUT = "";
    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        pw.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }

    public static void main(String[] args) throws Exception { new A().run(); }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }

    private double nd() { return Double.parseDouble(ns()); }
    private char nc() { return (char)skip(); }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}