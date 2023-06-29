import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by aditya on 5/3/17.
 */
public class Main3 {

    static long x, k;
    static long MOD = (long)1e9 + 7;

    public static void main(String args[]) throws Exception{
        FastInput fi = new FastInput(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        x = fi.nextLong();
        k = fi.nextLong();

        if(x == 0) {
            System.out.println(0);
            return;
        }

//        System.out.println(pow(2, k+1));
        long q1 = (pow(2, k+1) * (x%MOD)) % MOD;
        long q2 = pow(2, k);
        long q3 = 1;
//        System.out.println(q1);
//        System.out.println(q2);
//        System.out.println(q3);


        long exp = (q1-q2 + MOD + MOD)%MOD;
        exp = (exp + q3)%MOD;

//        exp = (exp*2)%MOD;

        pw.println(exp);

        pw.close();
    }

    static long pow(long n, long k) {
        if(k == 0)
            return 1;
        if(k == 1)
            return n;
        long ret = pow(n, k/2)%MOD;
        ret = (ret*ret)%MOD;
        if(k%2 == 1)
            ret = (ret*n)%MOD;

        return ret;
    }

    static class FastInput {

        private Reader in;
        private BufferedReader br;
        private StringTokenizer st;

        public FastInput(Reader in) {
            this.in=in;
            br = new BufferedReader(in);
        }

        public String nextString() {

            while(st==null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    System.out.println(e.getStackTrace());
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

        public long nextLong() {
            return Long.parseLong(nextString());
        }

        public double nextDouble() {

            return Double.parseDouble(nextString());
        }

    }

}
