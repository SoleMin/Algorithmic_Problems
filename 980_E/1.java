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
        //reading /writing file
        //Scanner sc=new Scanner(new File("src/text.txt"));
        //PrintWriter pr=new PrintWriter("output.txt");
        //File file = new File("src/text.txt");



        int T=1;
        for(int t=0;t<T;t++){
            int n=Int();
            int k=Int();
            int graph[][]=new int[n][];
            int edge[][]=new int[n-1][2];
            int cnt[]=new int[n];
            for(int i=0;i<n-1;i++){
                int u=Int()-1;int v=Int()-1;
                edge[i][0]=u;
                edge[i][1]=v;
                cnt[u]++;
                cnt[v]++;
            }

            for(int i=0;i<cnt.length;i++){
                graph[i]=new int[cnt[i]];
            }

            for(int pair[]:edge){
                int u=pair[0],v=pair[1];
                graph[u][--cnt[u]]=v;
                graph[v][--cnt[v]]=u;
            }
            Solution sol1=new Solution(out);
            sol1.solution(graph,n,k);
        }
        out.close();

    }


    public static int[] Arr(int n){
        int A[]=new int[n];
        for(int i=0;i<n;i++)A[i]=Int();
        return A;
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








class Solution {
    PrintWriter out;
    int INF = Integer.MAX_VALUE;
    int MOD = 1000000007;
    long mod = 1000000007;

    public Solution(PrintWriter out) {
        this.out = out;
    }

    boolean seen[];
    int graph[][];
    int f[][];
    public void solution(int graph[][],int n,int k) {
        this.graph=graph;
        seen=new boolean[n];
        f=new int[n][20];
        for(int i=0;i<f.length;i++){
            Arrays.fill(f[i],-1);
        }





        dfs(-1,n-1);

        for(int i=1;i<f[0].length;i++){
            for(int j=0;j<n;j++){
                int p = f[j][i-1];
                if(p==-1)continue;
                f[j][i]=f[p][i-1];
            }
        }


        seen[n-1]=true;
        int sum = 1;
        for(int i=n-2;i>=0;i--){
            if(seen[i])continue;
            int cur = i;
            int total=0;
            for(int j=19;j>=0;j--){
                if(f[cur][j]==-1)continue;
                int v = f[cur][j];
                if(seen[v])continue;//tag
                int dis = (1<<j);
                cur = f[cur][j];
                total+=dis;
                if(total+1+sum>n-k)break;
            }

            cur = i;
            if(total+1+sum<=n-k){
                sum+=total+1;
                while(!seen[cur]){
                    seen[cur]=true;
                    cur=f[cur][0];
                }
            }
        }



        for(int i=0;i<seen.length;i++){
            if(!seen[i]){
                out.print((i+1)+" ");
            }
        }
    }

    public void dfs(int p,int root){
        for(int next:graph[root]){
            if(p!=next){
                f[next][0]=root;
                dfs(root,next);
            }
        }
    }


}
