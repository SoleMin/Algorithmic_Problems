import java.util.*;
import java.io.*;
public class Solution implements Runnable {
    FastScanner sc;
    PrintWriter pw;
    final class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner() {
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
 
        public long nlo() {
            return Long.parseLong(next());
        }
 
        public String next() {
            if (st.hasMoreTokens()) return st.nextToken();
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }
 
        public int ni() {
            return Integer.parseInt(next());
        }
 
        public String nli() {
            String line = "";
            if (st.hasMoreTokens()) line = st.nextToken();
            else try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (st.hasMoreTokens()) line += " " + st.nextToken();
            return line;
        }
 
        public double nd() {
            return Double.parseDouble(next());
        }
    }
    public static void main(String[] args) throws Exception
    {
        new Thread(null,new Solution(),"codeforces",1<<28).start();
    }
    public void run()
    {
        sc=new FastScanner();
        pw=new PrintWriter(System.out);
        try{
        solve();}
        catch(Exception e)
        {
            pw.println(e);
        }
        pw.flush();
        pw.close();
    }
    public long gcd(long a,long b)
    {
        return b==0L?a:gcd(b,a%b);
    }
    public long ppow(long a,long b,long mod)
    {
        if(b==0L)
        return 1L;
        long tmp=1;
        while(b>1L)
        {
            if((b&1L)==1)
            tmp*=a;
            a*=a;
            a%=mod;
            tmp%=mod;
            b>>=1;
        }
        return (tmp*a)%mod;
    }
    public  int gcd(int x,int y)
    {
        return y==0?x:gcd(y,x%y);
    }
   
    //////////////////////////////////
    /////////////  LOGIC  ///////////
    ////////////////////////////////
    
    int[] visit,prr;
    ArrayList<Integer>[] adj;
    int mx=0,mv=0;
    boolean res=true;
    public void solve() throws Exception{
        int n=sc.ni();
        int k=sc.ni();
        visit=new int[n];
        adj=new ArrayList[n];
        for(int i=0;i<n;i++)
        adj[i]=new ArrayList();
        for(int i=0;i<n-1;i++)
        {
            int x=sc.ni()-1;
            int y=sc.ni()-1;
            adj[x].add(y);
            adj[y].add(x);
        }
        dm(n);
        res=((mx%2==0)&&(mx/2)==k);
        if(res){
            mx/=2;
            dist(mv,mx);
            visit=new int[n];
            if(adj[mv].size()<3)
            res=false;
            else
            check(mv,mx);
        }
        if(res)
        pw.println("Yes");
        else
        pw.println("No");
    }
    public void dm(int n){
        mx=0;
        prr=new int[n];
        dfs(0,0,0);
        visit=new int[n];
        mx=0;
        prr=new int[n];
        dfs(mv,0,mv);
        visit=new int[n];

    }
    public void dfs(int x,int d,int p)
    {
        visit[x]=1;
        prr[x]=p;
        if(d>mx){
            mx=d;
            mv=x;
        }
        for(int v:adj[x])
            if(visit[v]==0)
                dfs(v,d+1,x);
    }
    public void dist(int x,int d)
    {
       for(int i=0;i<d;i++)
           mv=prr[mv];
    }
    public void check(int x,int d){
        visit[x]=1;
        if(x!=mv){
            if(adj[x].size()==1){
                if(d!=0)
                    res=false;
                }
            else if(adj[x].size()<4)
                res=false;
        }
        for(int v:adj[x])
            if(visit[v]==0)
                check(v,d-1);
    }
}