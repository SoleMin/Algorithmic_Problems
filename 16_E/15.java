import java.util.*;
import java.io.*;

public class e{
  int n;
  double f[];
  double a[][];

  public void run(){
    Locale.setDefault(Locale.US);
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    a = new double[n][n];
    for(int i=0;i<n;i++) for(int j=0;j<n;j++) a[i][j] = in.nextDouble();
    f = new double[1<<n];
    for(int i=0;i<1<<n;i++) f[i] = -1;
    f[(1<<n)-1] = 1.0;
    
    for(int i=0;i<n;i++) System.out.print(doIt(1<<i) + " ");
  }

  private double doIt(int mask){
    if (f[mask] >=0) return f[mask];
    f[mask] = 0;
    double k = getBits(mask);
    k*=(k-1)/2.0;

    for(int i=0;i<n;i++)
      if ((mask & (1 << i)) > 0)
        for(int j=0;j<n;j++)
          if ((mask & (1 << j)) == 0)
            f[mask]+=doIt(mask|(1<<j))*a[i][j]/k;
    return f[mask]; 
  }
  private int getBits(int x){
    int cnt = 0;
    while(x > 0){
      x&=(x-1);
      cnt++;
    }
    return cnt+1;
  }

  public static void main(String args[]){
    new e().run();
  }
}