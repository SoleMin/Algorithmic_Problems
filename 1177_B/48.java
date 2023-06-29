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
            long k=input.nextLong();
            long v=9;
            long s=0;
            int x=1;
            while(true)
            {
                if(s+v*x>k)
                {
                    break;
                }
                s+=v*x;
                v*=10;
                x++;
            }
            if(s==k)
            {
                out.println(9);
            }
            else
            {
                long d=k-s;
                long u=d/x;
                long rem=d%x;
                long nu=(long)Math.pow(10,x-1);
                nu+=u;
                if(rem==0)
                {
                    nu--;
                    out.println(nu%10);
                }
                else
                {
                    String str=String.valueOf(nu);
                    out.println(str.charAt((int)(rem-1)));
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
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}