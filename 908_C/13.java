import java.io.*;
import java.util.*;
import java.math.*;
// import java.awt.Point;
 
public class Main {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
 
    long MOD = 1_000_000_007;
    int inf = Integer.MAX_VALUE;

    void solve(){
        int n = ni();
        int r = ni();
        int[] x = new int[n];
        for(int i = 0; i < n; i++){
            x[i] = ni();
        }
        double[] y = new double[n];
        Arrays.fill(y,-1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                double res = 4*r*r - (x[i]-x[j])*(x[i]-x[j]);
                if(res < 0) continue;
                else{
                    double tmp = Math.sqrt(res) + y[j];
                    if(tmp > y[i]){
                        y[i] = tmp;
                    }
                }
            }
            if(y[i]==-1) y[i] = r;
        }
        for(int i = 0; i < n; i++){
            out.print(y[i]+" ");
        }
    }  

    class Permutation{
    // max=10
    // n=10: 160ms
    // n=11: 1600-1700ms
    int n;
    int max;
    BitSet used;
    int[] p;
    public Permutation(int n, int max){
        this.n = n;
        this.max = max;
        used = new BitSet(n);
        p = new int[n];
    }
    
    public boolean next(){
        if(used.cardinality() == 0){
            for(int i=0; i<n; i++){
                p[i] = i;
            }
            used.set(0, n);
            return true;
        }
        int i;
        for(i=n-1; i>=0; i--){
            used.clear(p[i]);
            if((used.nextClearBit(p[i]+1)) < max) break;
        }
        if(i<0) return false;
        p[i] = used.nextClearBit(p[i]+1);
        used.set(p[i]);
        int idx = i+1;
        for(i=used.nextClearBit(0); i<max && idx<n; i=used.nextClearBit(i+1)){
            p[idx++] = i;
            used.set(i);
        }
        return true;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(p[i]+" ");
        }
        return sb.toString();
    }
}  
    void run() throws Exception
    {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        
        long s = System.currentTimeMillis();
        solve();
        out.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }
    
    public static void main(String[] args) throws Exception { new Main().run(); }
    
    private byte[] inbuf = new byte[1024];
    private int lenbuf = 0, ptrbuf = 0;
    
    private int readByte()
    {
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
    
    private String ns()
    {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b) && b != ' ')){
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    
    private char[] ns(int n)
    {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }
    
    private char[][] nm(int n, int m)
    {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }
    
    private int[] na(int n)
    {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }
    
    private int ni()
    {
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
    
    private long nl()
    {
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
    
    private static void tr(Object... o) { System.out.println(Arrays.deepToString(o)); }
 
}