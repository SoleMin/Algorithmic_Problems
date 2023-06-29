import java.util.*;
import java.io.*;
import java.text.*;
public class Main{
    //SOLUTION BEGIN
    //Into the Hardware Mode
    void pre() throws Exception{}
    void solve(int TC)throws Exception{
        int n = ni(), m = ni();
        long[][] a = new long[n][m];
        long[] col = new long[m];
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                a[i][j] = nl();
                col[j] = Math.max(a[i][j], col[j]);
            }
        }
        Integer[] p = new Integer[m];
        for(int i = 0; i< m; i++)p[i] = i;
        Arrays.sort(p, (Integer i1, Integer i2) -> Long.compare(col[i2], col[i1]));
        long[][] mat = new long[n][Math.min(m, 6)];
        for(int i = 0; i< Math.min(m, 6); i++){
            for(int j = 0; j< n; j++)mat[j][i] = a[j][p[i]];
        }
        long pow = 1;
        for(int i = 0; i< Math.min(m, 6); i++)pow *= n;
        int[] sh = new int[Math.min(m, 6)];
        long ans = 0;
        for(int i = 0; i< pow; i++){
            int x = i;
            for(int j = 0; j< Math.min(m, 6); j++){
                sh[j] = x%n;
                x/=n;
            }
            long cur = 0;
            for(int ro = 0; ro < n; ro++){
                long cR = 0;
                for(int j = 0; j < Math.min(m, 6); j++)cR = Math.max(cR, mat[(ro+sh[j])%n][j]);
                cur += cR;
            }
            ans = Math.max(ans, cur);
        }
        pn(ans);
    }
    //SOLUTION END
    void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
    void exit(boolean b){if(!b)System.exit(0);}
    long IINF = (long)1e18, mod = (long)1e9+7;
    final int INF = (int)1e9, MX = (int)2e6+5;
    DecimalFormat df = new DecimalFormat("0.00000000");
    double PI = 3.141592653589793238462643383279502884197169399, eps = 1e-6;
    static boolean multipleTC = true, memory = false, fileIO = false;
    FastReader in;PrintWriter out;
    void run() throws Exception{
        if(fileIO){
            in = new FastReader("input.txt");
            out = new PrintWriter("output.txt");
        }else {
            in = new FastReader();
            out = new PrintWriter(System.out);
        }
        //Solution Credits: Taranpreet Singh
        int T = (multipleTC)?ni():1;
        pre();
        for(int t = 1; t<= T; t++)solve(t);
        out.flush();
        out.close();
    }
    public static void main(String[] args) throws Exception{
        if(memory)new Thread(null, new Runnable() {public void run(){try{new Main().run();}catch(Exception e){e.printStackTrace();}}}, "1", 1 << 28).start();
        else new Main().run();
    }
    
    int digit(long s){int ans = 0;while(s>0){s/=10;ans++;}return ans;}
    long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
    int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
    int bit(long n){return (n==0)?0:(1+bit(n&(n-1)));}
    void p(Object o){out.print(o);}
    void pn(Object o){out.println(o);}
    void pni(Object o){out.println(o);out.flush();}
    String n()throws Exception{return in.next();}
    String nln()throws Exception{return in.nextLine();}
    int ni()throws Exception{return Integer.parseInt(in.next());}
    long nl()throws Exception{return Long.parseLong(in.next());}
    double nd()throws Exception{return Double.parseDouble(in.next());}
 
    class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        public FastReader(String s) throws Exception{
            br = new BufferedReader(new FileReader(s));
        }
 
        String next() throws Exception{
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }
 
        String nextLine() throws Exception{
            String str = "";
            try{   
                str = br.readLine();
            }catch (IOException e){
                throw new Exception(e.toString());
            }  
            return str;
        }
    }
}