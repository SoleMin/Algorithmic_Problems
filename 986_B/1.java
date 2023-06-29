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
    int ans=0;
    public void solve() throws Exception{
        int n=sc.ni();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.ni();
        invcount(arr,0,n-1);
        n%=2;
        ans%=2;
        if(n==ans)
        pw.print("Petr");
        else
        pw.print("Um_nik");
    }
    public ArrayList<Integer> invcount(int[] arr,int l,int r){
        if(r<=l){
         ArrayList<Integer> list = new ArrayList();
         list.add(arr[l]);
         return list;}
        int mid=(l+r)/2,p=0,q=0;
        ArrayList<Integer> list=invcount(arr,l,(l+r)/2);
        ArrayList<Integer> list1=invcount(arr,(l+r)/2+1,r);
        ArrayList<Integer> ret=new ArrayList();
        while(list1.size()>q&&list.size()>p){
            if(list.get(p)<list1.get(q))
            ret.add(list.get(p++));
            else{
                ans=(ans+(list.size()-p)%2)%2;
                ret.add(list1.get(q++));
            }
        }
        while(p<list.size())
        ret.add(list.get(p++));
        while(q<list1.size())
        ret.add(list1.get(q++));
        return ret;
    }
}