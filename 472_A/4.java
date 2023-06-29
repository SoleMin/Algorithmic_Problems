import java.util.Scanner;

public class Solution {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if (n % 2 == 0)
      System.out.println("4 " + (n - 4));
    else
      System.out.println("9 " + (n - 9));
  }
}
