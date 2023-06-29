// Don't place your source in a package
import javax.swing.*;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.util.stream.Stream;


// Please name your class Main
public class Main {
    static FastScanner fs=new FastScanner();
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        public String next() {
            while (!st.hasMoreElements())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
        int Int() {
            return Integer.parseInt(next());
        }

        long Long() {
            return Long.parseLong(next());
        }

        String Str(){
            return next();
        }
    }


    public static void main (String[] args) throws java.lang.Exception {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T=1;
        for(int t=0;t<T;t++){
            int n=Int();
            int k=Int();
            int A[][]=new int[n][2];
            for(int i=0;i<A.length;i++){
                A[i][0]=Int();
                A[i][1]=Int()-1;
            }
            Arrays.sort(A,(a,b)->{
                return a[1]-b[1];
            });

            Solution sol=new Solution(out);
            sol.solution(A,k);
        }
        out.close();

    }


    public static int Int(){
        return fs.Int();
    }
    public static long Long(){
        return fs.Long();
    }
    public static String Str(){
        return fs.Str();
    }

}






class Solution{
    PrintWriter out;
    public Solution(PrintWriter out){
        this.out=out;
    }



    int mod=1000000007;
    long dp3[][][][];
    public void solution(int A[][],int T){
        long res=0;
        int n=A.length;
        long dp1[][]=new long[n+1][T+1];//a
        long dp2[][][]=new long[n+1][n+1][T+1];//bc
        dp3=new long[n+1][n+1][n+1][3];

        //init
        long f[]=new long[n+1];
        f[0]=f[1]=1;
        for(int i=2;i<f.length;i++){
            f[i]=f[i-1]*i;
            f[i]%=mod;
        }

        for(int i=0;i<dp3.length;i++){
            for(int j=0;j<dp3[0].length;j++){
                for(int k=0;k<dp3[0][0].length;k++){
                    Arrays.fill(dp3[i][j][k],-1);
                }
            }
        }


        dp1[0][0]=1;
        for(int i=0;i<A.length;i++){//a
            int p=A[i][0],type=A[i][1];
            if(type==0){
                long newdp[][]=new long[dp1.length][dp1[0].length];
                for(int cnt=1;cnt<=n;cnt++){
                    for(int j=1;j<dp1[0].length;j++){
                        if(j>=p){
                            newdp[cnt][j]+=dp1[cnt-1][j-p];
                            newdp[cnt][j]%=mod;
                        }
                    }
                }

                for(int cnt=0;cnt<=n;cnt++){
                    for(int j=0;j<dp1[0].length;j++){
                        newdp[cnt][j]+=dp1[cnt][j];
                        newdp[cnt][j]%=mod;
                    }
                }
                dp1=newdp;

            }
            else{
                break;
            }
        }





        dp2[0][0][0]=1;
        for(int i=0;i<A.length;i++){//b c
            int p=A[i][0],type=A[i][1];
            if(type!=0){
                long newdp[][][]=new long[dp2.length][dp2[0].length][dp2[0][0].length];
                for(int a=0;a<dp2.length;a++){
                    for(int b=0;b<dp2[0].length;b++){
                        for(int j=0;j<dp2[0][0].length;j++){
                            if(j>=p){
                                if(type==1){
                                    if(a-1>=0){
                                        newdp[a][b][j]+=dp2[a-1][b][j-p];
                                    }
                                }
                                else{
                                    if(b-1>=0) {
                                        newdp[a][b][j]+=dp2[a][b-1][j-p];
                                    }
                                }
                            }
                            newdp[a][b][j]%=mod;
                        }
                    }
                }

                for(int a=0;a<dp2.length;a++){
                    for(int b=0;b<dp2[0].length;b++){
                        for(int j=0;j<dp2[0][0].length;j++){
                            newdp[a][b][j]+=dp2[a][b][j];
                            newdp[a][b][j]%=mod;
                        }
                    }
                }
                dp2=newdp;
            }
        }


        dp3[1][0][0][0]=1;
        dp3[0][1][0][1]=1;
        dp3[0][0][1][2]=1;
        dfs(n,n,n,0);dfs(n,n,n,1);dfs(n,n,n,2);








        for(int i=0;i<dp3.length;i++){
            for(int j=0;j<dp3[0].length;j++){
                for(int k=0;k<dp3[0][0].length;k++){
                    for(int cur=0;cur<3;cur++){
                        for(int t=0;t<=T;t++){//price
                            int aprice=t;
                            int bcprice=T-t;
                            long cnt1=dp1[i][aprice];
                            long cnt2=dp2[j][k][bcprice];
                            long combination=dp3[i][j][k][cur];
                            long p1=(cnt1*f[i])%mod;
                            long p2=(((f[j]*f[k])%mod)*cnt2)%mod;
                            long p3=(p1*p2)%mod;
                            res+=(p3*combination)%mod;
                            res%=mod;

                        }
                    }
                }
            }
        }

        /*System.out.println(dp3[1][0][0][0]+"  "+dp2[0][0][0]);

        for(long p[]:dp1){
            System.out.println(Arrays.toString(p));
        }*/



        out.println(res);

    }

    public long dfs(int a,int b,int c,int cur){
        if(a<0||b<0||c<0){
            return 0;
        }
        if(a==0&&b==0&&c==0){
            return 0;
        }

        if(dp3[a][b][c][cur]!=-1)return dp3[a][b][c][cur];

        long res=0;
        if(cur==0){
            res+=dfs(a-1,b,c,1);
            res%=mod;
            res+=dfs(a-1,b,c,2);
            res%=mod;

        }
        else if(cur==1){
            res+=dfs(a,b-1,c,0);
            res%=mod;
            res+=dfs(a,b-1,c,2);
            res%=mod;
        }
        else{
            res+=dfs(a,b,c-1,0);
            res%=mod;
            res+=dfs(a,b,c-1,1);
            res%=mod;
        }
        res%=mod;
        dp3[a][b][c][cur]=res;
        return res;
    }

}












/*
                             ;\
                            |' \
         _                  ; : ;
        / `-.              /: : |
       |  ,-.`-.          ,': : |
       \  :  `. `.       ,'-. : |
        \ ;    ;  `-.__,'    `-.|
         \ ;   ;  :::  ,::'`:.  `.
          \ `-. :  `    :.    `.  \
           \   \    ,   ;   ,:    (\
            \   :., :.    ,'o)): ` `-.
           ,/,' ;' ,::"'`.`---'   `.  `-._
         ,/  :  ; '"      `;'          ,--`.
        ;/   :; ;             ,:'     (   ,:)
          ,.,:.    ; ,:.,  ,-._ `.     \""'/
          '::'     `:'`  ,'(  \`._____.-'"'
             ;,   ;  `.  `. `._`-.  \\
             ;:.  ;:       `-._`-.\  \`.
              '`:. :        |' `. `\  ) \
      -hrr-      ` ;:       |    `--\__,'
                   '`      ,'
                        ,-'


                      free bug dog
*/


