
import java.util.*;
import java.io.*;
import java.math.*;
public class A{

    void solve(){
        int n=ni();
        s=new char[n+1];
        s[0]='.';
        for(int i=1;i<=n;i++) s[i]=ns().charAt(0);
        dp=new long[5001][5001];

        dp[1][0]=1;
        long sum[]=new long[n+2];
        sum[0]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<=n;j++) {
                if (s[i - 1] == 'f') {
                        if(j-1>=0) dp[i][j]=dp[i-1][j-1];
                        else dp[i][j]=0;
                }else {
                   dp[i][j]=sum[j];
                }
            }
            for(int j=n;j>=0;j--){
                sum[j]=(sum[j+1]+dp[i][j])%M;
            }
        }
        long ans=0;
        for(int i=0;i<=n;i++){
            ans+=dp[n][i];
            if(ans>=M) ans%=M;
        }
        pw.println(ans);

    }
    char s[];
    long dp[][];
    long go(int x,int cnt,int n){
   //    pw.println(x+" "+cnt);
        if(x>n) return 1;
        long cc=0;
        if(dp[x][cnt]!=-1) return dp[x][cnt];
        if(s[x]=='f'){
            cc=(cc+go(x+1,cnt+1,n))%M;
        }else {

            for(int j=cnt;j>=0;j--) cc=(cc+go(x+1,j,n))%M;
            if(x==n) cc=(cc-cnt+M)%M;
        }
        cc%=M;

        dp[x][cnt]=cc;
        return cc;
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