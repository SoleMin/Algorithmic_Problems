import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

  public static void main(String[] args) {
    Scanner cin=new Scanner(new BufferedInputStream(System.in));
    
    int n=cin.nextInt(),
        m=cin.nextInt(),
        k=cin.nextInt();
    int[] a=new int[51];
    
    for (int i=0;i<n;i++) {
      a[i]=-cin.nextInt();
    }
    Arrays.sort(a);
    
    if (m<=k) {
        System.out.println(0);
        return;
    }
    for (int i=0;i<Math.min(k,n);i++) {
      m+=a[i];
      if (m-(k-1-i)<=0) {
        System.out.println(i+1);
        return;
      }
    }
    for (int i=k;i<n;i++) {
      m+=a[i]+1;
      if (m<=0) {
        System.out.println(i+1);
        return;
      }
    }
    System.out.println(-1);
    
    cin.close();
  }

}