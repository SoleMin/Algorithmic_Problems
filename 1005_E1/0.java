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
   
    public void solve() throws Exception{
        int n=sc.ni();
        int m=sc.ni();
        int p=0;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
        arr[i]=sc.ni();
        if(arr[i]==m)
        p=i;
        }
        HashMap<Integer,Integer> map=new HashMap();
        int val=0;
        map.put(0,1);
        for(int i=p+1;i<n;i++){
            if(arr[i]>m)
            val++;
            else
            val--;
            if(map.containsKey(val))
            map.put(val,map.get(val)+1);
            else
            map.put(val,1);
        }
        long ans=0;val=0;
        for(int i=p;i>=0;i--){
        if(arr[i]>m)
        val++;
        else if(arr[i]<m)
        val--;
        long temp=0;
        int res=-1*val;
        if(map.containsKey(res))
        temp=map.get(res);
        if(map.containsKey(res+1))
        temp=temp+map.get(res+1);
        ans=ans+temp;            
        }
        pw.println(ans);
    }
}