import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class C {

    public static void main(String[] args) throws IOException {
        init(System.in);
        BigInteger x = new BigInteger(next());
        if (x.compareTo(BigInteger.ZERO) == 0) {
            System.out.println(0);
            return;
        }
        BigInteger k = new BigInteger(next());
        BigInteger mod = new BigInteger("1000000007");
        BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
        BigInteger ans = two.modPow(k, mod);
        ans = ans.multiply(two.multiply(x).subtract(BigInteger.ONE)).add(BigInteger.ONE).mod(mod);
        System.out.println(ans);
    }

    //Input Reader
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static void init(InputStream inputStream) {
        reader = new BufferedReader(new InputStreamReader(inputStream));
        tokenizer = new StringTokenizer("");
    }

    private static String next() throws IOException {
        String read;
        while (!tokenizer.hasMoreTokens()) {
            read = reader.readLine();
            if (read == null || read.equals(""))
                return "-1";
            tokenizer = new StringTokenizer(read);
        }

        return tokenizer.nextToken();
    }

//    private static int nextInt() throws IOException {
//        return Integer.parseInt(next());
//    }

//    private static long nextLong() throws IOException {
//        return Long.parseLong(next());
//    }
//
//    //    Get a whole line.
//    private static String line() throws IOException {
//        return reader.readLine();
//    }
//
//    private static double nextDouble() throws IOException {
//        return Double.parseDouble(next());
//    }
}

