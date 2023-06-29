import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Locale;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.RandomAccess;
import java.util.AbstractList;
import java.io.Writer;
import java.util.List;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.math.BigInteger;
import java.util.Collections;
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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int[] b = a.clone();
        ArrayUtils.safeSort(b);
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i])
                diff++;
        }
        out.println(diff <= 2 ? "YES" : "NO");
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

    public void println(String x) {
        writer.println(x);
    }

    public void close() {
        writer.close();
    }

    }

class ArrayUtils {



    public static List<Integer> asList(int[] array) {
        return new IntList(array);
    }

    private static class IntList extends AbstractList<Integer> implements RandomAccess {

        int[] array;

        private IntList(int[] array) {
            this.array = array;
        }

        public Integer get(int index) {
            return array[index];
        }

        public Integer set(int index, Integer element) {
            int result = array[index];
            array[index] = element;
            return result;
        }

        public int size() {
            return array.length;
        }
    }

    public static void safeSort(int[] array) {
        Collections.shuffle(asList(array));
        Arrays.sort(array);
    }

    }

