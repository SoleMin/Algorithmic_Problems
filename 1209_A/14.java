import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    void solve() {
       int n=ni();
       int a[]=new int[n+1];
       for(int i=1;i<=n;i++) a[i]=ni();
       int vis[]=new int[101];
       int ans=0;
       Arrays.sort(a,1,n+1);
       for(int i=1;i<=n;i++){
           if(vis[a[i]]==1) continue;
           ans++;
           for(int j=a[i];j<=100;j+=a[i]) vis[j]=1;
       }
       pw.println(ans);
    }

    long M = (long)1e9+7;
    // END
    PrintWriter pw;
    StringTokenizer st;
    BufferedReader br;

    void run() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        pw.flush();
    }
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    String ns() {
        while (st == null || !st.hasMoreElements()) {

            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    String nextLine() throws Exception {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            throw new Exception(e.toString());
        }
        return str;
    }

    int ni() {
        return Integer.parseInt(ns());
    }

    long nl() {
        return Long.parseLong(ns());
    }

    double nd() {
        return Double.parseDouble(ns());
    }
}