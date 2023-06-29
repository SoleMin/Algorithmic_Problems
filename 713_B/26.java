import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    InputStream is;
    PrintWriter out;
    String INPUT = "" ;
    boolean local = false;
    int inf=0x7FFFFFFF;
    int MOD=(int)(1e9+7);
    double eps=1e-5;
    double PI=Math.acos(-1);
    void solve() {
        long maxn=nl();
        long L=1,R=maxn,ans=-1;
        while (L<=R){
            long mid=(L+R)/2;
            if(ask(1,1,mid,maxn)<1)L=mid+1;
            else{
                R=mid-1;
                ans=mid;
            }
        }
        if(ask(1,1,ans,maxn)==1 && ask(ans+1,1,maxn,maxn)==1){
            Yts1999 a1=gao(1,1,ans,maxn);
            Yts1999 a2=gao(ans+1,1,maxn,maxn);
            answer(a1,a2);
        }else{
            L=1;R=maxn;ans=-1;
            while (L<=R){
                long mid=(L+R)/2;
                if(ask(1,1,maxn,mid)<1)L=mid+1;
                else{
                    R=mid-1;
                    ans=mid;
                }
            }
            Yts1999 a1=gao(1,1,maxn,ans);
            Yts1999 a2=gao(1,ans+1,maxn,maxn);
            answer(a1,a2);
        }
    }
    void answer(Yts1999 a1,Yts1999 a2){
        out.print("!");
        a1.print();
        a2.print();
        out.flush();
    }
    int ask(long a,long b,long c,long d){
        out.printf("? %d %d %d %d",a,b,c,d);
        out.println();
        out.flush();
        return ni();
    }
    Yts1999 gao(long x1,long x2,long y1,long y2){
        long a1=0,a2=0,a3=0,a4=0;
        long L,R;
        L=x1;R=y1;
        while(L<=R){
            long mid=(L+R)/2;
            if(ask(mid,x2,y1,y2)==1){
                a1=mid;
                L=mid+1;
            }else R=mid-1;
        }
        L=x1;R=y1;
        while(L<=R){
            long mid=(L+R)/2;
            if(ask(x1,x2,mid,y2)==1){
                a3=mid;
                R=mid-1;
            }else L=mid+1;
        }
        L=x2;R=y2;
        while(L<=R){
            long mid=(L+R)/2;
            if(ask(x1,mid,y1,y2)==1){
                a2=mid;
                L=mid+1;
            }else R=mid-1;
        }
        L=x2;R=y2;
        while(L<=R){
            long mid=(L+R)/2;
            if(ask(x1,x2,y1,mid)==1){
                a4=mid;
                R=mid-1;
            }else L=mid+1;
        }
        return new Yts1999(a1,a2,a3,a4);
    }
    public class Yts1999 implements Comparable{
        public long a,b,c,d;
        public Yts1999(long a,long b,long c,long d){
            this.a=a;
            this.b=b;
            this.c=c;
            this.d=d;
        }
        public int compareTo(Object o) {
            Yts1999 to=(Yts1999)o;
            if(this.d<to.d) return 1;
            else if(this.d==to.d) return 0;
            else return -1;
        }
        public void print(){
            out.printf(" %d %d %d %d",a,b,c,d);
        }
    }
    long[] exgcd(long a, long b) {
        if (b == 0) return new long[]{1,0,a};
        long[] res = exgcd(b, a%b);
        long t = res[0]; res[0] = res[1]; res[1] = t;
        res[1] -= a/b*res[0];
        return res;
    }
    long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
    long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
    private void run() {
        is = local? new ByteArrayInputStream(INPUT.getBytes()):System.in;
        out = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        out.flush();
        tr(System.currentTimeMillis()-s+"ms");
    }
    public static void main(String[] args) throws Exception { new Main().run(); }
    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;
    private int readByte(){
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
    private String ns(){
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    private char[] ns(int n){
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }
    private char[][] nm(int n, int m){
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }
    private int[] na(int n){
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }
    private int ni(){
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
    private long nl(){
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
    private void tr(Object... o) { if(local)System.out.println(Arrays.deepToString(o)); }
}