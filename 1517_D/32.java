// package com.company.codeforces;




import java.util.*;

public class  Solution {
   static int n,m,h[][],v[][];
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

            n=input.nextInt();
            m=input.nextInt();
           int k=input.nextInt();
           h=new int[n][m-1];
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <m-1 ; j++) {
                    h[i][j]=input.nextInt();
                }
            }
            v=new int[n][m];
            for (int i = 0; i <n-1 ; i++) {
                for (int j = 0; j <m ; j++) {
                    v[i][j]=input.nextInt();
                }
            }
            int ans[][]=new int[n][m];
           dp=new int[501][501][11];
        for (int aa[]:ans
             ) { Arrays.fill(aa,-1);

        }
        if (k%2==0) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ans[i][j] = dfs(i, j, k / 2) * 2;
                }

            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();

        }

    }
    static int dp[][][];

    private static int dfs(int i, int j, int k) {
        if (k==0) return 0;
        if (dp[i][j][k]!=0){
//            System.out.println("hit");
            return dp[i][j][k];
        }
        //left
        int ans=Integer.MAX_VALUE;
        if (j-1>=0)
         ans=dfs(i, j-1, k-1)+h[i][j-1];
        if (i<n-1)
        ans=Math.min(ans,dfs(i+1, j, k-1)+v[i][j]);
        if (i>0)
        ans=Math.min(ans,dfs(i-1, j, k-1)+v[i-1][j]);
        if (j<m-1)
        ans=Math.min(ans,dfs(i, j+1, k-1)+h[i][j]);

        return dp[i][j][k]= ans;

    }


}