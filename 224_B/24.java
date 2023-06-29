import java.util.Map;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.io.BufferedWriter;
import java.util.Locale;
import java.util.InputMismatchException;
import java.util.HashMap;
import java.util.Set;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigInteger;
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
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = in.nextIntArray(n);
        if (k == 1) {
            out.println("1 1");
            return;
        }
        int left = -1, right = -1;
        Counter<Integer> counter = new Counter<Integer>();
        while (true) {
            right++;
            if (right == n) {
                out.println("-1 -1");
                return;
            }
            counter.add(a[right]);
            if (counter.size() >= k)
                break;
        }
        while (true) {
            left++;
            if (counter.get(a[left]) == 1)
                break;
            counter.add(a[left], -1);
        }
        out.printLine(left + 1, right + 1);
    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
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

    public int[] nextIntArray(int count) {
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = nextInt();
        }
        return result;
    }

    }

class OutputWriter {
    private PrintWriter writer;

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

    public void println(String x) {
        writer.println(x);
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

class Counter<T> extends HashMap<T, Long> {
    public void add(T obj, long count) {
        put(obj, get(obj) + count);
    }

    public void add(T obj) {
        put(obj, get(obj) + 1L);
    }

    public Long get(Object key) {
        return containsKey(key) ? super.get(key) : 0L;
    }
}

