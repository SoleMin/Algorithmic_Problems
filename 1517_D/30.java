import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[])
    {
        FastReader input=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        int T=1;
        while(T-->0)
        {
            int n=input.nextInt();
            int m=input.nextInt();
            int k=input.nextInt();
            int arr1[][]=new int[n+1][m];
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<m;j++)
                {
                    arr1[i][j]=input.nextInt();
                }
            }
            int arr2[][]=new int[n][m+1];
            for(int i=1;i<n;i++)
            {
                for(int j=1;j<=m;j++)
                {
                    arr2[i][j]=input.nextInt();
                }
            }
            if(k%2==0)
            {
                int dp[][][]=new int[n+1][m+1][k+1];
                for(int l=2;l<=k;l+=2)
                {
                    for(int i=1;i<=n;i++)
                    {
                        for(int j=1;j<=m;j++)
                        {
                            int min=Integer.MAX_VALUE;
                            if(j+1<=m)
                            {
                                min=Math.min(min,dp[i][j+1][l-2]+2*arr1[i][j]);
                            }
                            if(i+1<=n)
                            {
                                min=Math.min(min,dp[i+1][j][l-2]+2*arr2[i][j]);
                            }
                            if(j-1>=1)
                            {
                                min=Math.min(min,dp[i][j-1][l-2]+2*arr1[i][j-1]);
                            }
                            if(i-1>=1)
                            {
                                min=Math.min(min,dp[i-1][j][l-2]+2*arr2[i-1][j]);
                            }
                            dp[i][j][l]=min;
                        }
                    }
                }
                for(int i=1;i<=n;i++)
                {
                    for(int j=1;j<=m;j++)
                    {
                        out.print(dp[i][j][k]+" ");
                    }
                    out.println();
                }
            }
            else
            {
                for(int i=1;i<=n;i++)
                {
                    for(int j=1;j<=m;j++)
                    {
                        out.print(-1+" ");
                    }
                    out.println();
                }
            }
        }
        out.close();
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt()
        {
            return Integer.parseInt(next());
        }
        long nextLong()
        {
            return Long.parseLong(next());
        }
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        String nextLine()
        {
            String str="";
            try
            {
                str=br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}