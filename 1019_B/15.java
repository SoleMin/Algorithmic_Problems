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

    public static void main(String[] args)throws IOException
    {
        PrintWriter out= new PrintWriter(System.out);
        Reader sc=new Reader();
        int n=sc.i();
        System.out.println("? "+1);
        int a=sc.i();
        System.out.println("? "+(1+n/2));
        int b=sc.i();
        if(a==b)
        {
            System.out.println("! "+1);
            System.exit(0);
        }
        int inv=0;
        if(a>b)
        inv=1;
        
        int low=2;
        int high=n/2;
        int q=0;
        while(low<=high)
        {
            if(q==60)
            break;
            int mid=(low+high)/2;
            System.out.println("? "+mid);
            a=sc.i();
            System.out.println("? "+(mid+n/2));
            b=sc.i();
            if(a==b)
            {
                System.out.println("! "+mid);
                System.exit(0);
            }
            else if(a<b)
            {
                if(inv==0)
                low=mid+1;
                else
                high=mid-1;
            }
            
            else
            {
                if(inv==0)
                high=mid-1;
                else
                low=mid+1;
            }
            q++;
        }
        System.out.println("! -1");
        out.flush();
    }
}