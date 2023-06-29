import java.io.*;
import java.util.*;

public class Solution{
    
    public static void main(String[] args) throws Exception{
        int[] nm = in.readA();
        int n = nm[0], m = nm[1];
        // System.out.println(n+","+m);
        char[][] matstr = new char[n][m];
        for(int i = 0; i < n; i++){
            matstr[i] = in.readLine().toCharArray();
        }
        int[][] mat = new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                mat[i][j] = matstr[i][j] == '#'?1:0;
        boolean valid = true;

        int[][] dir = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1}, {0,1},
            {1,-1}, {1,0}, {1,1}
        };

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(mat[i][j] == 1){
                    boolean check = false;
                    for(int[] d: dir){
                        int x = d[0]+i,y=d[1]+j;
                        if(x >= mat.length || y >= mat[0].length || x < 0 || y < 0)
                            continue;
                        check = check || dfs(x,y,mat);
                    }
                    if(!check)
                        valid = false;
                }
            }
        }
        if(valid)
            System.out.println("YES");
        else 
            System.out.println("NO");
    }

    public static boolean dfs(int i,int j,int[][] mat){
        // if(x >= mat.length || y >= mat[0].length || x < 0 || y < 0 || mat[x][y] != 0)  return;
        int[][] dir = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1}, {0,1},
            {1,-1}, {1,0}, {1,1}
        };
        boolean possible = true;
        for(int[] d: dir){
            int x = d[0]+i,y=d[1]+j;
            if(x >= mat.length || y >= mat[0].length || x < 0 || y < 0){
                possible = false;
                break;
            }
            if(mat[x][y] == 0)
                possible = false;
        }
        return possible;
    }

    static Inputer in;
    static {
        in = new Inputer();
    }

    static class Inputer{
        BufferedReader br;
        Inputer(){
            try{
                br = new BufferedReader(new InputStreamReader(System.in));
            }
            catch(Exception e){}
        }
        public int readInt() throws Exception{
            return Integer.parseInt(readLine());
        }
        public long readLong() throws Exception{
            return Long.parseLong(readLine());
        }
        public int[] readA(String delim) throws Exception{
            String[] s = readLine().split(delim);
            int[] A = new int[s.length];
            for(int i = 0; i < s.length; i++)
                A[i] = Integer.parseInt(s[i]);
            return A;
        }
        public int[] readA() throws Exception{
            String[] s = readLine().split("\\s+");
            int[] A = new int[s.length];
            for(int i = 0; i < s.length; i++)
                A[i] = Integer.parseInt(s[i]);
            return A;
        }
        public long[] readLA() throws Exception{
            String[] s = readLine().split("\\s+");
            long[] A = new long[s.length];
            for(int i = 0; i < s.length; i++)
                A[i] = Long.parseLong(s[i]);
            return A;
        }
        public String readLine() throws Exception{
            return br.readLine();
        }
        public int[] copyA(int[] A){
            int[] B = new int[A.length];
            for(int i= 0 ; i < A.length; i++)
                B[i] = A[i];
            return B;
        }
    }
    static void shuffle(int[] A){
        int n = A.length;
        Random rand = new Random();
        for(int t = 0; t < A.length; t++){
            int i1 = rand.nextInt(n);
            int i2 = rand.nextInt(n);
            int tmp = A[i1];
            A[i1] = A[i2];
            A[i2] = tmp;
        }
    }
}