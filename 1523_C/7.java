import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[])
    {
        FastReader input=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        int T=input.nextInt();
        while(T-->0)
        {
            int n=input.nextInt();
            int b[]=new int[n];
            for(int i=0;i<n;i++)
            {
                b[i]=input.nextInt();
            }
            StringBuilder sb=new StringBuilder("");
            int arr[]=new int[n+1];
            out.println('1');
            sb.append('1');
            int size=1;
            arr[size-1]=1;
            for(int i=1;i<n;i++)
            {
                int a=b[i];
                if(a==1)
                {
                    size++;
                    arr[size-1]=1;
                    sb.append(".1");
                    out.println(sb.toString());
                }
                else
                {
                    sb=new StringBuilder("");
                    int in=0;
                    for(int j=size-1;j>=0;j--)
                    {
                        if(arr[j]==a-1)
                        {
                            in=j;
                            break;
                        }
                    }
                    for(int j=0;j<in;j++)
                    {
                        sb.append(arr[j]+".");
                    }
                    sb.append(a);
                    size=in+1;
                    arr[size-1]=a;
                    out.println(sb.toString());
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