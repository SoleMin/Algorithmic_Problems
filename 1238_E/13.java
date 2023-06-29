import java.io.*;
import java.util.*;
import java.math.*;
 
public class Main {
	static int t,m,mod=998244353,maxn=1000000,q,n,k;
    static int INF=(int)1e8;
    
    void solve(PrintWriter out, Reader in) throws IOException{
        n = in.nextInt();
        m = in.nextInt();
        
        String str = in.next();
        int[][] pre = new int[1<<m][m];
        
        int child=0,head,child2=0;
        for(int i=0;i<n;i++){
            if(i!=0) child = 1<<(str.charAt(i-1)-'a');
            if(i!=n-1) child2 = 1<<(str.charAt(i+1)-'a');
            head = str.charAt(i)-'a';
            
            if(i!=0) pre[child][head]++;
            if(i!=n-1) pre[child2][head]++;
        }
        
        //pre[child][head] - number of elemnts that exists in child and are adjacent to head in the string.
        
        int rmv=0;
        for(int i=0;i<m;i++){
            head = i;
            for(int j=1;j<1<<m;j++){
                if(pre[j][i]!=0) continue;
                
                rmv = j-(j&-j);
                pre[j][head] = pre[rmv][head]+pre[j^rmv][head];
            }
        }
        
        
        int[] dp = new int[1<<m];
        for(int i=1;i<1<<m;i++) dp[i] = INF;
        
        // dp[mask] - the minimum cost using a permutation of the set bits in the mask.
        
        int bit=0,full=(1<<m)-1,cnt=0;
        for(int j=1;j<1<<m;j++){
            for(int i=0;i<m;i++){
                if(((1<<i)&j)!=0){
                    bit = 1<<i;
                    cnt = cnt(j);
                    dp[j] = Math.min(dp[j],dp[j^bit]+pre[j^bit][i]*cnt-pre[j^full][i]*cnt);
                }
            }
        }
        
        out.println(dp[full]);
    }
    
    
    
    
    static int cnt(int x){
        int res=0;
        while(x>0){
            res+=x&1;
            x>>=1;
        }
        return res;
    }
    
    static class Reader {
 
    private InputStream mIs;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
 
    public Reader() {
        this(System.in);
    }
 
    public Reader(InputStream is) {
        mIs = is;
    }
 
    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
 
    }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = mIs.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }
 
    public String nextLine() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }
 
    public String next() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
 
    double nextDouble()
    {
        return Double.parseDouble(next());
    }
 
    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }
 
    }
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Reader in = new Reader();
        Main solver = new Main();
        solver.solve(out, in);
        out.flush();
        out.close();
 
    }
}