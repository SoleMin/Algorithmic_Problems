import java.util.*;
import java.io.*;

public class Sockets {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;
    
    String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
    
    int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }
    
    void solve() throws Exception {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        List<Integer> fs = new ArrayList<Integer>();
        for (int i = 0; i < n; i++)
            fs.add(nextInt());
        Collections.sort(fs);
        Collections.reverse(fs);
        int c = k;
        for (int i = 0; i < fs.size(); i++) {
            if (c >= m) {
                out.println(i);
                return;
            }
            c += (fs.get(i)-1);
        }
        if (c>=m)
            out.println(fs.size());
        else
            out.println(-1);
    }
    
    void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
//            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter(System.out);
            solve();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            out.close();
        }
    }
    
    public static void main(String[] args) {
        new Sockets().run();
    }

}

