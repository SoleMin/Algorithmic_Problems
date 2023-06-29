import java.util.*;
import java.io.*;

public class ProblemD
{

    static int mod = (int) (1e9+7);
    static InputReader in;
    static PrintWriter out;
    
    static void update(int i, int val, int[] bit){
        for(; i < bit.length; i += (i&-i))
            bit[i] += val;
    }
    
    static int query(int i, int[] bit){
        int ans=0;
        
        for(; i>0; i -= (i&-i))
            ans += bit[i];
        
        return ans;
    }
    
    static int get(int l, int r, int[] bit){
        if(l > r) return 0;
        return query(r, bit) - query(l - 1, bit);
    }
    
    static void solve()
    {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);            
        
        int n = in.nextInt();
        int[] arr = new int[n + 1];
        int[] bit = new int[n + 2];
        
        for(int i = 1; i <= n; i++){
            arr[i] = in.nextInt();
        }
        int cnt = 0;
        
        for(int i = n; i > 0; i--){
            cnt += query(arr[i], bit);
            update(arr[i], 1, bit);
        }
        cnt %= 2;
        
        int q = in.nextInt();

        while(q-- > 0){
            
            int l = in.nextInt();
            int r = in.nextInt();
            int length = r - l + 1;
            int x = (length * (length - 1)) / 2;
            x %= 2;
            cnt ^= x;
            out.println(cnt == 0 ? "even" : "odd");
        }
        
        out.close();
    }
    
    public static void main(String[] args)
    {
        new Thread(null ,new Runnable(){
            public void run(){
                try{
                    solve();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        },"1",1<<26).start();
        
    }

    static class Pair implements Comparable<Pair>
    {

        long x,y;

        Pair (long x,long y)
        {
                this.x = x;
                this.y = y;
        }
        public int compareTo(Pair o)
        {
            return Long.compare(this.x,o.x);
                //return 0;
        }

        public boolean equals(Object o)
        {
            if (o instanceof Pair)
            {
                Pair p = (Pair)o;
                return p.x == x && p.y==y;
            }
            return false;
        }

        @Override
        public String toString()
        {
            return x + " "+ y ;
        }

        /*public int hashCode()
        {
            return new Long(x).hashCode() * 31 + new Long(y).hashCode();
        }*/

    } 

    static long add(long a,long b){
        long x=(a+b);
        while(x>=mod) x-=mod;
        return x;
    }

    static long sub(long a,long b){
        long x=(a-b);
        while(x<0) x+=mod;
        return x;
    }
    
    static long mul(long a,long b){
        long x=(a*b);
        while(x>=mod) x-=mod;
        return x;
    }
    
    static String rev(String s){
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
    
    static long gcd(long x,long y)
    {
        if(y==0)
                return x;
        else
                return gcd(y,x%y);
    }

    static int gcd(int x,int y)
    {
        if(y==0)
                return x;
        else 
                return gcd(y,x%y);
    }

    static long pow(long n,long p,long m)
    {
         long  result = 1;
          if(p==0){
            return 1;
          }
          
        while(p!=0)
        {
            if(p%2==1)
                result *= n;
            if(result >= m)
               result %= m;
            p >>=1;
            n*=n;
            if(n >= m)
                n%=m;
        }
        
        return result;
    }

    static long pow(long n,long p)
    {
        long  result = 1;
          if(p==0)
            return 1;

        while(p!=0)
        {
            if(p%2==1)
                result *= n;	    
            p >>=1;
            n*=n;	    
        }
        return result;
    }

    static void debug(Object... o)
    {
            System.out.println(Arrays.deepToString(o));
    }

    static class InputReader
    {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream)
        {
                this.stream = stream;
        }

        public int snext()
        {
                if (snumChars == -1)
                        throw new InputMismatchException();
                if (curChar >= snumChars)
                {
                        curChar = 0;
                        try
                        {
                                snumChars = stream.read(buf);
                        } catch (IOException e)
                        {
                                throw new InputMismatchException();
                        }
                        if (snumChars <= 0)
                                return -1;
                }
                return buf[curChar++];
        }

        public int nextInt()
        {
                int c = snext();
                while (isSpaceChar(c))
                {
                        c = snext();
                }
                int sgn = 1;
                if (c == '-')
                {
                        sgn = -1;
                        c = snext();
                }
                int res = 0;
                do
                {
                        if (c < '0' || c > '9')
                                throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = snext();
                } while (!isSpaceChar(c));
                return res * sgn;
        }

        public long nextLong()
        {
                int c = snext();
                while (isSpaceChar(c))
                {
                        c = snext();
                }
                int sgn = 1;
                if (c == '-')
                {
                        sgn = -1;
                        c = snext();
                }
                long res = 0;
                do
                {
                        if (c < '0' || c > '9')
                                throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = snext();
                } while (!isSpaceChar(c));
                return res * sgn;
        }

        public int[] nextIntArray(int n)
        {
                int a[] = new int[n];
                for (int i = 0; i < n; i++)
                {
                        a[i] = nextInt();
                }
                return a;
        }

        public long[] nextLongArray(int n)
        {
                long a[] = new long[n];
                for (int i = 0; i < n; i++)
                {
                        a[i] = nextLong();
                }
                return a;
        }

        public String readString()
        {
                int c = snext();
                while (isSpaceChar(c))
                {
                        c = snext();
                }
                StringBuilder res = new StringBuilder();
                do
                {
                        res.appendCodePoint(c);
                        c = snext();
                } while (!isSpaceChar(c));
                return res.toString();
        }

        public String nextLine()
        {
                int c = snext();
                while (isSpaceChar(c))
                        c = snext();
                StringBuilder res = new StringBuilder();
                do
                {
                        res.appendCodePoint(c);
                        c = snext();
                } while (!isEndOfLine(c));
                return res.toString();
        }

        public boolean isSpaceChar(int c)
        {
                if (filter != null)
                        return filter.isSpaceChar(c);
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c)
        {
                return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter
        {
                public boolean isSpaceChar(int ch);
        }

    }
}    
