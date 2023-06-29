import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class E {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());
        for(int t=0; t<T; t++) {
          StringTokenizer st = new StringTokenizer(bf.readLine());
          int n = Integer.parseInt(st.nextToken());
          int m = Integer.parseInt(st.nextToken());
          int[][] a = new int[n][m];
          for(int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++) a[i][j] = Integer.parseInt(st.nextToken());

          }
          // small case
          int[] max = new int[m];
          for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
              if(a[i][j] > max[j]) max[j] = a[i][j];
            }
          }
          int[][] pos = new int[m][2];
          for(int i=0; i<m; i++) {
            pos[i][0] = max[i];
            pos[i][1] = i;
          }
          Arrays.sort(pos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
              return Integer.compare(o2[0], o1[0]);
            }
          });

          int[][] new_a = new int[n][Math.min(n,m)];
          for(int i=0; i<n; i++) {
            for(int j=0; j<Math.min(n,m); j++) {
              new_a[i][j] = a[i][pos[j][1]];
            }
          }
          int exp = 1; for(int i=0; i<Math.min(n,m); i++) exp *= n;
          int maxval = -1;
          for(int i=0; i<exp; i++) {
          //  int val = i;
            int sum = 0;
            for(int j=0; j<n; j++) {
              int toAdd = 0;
              int val = i;
              for(int k=0; k<Math.min(n,m); k++) {
                int tooAdd = new_a[(j+val)%n][k];
                val /= n;
                if(tooAdd > toAdd) toAdd = tooAdd;
              }
              sum += toAdd;
            }
            if(sum > maxval) maxval = sum;
          }
          out.println(maxval);

        }

        // StringTokenizer st = new StringTokenizer(bf.readLine());
        // int[] a = new int[n]; for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
        // int n = Integer.parseInt(st.nextToken());

        out.close(); System.exit(0);
    }
}
