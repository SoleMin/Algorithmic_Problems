import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;
    
        
    void solve() throws IOException {
        int n=ni();//have bult yet
        int t=ni();//new house
        
        int[] center=new int[n];
        int[] width=new int[n];
        for(int i=0;i<n;i++){
            center[i]=ni();
            width[i]=ni();
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(center[i]>center[j]){
                    int cent=center[i];
                    int wid=width[i];
                    center[i]=center[j];
                    width[i]=width[j];
                    center[j]=cent;
                    width[j]=wid;
                }
            }
        }
        int count=2;
        for(int i=0;i<n-1;i++){
            //min way
            double ideal=(double)width[i]/2+(double)width[i+1]/2+t;

            //real way
            double real=center[i+1]-center[i];
            //out.println(ideal);
            //out.println(real);
            if(ideal==real)count++;
            else{
                if(ideal<real)count=count+2;
            }
        }
        out.println(count);
        
    }
    
    public Main() throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }

    String ns() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    int ni() throws IOException {
        return Integer.valueOf(ns());
    }

    long nl() throws IOException {
        return Long.valueOf(ns());
    }

    double nd() throws IOException {
        return Double.valueOf(ns());
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}