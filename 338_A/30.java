import java.util.*;
import java.io.*;


public class A2 {
/*



 */
    public static void main(String[] args) throws Exception {
        uu.s1();
        uu.out.close();
    }
    public static class uu {
        public static BR in = new BR();
        public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        public static boolean bg = true;
        public static MOD m1 = new MOD(1000000000+9);
        public static long mod = 1000000000+9;
        public static void s1() throws Exception {
            long n = in.ni();
            long m = in.ni();
            long k = in.ni();
            long lose = n - m;
            long aval = m / (k - 1l);
            long times1 = Math.min(lose, aval);
            long notused = times1 * (k - 1l);
            long used = m - notused;
            long blocks = used / k;
            long left = used % k;
            long k1 = 0;
            if (blocks != 0){
                k1 = m1.pow(2, blocks+1);
                k1 = m1.s(k1, 2);
            }
            long ans = (m1.t(k, k1)+left + notused)%mod;
            pn(ans);
        }
        public static void geom(long f1){
        }
        
        public static void s2() throws Exception {
            
        }
        public static void s3() throws Exception {
            
        }
        
        private static void pn(Object... o1) {
            for (int i = 0; i < o1.length; i++){
                if (i!= 0) out.print(" ");
                out.print(o1[i]);
            }
            out.println();
        }

        public static boolean allTrue(boolean ... l1){
            for (boolean e: l1) if (!e) return false;
            return true;
        }
        public static boolean allFalse(boolean ... l1){
            for (boolean e: l1) if (e) return false;
            return true;
        }
    }
    private static class MOD {
        public long mod = -1;

        public MOD(long k1) {
            mod = k1;
        }

        public long cl(long n1){
            long fin = n1%mod;
            if (fin<0) fin+= mod;
            return fin;
        }
        
        public long s(long n1, long n2) {
            long k1 = (n1 - n2) % mod;
            if (k1 < 0)
                k1 += mod;
            return k1;
        }

        public long t(long n1, long n2) {
            long k1 = (n1 * n2) % mod;
            if (k1 < 0)
                k1 += mod;
            return k1;
        }

        public static long xgcd(long n1, long n2) {
            long k1 = n1;
            long k2 = n2;
            long[] l1 = { 1, 0 };
            long[] l2 = { 0, 1 };
            for (;;) {
                long f1 = k1 / k2;
                long f2 = k1 % k2;
                if (f2 == 0)
                    break;

                long[] l3 = { 0, 0 };
                l3[0] = l1[0] - f1 * l2[0];
                l3[1] = l1[1] - f1 * l2[1];
                l1 = l2;
                l2 = l3;

                k1 = k2;
                k2 = f2;
            }
            long fin = l2[1] % n1;
            if (fin < 0) {
                fin += n1;
            }
            return fin;
        }

        public long pow(long n1, long pow) {
            if (pow == 0)
                return 1;
            else if (pow == 1)
                return t(1l, n1);
            else if ((pow & 1) == 0) {
                long half = pow(n1, pow >> 1);
                return t(half, half);
            } else {
                long half = pow(n1, pow >> 1);
                return t(half, t(half, n1));
            }
        }

        public long factorial(long k1, long n1) {
            long fin = 1;
            long q1 = k1;
            for (int i = 0; i < n1; i++) {
                fin = t(fin, q1);
                q1--;
                if (q1 <= 0)
                    break;
            }
            return cl(fin);
        }

    }
    
    private static class BR {
        BufferedReader k1 = null;
        StringTokenizer k2 = null;

        public BR() {
            k1 = new BufferedReader(new InputStreamReader(System.in));
        }
        public String nx() throws Exception {
            for (;;) {
                if (k2 == null || !k2.hasMoreTokens()) {
                    String temp = k1.readLine();
                    if (temp == null)
                        return null;
                    k2 = new StringTokenizer(temp);
                }
                else
                    break;
            }

            return k2.nextToken();
        }

        public int ni() throws Exception {
            return Integer.parseInt(nx());
        }
    }
}
