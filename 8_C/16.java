import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;

public class C {
    static int[] dp;
    static int[] f;
    static void solve(){
        dp = new int[1<<n];
        f  = new int[1<<n];
        Arrays.fill(dp, 1<<29);
        dp[0] = 0;
        for(int i=0;i<(1<<n);i++){
//            out.println("i="+i);
            for(int j=0;j<n;j++){
                int ni = i | (1<<j);
                if( i != ni ){
//                    out.println("i="+i+",j="+j);
                    int v = d[j]*2 + dp[i];
                    if(v < dp[ni]){
//                        out.println("up:"+ni+" to "+v + " fw="+i);
                        dp[ni] = v;
                        f[ni] = i;
                    }

                    for(int k=j+1;k<n;k++){
                        int nni = ni | (1<<k);
                        if( ni != nni){
                            int vv = d[j] + t[j][k] + d[k] + dp[i];
                            if(vv < dp[nni]){
//                                out.println("up:"+nni+" to "+vv + " fw="+i);
                                dp[nni] = vv;
                                f[nni] = i;
                            }
                        }
                    }
                    break;
                }
            }
        }
        out.println(dp[dp.length-1]);
//        out.println("dp="+Arrays.toString(dp));
//        out.println("f="+Arrays.toString(f));

        int idx = dp.length - 1;
        out.print("0 ");
        while(idx != 0){
            int road = idx ^ f[idx];
//            out.println("idx = "+idx + " f[idx] = "+f[idx]);
            for(int i=0;i<n;i++) if( ((road>>i) & 1) == 1) out.print((i+1)+" ");
            idx = f[idx];
            out.print("0 ");
        }
        out.println();
    }
    static int[] d;
    static int[][] t;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        n = sc.nextInt();
        int[] dx = new int[n];
        int[] dy = new int[n];

        for(int i=0;i<n;i++){
            dx[i] = sc.nextInt();
            dy[i] = sc.nextInt();
        }

        d = new int[n];
        for(int i=0;i<n;i++){
            d[i] = (x-dx[i])*(x-dx[i]) + (y-dy[i])*(y-dy[i]);
        }

        t = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                t[i][j] = (dx[i]-dx[j])*(dx[i]-dx[j]) + (dy[i]-dy[j])*(dy[i]-dy[j]);
            }
        }
//        out.println(Arrays.toString(d));
//        out.println(Arrays.deepToString(t));

        solve();
    }
}
