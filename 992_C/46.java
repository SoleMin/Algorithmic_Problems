import java.io.*;

import java.util.*;



public class ModifyLongest {

    InputStream is;

    PrintWriter out;

    String INPUT = "";

    //boolean codechef=true;

    boolean codechef=true;

    void solve()
    {
        /*
        long l=ni(),r=ni(),x=ni(),y=ni();
        long prod=x;
        prod*=y;
        int cnt=0;
        if(l==r && r==x && x==y && x==1)
        {
            System.out.println(1);
            return;
        }
        //HashSet<Long> set=new HashSet<>();
        for(long i=2;i<=Math.sqrt(prod);i++)
        {
            if(prod%i==0)
            {
                if(Math.min(i,prod/i)>=l && Math.max(i,prod/i)<=r && gcd(i,prod/i)==x)
                {
                    //set.add(fnc2(i,prod/i));
                    //set.add(fnc2(prod/i,i));
                    if(i!=prod/i)cnt+=2;
                    else cnt++;
                }
            }
        }
        ArrayList<Long> factors=new ArrayList<>();
        while(prod!=1)
        {
            long currF=PollardRho(prod);
            while(prod%currF!=0)
            {
                prod/=currF;
                factors.add(currF);
            }

        }

        if(l==1)
        {
            System.out.println((cnt+2));
        }
        else
        {
            System.out.println(cnt);
        }

*/
        long mod=1000000007;
        long x=nl(),k=nl();
        if(x==0)
        {
            System.out.println(0);
            return;
        }
        long val=calc((pow(2,k,mod)*(x%mod))%mod);
        val-=calc(((pow(2,k,mod)*(x%mod))%mod-(pow(2,k,mod)-1)-1+mod)%mod);
        //val*=2;

        val=(val+mod)%mod;
        val=(val*inv(pow(2,k,mod),mod))%mod;
        System.out.println(val);

    }

    static long calc(long a)
    {
        long b=(a*(a+1))%1000000007;
        return b;
    }


    /* method to return prime divisor for n */
    long PollardRho(long n)
    {
        /* initialize random seed */
        //srand (time(NULL));

        /* no prime divisor for 1 */
        if (n==1) return n;

        /* even number means one of the divisors is 2 */
        if (n % 2 == 0) return 2;
        Random r=new Random();
        /* we will pick from the range [2, N) */
        long x = (r.nextLong()%(n-2))+2;
        long y = x;

        /* the constant in f(x).
         * Algorithm can be re-run with a different c
         * if it throws failure for a composite. */
        long c = (r.nextLong()%(n-1))+1;

        /* Initialize candidate divisor (or result) */
        long d = 1;

    /* until the prime factor isn't obtained.
       If n is prime, return n */
        while (d==1)
        {
            /* Tortoise Move: x(i+1) = f(x(i)) */
            x = (pow(x, 2, n) + c + n)%n;

            /* Hare Move: y(i+1) = f(f(y(i))) */
            y = (pow(y, 2, n) + c + n)%n;
            y = (pow(y, 2, n) + c + n)%n;

            /* check gcd of |x-y| and n */
            d = gcd(Math.abs(x-y), n);

            /* retry if the algorithm fails to find prime factor
             * with chosen x and c */
            if (d==n) return PollardRho(n);
        }

        return d;
    }

    static HashMap<Long,HashSet<Long>> globalSet;





    static long fnc(int a,int b)

    {

        long val=Math.min(a,b)*1000000007;

        val+=Math.max(a,b);

        return val;

    }



    static long fnc2(long a,long b)

    {

        long val=a*1000000007;

        val+=b;

        return val;

    }





    static class Pair

    {

        int a,b;

        public Pair(int a,int b)

        {

            this.a=a;

            this.b=b;

        }

    }



    static int bit[];



    static void add(int x,int d,int n)

    {

        for(int i=x;i<=n;i+=i&-i)bit[i]+=d;

    }



    static int query(int x)

    {

        int ret=0;

        for(int i=x;i>0;i-=i&-i)

            ret+=bit[i];

        return ret;

    }



    static long lcm(int a,int b)

    {

        long val=a;

        val*=b;

        return (val/gcd(a,b));

    }



    static long gcd(long a,long b)

    {

        if(a==0)return b;

        return gcd(b%a,a);

    }



    static long pow(long a, long b, long p)

    {

        long ans = 1, base = a;

        while (b!=0)

        {

            if ((b & 1)!=0)

            {

                ans *= base;

                ans%= p;

            }

            base *= base;

            base%= p;

            b >>= 1;

        }

        return ans;

    }



    static long inv(long x,long p)

    {

        return pow(x, (int)p - 2, p);

    }





    void run() throws Exception

    {

        if(codechef)oj=true;

        is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());

        out = new PrintWriter(System.out);



        long s = System.currentTimeMillis();

        solve();

        out.flush();

        tr(System.currentTimeMillis()-s+"ms");

    }



    public static void main(String[] args) throws Exception {new ModifyLongest().run();}



    private byte[] inbuf = new byte[1024];

    public int lenbuf = 0, ptrbuf = 0;



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

        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')

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



    private boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    private void tr(Object... o) { if(!oj)System.out.println(Arrays.deepToString(o)); }

}