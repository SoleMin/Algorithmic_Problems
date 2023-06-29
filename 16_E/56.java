import java.util.*;
import java.io.*;

public class Main{

  public void run(){
    Locale.setDefault(Locale.US);
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    double a[][] = new double[n][n];
    for(int i=0;i<n;i++) for(int j=0;j<n;j++) a[i][j] = in.nextDouble();

    double f[] = new double[1<<n];
    f[(1<<n)-1] = 1;

    for(int mask = (1<<n)-1;mask > 0;mask--){
      int k = Integer.bitCount(mask);
      if (k == 1) continue;

      for(int i=0;i<n;i++){
        if ((mask & (1 << i)) > 0){
          for(int j=0;j<n;j++){
            if ((mask & (1 << j)) > 0){
              f[mask&(~(1<<j))]+=f[mask]*a[i][j]/(k*(k-1)/2); 
            }  
          }
        }
      }
    }
    for(int i=0;i<n;i++)
      System.out.print(f[1<<i]+" ");
  }

  public static void main(String args[]){
    new Main().run();
  }
}