import java.io.*;

import java.awt.geom.Point2D;
import java.text.*;
import java.math.*;
import java.util.*;

public class Main implements Runnable {
    
    final String filename="";
    
    public void solve() throws Exception {
        int n = iread(), k = iread();
        boolean[] f = new boolean[10000];
        int prev = -1;
        cycle:for (int i=2; i<=n; i++)
        {
            for (int j=2; j*j<=i; j++)
                if (i%j==0)
                    continue cycle;
            if (prev!=-1)
                f[i+prev+1] = true;
            if (f[i])
                k--;
            prev = i;
        }
        if (k<=0)
            out.write("YES\n");
        else out.write("NO\n");
    }
    
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new BufferedWriter(new OutputStreamWriter(System.out));
//          in = new BufferedReader(new FileReader(filename+".in"));
//          out = new BufferedWriter(new FileWriter(filename+".out"));
            solve();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public int iread() throws Exception {
        return Integer.parseInt(readword());
    }

    public double dread() throws Exception {
        return Double.parseDouble(readword());
    }

    public long lread() throws Exception {
        return Long.parseLong(readword());
    }

    BufferedReader in;

    BufferedWriter out;

    public String readword() throws IOException {
        StringBuilder b = new StringBuilder();
        int c;
        c = in.read();
        while (c >= 0 && c <= ' ')
            c = in.read();
        if (c < 0)
            return "";
        while (c > ' ') {
            b.append((char) c);
            c = in.read();
        }
        return b.toString();
    }
    public static void main(String[] args) {
        try{
            Locale.setDefault(Locale.US);
        } catch (Exception e)
        {
            
        }
        new Thread(new Main()).start();
        //new Thread(null, new Main(), "1", 1<<25).start();
    }
}