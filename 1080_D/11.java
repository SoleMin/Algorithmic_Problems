import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.function.Function;

public class D {
    public static void main(String[] args) throws IOException {
        try (Input input = new StandardInput(); PrintWriter writer = new PrintWriter(System.out)) {
            long[] s = new long[40];
            for (int i = 1; i < s.length; i++) {
                s[i] = 1 + 4 * s[i - 1];
                if (i >= 32) {
                    s[i] = Long.MAX_VALUE;
                }
            }
            Function<Integer, Long> getS = (i) -> (i < s.length) ? s[i] : Long.MAX_VALUE;
            int t = input.nextInt();
            testCase:
            for (int tt = 0; tt < t; tt++) {
                int n = input.nextInt();
                long k = input.nextLong();
                long kk = 1;
                BigInteger maxDivisions = BigInteger.ZERO;
                for (int division = 1; division <= n; division++) {
                    long needToDivide = (1L << division) - 1;
                    if (needToDivide > k) {
                        writer.println("NO");
                        continue testCase;
                    }
                    k -= needToDivide;
                    maxDivisions = maxDivisions.add(BigInteger.valueOf(kk).multiply(BigInteger.valueOf(getS.apply(n - division))));
                    if (maxDivisions.compareTo(BigInteger.valueOf(k)) >= 0) {
                        writer.println("YES " + (n - division));
                        continue testCase;
                    }
                    kk += (1L << division + 1);
                }
                writer.println("NO");
            }
        }
    }

    interface Input extends Closeable {
        String next() throws IOException;

        default int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        default long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    private static class StandardInput implements Input {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        private StringTokenizer stringTokenizer;

        @Override
        public void close() throws IOException {
            reader.close();
        }

        @Override
        public String next() throws IOException {
            if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                stringTokenizer = new StringTokenizer(reader.readLine());
            }
            return stringTokenizer.nextToken();
        }
    }
}