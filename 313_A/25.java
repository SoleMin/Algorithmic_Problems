import java.io.*;
import java.util.*;

public class A {
  public static void main(String[] args){
    FastScanner sc = new FastScanner();
    int n = sc.nextInt();
    String nStr = Integer.toString(n);

    String nStr1 = nStr.substring(0, nStr.length() - 1);
    String nStr2 = nStr.substring(0, nStr.length() - 2) + nStr.charAt(nStr.length() - 1);

    int result = Math.max(n, Integer.parseInt(nStr1));
    result = Math.max(result, Integer.parseInt(nStr2));
    System.out.println(result);
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
