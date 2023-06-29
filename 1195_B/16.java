import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();
    long k = in.nextLong();

    long res = solve(n, k);
    System.out.println(res);
  }

  private static long solve(long n, long k) {
    return solveEq(1, -3 - 2 * n, n * n + n - 2 * k);
  }

  private static long solveEq(long a, long b, long c) {
    long delta = b * b - 4 * a * c;
    return (-b - (long)Math.sqrt(delta)) / (2 * a);
  }
}
