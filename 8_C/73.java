import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.util.Comparator;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.io.Writer;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Nguyen Trung Hieu - vuondenthanhcong11@yahoo.com
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int xs = in.readInt();
        int ys = in.readInt();
        int n = in.readInt();
        int[] x = new int[n];
        int[] y = new int[n];
        IOUtils.readIntArrays(in, x, y);
        int[] res = new int[1 << n];
        int[] last = new int[1 << n];
        Arrays.fill(res, Integer.MAX_VALUE);
        int[] ds = new int[n];
        for (int i = 0; i < n; i++) {
            ds[i] = (x[i] - xs) * (x[i] - xs) + (y[i] - ys) * (y[i] - ys);
        }
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                d[i][j] = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
        }
        res[0] = 0;
        for (int i = 1; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) != 0) {
                    if (res[i - (1 << j)] + 2 * ds[j] < res[i]) {
                        res[i] = res[i - (1 << j)] + 2 * ds[j];
                        last[i] = i - (1 << j);
                    }
                    for (int k = j + 1; k < n; k++) {
                        if (((i >> k) & 1) != 0) {
                            if (res[i - (1 << j) - (1 << k)] + ds[j] + ds[k] + d[j][k] < res[i]) {
                                res[i] = res[i - (1 << j) - (1 << k)] + ds[j] + ds[k] + d[j][k];
                                last[i] = i - (1 << j) - (1 << k);
                            }
                        }
                    }
                    break;
                }
            }
        }
        int cur = (1 << n) - 1;
        out.printLine(res[cur]);
        while (cur != 0) {
            out.print("0 ");
            int dif = cur - last[cur];
            for (int i = 0; i < n && dif != 0; i++) {
                if (((dif >> i) & 1) != 0) {
                    out.print((i + 1) + " ");
                    dif -= (1 << i);
                }
            }
            cur = last[cur];
        }
        out.printLine("0");
    }
}

class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

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

    public int readInt() {
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
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }

    }

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object...objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void printLine(Object...objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

}

class IOUtils {

    public static void readIntArrays(InputReader in, int[]... arrays) {
        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = 0; j < arrays.length; j++)
                arrays[j][i] = in.readInt();
        }
    }

    }
