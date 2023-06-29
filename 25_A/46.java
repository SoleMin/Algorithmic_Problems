import java.util.Scanner;

public class IQ {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] a = new int[n];
    for(int i = 0; i < n; i++)
      a[i] = scan.nextInt();
    for(int i = 0; i < n; i++) {
      boolean x = a[i] % 2 == 0;
      int c = 0;
      for(int j = 0; j < n; j++) {
        if(x != (a[j] % 2 == 0))
          c++;
      }
      if(c == n-1) {
        System.out.println(i+1);
        break;
      }
    }
  }
}
