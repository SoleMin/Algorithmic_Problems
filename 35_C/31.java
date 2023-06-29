import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

@SuppressWarnings("unchecked")
public class P35C {

  final static int SHIFT = 11;
  final static int MASK = (1 << SHIFT) - 1;
  final static int [] DX = {-1, 1,  0, 0};
  final static int [] DY = { 0, 0, -1, 1};

  public void run() throws Exception {
    int m = nextInt();
    int n = nextInt();

    boolean [][] burned = new boolean [n][m];
    List<Integer> burn = new ArrayList();
    for (int k = nextInt(); k > 0; k--) {
      int x = nextInt() - 1;
      int y = nextInt() - 1;
      burned[y][x] = true;
      burn.add((x << SHIFT) | y);
    }

    int lastXY = 0;
    List<Integer> newBurn = null;
    do {
      lastXY = burn.get(0);
      newBurn = new ArrayList();

      for (int xy : burn) {
        int x = xy >> SHIFT;
        int y = xy & MASK;

        for (int i = 0; i < 4; i++) {
          int nx = x + DX[i];
          int ny = y + DY[i];

          if ((ny >= 0) && (ny < n) && (nx >= 0) && (nx < m) && (!burned[ny][nx])) {
            burned[ny][nx] = true;
            newBurn.add((nx << SHIFT) | ny);
          }
        }
      }

      burn = newBurn;
    } while (newBurn.size() > 0);

    println(((lastXY >> SHIFT) + 1) + " " + ((lastXY & MASK) + 1));
  }

  public static void main(String... args) throws Exception {
    br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
    pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("output.txt")));
    new P35C().run();
    br.close();
    pw.close();
    System.err.println("\n[Time : " + (System.currentTimeMillis() - startTime) + " ms]");
  }

  static long startTime = System.currentTimeMillis();
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
  void println(Object o) { print(o); println(); }
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