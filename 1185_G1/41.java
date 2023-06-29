import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
 public class realfast implements Runnable {
    private static final int INF = (int) 1e9;
    int time[]= new int[15];
     int g[]= new int [15];
    public  void solve() throws IOException 
    {
     int n = readInt();
     int t = readInt();
     
     for(int i=0;i<n;i++)
     {
     	time[i]=readInt();
     	g[i]=readInt();
     }
     long dp[][]= new long [(int)Math.pow(2,n)][4];
     for(int i =0;i<(int)Math.pow(2,n);i++)
     {
      for(int j=0;j<=3;j++)
       dp[i][j]=-1;	
     }
     long val = cal(dp,0,0,0,t);
     out.println(val);

    }
    public long cal(long dp[][], int mask , int genre , int t ,int T  )
    {
    	int val = dp.length;
  
        if(t>T)
        {
         return 0;	
        }
    	if(t==T)
    	{
    	 	return 1;
    	}
      
       if(dp[mask][genre]!=-1)
        return dp[mask][genre];
        dp[mask][genre]=0;
       int i=1;
       int count=0;
       while(i<val)
       {
      
       	if((i&mask)==0&&g[count]!=genre)
       	{
       	 	dp[mask][genre] = ((dp[mask][genre]%1000000007)+ cal(dp,mask|i,g[count],t+time[count],T)%1000000007)%1000000007;
       	}
       	i=2*i;
       	count++;
       }
       return dp[mask][genre];
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
    int v ;
    int val;
    edge(int u1, int v1 , int val1)
    {
       this.u=u1;
       this.v=v1;
       this.val=val1;
    }
    public int compareTo(edge e)
    {
        return this.val-e.val;
    }
}