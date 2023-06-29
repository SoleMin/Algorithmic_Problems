import java.io.*;
import java.util.*;
import java.math.*;

public class Main2 {
    public static void main(String[] args) throws Exception {
        new Main2().run();
    }

    public void solve() throws Exception {
        n = nextInt();
        int a[]= new int[n], pos = 1;
        for(int i=0; i<n; i++)
            a[i] = nextInt();
        Arrays.sort(a);
        if(n == 1){
            out.println("NO"); return;
        }
        boolean has = false;
        for(; pos<n; pos++){
            if(a[pos] != a[0]){
                has = true;
                break;
            }
        }
        if(!has){
            out.println("NO");
        }
        else{
            out.println(a[pos]);
        }
    }
    public int n, m;

    public void run() throws Exception {
        inter = new StreamTokenizer(new BufferedReader(new InputStreamReader(
                System.in)));
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }
    public BufferedReader in;
    public StreamTokenizer inter;
    public PrintWriter out;

    public int nextInt() throws Exception {
        inter.nextToken();
        return (int) inter.nval;
    }
    public String nextLine() throws Exception{
        return in.readLine();
    }
}
