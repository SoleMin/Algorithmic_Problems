import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]){
        FastReader input=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        int T=1;
        while(T-->0)
        {
            int n=input.nextInt();
            long a[][]=new long[n][n];
            for(int i=0;i<n;i++)
            {
                a[0][i]=input.nextInt();
            }
            int x=1;
            for(int i=1;i<n;i++)
            {
                for(int j=0;j<n-x;j++)
                {
                    a[i][j]=a[i-1][j]^a[i-1][j+1];
                }
                x++;
            }
            /*
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    out.print(a[i][j]+" ");
                }
                out.println();
            }

             */
            long arr[][]=new long[n][n];
            for(int i=0;i<n;i++)
            {
                long max=0;
                x=0;
                int y=i;
                while(y>=0)
                {
                    max=Math.max(max,a[x][y]);
                    arr[x][y]=max;
                    x++;
                    y--;
                }
            }
            x=0;
            for(int i=0;i<n;i++)
            {
                long max=0;
                int y=x;
                for(int j=0;j<n-i;j++)
                {
                    max=Math.max(max,arr[j][i]);
                    a[x][y]=max;
                    y++;
                }
                x++;
            }
            int q=input.nextInt();
            for(int i=0;i<q;i++)
            {
                int l=input.nextInt();
                int r=input.nextInt();
                l--;
                r--;
                out.println(a[l][r]);
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