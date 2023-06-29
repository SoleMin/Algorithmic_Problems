import java.io.*;
import java.util.*;

public class My {
  public static void main(String[] args) {
    new My().go();
  }

  
  void go() {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();
    int k = in.nextInt();
    int mn = 0, mx = k + 1;
    while (mn < mx) {
      int mid = (mn + mx) / 2;
      if (works(n, k, mid)) {
        mx = mid;
      } else {
        mn = mid + 1;
      }
    }
    if (mn > k) {
      pl("-1");
    } else {
      pl((mn - 1) + "");
    }
  }
  
  boolean works(long n, int k, int use) {
    return 1 + T(k - 1) - T(k - use) >= n;
  }
  
  long T(int n) {
    return n * (long)(n + 1) / 2;
  }
  
  void p(String s) {
    System.out.print(s);
  }

  void pl(String s) {
    System.out.println(s);
  }
}