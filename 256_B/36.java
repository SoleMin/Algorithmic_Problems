import java.util.*;
import java.io.*;
import java.math.*;
public class Main
{
    static class Reader 
    { 
        private InputStream mIs;private byte[] buf = new byte[1024];private int curChar,numChars;public Reader() { this(System.in); }public Reader(InputStream is) { mIs = is;} 
        public int read() {if (numChars == -1) throw new InputMismatchException();if (curChar >= numChars) {curChar = 0;try { numChars = mIs.read(buf);} catch (IOException e) { throw new InputMismatchException();}if (numChars <= 0) return -1; }return buf[curChar++];} 
        public String nextLine(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isEndOfLine(c));return res.toString() ;} 
        public String s(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isSpaceChar(c));return res.toString();} 
        public long l(){int c = read();while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }long res = 0; do{ if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read();}while(!isSpaceChar(c));return res * sgn;} 
        public int i(){int c = read() ;while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }int res = 0;do{if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read() ;}while(!isSpaceChar(c));return res * sgn;} 
        public double d() throws IOException {return Double.parseDouble(s()) ;}
        public boolean isSpaceChar(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; } 
        public boolean isEndOfLine(int c) { return c == '\n' || c == '\r' || c == -1; } 
        public int[] arr(int n){int[] ret = new int[n];for (int i = 0; i < n; i++) {ret[i] = i();}return ret;}
    }
    
    
 
           //       |----|       /\      |    |   -----   |
           //       |   /       /  \     |    |     |     |
           //       |--/       /----\    |----|     |     |
           //       |   \     /      \   |    |     |     |
           //       |    \   /        \  |    |   -----   -------
    
    public static long check(long mid,long x,long y,long n)
    {
        long ans=2*mid*mid+2*mid+1;
        long uleft=Math.max(0,mid-x+1);
        long dleft=Math.max(0,mid-(n-x));
        long lleft=Math.max(0,mid-y+1);
        long rleft=Math.max(0,mid-(n-y));
        ans-=uleft*uleft+dleft*dleft+lleft*lleft+rleft*rleft;
        
        ans+=(Math.max(0,mid-(x+y-1))*(Math.max(0,mid-(x+y-1))+1))/2;
        ans+=(Math.max(0,mid-(x+n-y))*(Math.max(0,mid-(x+n-y))+1))/2;
        ans+=(Math.max(0,mid-(y+n-x))*(Math.max(0,mid-(y+n-x))+1))/2;
        ans+=(Math.max(0,mid-(n-x+n-y+1))*(Math.max(0,mid-(n-x+n-y+1))+1))/2;
        return ans;
    }
    public static void main(String[] args)throws IOException
    {
        PrintWriter out= new PrintWriter(System.out);
        Reader sc=new Reader();
        long n=sc.l();
        long x=sc.l();
        long y=sc.l();
        long c=sc.l();
        long low=0;
        long high=(long)Math.pow(10,9);
        while(low<high)
        {
            long mid=(low+high)/2;
            if(check(mid,x,y,n)>=c)
            high=mid;
            else
            low=mid+1;
        }
        out.println(low);
        out.flush();
    }
}