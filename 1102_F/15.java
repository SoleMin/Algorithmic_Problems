import java.lang.*;
import java.math.*;
import java.util.*;
import java.io.*;
public class Main {
    void solve() {
        int n=ni(),m=ni();
        int a[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++) for(int j=1;j<=m;j++) a[i][j]=ni();

        if(n==1){
            int mn=Integer.MAX_VALUE;
            for(int i=1;i<m;i++) mn=Math.min(mn,Math.abs(a[1][i]-a[1][i+1]));
            pw.println(mn) ;
            return ;
        }
        mn1=new int[n+1][n+1];
        mn2=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){

                if(i==j) continue;

                mn1[i][j]=mn2[i][j]=Integer.MAX_VALUE;
                for(int k=1;k<=m;k++){
                    mn1[i][j]=Math.min(mn1[i][j],Math.abs(a[i][k]-a[j][k]));
                   // if(i==3 && j==4) pw.println(a[i][k]+" "+a[j][k]);
                }
                for(int k=1;k<m;k++){
                    mn2[i][j]=Math.min(mn2[i][j],Math.abs(a[i][k+1]-a[j][k]));
                }
                //if(m==1) mn2[i][j]=0;

            }
        }
      //  pw.println(mn1[3][4]);
        dp=new int[17][1<<16][17];
        for(int i=1;i<17;i++) for(int j=0;j<(1<<16);j++) Arrays.fill(dp[i][j],-1);

        int ans=0;
        for(int i=1;i<=n;i++){
            ans=Math.max(ans,go(2,1<<(i-1),i,i,n));
        }
        pw.println(ans);

    }
    int mn1[][],mn2[][];
    int dp[][][];
    int go(int i,int mask,int prev,int first,int n){
        if(i>n){
       //   if(mn2[first][prev]==0)  pw.println(prev+" "+first+" "+mn2[first][prev]);
            return mn2[first][prev];
        }
       if(dp[first][mask][prev]!=-1) return dp[first][mask][prev];
        int cc=0;
        for(int k=1;k<=n;k++){
            if((mask&(1<<(k-1)))==0){
                cc=Math.max(cc,Math.min(mn1[prev][k],go(i+1,mask|(1<<(k-1)),k,first,n)));
               //if(mn1[prev][k]==0)  pw.println(mn1[prev][k]+" "+prev+" "+k);
            }
        }
        dp[first][mask][prev]=cc;
        return cc;
    }



    long M= (long)1e9+7;
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
    private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }

}