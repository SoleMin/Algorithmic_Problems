/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
    public static int n;
    public static int m;
    public static int k;
    public static int[][] right;
    public static int[][] down;
    public static int[][][] dp;
    public static void recur(int i, int j, int depth)
    {
        if(dp[i][j][depth]!=-1)
            return;
        int min=Integer.MAX_VALUE;
        // left
        if(j>0)
        {
            recur(i, j-1, depth-1);
            min=Math.min(min, dp[i][j-1][depth-1] + right[i][j-1]);
        }
        // right
        if(j<m-1)
        {
            recur(i, j+1, depth-1);
            min=Math.min(min, dp[i][j+1][depth-1] + right[i][j]);
        }
        // up
        if(i>0)
        {
            recur(i-1, j, depth-1);
            min=Math.min(min, dp[i-1][j][depth-1] + down[i-1][j]);
        }
        // down
        if(i<n-1)
        {
            recur(i+1, j, depth-1);
            min=Math.min(min, dp[i+1][j][depth-1] + down[i][j]);

        }
        dp[i][j][depth]=min;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        k=sc.nextInt();
        right=new int[n][m-1];
        down=new int[n-1][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m-1;j++)
                right[i][j]=sc.nextInt();
        for(int i=0;i<n-1;i++)
            for(int j=0;j<m;j++)
                down[i][j]=sc.nextInt();
        if(k%2==1) {
            for(int i=0;i<n;++i) {
                for (int j = 0; j < m; j++)
                    System.out.print(-1 + " ");
                System.out.println();
            }
        }
        else
        {
            k/=2;
            dp=new int[n][m][k+1];
            for(int i=0;i<n;++i)
                for(int j=0;j<m;j++)
                    for(int z=1;z<=k;z++)
                        dp[i][j][z]=-1;
            for(int i=0;i<n;++i)
                for(int j=0;j<m;j++)
                    recur(i,j,k);
            for(int i=0;i<n;++i) {
                for (int j = 0; j < m; j++)
                    System.out.print((dp[i][j][k] * 2) + " ");
                System.out.println();
            }
        }
    }

}