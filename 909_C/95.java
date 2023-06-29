import java.io.PrintWriter;
import java.util.*;

/**
 * Created by trung.pham on 28/12/17.
 */
public class C_Round_455_Div2 {
    static long[][]dp;

    static  long MOD =(long) 1e9 + 7;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        char[]data = new char[n];
        dp = new long[n][n];
        for(long []a : dp){
            Arrays.fill(a,-1);
        }
        for(int i = 0; i < n; i++){
            data[i] = in.next().charAt(0);
        }
        out.println(cal(0, 0, data));

        out.close();
    }

    static long cal(int index, int nested, char[]data ){
        //System.out.println(index + " " + nested);
        if(index + 1 == data.length){
            return 1;
        }
        if(dp[index][nested] != -1){
            return dp[index][nested];
        }
        long result = 0;
        boolean isLoop = data[index] == 'f';
        if(isLoop){
            result = cal(index + 1, nested + 1, data);
        }else{
            result = cal(index + 1, nested, data);
            if(nested > 0){
                result += cal(index, nested - 1, data);
                result %= MOD;
            }
        }
       // System.out.println(result + " " + index + " " + nested);
        return dp[index][nested]= result;

    }
}
