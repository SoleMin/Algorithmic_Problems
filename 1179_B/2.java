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
            int x=1,y=n;
            int count=0;
            while(x<=y)
            {
                int a=1,b=m;
                int f=0;
                for(int i=1;i<=m*2;i++)
                {
                    if(i%2!=0)
                    {
                        out.println(x+" "+a);
                        count++;
                        if(count==n*m)
                        {
                            f=1;
                            break;
                        }
                        a++;
                    }
                    else
                    {
                        out.println(y+" "+b);
                        count++;
                        if(count==n*m)
                        {
                            f=1;
                            break;
                        }
                        b--;
                    }
                }
                if(f==1)
                {
                    break;
                }
                x++;
                y--;
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