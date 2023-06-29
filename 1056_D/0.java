import javafx.util.Pair;

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
            Vertex V[]=new Vertex[n+1];
            for(int i=1;i<=n;i++)
            {
                adj[i]=new ArrayList<>();
                V[i]=new Vertex(i);
            }
            for(int i=2;i<=n;i++)
            {
                int v=input.nextInt();
                adj[i].add(v);
                adj[v].add(i);
            }
            ArrayList<Integer> list=bfs(adj,V,1);
            int arr[]=new int[n+1];
            Queue<Integer> q=new LinkedList<>();
            HashSet<Integer> set=new HashSet<>();
            for(int i=1;i<=n;i++)
            {
                if(i==1)
                {
                    if(adj[i].size()==0)
                    {
                        q.add(1);
                        arr[1]=1;
                        set.add(1);
                    }
                }
                else
                {
                    if(adj[i].size()==1)
                    {
                        q.add(i);
                        arr[i]=1;
                        set.add(i);
                    }
                }
            }
            for(int i=list.size()-1;i>=0;i--)
            {
                int u=list.get(i);
                if(u!=1)
                {
                    int v=V[u].parent.key;
                    arr[v]+=arr[u];
                }
            }
            mergeSort(arr,1,n);
            HashMap<Integer,Integer> map=new HashMap<>();
            TreeMap<Integer,Integer> tmap=new TreeMap<>();
            int p=arr[1];
            int count=1;
            for(int i=2;i<=n;i++)
            {
                if(arr[i]!=arr[i-1])
                {
                    tmap.put(count,p);
                    count++;
                    p=arr[i];
                }
                else
                {
                    count++;
                }
            }
            tmap.put(count,p);
            for(int i=1;i<=n;i++)
            {
                int k=tmap.ceilingKey(i);
                out.print(tmap.get(k)+" ");
            }
            out.println();
        }
        out.close();
    }
    public static void mergeSort(int a[],int p,int r)
    {
        if(p<r)
        {
            int q=(p+r)/2;
            mergeSort(a,p,q);
            mergeSort(a,q+1,r);
            merge(a,p,q,r);
        }
    }
    public static void merge(int a[],int p,int q,int r)
    {
        int n1=q-p+2;
        int L[]=new int[n1];
        int n2=r-q+1;
        int R[]=new int[n2];
        for(int i=p;i<=q;i++)
        {
            L[i-p]=a[i];
        }
        L[n1-1]=Integer.MAX_VALUE;
        for(int i=q+1;i<=r;i++)
        {
            R[i-q-1]=a[i];
        }
        R[n2-1]=Integer.MAX_VALUE;
        int x=0,y=0;
        for(int i=p;i<=r;i++)
        {
            if(L[x]<=R[y])
            {
                a[i]=L[x];
                x++;
            }
            else
            {
                a[i]=R[y];
                y++;
            }
        }
    }
    public static ArrayList<Integer> bfs(ArrayList<Integer> adj[],Vertex V[], int s)
    {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(s);
        V[s].color="gray";
        V[s].d=0;
        V[s].parent=null;
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        while(!q.isEmpty())
        {
            int k=q.poll();
            Vertex u=V[k];
            for(int i=0;i<adj[k].size();i++)
            {
                int key=adj[k].get(i);
                Vertex v=V[key];
                if(v.color=="white")
                {
                    q.add(key);
                    list.add(key);
                    v.color="gray";
                    v.d=u.d+1;
                    v.parent=u;
                }
            }
            u.color="black";
        }
        return list;
    }
    public static class Vertex
    {
        int key;
        int d,f;
        String color;
        Vertex parent;
        Vertex(int key)
        {
            this.key=key;
            this.d=0;
            this.f=0;
            this.color="white";
            this.parent=null;
        }
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