// Author: aman_robotics

//package math_codet;

import java.io.*;
import java.util.*;

public class lets_do {
    FastReader in;
    PrintWriter out;
    Helper_class h;
    final long mod = 1000000009;
    final int MAXN = 1000005;
    final int lgN = 20;
    final long INF = (long)1e18;
    final long MAX_Ai = (long)1e12;
    public static void main(String[] args) throws java.lang.Exception{
        new lets_do().run();
    }
    void run() throws Exception{
        in=new FastReader(System.in);
        out = new PrintWriter(System.out);
        h = new Helper_class();
        int t = 1;
        while(t--> 0)
            solve();
        out.flush();
        out.close();
    }
    void solve(){
        int n = h.ni();
        long[] arr = new long[n];
        int i = 0, j = 0;
        for(i = 0; i < n; i++)
            arr[i] = h.nl();
        HashMap<Long, Integer> hmap = new HashMap<Long, Integer>();
        int cnt = 0;
        for(i = 0; i < n; i++){
            long sum = 0;
            for(j = i; j < n; j++){
                sum += arr[j];
                Integer x = hmap.get(sum);
                if(x == null)
                    hmap.put(sum, cnt++);
            }
        }
        TreeSet<Pair>[] tset = new TreeSet[cnt];
        for(i = 0; i < cnt; i++)
            tset[i] = new TreeSet<Pair>(com);
        for(i = 0; i < n; i++){
            long sum = 0;
            for(j = i; j < n; j++){
                sum += arr[j];
                tset[hmap.get(sum)].add(new Pair(i, j));
            }
        }
        int max = 0;
        int ind = -1;
        int max_x = 0, max_y = 0;
        for(i = 0; i < cnt; i++){
        	int curr_y = tset[i].first().y;
        	int cnt1 = 1;
            for(Pair yo : tset[i]){
                if(yo.x > curr_y) {
                	cnt1++;
                	curr_y = yo.y;
                }
            }
            if(max < cnt1) {
            	max = cnt1;
            	ind = i;
            }
        }
        h.pn(max);
        Pair hola_yee = new Pair(tset[ind].first().x, tset[ind].first().y);
        h.pn((tset[ind].first().x + 1) +" "+(tset[ind].first().y + 1));
        int curr_y = tset[ind].first().y;
        for(Pair yo : tset[ind]){
            if(yo.x > curr_y) {
            	curr_y = yo.y;
            	h.pn((yo.x + 1) +" "+(yo.y + 1));
            }
        }
    }



    static final Comparator<Pair> com=new Comparator<Pair>(){
        public int compare(Pair a, Pair b){
            if(Integer.compare(a.y, b.y) != 0)
                return Integer.compare(a.y, b.y);
            else
                return Integer.compare(a.x, b.x);
        }
    };

    class Pair{
        int x;
        int y;
        Pair(int p, int q){
            x = p;
            y = q;
        }
    }
    class Edge{
        int u , v;
        long wt;
        Edge(int a, int b, long w){
            u = a;
            v = b;
            wt = w;
        }
        int other(int x) {
            return u ^ v ^ x;
        }
    }


    class Helper_class{
        long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
        int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
        int bitcount(long n){return (n==0)?0:(1+bitcount(n&(n-1)));}
        void p(Object o){out.print(o);}
        void pn(Object o){out.println(o);}
        void pni(Object o){out.println(o);out.flush();}
        String n(){return in.next();}
        String nln(){return in.nextLine();}
        int ni(){return Integer.parseInt(in.next());}
        long nl(){return Long.parseLong(in.next());}
        double nd(){return Double.parseDouble(in.next());}

        long mul(long a,long b){
            if(a>=mod)a%=mod;
            if(b>=mod)b%=mod;
            a*=b;
            if(a>=mod)a%=mod;
            return a;
        }
        long modPow(long a, long p){
            long o = 1;
            while(p>0){
                if((p&1)==1)o = mul(o,a);
                a = mul(a,a);
                p>>=1;
            }
            return o;
        }
        long add(long a, long b){
            if(a>=mod)a%=mod;
            if(b>=mod)b%=mod;
            if(b<0)b+=mod;
            a+=b;
            if(a>=mod)a-=mod;
            return a;
        }
    }

    class FastReader{
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int peek() {
            if (numChars == -1)
                return -1;
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar];
        }

        public void skip(int x) {
            while (x-- > 0)
                read();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String nextString() {
            return next();
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        public String nextLine() {
            StringBuffer buf = new StringBuffer();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r')
                    buf.appendCodePoint(c);
                c = read();
            }
            return buf.toString();
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

        public boolean hasNext() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1)
                read();
            return value != -1;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
} 