import java.io.*;
import java.math.BigInteger;

public class C {

    private static Solver solver = new Solver();

    private static long m = 1000000000L + 7L;

    public static void main(String[] args) throws IOException {
        solver.withProcedure(() -> {
            String[] input = solver.readString().split(" ");
            BigInteger x = new BigInteger(input[0]);
            BigInteger k = new BigInteger(input[1]);

            if (x.compareTo(BigInteger.ZERO) == 0) {
                solver.println("" + 0);
                return;
            }

            BigInteger two = BigInteger.valueOf(2);

            BigInteger mm = BigInteger.valueOf(m);
            BigInteger binpowedK = two.modPow(k, mm);
            BigInteger binpowedKPlusOne = two.modPow(k.add(BigInteger.ONE), mm);

            BigInteger res = binpowedKPlusOne.multiply(x).subtract(binpowedK.subtract(BigInteger.ONE)).mod(mm);

            if (res.compareTo(BigInteger.ZERO) < 0) {
                res = BigInteger.ZERO;
            }

            solver.println("" + res);
        }).solve();
    }

    private static long binpow(long a, long n) {
        a = a % m;

        long res = 1L;
        while (n > 0) {
            if ((n & 1L) != 0)
                res = (res * a) % m;

            a = (a * a) % m;
            n >>= 1L;
        }

        return res;
    }


    @FunctionalInterface
    private interface Procedure {
        void run() throws IOException;
    }

    private static class Solver {
        private Procedure procedure;

        private StreamTokenizer in;
        private PrintWriter out;
        private BufferedReader bufferedReader;

        Solver() {
            try {
                boolean oj = System.getProperty("ONLINE_JUDGE") != null;

                Reader reader = oj ? new InputStreamReader(System.in) : new FileReader("input.txt");
                Writer writer = oj ? new OutputStreamWriter(System.out) : new FileWriter("output.txt");

                bufferedReader = new BufferedReader(reader);
                in = new StreamTokenizer(bufferedReader);
                out = new PrintWriter(writer);
            } catch (Exception e) {
                throw new RuntimeException("Initialization has failed");
            }
        }

        void solve() throws IOException {
            procedure.run();
        }

        int readInt() throws IOException {
            in.nextToken();
            return (int) in.nval;
        }

        long readLong() throws IOException {
            in.nextToken();
            return (long) in.nval;
        }

        String readString() throws IOException {
            return bufferedReader.readLine();
        }

        char readChar() throws IOException {
            in.nextToken();
            return in.sval.charAt(0);
        }

        void println(String str) {
            out.println(str);
            out.flush();
        }

        void print(String str) {
            out.print(str);
            out.flush();
        }

        Solver withProcedure(Procedure procedure) {
            this.procedure = procedure;

            return this;
        }
    }

}