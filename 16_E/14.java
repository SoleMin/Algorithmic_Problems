import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author AlexFetisov
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskE solver = new TaskE();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskE {

    private int n;
    private double[] dp;
    private double[][] p;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        p = new double[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                p[i][j] = in.nextDouble();
            }
        }
        dp = new double[1 << n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; ++i) {
            out.printf("%.6f ", rec(1 << i));
        }
        out.println();
    }

    private double rec(int mask) {
        if (mask == (1 << n) - 1) return 1;
        if (dp[mask] > -0.5) return dp[mask];
        double res = 0;
        int nn = Integer.bitCount(mask);
        int total = (nn * (nn + 1)) / 2;
        for (int i = 0; i < n; ++i) if (BitUtils.checkBit(mask, i)) for (int j = 0; j < n; ++j) if (!BitUtils.checkBit(mask, j)) {
            res += rec(BitUtils.setBit(mask, j)) * p[i][j];
        }
        res /= total;
        dp[mask] = res;
        return res;
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer stt;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String nextLine() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            return null;
        }
    }

    public String nextString() {
        while (stt == null || !stt.hasMoreTokens()) {
            stt = new StringTokenizer(nextLine());
        }
        return stt.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextString());
    }

    public double nextDouble() {
        return Double.parseDouble(nextString());
    }

}

class BitUtils {
    public static boolean checkBit(int mask, int bit) {
        return (mask & (1 << bit)) > 0;
    }

    public static int setBit(int mask, int bit) {
        return (mask | (1 << bit));
    }

}

