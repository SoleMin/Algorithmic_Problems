import java.io.*;
import java.util.*;
import java.math.*;

public class P255D {

  @SuppressWarnings("unchecked")
  public void run() throws Exception {
    long n = nextLong();
    long x = nextLong();
    long y = nextLong();
    long c = nextLong();

    if ((n == 1) || (c == 1)) {
      println(0);
      return;
    }

    x = Math.min(x, n - x + 1);
    y = Math.min(y, n - y + 1);
    long t = 0;
    long s = 1;

    while (s < c) {
      t++;

      s += (t * 4) + ((t >= x + y) ? (t - x - y + 1) : 0)
           - ((t >= x) ? (t - x) * 2 + 1 : 0)
           - ((t >= y) ? (t - y) * 2 + 1 : 0)
           + ((t >= x + n - y + 1) ? (t - x - n + y) : 0)
           + ((t >= n - x + 1 + y) ? (t - n + x - y) : 0)
           - ((t >= n - x + 1) ? (t - n + x - 1) * 2 + 1 : 0)
           - ((t >= n - y + 1) ? (t - n + y - 1) * 2 + 1 : 0);
    }

    println(t);
  }

  public static void main(String... args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(new BufferedOutputStream(System.out));
    new P255D().run();
    br.close();
    pw.close();
  }

  static BufferedReader br;
  static PrintWriter pw;
  StringTokenizer stok;

  String nextToken() throws IOException {
    while (stok == null || !stok.hasMoreTokens()) {
      String s = br.readLine();
      if (s == null) { return null; }
      stok = new StringTokenizer(s);
    }
    return stok.nextToken();
  }

  void print(byte b) { print("" + b); }
  void print(int i) { print("" + i); }
  void print(long l) { print("" + l); }
  void print(double d) { print("" + d); }
  void print(char c) { print("" + c); }
  void print(Object o) {
    if (o instanceof int[]) { print(Arrays.toString((int [])o));
    } else if (o instanceof long[]) { print(Arrays.toString((long [])o));
    } else if (o instanceof char[]) { print(Arrays.toString((char [])o));
    } else if (o instanceof byte[]) { print(Arrays.toString((byte [])o));
    } else if (o instanceof short[]) { print(Arrays.toString((short [])o));
    } else if (o instanceof boolean[]) { print(Arrays.toString((boolean [])o));
    } else if (o instanceof float[]) { print(Arrays.toString((float [])o));
    } else if (o instanceof double[]) { print(Arrays.toString((double [])o));
    } else if (o instanceof Object[]) { print(Arrays.toString((Object [])o));
    } else { print("" + o); }
  }
  void print(String s) { pw.print(s); }
  void println() { println(""); }
  void println(byte b) { println("" + b); }
  void println(int i) { println("" + i); }
  void println(long l) { println("" + l); }
  void println(double d) { println("" + d); }
  void println(char c) { println("" + c); }
  void println(Object o) { print(o); println(""); }
  void println(String s) { pw.println(s); }
  int nextInt() throws IOException { return Integer.parseInt(nextToken()); }
  long nextLong() throws IOException { return Long.parseLong(nextToken()); }
  double nextDouble() throws IOException { return Double.parseDouble(nextToken()); }
  char nextChar() throws IOException { return (char) (br.read()); }
  String next() throws IOException { return nextToken(); }
  String nextLine() throws IOException { return br.readLine(); }
  int [] readInt(int size) throws IOException {
    int [] array = new int [size];
    for (int i = 0; i < size; i++) { array[i] = nextInt(); }
    return array;
  }
  long [] readLong(int size) throws IOException {
    long [] array = new long [size];
    for (int i = 0; i < size; i++) { array[i] = nextLong(); }
    return array;
  }
  double [] readDouble(int size) throws IOException {
    double [] array = new double [size];
    for (int i = 0; i < size; i++) { array[i] = nextDouble(); }
    return array;
  }
  String [] readLines(int size) throws IOException {
    String [] array = new String [size];
    for (int i = 0; i < size; i++) { array[i] = nextLine(); }
    return array;
  }
}