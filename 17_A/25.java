import java.util.*;
import java.io.*;

/**
 * Created by HREN_VAM.
 */

public class A implements Runnable{

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;
    public static final String filename = "";

    public void solve() throws IOException{

        int n = nextInt();

        int[] a = new int[n + 1];
        ArrayList<Integer> pr = new ArrayList<Integer>();
        
        for(int i = 2;i < n + 1;i ++){
            if(a[i] != 0)continue;
            pr.add(i);
            for(int j = 2 * i;j < n + 1;j += i){
                a[j] = 1;
            }
        }

        int k = nextInt();
        for(int i = 2;i < n + 1;i ++){
            if(a[i] != 0)continue;
            for(int j = 1;j < pr.size();j ++){
                if(i == pr.get(j) + pr.get(j - 1) + 1){
                    k --;
                    break;
                }
            }
        }
        if(k > 0){
            out.println("NO");
            return;
        }
        out.println("YES");
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