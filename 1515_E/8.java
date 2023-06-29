import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {new Main().run();}

    FastReader in = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
    void run(){
        work();
        out.flush();
    }
    long mod=998244353;
    long gcd(long a,long b) {
        return a==0?b:gcd(b%a,a);
    }

    void work() {
        int n=ni();
        mod=nl();
        long[] dp1=new long[401];
        long[][] dp2=new long[n+1][n+1];
        long[][] C=new long[401][401];
        for(int j=0;j<=400;j++){
            for(int i=0;i<=j;i++){
                if(i==0||j==i){
                    C[i][j]=1;
                }else{
                    C[i][j]=(C[i-1][j-1]+C[i][j-1])%mod;
                }
            }
        }
        for(int i=1;i<=400;i++){
            for(int j=0;j<i;j++){
                dp1[i]=(dp1[i]+C[j][i-1])%mod;
            }
        }
        for(int i=1;i<=n;i++){
            dp2[i][i]=dp1[i];
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                for(int k=1;k<j;k++){
                    dp2[i][j]=dp2[i][j]+((((dp2[i-k-1][j-k]*dp1[k])%mod)*C[k][j])%mod);
                    dp2[i][j]%=mod;
                }
            }
        }
        long ret=0;
        for(int j=1;j<=n;j++){
            ret=(ret+dp2[n][j])%mod;
        }
        out.println(ret);
    }


    private ArrayList<long[]>[] ngw(int n, int m) {
        ArrayList<long[]>[] graph=(ArrayList<long[]>[])new ArrayList[n];
        for(int i=0;i<n;i++) {
            graph[i]=new ArrayList<>();
        }
        for(int i=1;i<=m;i++) {
            long s=in.nextLong()-1,e=in.nextLong()-1,w=in.nextLong();
            graph[(int)s].add(new long[] {e,w});
            graph[(int)e].add(new long[] {s,w});
        }
        return graph;
    }

    private int ni() {
        return in.nextInt();
    }

    private long nl() {
        return in.nextLong();
    }

    private String ns() {
        return in.next();
    }

    private long[] na(int n) {
        long[] A=new long[n];
        for(int i=0;i<n;i++) {
            A[i]=in.nextLong();
        }
        return A;
    }
    private int[] nia(int n) {
        int[] A=new int[n];
        for(int i=0;i<n;i++) {
            A[i]=in.nextInt();
        }
        return A;
    }
}

class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br=new BufferedReader(new InputStreamReader(System.in));
    }


    public String next()
    {
        while(st==null || !st.hasMoreElements())//回车，空行情况
        {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt()
    {
        return Integer.parseInt(next());
    }

    public long nextLong()
    {
        return Long.parseLong(next());
    }
}