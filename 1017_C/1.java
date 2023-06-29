import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main
{
    public static void process(int test_number)throws IOException
    {
        int n = ni(), groupSize = 1, minSecretVal = 2 * n;

        for(int i = 1; i <= n; i++){
            int incr = i, decr = n / i + (n % i != 0 ? 1 : 0); 
            if(minSecretVal > (incr + decr)){
                minSecretVal = incr + decr;
                groupSize = i;
            }
        }


        Queue<Integer> q = new LinkedList<>();
        for(int i = n; i >= 1; i--)
            q.add(i);

        int initial = n % groupSize; 
        ArrayList<Integer> li = new ArrayList<>();
        for(int i = 1; i <= initial; i++){
            int x = q.poll();
            li.add(x);
        }

        Collections.sort(li);
        for(int y : li)
            p(y + " ");
        li.clear();
        
        while(!q.isEmpty()){
            for(int i = 1; i <= groupSize; i++){
                int x = q.poll();
                li.add(x);
            }

            Collections.sort(li);
            for(int y : li)
                p(y + " ");
            li.clear();
        }

        p('\n');
    }
 
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
