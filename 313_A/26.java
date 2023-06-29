import java.io.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    String line = stdin.readLine();
    int n = Integer.parseInt(line);
    
    if (n >= 0) {
      System.out.println(n);
    } else if (n > -10) {
      System.out.println(0);
    } else {
      String sa = line.substring(0, line.length() - 1);
      int a = Integer.parseInt(sa);
      String sb = line.substring(0, line.length() - 2) + line.charAt(line.length() - 1);
      int b = Integer.parseInt(sb);
      System.out.println(Math.max(a, b));
    }
  }
}
