import java.io.*;
import java.util.StringTokenizer;

public class C {

    static final int MOD = (int)1e9 + 7;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long x = sc.nextLong(), k = sc.nextLong();
        if(x == 0)
            out.println(0);
        else
            out.println(((x % MOD * 2 - 1 + MOD) % MOD * modPow(2, k) % MOD + 1) % MOD);
        out.close();
    }

    static long modPow(long b, long e) {
        long res = 1;
        while(e > 0) {
            if((e & 1) == 1)
                res = res * b % MOD;
            b = b * b % MOD;
            e >>= 1;
        }

        return res;
    }

    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public double nextDouble() throws IOException { return Double.parseDouble(next()); }

        public String nextLine() throws IOException {return br.readLine();}

        public boolean ready() throws IOException { return br.ready(); }

    }
}
