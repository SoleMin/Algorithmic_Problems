import java.util.*;
import java.io.*; 
import java.text.DecimalFormat;

public class Main{
    final long mod = (int)1e9+7, IINF = (long)1e19;
    final int MAX = (int)1e6+1, MX = (int)1e7+1, INF = (int)1e9;
    DecimalFormat df = new DecimalFormat("0.0000000000000");
    FastReader in;
    PrintWriter out;
    static boolean multipleTC = false, memory = false;

    public static void main(String[] args) throws Exception{
        if(memory)new Thread(null, new Runnable() {public void run(){try{new Main().run();}catch(Exception e){e.printStackTrace();}}}, "1", 1 << 26).start();
        else new Main().run();
    }

    void run() throws Exception{
        in = new FastReader();
        out = new PrintWriter(System.out);
        for(int i = 1, t = (multipleTC)?ni():1; i<=t; i++)solve(i);
        out.flush();    
        out.close();
    }

    void solve(int TC) throws Exception{
        long x = nl(), k = nl();
        if(x==0)pn(0);
        else {
            x%=mod;
            long p = modPow(2,k);
            long b = mul((x-1+mod)%mod,p), e = mul(x,p);
            long ans = c(e)%mod;
            ans -= c(b)%mod;
            ans%=mod;
            if(ans<0)ans+=mod;
            ans = mul(ans, 2);
            ans = mul(ans, modPow(p, mod-2));
            pn(ans);
        }
    }
    long modPow(long a, long p){
        long o = 1;
        while(p>0){
            if((p&1)==1)o = mul(a,o);
            a = mul(a,a);
            p>>=1;
        }
        return o;
    }
    
    
    long mul(long a, long b){
        if(a>=mod)a%=mod;
        if(b>=mod)b%=mod;
        a*=b;
        if(a>=mod)a%=mod;
        return a;
    }
    
    long c(long c){
        return (c*c+c)/2;
    }
    
    int[] reverse(int[] a){
        int[] o = new int[a.length];
        for(int i = 0; i< a.length; i++)o[i] = a[a.length-i-1];
        return o;   
    }

    int[] sort(int[] a){
        if(a.length==1)return a;
        int mid = a.length/2;
        int[] b = sort(Arrays.copyOfRange(a,0,mid)), c = sort(Arrays.copyOfRange(a,mid,a.length));
        for(int i = 0, j = 0, k = 0; i< a.length; i++){
            if(j<b.length && k<c.length){
                if(b[j]<c[k])a[i] = b[j++];
                else a[i] = c[k++];
            }else if(j<b.length)a[i] = b[j++];
            else a[i] = c[k++];
        }
        return a;
    }

    long[] sort(long[] a){
        if(a.length==1)return a;
        int mid = a.length/2;
        long[] b = sort(Arrays.copyOfRange(a,0,mid)), c = sort(Arrays.copyOfRange(a,mid,a.length));
        for(int i = 0, j = 0, k = 0; i< a.length; i++){
            if(j<b.length && k<c.length){
                if(b[j]<c[k])a[i] = b[j++];
                else a[i] = c[k++];
            }else if(j<b.length)a[i] = b[j++];
            else a[i] = c[k++];
        }
        return a;
    }

    int[] ia(int ind,int n){
        int[] out = new int[ind+n];
        for(int i = 0; i< n; i++)out[ind+i] = ni();
        return out;
    }

    long[] la(int ind, int n){
        long[] out = new long[ind+n];
        for(int i = 0; i< n; i++)out[ind+i] = nl();
        return out;
    }

    double[] da(int ind, int n){
        double[] out = new double[ind+n];
        for(int i = 0; i< n; i++)out[ind+i] = nd();
        return out;
    }

    long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
    int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
    int bitcount(long n){return (n==0)?0:(1+bitcount(n&(n-1)));}
    void p(Object o){out.print(o);}
    void pn(Object o){out.println(o);}
    void pni(Object o){out.println(o);out.flush();}
    String n(){return in.next();}
    String nln(){return in.nextLine();}
    int ni(){return Integer.parseInt(in.next());}
    long nl(){return Long.parseLong(in.next());}
    double nd(){return Double.parseDouble(in.next());}

    class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception{
            br = new BufferedReader(new FileReader(s));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }   
            return str;
        }
    }
}      