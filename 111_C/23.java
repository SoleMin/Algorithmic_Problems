import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class C{
    Scanner sc=new Scanner(System.in);

    int INF=1<<28;
    double EPS=1e-9;

    int n, m;

    void run(){
        n=sc.nextInt();
        m=sc.nextInt();
        solve();
    }

    void solve(){
        if(n<m){
            int t=n;
            n=m;
            m=t;
        }
        int full=(1<<m)-1;
        int[][] dp=new int[1<<m][1<<m];
        int[][] tmp=new int[1<<m][1<<m];
        for(int i=0; i<1<<m; i++){
            fill(dp[i], INF);
        }
        for(int i=0; i<1<<m; i++){
            int b1=(i|(i>>1)|(i<<1))&full;
            int b2=i;
            dp[b1][b2]=Integer.bitCount(i);
            debug(Integer.toBinaryString(b1), dp[b1]);
        }
        debug();
        for(int j=0; j<n-1; j++){
            for(int i=0; i<1<<m; i++){
                System.arraycopy(dp[i], 0, tmp[i], 0, 1<<m);
                fill(dp[i], INF);
            }

            for(int b1=0; b1<1<<m; b1++){
                for(int b2=0; b2<1<<m; b2++){
                    for(int i=0; i<1<<m; i++){
                        if((b1|i)!=full){
                            continue;
                        }
                        if(false)
                            debug(Integer.toBinaryString(b1),
                                    Integer.toBinaryString(b2),
                                    Integer.toBinaryString(i));
                        int b=(i|(i>>1)|(i<<1))&full;
                        dp[b2|b][i]=min(dp[b2|b][i],
                                tmp[b1][b2]+Integer.bitCount(i));
                    }
                }
            }
            debug(j);
            for(int i=0; i<1<<m; i++){
                debug(Integer.toBinaryString(i), dp[i]);
            }
        }

        int min=INF;
        for(int i=0; i<1<<m; i++){
            min=min(min, dp[full][i]);
        }
        debug(min);
        int ans=m*n-min;
        debug("ans",ans);
        println(ans+"");
    }

    void println(String s){
        System.out.println(s);
    }

    void print(String s){
        System.out.print(s);
    }

    void debug(Object... os){
        // System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args){
        new C().run();
    }
}
