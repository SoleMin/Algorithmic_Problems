import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;

public class Main {
    boolean[] b;
    int[] r;
    ArrayList<ArrayList<Integer>> q;

    public void dfs(int u, int p) {
        for (int i = 0; i < q.get(u).size(); i++) {
            int v = q.get(u).get(i);
            if (v != p) {
                r[v] = r[u] + 1;
                if (b[u]) {
                    b[v] = b[u];
                }
                dfs(v, u);
            }
        }
    }

    public void solve() throws IOException {
        long n = nextLong();
        long s = nextLong();
        long t = 0;
        if(s + 200 < n){
            t = n - s - 200;
        }
        for(long i = s; i <= Math.min(s + 200,n); i++){
            long p = 0;
            long u = i;
            while (u > 0){
                p += u % 10;
                u /= 10;
            }
            if(i - p >= s){
                t++;
            }
        }
        out.print(t);
    }

    BufferedReader br;
    StringTokenizer sc;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (sc == null || !sc.hasMoreTokens()) {
            try {
                sc = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                return null;
            }
        }
        return sc.nextToken();
    }

    public Integer nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public Long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception e) {
        }
        new Main().run();
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
//            br = new BufferedReader(new FileReader("lesson.in"));
//            out = new PrintWriter(new File("lesson.out"));
            solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}