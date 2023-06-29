import java.io.*;
import java.util.*;

public class Main {

    StreamTokenizer in;
    PrintWriter out;

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        in = new StreamTokenizer (new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }
    
    int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }


    public void solve() throws Exception {
        int n=nextInt();
        long ans=0;
        for (int i=0;i<n;i+=2)
            ans+=3;
        out.println(ans);
    }
}