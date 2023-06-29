import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Locale;
import java.io.OutputStream;
import java.util.RandomAccess;
import java.io.PrintWriter;
import java.util.AbstractList;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.TreeMap;
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
        long k = in.nextInt();
        if (k == 1) {
            out.println(n);
            return;
        }
        long[] a = in.nextLongArray(n);
        ArrayUtils.safeSort(a);
        Map<Long, Integer> map = new TreeMap<Long, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], i);
        }
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int count = 1;
                long cur = a[i];
                while (true) {
                    cur *= k;
                    Integer index = map.get(cur);
                    if (index == null)
                        break;
                    visited[index] = true;
                    count++;
                }
                answer += NumberUtils.upDiv(count, 2);
            }
        }
        out.println(answer);
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

    public long nextLong() {
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
            res += c & 15;
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long[] nextLongArray(int count) {
        long[] result = new long[count];
        for (int i = 0; i < count; i++) {
            result[i] = nextLong();
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

    public void println(int i) {
        writer.println(i);
    }

    public void close() {
        writer.close();
    }

    }

class ArrayUtils {



    public static List<Long> asList(long[] array) {
        return new LongList(array);
    }

    private static class LongList extends AbstractList<Long> implements RandomAccess {
        long[] array;

        private LongList(long[] array) {
            this.array = array;
        }

        public Long set(int index, Long element) {
            long result = array[index];
            array[index] = element;
            return result;
        }

        public Long get(int index) {
            return array[index];
        }

        public int size() {
            return array.length;
        }
    }

    public static void safeSort(long[] array) {
        Collections.shuffle(asList(array));
        Arrays.sort(array);
    }

    }

class NumberUtils {
    public static int upDiv(int a, int b) {
        return a % b == 0 ? (a / b) : (a / b + 1);
    }

    }

