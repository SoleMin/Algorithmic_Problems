//package math_codet;

import java.io.*;
import java.util.*;
 /******************************************
*    AUTHOR:         AMAN KUMAR SINGH        *
*    INSTITUITION:   KALYANI GOVERNMENT ENGINEERING COLLEGE  *
******************************************/
public class lets_do {
    InputReader in;
    PrintWriter out;
    Helper_class h;
    final long mod=1000000007;
    public static void main(String[] args) throws java.lang.Exception{
        new lets_do().run();
    }
    void run() throws Exception{
        in=new InputReader();
        out = new PrintWriter(System.out);
        h = new Helper_class();
        int t=1;
        while(t-->0)
            solve();
        out.flush();    
        out.close();
    }
    long[] arr;
    int n;
    HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();
    HashSet<Integer> hset=new HashSet<Integer>();
    void solve(){
        n=h.ni();
        long d=h.nl();
        int i=0;
        arr=new long[n];
        for(i=0;i<n;i++)
            arr[i]=h.nl();
        int count=2;
        for(i=0;i<n-1;i++){
            if(Math.abs(arr[i]-arr[i+1])>(2*d))
                count+=2;
            else if(Math.abs(arr[i]-arr[i+1])==(2*d))
                count+=1;
        }
        h.pn(count);
    }
    class Helper_class{
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

        long mul(long a,long b){
            if(a>=mod)a%=mod;
            if(b>=mod)b%=mod;
            a*=b;
            if(a>=mod)a%=mod;
            return a;
        }
        long modPow(long a, long p){
            long o = 1;
            while(p>0){
                if((p&1)==1)o = mul(o,a);
                a = mul(a,a);
                p>>=1;
            }
            return o;
        }
        long add(long a, long b){
            if(a>=mod)a%=mod;
            if(b>=mod)b%=mod;
            if(b<0)b+=mod;
            a+=b;
            if(a>=mod)a-=mod;
            return a;
        }
    }

    class InputReader{
        BufferedReader br;
        StringTokenizer st;
        public InputReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        public InputReader(String s) throws Exception{
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