import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    String line = stdin.readLine();
    String[] prms = line.split(" ");
    
    long a = Long.parseLong(prms[0]);
    long b = Long.parseLong(prms[1]);
    
    long cnt = 0;
    while (a > 0 && b > 0) {
      if (a >= b) {
        cnt += a / b;
        a =  a % b;
      }
      long c = a;
      a = b;
      b = c;
    }
    
    System.out.println(cnt);
  }
}
