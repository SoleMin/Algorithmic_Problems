import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.List;
 import java.util.*;
public  class realfast implements Runnable 
  {
    private static final int INF = (int) 1e9;
    long in= 1000000007;
    long fac[]= new long[1000001];
    long inv[]=new long[1000001];
    public  void solve() throws IOException 
    {

      int n = readInt();

      int arr[]=new int[n+1];
      for(int i =1;i<=n;i++)
        arr[i]= readInt();
      long max[]=new long[n+1];

      ArrayList<Integer> adj []=new ArrayList[n+1];
      for(int i =0;i<=n;i++)
        adj[i]= new ArrayList<Integer>();
      for(int i =0;i<n-1;i++)
      {
         int u = readInt();
         int v = readInt();
         adj[u].add(v);
         adj[v].add(u);
      }
        cons(adj,1,-1,max, arr);
        
        long max1= -1000000000;
        for(int i =1;i<=n;i++)
            max1=Math.max(max1,max[i]);
        long count[]=new long[2];
        Arrays.fill(max,0);
         count(adj,1,-1,max1,arr,max,count);

        max1= max1*count[0];
        
        out.println(max1+" "+count[0]);
        

    }
    public void cons(ArrayList<Integer> adj[] , int i , int par , long max[], int arr[])
    {

            max[i]=arr[i];

            for(int j =0;j<adj[i].size();j++)
            {
                 int v = adj[i].get(j);
                 if(v==par)
                    continue;
                 cons(adj,v,i,max,arr);
                 max[i]=Math.max(max[v],0)+max[i];
            }



    }
    public void count(ArrayList<Integer> adj[], int i , int par  , long max1, int arr[], long dp[], long count[])
    {
            
               
                   dp[i]= arr[i];

                   for(int j =0;j<adj[i].size();j++)
                   {
                      int v = adj[i].get(j);
                      if(v==par)
                        continue;
                    count(adj,v,i,max1,arr,dp,count);
                      dp[i]=Math.max(dp[v],0)+dp[i];
                   }

                   if(dp[i]==max1)
                   {
                    dp[i]=0;
                    count[0]++;
                   }
                   
            
    }

   
    public int value (int seg[], int left , int right ,int index, int l, int r)
    {
            
            if(left>right)
            {
              return -100000000;
            }
            if(right<l||left>r)
                return -100000000;
            if(left>=l&&right<=r)
                return seg[index];
            int mid = left+(right-left)/2;
            int val = value(seg,left,mid,2*index+1,l,r);
            int val2 = value(seg,mid+1,right,2*index+2,l,r);
            return Math.max(val,val2);

    }
   
    public int gcd(int a , int b )
    {
      if(a<b)
      {
        int t =a;
        a=b;
        b=t;
      }
      if(a%b==0)
        return b ;
      return gcd(b,a%b);
    }
    public long pow(long n , long p,long m)
    {
         if(p==0)
            return 1;
        long val = pow(n,p/2,m);;
        val= (val*val)%m;
        if(p%2==0)
            return val;
        else
            return (val*n)%m;
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        new Thread(null, new realfast(), "", 128 * (1L << 20)).start();
    }
 
    private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter out;
 
    @Override
    public void run() {
        try {
            if (ONLINE_JUDGE || !new File("input.txt").exists()) {
                reader = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                reader = new BufferedReader(new FileReader("input.txt"));
                out = new PrintWriter("output.txt");
            }
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                // nothing
            }
            out.close();
        }
    }
 
    private String readString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
 
    @SuppressWarnings("unused")
    private int readInt() throws IOException {
        return Integer.parseInt(readString());
    }
 
    @SuppressWarnings("unused")
    private long readLong() throws IOException {
        return Long.parseLong(readString());
    }
 
    @SuppressWarnings("unused")
    private double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }
}
class edge implements Comparable<edge>{
    int u ;
    int v;
    
    edge(int u, int v)
    {
       this.u=u;
       this.v=v;
    }
    public int compareTo(edge e)
    {
        return this.v-e.v;
    }
}