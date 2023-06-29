import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: piyushd
 * Date: 3/26/11
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaskC {

    final  int INF = 123456;
    int[][][] memo;
    int N, M;

    int solve(int row, int prevFreeMask, int curStayMask) {
        if(row == N) return (curStayMask == 0) ? 0 : -INF;
        if(memo[row][prevFreeMask][curStayMask] != -1) return memo[row][prevFreeMask][curStayMask];

        int res = 0;
        for(int mask = 0; mask < (1<<M); mask++) {
            if((mask & curStayMask) == curStayMask) {
                int freeCellsMask = (1<<M) - 1 - mask;
                int toMoveMask = freeCellsMask;

                for(int i = 0; i < M; i++) {
                    if((toMoveMask & (1<<i)) > 0) {
                        if(i > 0) {
                            if((mask & (1<<(i - 1))) > 0) {
                                toMoveMask -= (1<<i);
                                continue;
                            }
                        }

                        if(i < M - 1) {
                            if((mask & (1<<(i + 1))) > 0) {
                                toMoveMask -= (1<<i);
                                continue;
                            }
                        }
                    }
                }

                if (row > 0) {
                    for (int prevFillMask = toMoveMask; prevFillMask > 0; prevFillMask = (prevFillMask - 1) & toMoveMask) {
                        int bc1 = Integer.bitCount(freeCellsMask);
                        int bc2 = Integer.bitCount(prevFreeMask & prevFillMask);
                        res = Math.max(res, bc1 - bc2 + solve(row + 1, freeCellsMask, toMoveMask ^ prevFillMask));
                    }
                }

                res = Math.max(res, Integer.bitCount(freeCellsMask) + solve(row + 1, freeCellsMask, toMoveMask));
            }
        }

        return memo[row][prevFreeMask][curStayMask] = res;
    }

    void run() {
        N = nextInt();
        M = nextInt();
        if(M > N) {
            int temp = M;
            M = N;
            N = temp;
        }

        this.memo = new int[N + 1][1<<M][1<<M];
        for(int[][] g : memo) for(int[] f : g) Arrays.fill(f, -1);

        System.out.println(solve(0, 0, 0));
    }

    int nextInt(){
        try{
            int c = System.in.read();
            if(c == -1) return c;
            while(c != '-' && (c < '0' || '9' < c)){
                c = System.in.read();
                if(c == -1) return c;
            }
            if(c == '-') return -nextInt();
            int res = 0;
            do{
                res *= 10;
                res += c - '0';
                c = System.in.read();
            }while('0' <= c && c <= '9');
            return res;
        }catch(Exception e){
            return -1;
        }
    }

    long nextLong(){
        try{
            int c = System.in.read();
            if(c == -1) return -1;
            while(c != '-' && (c < '0' || '9' < c)){
                c = System.in.read();
                if(c == -1) return -1;
            }
            if(c == '-') return -nextLong();
            long res = 0;
            do{
                res *= 10;
                res += c-'0';
                c = System.in.read();
            }while('0' <= c && c <= '9');
            return res;
        }catch(Exception e){
            return -1;
        }
    }

    double nextDouble(){
        return Double.parseDouble(next());
    }

    String next(){
        try{
            StringBuilder res = new StringBuilder("");
            int c = System.in.read();
            while(Character.isWhitespace(c))
                c = System.in.read();
            do{
                res.append((char)c);
            }while(!Character.isWhitespace(c=System.in.read()));
            return res.toString();
        }catch(Exception e){
            return null;
        }
    }

    String nextLine(){
        try{
            StringBuilder res = new StringBuilder("");
            int c = System.in.read();
            while(c == '\r' || c == '\n')
                c = System.in.read();
            do{
                res.append((char)c);
                c = System.in.read();
            }while(c != '\r' && c != '\n');
            return res.toString();
        }catch(Exception e){
            return null;
        }
    }

    public static void main(String[] args){
        new TaskC().run();
    }
}
