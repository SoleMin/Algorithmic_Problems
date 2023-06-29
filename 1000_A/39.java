import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    void solve(){
        int n=ni();
        int c1[]=new int[9];
        int c2[]=new int[9];
        for(int i=0;i<n;i++){
            String s=ns();
            if(s.equals("M")) c1[0]++;
            else if(s.equals("S")) c1[1]++;
            else if(s.equals("L")) c1[2]++;
            else if(s.equals("XS")) c1[3]++;
            else if(s.equals("XL")) c1[4]++;
            else if(s.equals("XXS")) c1[5]++;
            else if(s.equals("XXL")) c1[6]++;
            else if(s.equals("XXXS")) c1[7]++;
            else if(s.equals("XXXL")) c1[8]++;
        }
        for(int i=0;i<n;i++){
            String s=ns();
            if(s.equals("M")) c2[0]++;
            else if(s.equals("S")) c2[1]++;
            else if(s.equals("L")) c2[2]++;
            else if(s.equals("XS")) c2[3]++;
            else if(s.equals("XL")) c2[4]++;
            else if(s.equals("XXS")) c2[5]++;
            else if(s.equals("XXL")) c2[6]++;
            else if(s.equals("XXXS")) c2[7]++;
            else if(s.equals("XXXL")) c2[8]++;
        }
        int ans=0;
        for(int i=0;i<9;i++){
            if(c2[i]<c1[i]) ans+=c1[i]-c2[i];
        }
        pw.println(ans);


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

    public static void main(String[] args) throws Exception { new Main().run(); }

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