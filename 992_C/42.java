import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by artur on 18/06/18
 */
public class A
{
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = null;

    long mod = 1000000007;

    public static void main(String[] args) throws IOException
    {
        new A().solve();
    }

    private void solve() throws IOException
    {
        long x = nl();
        long k = nl();

        if (x == 0)
        {
            System.out.println(0);
            System.exit(0);
        }

        if (k == 0)
        {
            System.out.println((x * 2) % mod);
            System.exit(0);
        }

//        for (int sx = 0; sx < 100; sx++)
//        {
//            for (int sk = 0; sk < 100; sk++)
//            {
//                BigInteger n = BigInteger.valueOf(2)
//                        .modPow(BigInteger.valueOf(k + 1), BigInteger.valueOf(mod))
//                        .multiply(BigInteger.valueOf(x))
//                        .add(BigInteger.ONE)
//                        .subtract(BigInteger.valueOf(2)
//                                .modPow(BigInteger.valueOf(k), BigInteger.valueOf(mod)))
//                        .mod(BigInteger.valueOf(mod));
//                long res = n.longValue();
//
//                long aux = aux(sx, sk);
//                if ((res % mod) != aux) {
//                    System.out.println(sx + " " + sk + ": " + res + " " + aux);
//                }
//            }
//        }

        BigInteger n = BigInteger.valueOf(2)
                .modPow(BigInteger.valueOf(k + 1), BigInteger.valueOf(mod))
                .multiply(BigInteger.valueOf(x))
                .add(BigInteger.ONE)
                .subtract(BigInteger.valueOf(2)
                        .modPow(BigInteger.valueOf(k), BigInteger.valueOf(mod)))
                .mod(BigInteger.valueOf(mod));

        System.out.println(n.toString());
    }

    long aux(long x, long k) {
        long p1 = 2 * x;
        long p2 = 2 * x - 1;

        for (int i = 0; i < k - 1; i++)
        {
            p1 = (p1 * 2) % mod;
            p2 = (p2 * 2 - 1) % mod;
        }

        return ((p1 + p2) % mod);
    }

    void debug(Object... os)
    {
        System.out.println(Arrays.deepToString(os));
    }

    int ni() throws IOException
    {
        return Integer.parseInt(ns());
    }

    long nl() throws IOException
    {
        return Long.parseLong(ns());
    }

    double nd() throws IOException
    {
        return Double.parseDouble(ns());
    }

    String ns() throws IOException
    {
        while (tokenizer == null || !tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(br.readLine());
        return tokenizer.nextToken();
    }

    String nline() throws IOException
    {
        tokenizer = null;
        return br.readLine();
    }

    private static long gcd(long a, long b)
    {
        while (b > 0)
        {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    private static long lcm(long a, long b)
    {
        return a * (b / gcd(a, b));
    }
}
