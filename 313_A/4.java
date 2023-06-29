import java.util.*;
import java.math.*;

public class Main {
  
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int res = n;
    String str = Integer.toString(n);
    res = Math.max(res, Integer.parseInt(str.substring(0, str.length() - 1)));
    res = Math.max(res, Integer.parseInt(str.substring(0, str.length() - 2) + str.substring(str.length() - 1)));
    System.out.println(res);
  }
}