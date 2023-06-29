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
            long dp[][]=new long[n+1][n+1];
            char pre='0';
            long m=1000000007;
            for(int i=1;i<=n;i++)
            {
                char c=input.next().charAt(0);
                if(i==1)
                {
                    dp[1][1]=1;
                    pre=c;
                }
                else
                {
                    if(pre=='s')
                    {
                        long v=0;
                        for(int j=n;j>=1;j--)
                        {
                            v=(v+dp[i-1][j])%m;
                            dp[i][j]=v;
                        }
                    }
                    else
                    {
                        for(int j=1;j<i;j++)
                        {
                            dp[i][j+1]=dp[i-1][j];
                        }
                    }
                    pre=c;
                }
            }
            /*
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    out.print(dp[i][j]+" ");
                }
                out.println();
            }

             */
            long ans=0;
            for(int i=1;i<=n;i++)
            {
                ans=(ans+dp[n][i])%m;
            }
            out.println(ans);
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