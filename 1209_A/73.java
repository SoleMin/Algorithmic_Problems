import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Asgar Javadov
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

    static class TaskA {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int[] a = in.readIntArray(n);

            ArrayUtils.radixSort(a);

            int answer = 0;
            boolean[] used = new boolean[a.length];
            for (int i = 0; i < a.length; ++i) {
                if (used[i]) continue;

                used[i] = true;
                answer++;
                for (int j = i + 1; j < a.length; ++j)
                    if (a[j] % a[i] == 0)
                        used[j] = true;
            }

            out.println(answer);
        }

    }

    static class ArrayUtils {
        public static void radixSort(int[] array) {
            int[] ordered = new int[array.length];
            {
                int[] freq = new int[0xFFFF + 2];
                for (int i = 0; i < array.length; ++i) freq[(array[i] & 0xFFFF) + 1]++;
                for (int i = 1; i < freq.length; ++i) freq[i] += freq[i - 1];

                for (int i = 0; i < array.length; ++i)
                    ordered[freq[array[i] & 0xFFFF]++] = array[i];
                for (int i = 0; i < array.length; ++i)
                    array[i] = ordered[i];
            }
            {
                int[] freq = new int[0xFFFF + 2];
                for (int i = 0; i < array.length; ++i) freq[(array[i] >>> 16) + 1]++;
                for (int i = 1; i < freq.length; ++i) freq[i] += freq[i - 1];

                for (int i = 0; i < array.length; ++i)
                    ordered[freq[array[i] >>> 16]++] = array[i];

                int indexOfFirstNegative = freq[0x7FFF];
                int index = 0;
                for (int i = indexOfFirstNegative; i < ordered.length; ++i, ++index)
                    array[index] = ordered[i];
                for (int i = 0; i < indexOfFirstNegative; ++i, ++index)
                    array[index] = ordered[i];
            }
        }

    }

    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream outputStream) {
            super(outputStream);
        }

        public OutputWriter(Writer writer) {
            super(writer);
        }

        public OutputWriter(String filename) throws FileNotFoundException {
            super(filename);
        }

        public void close() {
            super.close();
        }

    }

    static class InputReader extends BufferedReader {
        StringTokenizer tokenizer;

        public InputReader(InputStream inputStream) {
            super(new InputStreamReader(inputStream), 32768);
        }

        public InputReader(String filename) {
            super(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(readLine());
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
            return tokenizer.nextToken();
        }

        public Integer nextInt() {
            return Integer.valueOf(next());
        }

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++)
                array[i] = nextInt();
            return array;
        }

    }
}

