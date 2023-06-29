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
   public ArrayList<Integer>[] adj;
   public int[] visit;
   public int[] dist,ans;
    public void solve() throws Exception{
       int n=sc.ni();
       int[] arr=new int[n];
       StringBuilder str=new StringBuilder();
       int m = 0,d=0;
       ArrayList<Integer> list,list1;
       list=new ArrayList();
       list1=new ArrayList();
       for(int i=0;i<n;i++){
           arr[i]=sc.ni();
           if(arr[i]==1)
           list.add(i);
           else
           list1.add(i);
       }
       boolean res=true;
       if(list1.size()==0)
       res=false;
       else if(list1.size()==1){
        if(arr[list1.get(0)]<list.size()){
            res=false;
        }
        else{
            m=list.size();
            d=2;
            for(int x:list){
                int a=x+1;
                int b=list1.get(0)+1;
                str.append(a+" "+b+"\n");
            }
        }
       }
       else{
            m=list1.size()-1+list.size();
            d=list1.size()-1;
            for(int i=1;i<list1.size();i++){
                int a=list1.get(i)+1;
                int b=list1.get(i-1)+1;
                arr[a-1]--;arr[b-1]--;
                str.append(a+" "+b+"\n");
            }
            int p=0;
            if(p<list.size())
            {
                int a=list.get(p++)+1;
                int b=list1.get(0)+1;
                arr[b-1]--;
                str.append(a+" "+b+"\n");d++;
            }
            if(p<list.size())
            {
                int a=list.get(p++)+1;
                int b=list1.get(list1.size()-1)+1;
                arr[b-1]--;
                str.append(a+" "+b+"\n");d++;
            }
            HashSet<Integer> set=new HashSet();
            for(int x:list1)
                if(arr[x]>0)
                    set.add(x);
            
            for(int x:set){
                for(;p<list.size();p++){
                    if(arr[x]==0)
                    break;
                    int a=x+1;
                    int b=list.get(p)+1;
                    str.append(a+" "+b+"\n");
                    arr[x]--;
                }
            }
            if(p<list.size())
            res=false;
       }
       if(res){
           pw.println("YES "+d);
           pw.println(m+"\n"+str);
       }
       else
       pw.println("NO");
    }
}