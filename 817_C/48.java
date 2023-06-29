import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class C {

  private static final String REGEX = " ";
  private static final Boolean DEBUG = false;
  private static final String FILE_NAME = "input.txt";


  public static void main(String[] args) throws IOException {
    if (DEBUG) {
      generate();
    }
    Solver solver = new Solver();
    solver.readData();
    solver.solveAndPrint();
  }

  private static void generate() throws IOException {
//    FileWriter writer = new FileWriter("input.txt");
//    writer.close();
  }

  private static class Solver {

    long n, s;

    void readData() throws IOException {
      InputStream in = DEBUG ? new FileInputStream(FILE_NAME) : System.in;
      Scanner scanner = new Scanner(in);
      n = scanner.nextLong();
      s = scanner.nextLong();
      scanner.close();
    }

    void solveAndPrint() {
      long cur = s + 1;
      long sum = getSum(cur);
      long res = 0;
      while (cur <= n) {
        if (cur - sum >= s) {
          System.out.println(n - cur + 1);
          return;
        }
        cur++;
        if (cur % 10 != 0) {
          sum++;
        } else {
          sum = getSum(cur);
        }
      }
      System.out.println(0);
    }

    long getSum(long cur) {
      long res = 0;
      while (cur > 0) {
        res += cur % 10;
        cur /= 10;
      }
      return res;
    }


    @SuppressWarnings("SameParameterValue")
    int[] splitInteger(String string, int n) {
      final String[] split = string.split(REGEX, n);
      int[] result = new int[split.length];
      for (int i = 0; i < n; ++i) {
        result[i] = Integer.parseInt(split[i]);
      }
      return result;
    }

    public int[] splitInteger(String string) {
      return splitInteger(string, 0);
    }


    @SuppressWarnings("SameParameterValue")
    long[] splitLong(String string, int n) {
      final String[] split = string.split(REGEX, n);
      long[] result = new long[split.length];
      for (int i = 0; i < n; ++i) {
        result[i] = Long.parseLong(split[i]);
      }
      return result;
    }

    public long[] splitLong(String string) {
      return splitLong(string, 0);
    }

    @SuppressWarnings("SameParameterValue")
    double[] splitDouble(String string, int n) {
      final String[] split = string.split(REGEX, n);
      double[] result = new double[split.length];
      for (int i = 0; i < n; ++i) {
        result[i] = Double.parseDouble(split[i]);
      }
      return result;
    }

    public double[] splitDouble(String string) {
      return splitDouble(string, 0);
    }

    @SuppressWarnings("SameParameterValue")
    String[] splitString(String string, int n) {
      return string.split(REGEX, n);
    }

    public String[] splitString(String string) {
      return splitString(string, 0);
    }

    public int max(int a, int b) {
      return Math.max(a, b);
    }

    public long max(long a, long b) {
      return Math.max(a, b);
    }

    public int min(int a, int b) {
      return Math.min(a, b);
    }

    public long min(long a, long b) {
      return Math.min(a, b);
    }

    public double max(double a, double b) {
      return Math.max(a, b);
    }

    public double min(double a, double b) {
      return Math.min(a, b);
    }

    private final static int MOD = 1000000009;

    int multMod(int a, int b) {
      return ((a % MOD) * (b % MOD)) % MOD;
    }

    int sumMod(int a, int b) {
      return ((a % MOD) + (b % MOD)) % MOD;
    }

    long multMod(long a, long b) {
      return ((a % MOD) * (b % MOD)) % MOD;
    }

    long sumMod(long a, long b) {
      return ((a % MOD) + (b % MOD)) % MOD;
    }
  }


}
