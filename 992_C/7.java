import java.io.*;
import java.math.BigInteger;
import java.util.Locale;
import java.util.StringTokenizer;

public class C {
    String fileName = "<name>";

    public static final int MOD = (int) (1e9 + 7);

    public void solve() throws IOException {
        long x = nextLong();
        if (x == 0) {
            out.print(0);
            return;
        }
        long k = nextLong();
        BigInteger power = BigInteger.valueOf(2)
                .modPow(BigInteger.valueOf(k), BigInteger.valueOf(MOD));
        BigInteger r = BigInteger.valueOf(x).multiply(power);
        BigInteger l = r.subtract(power).add(BigInteger.ONE);
        out.print(l.add(r).mod(BigInteger.valueOf(MOD)));
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new C().run();
    }
}