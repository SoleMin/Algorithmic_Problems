import java.util.*;

public class Main {

  public static void main(String args[]) {
    (new Main()).solve();
  }

  void solve() {

    Scanner cin = new Scanner(System.in);

    while( cin.hasNextInt() ) {

      int n = cin.nextInt();
      int arr[] = new int[n];
      for(int i=0; i<n; ++i) {
        arr[i] = cin.nextInt();
      }

      Arrays.sort(arr);

      int ret[] = new int[n];
      ret[0] = 1;
      for(int i=0; i<n-1; ++i) { ret[i + 1] = arr[i]; }
      if( arr[n - 1] == 1 ) { ret[n - 1] = 2; }

      String glue = "";
      for(int i=0; i<n; ++i) {
        System.out.print(glue + ret[i]);
        glue = " ";
      }

      System.out.println();

    }

  }

}
