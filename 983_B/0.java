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
            pw.println(5/0);
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
            if((b&1L)==1L)
            tmp*=a;
            a*=a;
            a%=mod;
            tmp%=mod;
            b>>=1;
        }
        return (tmp*a)%mod;
    }
    public long pow(long a,long b)
    {
        if(b==0L)
        return 1L;
        long tmp=1;
        while(b>1L)
        {
            if((b&1L)==1)
            tmp*=a;
            a*=a;
            b>>=1;
        }
        return (tmp*a);
    }
    public  int gcd(int x,int y)
    {
        return y==0?x:gcd(y,x%y);
    }
   
    //////////////////////////////////
    /////////////  LOGIC  ///////////
    ////////////////////////////////
    public class Node implements Comparable<Node>{
        int indx;
        int val;
        public Node(int x,int y)
        {
            val=y;indx=x;
        }
        public int compareTo(Node b)
        {
            if(b.val==val)
            return indx-b.indx;
            return val-b.val;
        }
    }
    public void solve() throws Exception{
    int n=sc.ni();
    int[][] dp=new int[n][n];
    int[][] val=new int[n][n];
    int[] arr=new int[n];
    for(int i=0;i<n;i++)
    arr[i]=sc.ni();
    for(int i=n-1;i>=0;i--){
        val[i][i]=dp[i][i]=arr[i];
        for(int j=i+1;j<n;j++){
            val[i][j]=val[i][j-1]^val[i+1][j];
            dp[i][j]=Math.max(val[i][j],Math.max(dp[i+1][j],dp[i][j-1]));
        }
    }
    int q=sc.ni();
    while(q-->0){
        int l=sc.ni()-1;
        int r=sc.ni()-1;
        pw.println(dp[l][r]);
    }
}
}