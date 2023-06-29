/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class TaskA {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    String[] s = br.readLine().split(" ");
    int[] arr = new int[n];
    for (int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(s[i]);
    }
    Arrays.sort(arr);
    boolean[] vis = new boolean[n];
    int nColours = 0;
    int nVis = 0;
    int index = 0;
    while (nVis<n) {
      while (index<n && nVis<n) {
        if (vis[index]) {
          index++;
          continue;
        }
        int val = arr[index];
        nColours++;
        while (index<n && nVis<n) {
          if (vis[index]) {
            index++;
            continue;
          }
          if (arr[index]%val==0) {
            vis[index] = true;
            nVis++;
          }
          index++;
        }
        index = 0;
      }
    }
    System.out.println(nColours);

  }
}
