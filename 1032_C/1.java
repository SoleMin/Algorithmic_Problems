import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main
{
    static boolean feasible(int f1, int i, int f2, int j){
        if(arr[i] == arr[j])
            return f1 != f2;

        if(arr[i] < arr[j])
            return f1 < f2;

        return f1 > f2;
    }

    static int dfs(int prev, int idx){
        if(idx == n + 1)
            return 1;

        if(dp[idx][prev] != -1)
            return dp[idx][prev];

        for(int i = 1; i <= 5; i++){
            if(feasible(i, idx, prev, idx - 1)){
                int flag = dfs(i, idx + 1);
                if(flag == 1){
                    li.add(i);
                    return dp[idx][prev] = 1;
                }
            }
        }

        return dp[idx][prev] = 0;
    }

    public static void process(int test_number)throws IOException
    {
        n = ni();
        arr = new int[n + 1];
        dp = new int[n + 1][6]; for(int row[] : dp) Arrays.fill(row, -1);
        for(int i = 1; i <= n; i++)
            arr[i] = ni();

        int flag = dfs(0, 1);
        if(flag == 1){
            for(int i =li.size() - 1; i >= 0; i--)
                p(li.get(i) + " ");
            p("\n");
        }else{
            pn("-1");
        }
    }
    
    static int dp[][], arr[], n;
    static ArrayList<Integer> li = new ArrayList<>();
    static final long mod = (long)1e9+7l;
    static boolean DEBUG = true;
    static FastReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc = new FastReader();
 
        long s = System.currentTimeMillis();
        int t = 1;
        // t = ni();
        for(int i = 1; i <= t; i++)
            process(i);
 
        out.flush();
        System.err.println(System.currentTimeMillis()-s+"ms");
    }

    static void trace(Object... o){ if(!DEBUG) return; System.err.println(Arrays.deepToString(o)); };    
    static void pn(Object o){ out.println(o); }
    static void p(Object o){ out.print(o); }
    static int ni()throws IOException{ return Integer.parseInt(sc.next()); }
    static long nl()throws IOException{ return Long.parseLong(sc.next()); }
    static double nd()throws IOException{ return Double.parseDouble(sc.next()); }
    static String nln()throws IOException{ return sc.nextLine(); }
    static long gcd(long a, long b){ return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b){ return (b==0)?a:gcd(b,a%b); }
    
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
    } 
}
