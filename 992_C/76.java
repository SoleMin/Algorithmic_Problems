import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class A {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        long x = scanner.nextLong();
        long k = scanner.nextLong();
        if (x==0) {
            System.out.println("0");
            return;
        }
        BigInteger M = BigInteger.valueOf(1000_000_000L+7);
        BigInteger modus = BigInteger.valueOf(x).multiply(BigInteger.valueOf(2)).subtract(BigInteger.ONE).mod(M);
        BigInteger operandi = BigInteger.valueOf(2).modPow(BigInteger.valueOf(k), M);
        BigInteger result = modus.multiply(operandi).mod(M).add(BigInteger.ONE).mod(M);
        System.out.println(result);
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b, long gcd) {
        return a * (b / gcd);
    }


    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
