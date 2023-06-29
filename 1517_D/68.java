import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author:
 * @Date: 2021/4/23 23:55
 */
public class ExplorerSpace {
    static int n;
    static int m;
    static int k;
    static int [][] rows;
    static int [][] cols;
    static int max;
    static int orix;
    static int oriy;
    static int [][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    static int [][][][][] mem;
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        n = fs.nextInt();
        m =fs.nextInt();
        k = fs.nextInt();
        rows = new int[n][m-1];
        cols = new int[n-1][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m-1; j++){
                rows[i][j] = fs.nextInt();
            }
        }
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < m; j++){
                cols[i][j] = fs.nextInt();
            }
        }
        int [][][] res = new int[100][n][m];
        for(int o = 2; o <= k; o+=2){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    res[o][i][j] = 0x3f3f3f3f;
                    if(i>0){
                        res[o][i][j] = Math.min(res[o][i][j], res[o-2][i-1][j] + 2*cols[i-1][j]);
                    }
                    if(i+1<n){
                        res[o][i][j] = Math.min(res[o][i][j], res[o-2][i+1][j] + 2 * cols[i][j]);
                    }
                    if(j>0){
                        res[o][i][j] = Math.min(res[o][i][j], res[o-2][i][j-1] + 2 * rows[i][j-1]);
                    }
                    if(j+1<m){
                        res[o][i][j] = Math.min(res[o][i][j], res[o-2][i][j+1] + 2 * rows[i][j]);
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m;j ++){
                if(k%2==1){
                    System.out.print(-1+" ");
                }else{
                    System.out.print(res[k][i][j] + " ");
                }

            }
            System.out.println();
        }
    }

//    static void dfs(int x, int y,int cur, int left){
//        if(x<0||x>=n||y<0||y>=m){
//            return;
//        }
//        if(left==0&&x==orix&&y==oriy){
//            max = Math.min(max,cur);
//            return;
//        }
//        if(left<=0){
//            return;
//        }
//        if(cur>=max){
//            return;
//        }
//        if(x+1<n){
//            dfs(x+1,y,cur+cols[x][y],left-1);
//        }
//        if(x-1>=0){
//            dfs(x-1,y,cur+cols[x-1][y],left-1);
//        }
//        if(y+1<m){
//            dfs(x,y+1,cur+rows[x][y],left-1);
//        }
//        if(y-1>=0){
//            dfs(x,y-1,cur+rows[x][y-1],left-1);
//        }
//
//    }
    static class  FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        String next(){
            while (!st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
    }
}
