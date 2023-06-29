import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    static BiFunction<Integer, Integer, Integer> ADD = (x, y) -> (x + y);
    static BiFunction<ArrayList<Integer>, ArrayList<Integer>, ArrayList<Integer>> ADD_ARRAY_LIST = (x, y) -> {
        x.addAll(y);
        return x;
    };

    static Function<Pair<Long, Queue<Integer>>, Long> GET_FIRST = (x) -> (x.first);
    static Comparator<Pair<Long, Queue<Integer>>> C = Comparator.comparing(GET_FIRST);

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        long endTime = System.nanoTime();
        err.println("Execution Time : +" + (endTime - startTime) / 1000000 + " ms");
        exit(0);
    }

    static void solve() {
        long n = in.nextLong();
        int m = in.nextInt();
        long k = in.nextLong();
        long[] data = in.readAllLongs(m);
        Queue<Long> values = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            values.add(data[i]);
        }
        int offset = 0;
        int ans = 0;
        while (true) {
            if (values.isEmpty()) {
                break;
            }
            long v = values.peek();
            long bucket = (v - offset + k - 1) / k;
            offset += process(values, bucket, offset, k);
            ans++;
        }
        out.println(ans);
    }

    static int process(Queue<Long> values, long bucket, int offSet, long k) {
        int ans = 0;
        while (!values.isEmpty()) {
            long v = values.peek();
            long b = (v - offSet + k - 1) / k;
            if (b == bucket) {
                ans++;
                values.poll();
            } else {
                break;
            }
        }
        return ans;
    }

    static void debug(Object... args) {
        for (Object a : args) {
            out.println(a);
        }
    }

    static void y() {
        out.println("YES");
    }

    static void n() {
        out.println("NO");
    }

    static <T> T min(T a, T b, Comparator<T> C) {
        if (C.compare(a, b) <= 0) {
            return a;
        }
        return b;
    }

    static <T> T max(T a, T b, Comparator<T> C) {
        if (C.compare(a, b) >= 0) {
            return a;
        }
        return b;
    }

    static void fail() {
        out.println("-1");
    }

    static class Pair<T, R> {
        public T first;
        public R second;

        public Pair(T first, R second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "Pair{" + "a=" + first + ", b=" + second + '}';
        }

        public T getFirst() {
            return first;
        }

        public R getSecond() {
            return second;
        }
    }

    static <T, R> Pair<T, R> make_pair(T a, R b) {
        return new Pair<>(a, b);
    }

    static class ArrayUtils {

        static void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        static void swap(char[] a, int i, int j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        static void print(char[] a) {
            for (char c : a) {
                out.print(c);
            }
            out.println("");
        }

        static int[] reverse(int[] data) {
            int[] p = new int[data.length];
            for (int i = 0, j = data.length - 1; i < data.length; i++, j--) {
                p[i] = data[j];
            }
            return p;
        }

        static void prefixSum(long[] data) {
            for (int i = 1; i < data.length; i++) {
                data[i] += data[i - 1];
            }
        }

        static void prefixSum(int[] data) {
            for (int i = 1; i < data.length; i++) {
                data[i] += data[i - 1];
            }
        }

        static long[] reverse(long[] data) {
            long[] p = new long[data.length];
            for (int i = 0, j = data.length - 1; i < data.length; i++, j--) {
                p[i] = data[j];
            }
            return p;
        }

        static char[] reverse(char[] data) {
            char[] p = new char[data.length];
            for (int i = 0, j = data.length - 1; i < data.length; i++, j--) {
                p[i] = data[j];
            }
            return p;
        }

        static int[] MergeSort(int[] A) {
            if (A.length > 1) {
                int q = A.length / 2;
                int[] left = new int[q];
                int[] right = new int[A.length - q];
                System.arraycopy(A, 0, left, 0, q);
                System.arraycopy(A, q, right, 0, A.length - q);
                int[] left_sorted = MergeSort(left);
                int[] right_sorted = MergeSort(right);
                return Merge(left_sorted, right_sorted);
            } else {
                return A;
            }
        }

        static int[] Merge(int[] left, int[] right) {
            int[] A = new int[left.length + right.length];
            int i = 0;
            int j = 0;
            for (int k = 0; k < A.length; k++) {
                // To handle left becoming empty
                if (i == left.length && j < right.length) {
                    A[k] = right[j];
                    j++;
                    continue;
                }
                // To handle right becoming empty
                if (j == right.length && i < left.length) {
                    A[k] = left[i];
                    i++;
                    continue;
                }
                if (left[i] <= right[j]) {
                    A[k] = left[i];
                    i++;
                } else {
                    A[k] = right[j];
                    j++;
                }
            }
            return A;
        }

        static long[] MergeSort(long[] A) {
            if (A.length > 1) {
                int q = A.length / 2;
                long[] left = new long[q];
                long[] right = new long[A.length - q];
                System.arraycopy(A, 0, left, 0, q);
                System.arraycopy(A, q, right, 0, A.length - q);
                long[] left_sorted = MergeSort(left);
                long[] right_sorted = MergeSort(right);
                return Merge(left_sorted, right_sorted);
            } else {
                return A;
            }
        }

        static long[] Merge(long[] left, long[] right) {
            long[] A = new long[left.length + right.length];
            int i = 0;
            int j = 0;
            for (int k = 0; k < A.length; k++) {
                // To handle left becoming empty
                if (i == left.length && j < right.length) {
                    A[k] = right[j];
                    j++;
                    continue;
                }
                // To handle right becoming empty
                if (j == right.length && i < left.length) {
                    A[k] = left[i];
                    i++;
                    continue;
                }
                if (left[i] <= right[j]) {
                    A[k] = left[i];
                    i++;
                } else {
                    A[k] = right[j];
                    j++;
                }
            }
            return A;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 2048);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] readAllInts(int n) {
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }
            return p;
        }

        public int[] readAllInts(int n, int s) {
            int[] p = new int[n + s];
            for (int i = s; i < n + s; i++) {
                p[i] = in.nextInt();
            }
            return p;
        }

        public long[] readAllLongs(int n) {
            long[] p = new long[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextLong();
            }
            return p;
        }

        public long[] readAllLongs(int n, int s) {
            long[] p = new long[n + s];
            for (int i = s; i < n + s; i++) {
                p[i] = in.nextLong();
            }
            return p;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static void exit(int a) {
        out.close();
        err.close();
        System.exit(a);
    }

    static InputStream inputStream = System.in;
    static OutputStream outputStream = System.out;
    static OutputStream errStream = System.err;
    static InputReader in = new InputReader(inputStream);
    static PrintWriter out = new PrintWriter(outputStream);
    static PrintWriter err = new PrintWriter(errStream);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

}
