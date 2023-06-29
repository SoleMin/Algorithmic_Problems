import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

public class Main
{
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            } catch (Exception e){
                e.printStackTrace();
            }
            return str;
        }
        int[] ra(int n){
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = nextInt();
            }
            return a;
        }
        long[] rla(int n){
            long[] a = new long[n];
            for(int i = 0; i < n; i++){
                a[i] = nextLong();
            }
            return a;
        }
        double[] rda(int n){
            double[] a = new double[n];
            for(int i = 0; i < n; i++){
                a[i] = nextDouble();
            }
            return a;
        }
    }
    static int modPower(int x, int y, int mod){
        int res = 1;
        x %= mod;
        if(x==0) return 0;
        while(y>0){
            if(y%2==1){
                res = (res*x)%mod;
            }
            y = y>>1;
            x = (x*x)%mod;
        }
        return res;
    }
    static class pair<T1, T2>{
        T1 first;
        T2 second;
        pair(T1 first, T2 second){
            this.first = first;
            this.second = second;
        }
    }

    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        FastReader in = new FastReader();
        int n = in.nextInt();
        Map<Double,Integer> m=new HashMap<>();
        double[] a = new double[n];
        for(int i=0;i<n;i++){
          String[] s=in.next().split("/");
          s[0]=s[0].substring(1,s[0].length()-1);
          String[] b=s[0].split("\\+");
          double x=Double.parseDouble(b[0]),
          y=Double.parseDouble(b[1]),
          z=Double.parseDouble(s[1]);
          a[i]=(x+y)/z;
          if(!m.containsKey(a[i]))m.put(a[i],0);
          m.replace(a[i],m.get(a[i])+1);
        }
        for(double d:a){
          System.out.print(m.get(d)+" ");
        }
    }
}