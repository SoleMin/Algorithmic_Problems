import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class _P023A{
    Scanner sc=new Scanner(System.in);

    int INF=1<<28;
    double EPS=1e-9;

    String s;

    void run(){
        s=sc.nextLine();
        solve();
    }

    void solve(){
        int n=s.length();
        int max=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=0; j+k<n; k++){
                    if(s.charAt(i+k)!=s.charAt(j+k)){
                        break;
                    }else{
                        max=max(max, k+1);
                    }
                }
            }
        }
        println(max+"");
    }

    void println(String s){
        System.out.println(s);
    }

    void print(String s){
        System.out.print(s);
    }

    void debug(Object... os){
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        new _P023A().run();
    }
}
