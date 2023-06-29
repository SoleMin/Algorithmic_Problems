import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/** Built using CHelper plug-in Actual solution is at the top */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    Scanner in = new Scanner(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    TaskC solver = new TaskC();
    solver.solve(1, in, out);
    out.close();
  }

  static class TaskC {
    static final long MODULO = (int) (1e9 + 7);

    public void solve(int testNumber, Scanner in, PrintWriter out) {
      long x = in.nextLong();
      long k = in.nextLong();

      if (x == 0) {
        out.println(0);
      } else {
        long e = modPow(2, k, MODULO);
        long y = 2 * x - 1;
        long w = ((e % MODULO) * (y % MODULO)) % MODULO;
        long z = (w + 1) % MODULO;
        out.println(z);
      }
    }

    private long modPow(long a, long b, long m) {
      if (b == 0) return 1 % m;
      if (b == 1) return a % m;
      long res = modPow(a, b / 2, m);
      res = (res * res) % m;
      if (b % 2 == 1) res = (res * a) % m;
      return res;
    }
  }
}
