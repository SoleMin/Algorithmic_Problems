import java.util.*;
import java.io.*;
import java.text.*;
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
            solve();
        }
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
    public void solve() throws Exception{
        int n=sc.ni();
        int k=sc.ni();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.ni();
        HashMap<Integer,Long> map=new HashMap<Integer,Long>();
        int xor=arr[0];
        map.put(xor,1L);
        for(int i=1;i<n;i++){
            xor^=arr[i];
            map.put(xor,map.getOrDefault(xor,0L)+1);
        }
        Iterator<Integer> itr=map.keySet().iterator();
        HashSet<Integer> set=new HashSet();
        long ans=(Long.valueOf(n)*Long.valueOf(n+1))/Long.valueOf(2);
        while(itr.hasNext()){
            int x=itr.next();
            if(set.contains(x))
            continue;
            int y=((1<<k)-1)^x;
            long f=map.get(x)+map.getOrDefault(y,0L),min=Long.MAX_VALUE;
            for(long i=0;i<=f;i++){
                long val = nc2(i)+nc2(f-i) + ((x==0L||y==0L) ? i:0L);
                min=Math.min(min,val);
            }
            ans-=min;
            set.add(x);set.add(y);
        }
        pw.println(ans);
    }
    public long nc2(long n){
        return n*(n-1L)/2L;
    }
}
