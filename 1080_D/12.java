import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.math.*;
import java.lang.*;
import java.util.PriorityQueue;
import static java.lang.Math.*;
@SuppressWarnings("unchecked")
public class Solution implements Runnable {
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();
 
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }
 
                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();
 
            while(isSpaceChar(c))
                c = read();
 
            int sgn = 1;
 
            if (c == '-') {
                sgn = -1;
                c = read();
            }
 
            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
 
            return res * sgn;
        }
 
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
 
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
                return res * sgn;
        }
 
        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
 
        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));
 
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public String next() {
            return readString();
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
    public static long min(long a,long b)
    {
        if(a>b)
        {
            return b;
        }
        return a;
    }
    public static int min(int a,int b)
    {
        if(a>b)
        {
            return b;
        }
        return a;
    }
    public static long max(long a,long b)
    {
        if(a>b)
        {
            return a;
        }
        return b;
    }
    public static int max(int a,int b)
    {
        if(a>b)
        {
            return a;
        }
        return b;
    }
    static class pair
    {
      long x;
      long y;
      pair(long x,long y)
      {
        this.x = x;
        this.y = y;
      }
      public String toString()
      {
        return x+" "+y;
      }
    }
    public static int gcd(int a,int b)
    {
        if(a==0)
        return b;
        if(b==0)
        return a;
        while((a%=b)!=0&&(b%=a)!=0);
        return a^b;
    }
    static int num = (int)1e6;
    public static int random(int min,int max)
    {
      return min+(int)((max-min)*Math.random());
    }
    float min(float a,float b)
    {
        if(a>b)
        {
            return b;
        }
        return a;
    }
    float dist(float x1,float y1,float x2,float y2)
    {
        return (float)Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }
    float mod(float x)
    {
        if(x>0)
        {
            return x;
        }
        return -x;
    }
    public static long pow(long n,int pow)
    {
        long res = 1;
        while(pow!=0)
        {
            if((pow&1)==1)
            {
                res *= n;
            }
            n *= n;
            pow = pow>>1;
        }
        return res;
    }
    public static int bsearch(int n,long k)
    {
        int l = 1;
        int r = n;
        while(r>l)
        {
            int mid = (l+r+1)>>1;
            if(pow(2,mid+1)-mid-2<=k)
            {
                l = mid;
            }
            else
            {
                r = mid-1;
            }
        }
        if(pow(2,l+1)-l-2==0&&pow(2,l+1)-l-2==k)
        {
            return 0;
        }
        else if(pow(2,l+1)-l-2<=k)
        {
            return l;
        }
        return 0;
    }
    public static boolean valid(int n,long k,int steps)
    {
        long total_max = (pow(4,n)-1)/3;
        long cant_be = ((pow(4,n-steps)-1)/3)*(pow(2,steps+1)-1);
        long available = total_max-cant_be;
        if(available>=k)
        {
            return true;
        }
        return false;
    }
    public static void main(String args[]) throws Exception {
        new Thread(null, new Solution(),"Main",1<<26).start();
    }    public void run() {
      InputReader sc  = new InputReader(System.in);
      PrintWriter out = new PrintWriter(System.out);
      int t1 = sc.nextInt();
      while(t1-->0)
      {
        int n = sc.nextInt();
        long k = sc.nextLong();
        if(n>31)
        {
            out.println("YES "+(n-1));
            continue;
        }
        int steps = bsearch(n,k);
        if(steps==0)
        {
            if(k==0)
                out.println("YES "+n);
            else
                out.println("NO");
        }
        if(valid(n,k,steps))
        {
            out.println("YES "+(n-steps));
        }
        else
        {
            out.println("NO");
        }
      }
      out.close();
  }
}