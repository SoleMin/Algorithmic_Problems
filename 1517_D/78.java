
import java.util.*;
public class temp {
    public static void main(String str[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int arr[][] = new int[n][m];
        int cross[][] = new int[n][m-1];
        int up[][] = new int[n-1][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m-1;j++){
                cross[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m;j++){
                up[i][j] = sc.nextInt();
            }
        }
        int[][] fans = new int[n][m];
            if (k % 2 != 0) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        fans[i][j] = -1;
                    }
                }
            }
            else {
                int[][][] ans = new int[(k/2)+1][n][m];
                for (int l = 1; l <= k / 2; l++){
                    for (int i = 0; i < n ; i++) {
                        for (int j = 0; j < m; j++) {
                            int min = Integer.MAX_VALUE;
                            if(i>0){
                                min = Math.min(min, up[i-1][j] + ans[l-1][i-1][j]);
                            }
                            if(j>0){
                                min = Math.min(min, cross[i][j-1] + ans[l-1][i][j-1]);
                            }
                            if(i<n-1){
                                min = Math.min(min, up[i][j] + ans[l-1][i+1][j]);
                            }
                            if(j<m-1){
                                min = Math.min(min, cross[i][j] + ans[l-1][i][j+1]);
                            }
                            ans[l][i][j] = min;
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        fans[i][j] = 2*ans[k/2][i][j];
                    }
                }
            }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(fans[i][j]+" ");
            }
            System.out.println();
        }


    }

}

