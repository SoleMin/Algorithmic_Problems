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
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=input.nextInt();
            }
            int sum=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<i;j++)
                {
                    if(a[j]>a[i])
                    {
                        sum++;
                    }
                }
            }
            int f=sum%2;
            int m=input.nextInt();
            for(int i=0;i<m;i++)
            {
                int l=input.nextInt();
                int r=input.nextInt();
                int d=r-l+1;
                int s=d*(d-1)/2;
                int f1=s%2;
                f+=f1;
                f=f%2;
                if(f==0)
                {
                    out.println("even");
                }
                else
                {
                    out.println("odd");
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