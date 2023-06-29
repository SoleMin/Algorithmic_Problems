//created by Whiplash99
import java.io.*;
import java.util.*;
public class A
{
    private static final int MAX=(int)1e9+5;
    private static ArrayDeque<Integer>[] edge;
    private static int[] indeg, level;
    private static Pair[] pairs;
    private static ArrayDeque<Integer> Q;

    static class Pair implements Comparable<Pair>
    {
        int f, s, c, id;
        Pair(int f, int s, int c, int id){this.f = f;this.s = s; this.c=c; this.id=id;}
        public int compareTo(Pair b){return Integer.compare(this.c,b.c);}
    }
    private static int topoSort(int mid, int N, int M)
    {
        int i;
        for(i=0;i<N;i++) edge[i].clear();
        Arrays.fill(indeg,0);
        Q.clear(); Arrays.fill(level,0);

        for(i=M-1;i>=0;i--)
        {
            if(pairs[i].c<=mid) break;

            int u=pairs[i].f, v=pairs[i].s;
            indeg[v]++; edge[u].add(v);
        }

        int count=0;
        for(i=0;i<N;i++) if(indeg[i]==0) Q.add(i);
        while (!Q.isEmpty())
        {
            int u=Q.poll();
            level[u]=++count;

            for(int v:edge[u])
            {
                indeg[v]--;
                if(indeg[v]==0) Q.add(v);
            }
        }
        return count;
    }
    private static boolean check(int mid, int N, int M){return topoSort(mid,N,M)==N;}
    private static int bSearch(int N, int M)
    {
        int l=0,r=MAX, mid, ans=-1;
        while (l<=r)
        {
            mid=(l+r)/2;
            if(check(mid,N,M))
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }

        return ans;
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int i,N;

        String[] s=br.readLine().trim().split(" ");
        N=Integer.parseInt(s[0]);
        int M=Integer.parseInt(s[1]);

        edge=new ArrayDeque[N]; for(i=0;i<N;i++) edge[i]=new ArrayDeque<>();
        pairs=new Pair[M]; Q=new ArrayDeque<>(); indeg=new int[N];
        level=new int[N];

        for(i=0;i<M;i++)
        {
            s=br.readLine().trim().split(" ");
            int u=Integer.parseInt(s[0])-1;
            int v=Integer.parseInt(s[1])-1;
            int c=Integer.parseInt(s[2]);

            pairs[i]=new Pair(u,v,c,i);
        }
        Arrays.sort(pairs);

        int ans=bSearch(N,M);
        StringBuilder sb=new StringBuilder();

        int cur=topoSort(ans,N,M), rev=0;
        for(i=0;i<M;i++)
        {
            if(pairs[i].c>ans) break;
            int u=pairs[i].f, v=pairs[i].s;

            if(level[u]==0&&level[v]==0)
            {
                level[u]=++cur;
                level[v]=++cur;
            }
            else if(level[u]==0)
            {
                level[u]=++cur;
                rev++; sb.append(pairs[i].id+1).append(" ");
            }
            else if(level[v]==0)
            {
                level[v]=++cur;
            }
            else
            {
                if(level[v]<level[u])
                {
                    rev++;
                    sb.append(pairs[i].id+1).append(" ");
                }
            }
        }

        System.out.println(ans+" "+rev);
        System.out.println(sb);
    }
}