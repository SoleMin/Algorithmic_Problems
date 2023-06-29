import java.io.*;
import java.util.Scanner;

/**
 * @author pvasilyev
 * @since 8/16/13
 */
public class ProblemC {

    public static final String FILE_IN = "std.in";
    public static final String FILE_OUT = "std.out";
    private static boolean debugMode = true;
    private static final long MOD = 1000 * 1000 * 1000 + 9;

    public static void main(String[] args) throws IOException {

        final Scanner reader = new Scanner(new InputStreamReader(debugMode ? System.in : new FileInputStream(FILE_IN)));
        final PrintWriter writer = new PrintWriter(debugMode ? System.out : new FileOutputStream(FILE_OUT));

//        final long start = System.currentTimeMillis();
        solveTheProblem(reader, writer);
//        System.out.println(System.currentTimeMillis() - start);

        reader.close();
        writer.close();
    }

    private static void solveTheProblem(final Scanner reader, final PrintWriter writer) {

        final long n = reader.nextLong();
        final long m = reader.nextLong();
        final long k = reader.nextLong();

        if (n - n/k >= m) {
            writer.println(m);
            return;
        } else {
            long sum = 1;
            long maxK = m - n + n/k;
            sum = fastPow(2, maxK);
            sum = 2 * (sum - 1);
            sum = sum % MOD;
            sum *= k;
            sum += m - maxK * k;
            writer.println(sum % MOD);
        }

    }

    private static long fastPow(final int exp, final long deg) {
        if (deg == 0) {
            return 1;
        } else if (deg == 1) {
            return exp;
        } else if (deg % 2 == 0) {
            long temp = fastPow(exp, deg / 2);
            temp = (temp * temp) % MOD;
            return temp;
        } else {
            long temp = fastPow(exp, deg / 2);
            temp = (temp * temp) % MOD;
            return (temp * exp) % MOD;
        }
    }


}
