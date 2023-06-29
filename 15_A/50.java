import java.util.*;
import java.io.*;

/**
 * Created by HREN_VAM.
 */

public class A implements Runnable{

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;
    public static final String filename = "a";

    class I implements Comparable<I>{

        int x;
        int a;

        I(int x, int a){
            this.x = x;
            this.a = a;
        }

        public int compareTo(I o){
            return Double.compare(x, o.x);
        }
    }

    public void solve() throws IOException{
        int n = nextInt();
        int t = nextInt();

        I[] a = new I[n];

        for(int i = 0;i < n;i ++){
            a[i] = new I(nextInt(), nextInt());
        }

        int res = 2;

        Arrays.sort(a);
        for(int i = 1;i < n;i ++){
            if((a[i].x - a[i - 1].x - 1.0 * (a[i].a + a[i - 1].a) / 2) >= t)res ++;
            if((a[i].x - a[i - 1].x - 1.0 * (a[i].a + a[i - 1].a) / 2) > t)res ++;
        }
        out.println(res);
    }

    public void run(){
        try{
            Locale.setDefault(Locale.US);
            in = new BufferedReader(new InputStreamReader(System.in));
            //in = new BufferedReader(new FileReader(filename + ".in"));
            out = new PrintWriter(System.out);
            //out = new PrintWriter(new FileWriter(filename + ".out"));
            st = new StringTokenizer("");
            solve();
            out.close();
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        new Thread(new A()).start();
    }

    public String nextToken() throws IOException{
        while(!st.hasMoreTokens()){
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException{
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException{
        return Double.parseDouble(nextToken());
    }
}