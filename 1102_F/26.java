// Don't place your source in a package
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;








// Please name your class Main
public class Main {
    static FastScanner fs=new FastScanner();
    static class FastScanner {//scanner from SecondThread
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
        PrintWriter out = new PrintWriter(System.out);


        int T=1;
        for(int t=0;t<T;t++){
            int n=Int();int m=Int();
            int A[][]=new int[n][m];

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    A[i][j]=Int();
                }
            }

            Sol sol=new Sol();
            sol.solution(out,A);
        }
        out.flush();

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



class Sol{
    int dif[][];
    int dp[][][];
    public void solution(PrintWriter out,int A[][]){
        int n=A.length;int m=A[0].length;
        int res=0;
        dif=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<A.length;j++){
                int mn=Integer.MAX_VALUE;
                for(int k=0;k<m;k++){//different ordering pair
                    mn=Math.min(mn,Math.abs(A[i][k]-A[j][k]));
                }
                dif[i][j]=mn;
                dif[j][i]=mn;
                //System.out.println(i+"  "+j+"  "+mn);
            }
        }

        int state=(1<<n)-1;
        dp=new int[state+5][n+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        for(int i=0;i<n;i++){
            res=Math.max(res,dfs(A,state^(1<<i),i,i));
        }

        out.println(res);

    }

    public int dfs(int A[][],int state,int pre,int start){

        if(state==0){
            int mn=Integer.MAX_VALUE;
            for(int i=1;i<A[0].length;i++){
                mn=Math.min(mn,Math.abs(A[start][i]-A[pre][i-1]));
            }
            return mn;
        }



        if(dp[state][pre][start]!=-1){
            return dp[state][pre][start];
        }

        int res=0;
        for(int i=0;i<A.length;i++){
            if((state&(1<<i))!=0){
                int di=dif[pre][i];
                res=Math.max(res,Math.min(di,dfs(A,state^(1<<i),i,start)));
            }
        }


        //System.out.println(Integer.toBinaryString(state)+"  "+res);
        dp[state][pre][start]=res;
        return res;
    }








}






