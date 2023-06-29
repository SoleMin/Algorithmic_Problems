import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Saul
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskB {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    long n = in.nextLong() ;
    int k = in.nextInt();
    long top = 1L * k * (k+1) / 2L - k + 1;

    if ( n == 1L ){
      out.print(0);
      return;
    }

    if ( n > top ){
      out.print(-1);
      return;
    }

    int ans = 0;
    if ( n > 0 ){
      ++ans;
      n -= k;
      k -= 2;
    }

    while ( n > 0 ){
      ++ans;
      n -= k;
      k--;
    }
    out.print(ans);
  }
}
