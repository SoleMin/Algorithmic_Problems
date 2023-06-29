import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  Main{
    static long result;
    static int n, k;
    static boolean[][] field;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if(n==0 && k==0) break;

            field = new boolean[n][n];
            result = 0;

            backTracking(0,0,0);
            sb.append(result).append('\n');

        }
        System.out.println(sb);



    }
    public static void backTracking(int depth, int startI, int startJ){
        if(depth == k){
            result++;
            return;
        }

        for(int j=startJ; j<n; j++){
            if(!isAttacked(startI, j)){
                field[startI][j] = true;
                backTracking(depth+1, startI, j+1);
                field[startI][j] = false;
            }
        }
        for(int i=startI+1; i<n; i++){
            for(int j=0; j<n; j++){
                if(!isAttacked(i, j)){
                    field[i][j] = true;
                    backTracking(depth+1, i, j+1);
                    field[i][j] = false;
                }
            }
        }





    }
    static int[] dx = {-1,-1,1,1};
    static int[] dy = {-1,1,-1,1};
    public static boolean isAttacked(int row, int col){
        for(int i=0; i<4; i++){
            int newI = row+dx[i];
            int newJ = col+dy[i];
            while(newI>=0 && newI<n && newJ>=0 && newJ<n){
                if(field[newI][newJ]) return true;
                newI += dx[i];
                newJ += dy[i];
            }
        }


        return false;
    }
}