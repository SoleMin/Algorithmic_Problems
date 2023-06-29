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
            int c[]=new int[n];
            for(int i=0;i<n;i++)
            {
                c[i]=input.nextInt();
            }
            ArrayList<Integer> adj[]=new ArrayList[n+1];
            for(int i=1;i<=n;i++)
            {
                adj[i]=new ArrayList<>();
            }
            for(int i=1;i<=n;i++)
            {
                int a=input.nextInt();
                adj[i].add(a);
            }
            ArrayList<ArrayList<Integer>> list=dfs(adj,n);
            int ans=0;
            for(int i=0;i<list.size();i++)
            {
                int min=Integer.MAX_VALUE;
                for(int j=0;j<list.get(i).size();j++)
                {
                    min=Math.min(min,c[list.get(i).get(j)-1]);
                }
                ans+=min;
            }
            out.println(ans);
        }
        out.close();
    }
    public static ArrayList<ArrayList<Integer>> dfs(ArrayList<Integer> adj[],int n)
    {
        int visit[]=new int[n+1];
        HashSet<Integer> set=new HashSet<>();
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            if(visit[i]==0)
            {
                dfsUtil(adj,i,visit,list,set,n);
            }
        }
        return list;
    }
    public static void dfsUtil(ArrayList<Integer> adj[],int u,int visit[],ArrayList<ArrayList<Integer>> list,HashSet<Integer> set,int n)
    {
        visit[u]=1;
        int v=adj[u].get(0);
        if(visit[v]==1)
        {
            if(!set.contains(v) && !set.contains(u))
            {
                ArrayList<Integer> l=new ArrayList<>();
                l.add(v);
                l.add(u);
                int x=l.get(0);
                int z=l.get(1);
                ArrayList<Integer> l1=new ArrayList<>();
                int c=0;
                int flag=0;
                while(true)
                {
                    l1.add(x);
                    c++;
                    set.add(x);
                    if(x==z)
                    {
                        break;
                    }
                    x=adj[x].get(0);
                    if(c>n)
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                list.add(l1);
            }
            else
            {
                set.add(u);
            }
            return;
        }
        else
        {
            dfsUtil(adj,v,visit,list,set,n);
        }
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