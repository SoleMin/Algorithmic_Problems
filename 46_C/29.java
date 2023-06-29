import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br=null;
    static PrintWriter pw=null;
    static StringTokenizer st=null;
    static String FILENAME="";
    
    void nline(){
        try {
            st=new StringTokenizer(br.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    int ni(){
        while(st==null || !st.hasMoreTokens()) nline();
        return Integer.parseInt(st.nextToken());
    }
    long nl(){
        while(st==null || !st.hasMoreTokens()) nline();
        return Long.parseLong(st.nextToken());
    }
    double nd(){
        while(st==null || !st.hasMoreTokens()) nline();
        return Double.parseDouble(st.nextToken());
    }
    String ns(){
        while(st==null || !st.hasMoreTokens()) nline();
        return st.nextToken();
    }
    String nstr(){
        String s="";
        try {
            s=br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return s;
    }

    public void solve(){
        int n = ni();
        String s = nstr();
        int[] a = new int[n];
        for (int i=0;i<n;i++)
            a[i]=s.charAt(i)=='H'?0:1;
        int hc = 0;
        for (int i=0;i<n;i++)
            if (a[i]==0) hc++;
        int min = 1000000;
        for (int ss=0;ss<n;ss++) {
            int rc = 0;
            for (int i=0;i<hc;i++)
                if (a[(i+ss)%n]==0) rc++;
            if (hc-rc<min) min=hc-rc;
        }
        pw.print(min);
    }
    public void run(){
        solve();
        pw.close();
    }
    public static void main(String[] args) {
            br = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(System.out);
        
        new Solution().run();
    }

}
