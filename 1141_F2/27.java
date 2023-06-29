import java.util.*;
import java.io.*;
import java.text.*;
//Solution Credits: Taranpreet Singh
public class Main{
    //SOLUTION BEGIN
    //Code not meant for understanding, proceed with caution
    void pre() throws Exception{}
    void solve(int TC) throws Exception{
        int n = ni();
        int[] a = new int[n];
        for(int i = 0; i< n; i++)a[i] = ni();
        HashMap<Long, ArrayList<int[]>> map = new HashMap<>();
        for(int i = 0; i< n; i++){
            long sum = 0;
            for(int j = i; j< n; j++){
                sum+=a[j];
                if(!map.containsKey(sum))map.put(sum, new ArrayList<>());
                map.get(sum).add(new int[]{i+1, j+1});
            }
        }
        int[][] ans = new int[n][];int cur = 0;
        int[][] tmp = new int[n][];int tc;
        for(Map.Entry<Long, ArrayList<int[]>> e: map.entrySet()){
            int prev = 0;
            ArrayList<int[]> li = e.getValue();
            Collections.sort(li, new Comparator<int[]>(){
                public int compare(int[] i1, int[] i2){
                    if(i1[1]!=i2[1])return Integer.compare(i1[1], i2[1]);
                    return Integer.compare(i1[0], i1[0]);
                }
            });
                tc = 0;
            for(int[] p:li){
                if(p[0]>prev){
                    tmp[tc++] = new int[]{p[0],p[1]};
                    prev = p[1];
                }
            }
            if(tc>cur){
                cur = tc;
                for(int i = 0; i< tc; i++)ans[i] = new int[]{tmp[i][0], tmp[i][1]};
            }
        }
        pn(cur);
        for(int i = 0; i< cur; i++)pn(ans[i][0]+" "+ans[i][1]);
    }
    //SOLUTION END
    void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
    long mod = (long)1e9+7, IINF = (long)1e18;
    final int INF = (int)1e9, MX = (int)2e3+1;
    DecimalFormat df = new DecimalFormat("0.00000000000");
    double PI = 3.1415926535897932384626433832792884197169399375105820974944, eps = 1e-8;
    static boolean multipleTC = false, memory = false;
    FastReader in;PrintWriter out;
    void run() throws Exception{
        in = new FastReader();
        out = new PrintWriter(System.out);
        int T = (multipleTC)?ni():1;
        //Solution Credits: Taranpreet Singh
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