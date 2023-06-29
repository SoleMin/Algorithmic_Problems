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
            int k=input.nextInt();
            int p[]=new int[n];
            int arr[]=new int[256];
            for(int i=0;i<256;i++)
            {
                arr[i]=-1;
            }
            for(int i=0;i<n;i++)
            {
                p[i]=input.nextInt();
            }
            int b[]=new int[n];
            int a[]=new int[256];
            for(int i=0;i<n;i++)
            {
                int x=p[i];
                if(arr[x]==-1)
                {
                    int y=x-(k-1);
                    if(y<0)
                    {
                        y=0;
                    }
                    if(y==0)
                    {
                        for(int j=0;j<=x;j++)
                        {
                            arr[j]=0;
                        }
                        a[0]=1;
                    }
                    else
                    {
                        int z=-1;
                        for(int j=y;j<=x;j++)
                        {
                            if(a[j]==1)
                            {
                                z=j;
                                break;
                            }
                        }
                        if(z!=-1)
                        {
                            for(int j=z;j<=x;j++)
                            {
                                arr[j]=z;
                            }
                        }
                        else
                        {
                            int in=-1;
                            for(int j=x;j>=y;j--)
                            {
                                if(arr[j]!=-1)
                                {
                                    in=j;
                                    break;
                                }
                            }
                            if(in==-1)
                            {
                                in=y;
                            }
                            else
                            {
                                in++;
                            }
                            for(int j=in;j<=x;j++)
                            {
                                arr[j]=in;
                            }
                            a[in]=1;
                        }
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                b[i]=arr[p[i]];
            }
            for(int i=0;i<n;i++)
            {
                out.print(b[i]+" ");
            }
            out.println();
        }
        out.close();
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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