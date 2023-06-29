import java.awt.*;
import java.io.*;
import java.sql.Array;
import java.util.*;
import java.util.List;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static final int N=405;
    static final int mod=1000000007;
    static final int INF=1000000009;
    static final int numBit=17;
    static FastReader r=new FastReader();
    static PrintWriter pw = new PrintWriter(System.out);

//    call dp[i][j] is number ways can turn on i computer but we just turn on j computer manually.
    static int [][]dp=new int[N][N];
    static int []p2=new int[N];
    static int []fac=new int[N];
    static int []ifac=new int[N];
    static int M;

    public static int mul(int a,int b){
        return (int)(1l*a*b%M);
    }

    public static int poww(int a,int b){
        int r=1;
        while(b>0){
            if(b%2==1) r=mul(r,a);
            a=mul(a,a);
            b>>=1;
        }
        return r;
    }

    public static int inv(int x){
        return poww(x,M-2);
    }

    public static int add(int a,int b){
        a+=b;
        if(a>=M) a-=M;
        return a;
    }

    public static int bino(int n,int k){
        return mul(fac[n],mul(ifac[n-k],ifac[k]));
    }

    public static void main(String[] args) throws IOException {
        int n=r.nextInt();
        M=r.nextInt();
        fac[0]=1;
        ifac[0]=1;
        p2[0]=1;
        for(int i=1;i<=n;++i){
            fac[i]=mul(fac[i-1],i);
            ifac[i]=inv(fac[i]);
            p2[i]=mul(p2[i-1],2);
        }
        int ans=0;
        dp[0][0]=1;
        for(int i=0;i<=n;++i){
            for(int k=0;k<=i;++k){
                for(int j=1;j<=n-i+1;++j){
                    dp[i+j+1][k+j]=add(dp[i+j+1][k+j],mul(dp[i][k],mul(p2[j-1],bino(j+k,j))));
                }
            }
        }
        for(int i=0;i<=n+1;++i){
            ans=add(ans,dp[n+1][i]);
        }
        pw.print(ans);
        pw.close();
    }
}
