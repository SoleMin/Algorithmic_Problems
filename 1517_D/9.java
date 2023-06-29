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
            int n=Int(),m=Int(),k=Int();
            List<int[]>g[]=new ArrayList[n*m+1];
            for(int i=0;i<g.length;i++){
                g[i]=new ArrayList<>();
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m-1;j++){
                    int w=Int();
                    int u=i*m+j;
                    int v=i*m+(j+1);
                    g[u].add(new int[]{v,w});
                    g[v].add(new int[]{u,w});
                }
            }

            for(int i=0;i<n-1;i++){
                for(int j=0;j<m;j++){
                    int w=Int();
                    int u=i*m+j;
                    int v=(i+1)*m+j;
                    g[u].add(new int[]{v,w});
                    g[v].add(new int[]{u,w});
                }
            }

            Solution sol=new Solution(out);
            sol.solution(n,m,k,g);
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




    List<int[]>g[];
    int n,m;
    long INF=10000000000000000l;
    int curr=-1,curc=-1;
    long mn=Long.MAX_VALUE;
    long dp[][];
    public void solution(int n,int m,int k,List<int[]>g[]){
        //edge : 4 directions.
        this.n=n;
        this.m=m;
        long res[][]=new long[n][m];
        if(k%2==1){
            for(int i=0;i<n;i++){
                Arrays.fill(res[i],-1);
            }
            print(res);
            return;
        }
        this.g=g;
        dp=new long[n*m+1][k/2+2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int id=i*m+j;
                dfs(id,k/2);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int id=i*m+j;
                res[i][j]=dp[id][k/2];
            }
        }
        print(res);
    }

    public long dfs(int id,int cnt){
        if(cnt==0){
            return 0;
        }
        if(dp[id][cnt]!=-1)return dp[id][cnt];

        int r=id/m;
        int c=id%m;
        long res=Long.MAX_VALUE;
        for(int p[]:g[id]){
            int next=p[0],w=p[1];
            res=Math.min(res,w*2+dfs(next,cnt-1));
        }
        dp[id][cnt]=res;
        return res;

    }

    public int dis(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }


    public void print(long A[][]){
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                out.print(A[i][j]+" ");
            }
            out.println();
        }
    }






}

class Solution1{
    PrintWriter out;
    public Solution1(PrintWriter out){
        this.out=out;
    }

    public void solution(int A[]){

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


