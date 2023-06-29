import java.io.*;
import java.util.*;

public class Main {
    StreamTokenizer in;
    BufferedReader inb;
    PrintWriter out;

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(
                System.in)));
        inb = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }

    public int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public int parseInt() throws Exception {
        return Integer.parseInt(inb.readLine());
    }

    public String nextLine() throws Exception {
        return inb.readLine();
    }

    
    public void solve() throws Exception {
        int n = nextInt();
        if ((n%4==0)||(n%44==0)||(n%47==0)||(n%74==0)
                ||(n%744==0)||(n%747==0)||(n%774==0)||(n%777==0)
                ||(n%7==0)||(n%444==0)||(n%447==0)||(n%474==0)||(n%477==0)||(n%77==0))
        {
            out.print("YES");
        }
        else
        {
            out.print("NO");
        }
    }

}
