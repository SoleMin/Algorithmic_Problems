import java.util.*;
import java.io.*;

public class ProbA {
  int account;

  void start(Scanner sc, PrintStream out) {
    int ans = 0;
    account = sc.nextInt();
    int account1 = account / 10; 
    int account2 = (account - (account % 100)) / 10 + (account % 10); 
   
    out.println(Math.max(account1, Math.max(account, account2)));
  }

  public static void main(String[] args)  {
    Scanner sc = new Scanner(System.in);
    PrintStream out = System.out;

    new ProbA().start(sc, out);

  }

}
