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
            int a=input.nextInt();
            int b=input.nextInt();
            if(a>1)
            {
                if(b>1)
                {
                    out.println("NO");
                }
                else
                {
                    if(n<a)
                    {
                        out.println("NO");
                    }
                    else
                    {
                        out.println("YES");
                        for(int i=1;i<=a-1;i++)
                        {
                            for(int j=0;j<n;j++)
                            {
                                out.print('0');
                            }
                            out.println();
                        }
                        for(int i=1;i<=n;i++)
                        {
                            if(i<=a)
                            {
                                out.print('0');
                            }
                            else
                            {
                                out.print('1');
                            }
                        }
                        out.println();
                        for(int i=a+1;i<=n;i++)
                        {
                            for(int j=1;j<=n;j++)
                            {
                                if(j==a)
                                {
                                    out.print('1');
                                }
                                else
                                {
                                    out.print('0');
                                }
                            }
                            out.println();
                        }
                    }
                }
            }
            else
            {
                if(b==1)
                {
                    if(n==1)
                    {
                        out.println("YES");
                        out.println('0');
                    }
                    else if(n<=3)
                    {
                        out.println("NO");
                    }
                    else
                    {
                        out.println("YES");
                        for(int i=1;i<=n;i++)
                        {
                            for(int j=1;j<=n;j++)
                            {
                                if(j==i-1 || j==i+1)
                                {
                                    out.print('1');
                                }
                                else
                                {
                                    out.print('0');
                                }
                            }
                            out.println();
                        }
                    }
                }
                else
                {
                    if(n<b)
                    {
                        out.println("NO");
                    }
                    else
                    {
                        out.println("YES");
                        char ch[][]=new char[n+1][n+1];
                        for(int i=1;i<=b-1;i++)
                        {
                            for(int j=1;j<=n;j++)
                            {
                                if(j==i)
                                {
                                    ch[i][j]='0';
                                    ch[j][i]='0';
                                }
                                else
                                {
                                    ch[i][j]='1';
                                    ch[j][i]='1';
                                }
                            }
                        }
                        for(int i=b;i<=n;i++)
                        {
                            for(int j=b;j<=n;j++)
                            {
                                ch[i][j]='0';
                            }
                        }
                        for(int i=1;i<=n;i++)
                        {
                            for(int j=1;j<=n;j++)
                            {
                                out.print(ch[i][j]);
                            }
                            out.println();
                        }
                    }
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