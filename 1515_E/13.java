import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.List;
 import java.util.*;
 public class realfast implements Runnable 
  {
    private static final int INF = (int) 1e9;
    long in= 1000000007;
    long fac[]= new long[1000001];
    long inv[]=new long[1000001];
    public  void solve() throws IOException 
    {

        //int t = readInt();

        int n = readInt();

        long m  = readInt();

        long method[][]=new long [n+1][n+1];

        for(int i=0;i<=n;i++)
        {
            method[0][i]=1;
            method[i][0]=1;
        }

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                 for(int k=i;k>=0;k--)
                 {
                      method[i][j]= (method[i][j]%m+method[k][j-1]%m)%m;
                 }
            }
        }
         // index , total , cont
        //long dp[][][]=new  long[n+2][n+2][n+2];
        long sum[][]=new long[n+2][n+2];
        sum[0][0]=1;
      //  dp[0][0][0]=1;

        long len[][]=new long[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            len[i][0]=1;
            len[0][i]=1;
        }

        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<i;j++)
            {
                 len[j][i-j]= (len[j-1][i-j]%m+len[j][i-j-1]%m)%m;
            }
        }

        long gal[]=new long[2*n+1];

        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                gal[i+j]= (gal[i+j]+ len[i][j])%m; 
            }
        }





        for(int i=1;i<=n;i++)
        {
            if(i==n-1)
                continue;
            for(int j=1;j<=i;j++)
            {
                    
                   for(int k=1;k<=j;k++)
                   {
                          
                          
                              long val =sum[i-k][j-k];
                              val = (val*method[j-k][k])%m;
                            
                              val =(val*gal[k-1])%m;
                              sum[i+1][j]= (sum[i+1][j]+val)%m;
                          

                   }
            }
        }

        long ans =0;

        for(int i=1;i<=n;i++)
        {
            ans = (ans + sum[n+1][i])%m;

        }

        out.println(ans);




       

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