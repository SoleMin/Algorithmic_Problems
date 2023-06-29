import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.Writer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author emotionalBlind
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
    int[] lo;
    int[] hi;

    long[][][][][] dp;
    long[] posVal;

    long go(int pos, int isAGreaterLo, int isALessHi, int isBGreaterLo, int isBLessHi) {
        if (pos == 63) {
            return 0;
        }
        if (dp[pos][isAGreaterLo][isALessHi][isBGreaterLo][isBLessHi] != -1) {
            return dp[pos][isAGreaterLo][isALessHi][isBGreaterLo][isBLessHi];
        }
        // range a
        int ua = 0;
        int va = 1;
        if (isALessHi == 0 && hi[pos] == 0) {
            va = 0;
        }
        if (isAGreaterLo == 0 && lo[pos] == 1) {
            ua = 1;
        }
        // range b;
        int ub = 0;
        int vb = 1;
        if (isBLessHi == 0 && hi[pos] == 0) {
            vb = 0;
        }
        if (isBGreaterLo == 0 && lo[pos] == 1) {
            ub = 1;
        }
        long res = 0;
        dp[pos][isAGreaterLo][isALessHi][isBGreaterLo][isBLessHi] = 0;
        for (int i = ua; i <= va; ++i) {
            int newIsAGreaterLo = isAGreaterLo;
            int newIsALessHi = isALessHi;
            if (i < hi[pos]) newIsALessHi = 1;
            if (i > lo[pos]) newIsAGreaterLo = 1;
            for (int j = ub; j <= vb; ++j) {
                int newIsBGreaterLo = isBGreaterLo;
                int newIsBLessHi = isBLessHi;
                if (j < hi[pos]) newIsBLessHi = 1;
                if (j > lo[pos]) newIsBGreaterLo = 1;
                long val = 0;
                if (i != j) val = posVal[pos];
                val += go(pos + 1, newIsAGreaterLo, newIsALessHi, newIsBGreaterLo, newIsBLessHi);
                res = Math.max(res, val);
            }
        }
        dp[pos][isAGreaterLo][isALessHi][isBGreaterLo][isBLessHi] = res;
        return res;
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        lo = new int[63];
        hi = new int[63];
        long a = in.readLong();
        long b = in.readLong();
        Binary.convertBinary(a, lo);
        Binary.convertBinary(b, hi);
        posVal = new long[63];
        posVal[62] = 1;
        for (int i = 61; i >= 0; --i) {
            posVal[i] = posVal[i + 1] * 2;
        }
        dp = new long[65][2][2][2][2];
        for (long[][][][] a1 : dp) {
            for (long[][][] a2 : a1) {
                for (long[][] a3 : a2) {
                    for (long[] a4 : a3) {
                        Arrays.fill(a4, -1);
                    }
                }
            }
        }
        long res = go(0, 0, 0, 0, 0);
        out.printLine(res);
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
        // InputMismatchException -> UnknownError
        if (numChars == -1)
            throw new UnknownError();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new UnknownError();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    }

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(outputStream);
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

class Binary {
    public static void convertBinary(long val, int[] a) {
        int last = a.length - 1;
        Arrays.fill(a, 0);
        while (val > 0) {
            a[last] = (int) (val % 2);
            last--;
            val /= 2;
        }
    }
}

