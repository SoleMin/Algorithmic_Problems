import java.io.BufferedReader;
import java.util.Comparator;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.Collections;
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
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {

    private double[][][] dp;
    private int n;
    private int k;
    private int[] loyalty;
    private int[] level;
    double[] P;
    private int a;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        k = in.nextInt();
        a = in.nextInt();
        level = new int[n];
        loyalty = new int[n];
        for (int i = 0; i < n; ++i) {
            level[i] = in.nextInt();
            loyalty[i] = in.nextInt();
        }

        P = new double[1 << n];
        for (int mask = 0; mask < (1 << n); ++mask) {
            if (Integer.bitCount(mask) * 2 > n) {
                P[mask] = 1.;
            } else {
                double sumB = 0;
                for (int i = 0; i < n; ++i) {
                    if (!BitUtils.checkBit(mask, i)) {
                        sumB += level[i];
                    }
                }
                P[mask] = (double)a / (sumB + a);
            }
        }

        dp = new double[1 << n][n + 1][k + 1];
        ArrayUtils.fill(dp, -1);
        newLoyalty = new int[n];
        //double res = rec(0, 0, k, 0);
        brute(0, k);
        out.println(best);
    }

    int[] newLoyalty;
    double best = 0;

    void brute(int id, int leftCandies) {
        if (id == n) {
            double cur = calcCur();
            if (best < cur) {
                best = cur;
            }
            return;
        }
        for (int candies = 0; candies <= leftCandies; ++candies) {
            newLoyalty[id] = loyalty[id] + candies * 10;
            if (newLoyalty[id] > 100) {
                break;
            }
            brute(id + 1, leftCandies - candies);
        }
    }

    private double calcCur() {
        double sum = 0;
        for (int mask = 0; mask < (1 << n); ++mask) {
            double p = getP(mask) * P[mask];
            sum += p;
        }
        return sum;
    }

    private double getP(int mask) {
        double p = 1;
        for (int i = 0; i < n; ++i) {
            if (BitUtils.checkBit(mask, i)) {
                p *= (newLoyalty[i] * 1.) / 100.;
            } else {
                p *= (100. - newLoyalty[i]) / 100.;
            }
        }
        return p;
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

}

class BitUtils {
    public static boolean checkBit(int mask, int bit) {
        return (mask & (1 << bit)) > 0;
    }

}

class ArrayUtils {

    public static void fill(double[][][] f, double value) {
        for (int i = 0; i < f.length; ++i) {
            for (int j = 0; j < f[i].length; ++j) {
                Arrays.fill(f[i][j], value);
            }
        }
    }

}

