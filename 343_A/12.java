import java.io.*;
import java.util.*;

public class A {
  
  public static void main(String[] args) throws Throwable {
    new A().go();
  }
  
  void p(String s) {
    System.out.println(s);
  }
  
  void go() throws Throwable {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String[] t = in.readLine().split(" ");
    long a = Long.parseLong(t[0]), b = Long.parseLong(t[1]);
    long mv = 0;
    while (a > 1 && b > 1) {
      if (a > b) {
        long tt = a;
        a = b;
        b = tt;
      }
      mv += b / a;
      b %= a;
    }
    System.out.println(mv + Math.max(a, b));
  }
}