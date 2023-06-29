import java.io.*;
import java.util.*;

public class A {
  public static void main(String[] args){
    FastScanner sc = new FastScanner();
    long a = sc.nextLong();
    long b = sc.nextLong();
    long result = 0L;

    while(a != 0 && b != 0) {
      if(a > b) {
        result += a/b;
        a = a % b;
      } else {
        result += b/a;
        b = b % a;
      }

      long gcd = gcd(a, b);
      a /= gcd;
      b /= gcd;
    }

      System.out.println(result);
  }

  private static long gcd(long a, long b) {
    while(a != 0 && b != 0) {
      if(a < b) {
        long tmp = a;
        a = b;
        b = tmp;
      }
      a%=b;
    }
    return a + b;
  }

  public static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner(String s) {
      try {
        br = new BufferedReader(new FileReader(s));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }

    public FastScanner() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String nextToken() {
      while (st == null || !st.hasMoreElements()) try {
        st = new StringTokenizer(br.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(nextToken());
    }

    long nextLong() {
      return Long.parseLong(nextToken());
    }

    double nextDouble() {
      return Double.parseDouble(nextToken());
    }
  }
}
