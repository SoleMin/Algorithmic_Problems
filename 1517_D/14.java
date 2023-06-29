import java.io.PrintWriter;
import java.util.*;

public class D {

    static Scanner sc;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {

        sc = new Scanner(System.in);
        out = new PrintWriter(System.out);
        //int t = sc.nextInt();
        for(int i=0; i<1; i++) {
            solve();
        }
        out.flush();
    }

    static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[n][m-1];
        int[][] b = new int[n-1][m];
        for(int i=0 ;i<n; i++) {
            for(int j=0; j<m-1; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for(int i=0 ;i<n-1; i++) {
            for(int j=0; j<m; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        if(k % 2 == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j > 0)
                        out.print(" ");
                    out.print("-1");
                }
                out.println();
            }
            return;
        }


        int[][] prev = new int[n][m];
        k /= 2;
        for(int l=0; l<k; l++) {
            int[][] next = new int[n][m];
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    next[i][j] = Integer.MAX_VALUE;
                    if(i>0) {
                        next[i][j] = Math.min(next[i][j], prev[i-1][j] + b[i-1][j]);
                    }
                    if(i+1<n) {
                        next[i][j] = Math.min(next[i][j], prev[i+1][j] + b[i][j]);
                    }
                    if(j>0) {
                        next[i][j] = Math.min(next[i][j], prev[i][j-1] + a[i][j-1]);
                    }
                    if(j+1<m) {
                        next[i][j] = Math.min(next[i][j], prev[i][j+1] + a[i][j]);
                    }
                }
            }
            prev = next;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0)
                    out.print(" ");
                out.print(prev[i][j] * 2);
            }
            out.println();
        }


    }



}