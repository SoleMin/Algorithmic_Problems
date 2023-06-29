import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _8C {

  static int[] x = new int[30], y = new int[30];
  static int[][] dist = new int[30][30];
  static int n;
  static final int M = 1000;
  static int[] bitPos = new int[M];
  static {
    Arrays.fill(bitPos, -1);
    for (int i=0; i<24; i++)
      bitPos[(1 << i) % M] = i;
  }

  static int sqr(int i) { 
    return i * i;
  }
  
  public static void main(String[] args) throws Exception {
    Reader.init(System.in);
    BufferedWriter cout = new BufferedWriter(new OutputStreamWriter(System.out));

    x[0] = Reader.nextInt();
    y[0] = Reader.nextInt();
    n = Reader.nextInt();
    for (int i=1; i<=n; i++) {
      x[i] = Reader.nextInt();
      y[i] = Reader.nextInt();
    }
    for (int i=0; i<=n; i++)
      for (int j=0; j<=n; j++)
        dist[i][j] = sqr(x[i] - x[j]) + sqr(y[i] - y[j]);
    
    int[] f = new int[1 << n];
    int[] r = new int[1 << n];
    for (int mask=1; mask<(1 << n); mask++) {
      int lowbit = mask & -mask;
      int lowbitPos = bitPos[lowbit % M];
      f[mask] = dist[lowbitPos + 1][0] * 2 + f[mask ^ lowbit];
      r[mask] = lowbit;
        for (int i=mask^(lowbit); i>0; i=i^(i & -i)) {
          int otherBit = i & -i;
          int otherBitPos = bitPos[otherBit % M];
          int tmp = dist[0][lowbitPos + 1] + dist[lowbitPos + 1][otherBitPos + 1] + dist[otherBitPos + 1][0] + f[mask ^ otherBit ^ lowbit];
          if (tmp < f[mask]) {
            f[mask] = tmp;
            r[mask] = lowbit | otherBit;
          }
      }
    }
    
    System.out.println(f[(1 << n) - 1]);
    int mask = (1 << n) - 1;
    while(mask > 0) {
      if ((r[mask] ^ (r[mask] & -r[mask])) == 0) {
        System.out.print("0 " + (bitPos[r[mask] % M] + 1) + " ");
      }
      else {
        int bit1 = r[mask] & -r[mask];
        int bit2 = r[mask] ^ bit1;
        System.out.print("0 " + (bitPos[bit1 % M] + 1) + " " + (bitPos[bit2 % M] + 1) + " ");
      }
      mask ^= r[mask];
    }
    System.out.println("0");
      
    cout.close();
  }

  static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
    final U _1;
    final V _2;

    private Pair(U key, V val) {
      this._1 = key;
      this._2 = val;
    }

    public static <U extends Comparable<U>, V extends Comparable<V>> Pair<U, V> instanceOf(U _1, V _2) {
      return new Pair<U, V>(_1, _2);
    }

    @Override
    public String toString() {
      return _1 + " " + _2;
    }

    @Override
    public int hashCode() {
      int res = 17;
      res = res * 31 + _1.hashCode();
      res = res * 31 + _2.hashCode();
      return res;
    }

    @Override
    public int compareTo(Pair<U, V> that) {
      int res = this._1.compareTo(that._1);
      if (res < 0 || res > 0)
        return res;
      else
        return this._2.compareTo(that._2);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (!(obj instanceof Pair))
        return false;
      Pair<?, ?> that = (Pair<?, ?>) obj;
      return _1.equals(that._1) && _2.equals(that._2);
    }
  }

  /** Class for buffered reading int and double values */
  static class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
      reader = new BufferedReader(new InputStreamReader(input));
      tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
      while (!tokenizer.hasMoreTokens()) {
        // TODO add check for eof if necessary
        tokenizer = new StringTokenizer(reader.readLine());
      }
      return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
      return Double.parseDouble(next());
    }
  }

  static class ArrayUtil {
    static void swap(int[] a, int i, int j) {
      int tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
    }

    static void swap(long[] a, int i, int j) {
      long tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
    }

    static void swap(double[] a, int i, int j) {
      double tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
    }

    static void swap(char[] a, int i, int j) {
      char tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
    }

    static void swap(boolean[] a, int i, int j) {
      boolean tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
    }

    static void reverse(int[] a, int i, int j) {
      for (; i < j; i++, j--)
        swap(a, i, j);
    }

    static void reverse(long[] a, int i, int j) {
      for (; i < j; i++, j--)
        swap(a, i, j);
    }

    static void reverse(double[] a, int i, int j) {
      for (; i < j; i++, j--)
        swap(a, i, j);
    }

    static void reverse(char[] a, int i, int j) {
      for (; i < j; i++, j--)
        swap(a, i, j);
    }

    static void reverse(boolean[] a, int i, int j) {
      for (; i < j; i++, j--)
        swap(a, i, j);
    }

    static long sum(int[] a) {
      int sum = 0;
      for (int i : a)
        sum += i;
      return sum;
    }

    static long sum(long[] a) {
      long sum = 0;
      for (long i : a)
        sum += i;
      return sum;
    }

    static double sum(double[] a) {
      double sum = 0;
      for (double i : a)
        sum += i;
      return sum;
    }

    static int max(int[] a) {
      int max = Integer.MIN_VALUE;
      for (int i : a)
        if (i > max)
          max = i;
      return max;
    }

    static int min(int[] a) {
      int min = Integer.MAX_VALUE;
      for (int i : a)
        if (i < min)
          min = i;
      return min;
    }

    static long max(long[] a) {
      long max = Long.MIN_VALUE;
      for (long i : a)
        if (i > max)
          max = i;
      return max;
    }

    static long min(long[] a) {
      long min = Long.MAX_VALUE;
      for (long i : a)
        if (i < min)
          min = i;
      return min;
    }
  }
}
