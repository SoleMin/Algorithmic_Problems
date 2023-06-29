import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class ProblemE
{

    static int mod = (int) (1e9+7);
    static InputReader in;
    static PrintWriter out;
    
    static class SegmentTree {
        long st[];
 
        SegmentTree(int n)  {
            st = new long[4*n];
            build(0, n - 1, 1);
        }
        
        int getMid(int s, int e) {
            return (s+e)>>1;
        }

        long merge(long a,long b){
            return a+b;
        }
        
        void update(int s, int e, int x, int y, long c, int si){
            if(s == x && e == y){
                st[si] += c;
            }
            else{
                int mid = getMid(s, e);
                if(y <= mid)    
                    update(s, mid, x, y, c, 2*si);
                else if(x > mid)
                    update(mid + 1, e, x ,y ,c ,2*si + 1);
                else{
                    update(s, mid, x, mid, c, 2*si);
                    update(mid + 1, e, mid + 1, y, c, 2*si + 1);
                }
                st[si] = merge(st[2*si],st[2*si+1]);
            }
        }

        long  get(int s, int e, int x, int y, int si){

            if(s == x && e == y){
                return st[si];
            }
            int mid = getMid(s, e);
            if(y <= mid)
                return get(s, mid, x, y, 2*si);
            else if(x > mid)
                return get(mid + 1, e, x, y, 2*si + 1);
            return merge(get(s, mid, x, mid, 2*si), get(mid + 1, e, mid + 1, y, 2*si + 1));
        }

        void build(int ss, int se, int si){
            if (ss == se) {
                st[si] = 0;
                return;
            }

            int mid = getMid(ss, se);
            build(ss, mid, si * 2 );
            build(mid + 1, se, si * 2 + 1);
            st[si] = merge(st[2*si],st[2*si+1]);
        }
        
    }

    
    public static void main(String[] args) throws FileNotFoundException
    {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);            
        
        int n = in.nextInt();
        int[] arr = in.nextIntArray(n);
        ArrayList<Integer>list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            list.add(arr[i]);
            list.add(arr[i] + 1);
            list.add(arr[i] - 1);
        }
        Collections.sort(list);
        int j = 1;
        for(int k : list){
            if(map.containsKey(k)) continue;
            map.put(k, j++);
        }
        
        SegmentTree seg = new SegmentTree(j + 1);
        SegmentTree seg1 = new SegmentTree(j + 1);
        BigInteger ans = BigInteger.ZERO;
        BigInteger sum = BigInteger.ZERO;
//        long ans = 0;
//        long sum = 0;
        for(int i = 0; i < n; i++){
            long x = seg.get(0, j - 1, map.get(arr[i] - 1), map.get(arr[i] + 1), 1);
            long y = seg1.get(0, j - 1, map.get(arr[i] - 1), map.get(arr[i] + 1), 1);
            ans = ans.add(new BigInteger(""+x));
            ans = ans.subtract(sum);
            ans = ans.add(new BigInteger(""+((arr[i] * 1l *(i - y)))));
//              ans += arr[i] * 1l * (i - y) - sum + x;
            
            seg.update(0, j - 1, map.get(arr[i]), map.get(arr[i]), arr[i], 1);
            seg1.update(0, j - 1, map.get(arr[i]), map.get(arr[i]), 1, 1);
            sum = sum.add(new BigInteger(arr[i] + ""));
        }
        
        out.println(ans);
        out.close();
    }

    static class Pair implements Comparable<Pair>
    {

        int x,y;
        int i;
        
        Pair (int x,int y)
        {
                this.x = x;
                this.y = y;
        }

        Pair (int x,int y, int i)
        {
                this.x = x;
                this.y = y;
                this.i = i;
        }

        public int compareTo(Pair o)
        {
            return Long.compare(this.i,o.i);
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
            return x + " "+ y + " "+i;
        }

        /*public int hashCode()
        {
            return new Long(x).hashCode() * 31 + new Long(y).hashCode();
        }*/

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
            return n;
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
