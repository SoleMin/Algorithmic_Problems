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
            if(n==1)
            {
                out.println("NO");
            }
            else
            {
                HashMap<Integer,Integer> map=new HashMap<>();
                int visit[]=new int[n+1];
                for(int i=1;i<=n;i++)
                {
                    if(adj[i].size()==1)
                    {
                        map.put(i,3);
                        visit[i]=1;
                    }
                }
                int c=0;
                int flag=0;
                while(true)
                {
                    Iterator it=map.entrySet().iterator();
                    int count=0;
                    HashMap<Integer,Integer> map1=new HashMap<>();
                    while(it.hasNext())
                    {
                        Map.Entry e=(Map.Entry)it.next();
                        int v=(int)e.getKey();
                        int r=(int)e.getValue();
                        if(r<3)
                        {
                            flag=1;
                            break;
                        }
                        else
                        {
                            int co=0;
                            for(int i=0;i<adj[v].size();i++)
                            {
                                if(visit[adj[v].get(i)]==0)
                                {
                                    int ver=adj[v].get(i);
                                    if(map1.containsKey(ver))
                                    {
                                        map1.put(ver,map1.get(ver)+1);
                                    }
                                    else
                                    {
                                        map1.put(ver,1);
                                    }
                                    co++;
                                }
                            }
                            if(co==0)
                            {
                                count++;
                            }
                            else if(co>1)
                            {
                                flag=1;
                                break;
                            }
                        }
                    }
                    if(flag==1)
                    {
                        break;
                    }
                    map=new HashMap<>();
                    it=map1.entrySet().iterator();
                    while(it.hasNext())
                    {
                        Map.Entry e=(Map.Entry)it.next();
                        int ver=(int)e.getKey();
                        int r=(int)e.getValue();
                        visit[ver]=1;
                        map.put(ver,r);
                    }
                    c++;
                    if(count==1)
                    {
                        break;
                    }
                    else if(count>1)
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==1)
                {
                    out.println("NO");
                }
                else
                {
                    c--;
                    if(c==k)
                    {
                        out.println("YES");
                    }
                    else
                    {
                        out.println("NO");
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