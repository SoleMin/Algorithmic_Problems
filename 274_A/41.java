import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int N = in.readInt();
        long K = in.readLong();
        long[] a = new long[N];
        for (int i = 0; i < N; ++i) {
            a[i] = in.readLong();
        }
        ArrayShuffler s = new ArrayShuffler();
        s.shuffle(a);
        Arrays.sort(a);
        boolean[] taken = new boolean[N];
        Arrays.fill(taken, true);
        int i = 0;
        int j = i + 1;
        int res = N;
        while (i < a.length) {
            if (taken[i] == false) {
                i++;
                if (j <= i) j = i + 1;
                continue;
            }
            while (j < a.length && a[j] < a[i] * K) {
                j++;
            }
            if (j < a.length) {
                if (a[j] == a[i] * K) {
                    taken[j] = false;
                    res--;
                }
            }
            i++;
            if (j <= i) j = i + 1;
        }
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

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        } else if (c == '+') {
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

class ArrayShuffler {
    static Random random = new Random(7428429L);

    public void shuffle(long[] p) {
        for (int i = 0; i < p.length; ++i) {
            int j = i + random.nextInt(p.length - i);
            long temp = p[i];
            p[i] = p[j];
            p[j] = temp;
        }
    }

    }

