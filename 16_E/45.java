import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Locale;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.AbstractList;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Jacob Jiang
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskE solver = new TaskE();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskE {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        double[][] probability = in.next2DDoubleArray(n, n);
        double[] dp = new double[1 << n];
        dp[dp.length - 1] = 1;
        for (int mask = (1 << n) - 1; mask >= 0; mask--) {
            int count = Integer.bitCount(mask);
            if (count <= 1) continue;
            double multi = 1. / calc(count);
            for (int i = 0; i < n; i++) {
                if (NumberUtils.checkBit(mask, i)) {
                    for (int j = i + 1; j < n; j++) {
                        if (NumberUtils.checkBit(mask, j)) {
                            // i eat j
                            dp[mask - (1 << j)] += multi * probability[i][j] * dp[mask];
                            // j eat i
                            dp[mask - (1 << i)] += multi * probability[j][i] * dp[mask];
                        }
                    }
                }
            }
        }
        double[] answer = new double[n];
        for (int i = 0; i < n; i++) {
            answer[i] = dp[1 << i];
        }
        out.printLine(ArrayUtils.asList(answer).toArray());
    }

    private static int calc(int x) {
        return x * (x - 1) / 2;
    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c & 15;
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public double nextDouble() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E')
                return res * Math.pow(10, nextInt());
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    public double[] nextDoubleArray(int count) {
        double[] result = new double[count];
        for (int i = 0; i < count; i++) {
            result[i] = nextDouble();
        }
        return result;
    }

    public double[][] next2DDoubleArray(int n, int m) {
        double[][] result = new double[n][];
        for (int i = 0; i < n; i++) {
            result[i] = nextDoubleArray(m);
        }
        return result;
    }

    }

class OutputWriter {
    PrintWriter writer;

    public OutputWriter(OutputStream stream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(stream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object obj) {
        writer.print(obj);
    }

    public void println() {
        writer.println();
    }

    public void print(char c) {
        writer.print(c);
    }

    public void close() {
        writer.close();
    }

    public void printItems(Object... items) {
        for (int i = 0; i < items.length; i++) {
            if (i != 0) {
                print(' ');
            }
            print(items[i]);
        }
    }

    public void printLine(Object... items) {
        printItems(items);
        println();
    }

}

class NumberUtils {

    public static boolean checkBit(int mask, int bit) {
        return (mask & (1 << bit)) != 0;
    }

    }

class ArrayUtils {

    private ArrayUtils() {
    }

    public static List<Double> asList(double[] array) {
        return new DoubleList(array);
    }

    private static class DoubleList extends AbstractList<Double> {
        double[] array;

        private DoubleList(double[] array) {
            this.array = array;
        }

        public Double set(int index, Double element) {
            double result = array[index];
            array[index] = element;
            return result;
        }

        public Double get(int index) {
            return array[index];
        }

        public int size() {
            return array.length;
        }
    }

    }

