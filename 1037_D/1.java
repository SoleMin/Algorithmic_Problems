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
            ArrayList<Integer> adj[]=new ArrayList[n+1];
            for(int i=1;i<=n;i++)
            {
                adj[i]=new ArrayList<>();
            }
            for(int i=0;i<n-1;i++)
            {
                int u=input.nextInt();
                int v=input.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=input.nextInt();
            }
            if(a[0]!=1)
            {
                out.println("No");
            }
            else
            {
                int in=1;
                int visit[]=new int[n+1];
                int flag=0;
                for(int i=0;i<n;i++)
                {
                    visit[a[i]]=1;
                    HashSet<Integer> set=new HashSet<>();
                    for(int j=0;j<adj[a[i]].size();j++)
                    {
                        if(visit[adj[a[i]].get(j)]==0)
                        {
                            set.add(adj[a[i]].get(j));
                            visit[adj[a[i]].get(j)]=1;
                        }
                    }
                    if(set.size()>0)
                    {
                        if(in+set.size()>n)
                        {
                            flag=1;
                            break;
                        }
                        for(int j=in;j<in+set.size();j++)
                        {
                            if(!set.contains(a[j]))
                            {
                                flag=1;
                                break;
                            }
                        }
                        if(flag==1)
                        {
                            break;
                        }
                        in=in+set.size();
                    }
                }
                if(flag==1)
                {
                    out.println("No");
                }
                else
                {
                    out.println("Yes");
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