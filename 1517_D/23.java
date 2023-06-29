
import java.util.*;

public class Main {
  public static Scanner scan = new Scanner(System.in);

  int n, m;
  int[][] x;
  int[][] y;
  int k, k2;

  int[][] sol0;
  int[][] sol1;
    
  public Main(int[][] x, int[][] y, int k) {
    this.x = x;
    this.y = y;
    this.k = k;
    this.n = x.length;
    this.m = x[0].length;
  }

  void go() {
    if(k%2 != 0) {
      for(int i=0; i<n; ++i) {
        for(int j=0; j<m; ++j) {
          System.out.print(-1 + " ");
        }
        System.out.println();
      }  
      return;
    }
    k2 = k/2;
    sol0 = new int[n][m];
    sol1 = new int[n][m];
    
    for(int d=0; d<k2; ++d) {
      var zzz = sol1;
      sol1 = sol0;
      sol0 = zzz;
      
      for(int i=0; i<n; ++i)
        for(int j=0; j<m; ++j) {
          update(i,j);
        }
    }
    for(int i=0; i<n; ++i) {
      for(int j=0; j<m; ++j) {
        System.out.print(sol1[i][j]*2 + " ");
      }
      System.out.println();
    }

  }
  
  void update(int i, int j) {
    int ret = Integer.MAX_VALUE;
    if(i>0)
      ret = Math.min(ret, sol0[i-1][j] + y[i-1][j]);
    if(j>0)
      ret = Math.min(ret, sol0[i][j-1] + x[i][j-1]);
    if(i < n-1)
      ret = Math.min(ret, sol0[i+1][j] + y[i][j]);
    if(j < m-1)
      ret = Math.min(ret, sol0[i][j+1] + x[i][j]);
    sol1[i][j] = ret;
  }
  
  
  public static void main(String[] args) {
    int n = scan.nextInt();
    int m = scan.nextInt();
    int k = scan.nextInt();
    int x[][] = new int[n][m];
    int y[][] = new int[n][m];
    for(int i=0; i<n; ++i) {
      for(int j=0; j<m-1; ++j) {
        x[i][j] = scan.nextInt();
      }
    }
    for(int i=0; i<n-1; ++i) {
      for(int j=0; j<m; ++j) {
        y[i][j] = scan.nextInt();
      }
    }
    Main mm = new Main(x,y,k);
    mm.go();
  }

}
