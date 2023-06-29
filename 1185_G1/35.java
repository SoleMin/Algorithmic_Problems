import java.util.*;
import java.io.*;
import java.text.*;
public class Main{
    //SOLUTION BEGIN
    //Into the Hardware Mode
    void pre() throws Exception{}
    int n, t;
    void solve(int TC) throws Exception{
        n = ni();t = ni();
        int[][] song = new int[n][];
        for(int i = 0; i< n; i++)song[i] = new int[]{ni(), ni()-1};
        long[][] dp = new long[1<<n][3];
        for(int i = 0; i< dp.length; i++)
            for(int j = 0; j< dp[i].length; j++)
                dp[i][j] = -1;
        pn(start(dp, song, 0, -1));
    }
    long start(long[][] dp, int[][] song, int mask, int prev){
        long ti = 0;
        for(int i = 0; i< n; i++){
            if(((mask>>i)&1)==1)ti+=song[i][0];
        }
        if(ti==t)return 1;
        if(prev != -1 && dp[mask][prev] != -1)return dp[mask][prev];
        long ans = 0;
        for(int i = 0; i< n; i++){
            if(((mask>>i)&1)==0 && song[i][1] != prev && ti+song[i][0] <= t)
                ans = (ans+start(dp, song, mask|(1<<i), song[i][1]))%mod;
        }
        if(prev!= -1)dp[mask][prev] = ans;
        return ans;
    }
    //SOLUTION END
    void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
    long mod = (long)1e9+7, IINF = (long)1e18;
    final int INF = (int)1e9, MX = (int)2e5+5;
    DecimalFormat df = new DecimalFormat("0.00000000000");
    double PI = 3.141592653589793238462643383279502884197169399, eps = 1e-8;
    static boolean multipleTC = false, memory = false;
    FastReader in;PrintWriter out;
    void run() throws Exception{
        in = new FastReader();
        out = new PrintWriter(System.out);
        //Solution Credits: Taranpreet Singh
        int T = (multipleTC)?ni():1;
        pre();for(int t = 1; t<= T; t++)solve(t);
        out.flush();
        out.close();
    }
    public static void main(String[] args) throws Exception{
        if(memory)new Thread(null, new Runnable() {public void run(){try{new Main().run();}catch(Exception e){e.printStackTrace();}}}, "1", 1 << 28).start();
        else new Main().run();
    }
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