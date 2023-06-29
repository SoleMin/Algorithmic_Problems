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
            int n=Int(),k=Int();
            int A[][]=new int[n][2];
            for(int i=0;i<n;i++){
                A[i][0]=Int();
                A[i][1]=Int();
            }

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



    long dp[][];
    int mod=1000000007;
    int time;
    public void solution(int A[][],int t){
        this.time=t;
        dp=new long[4][1<<A.length+2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        long a=dfs(A,0,(1<<A.length)-1);
        out.println(a);
    }

    public long dfs(int A[][],int pre,int state){
        int use=cal(A,state);
        if(time-use==0){
            return 1;
        }
        if(time<use||state==0){
            return 0;
        }

        if(dp[pre][state]!=-1)return dp[pre][state];

        long res=0;

        for(int i=0;i<A.length;i++){
            if(((state&(1<<i))!=0)&&A[i][1]!=pre){
                res+=dfs(A,A[i][1],(state^(1<<i)));
                res%=mod;
            }
        }

        dp[pre][state]=res;
        return res;
    }

    public int cal(int A[][],int state){
        int t=0;
        for(int i=0;i<A.length;i++){
            if((state&(1<<i))==0){
                t+=A[i][0];
            }
        }
        return t;
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


