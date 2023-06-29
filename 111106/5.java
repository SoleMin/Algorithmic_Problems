import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAXL = 100;
    static int n, carlength, carlengthsum, max, dynamic[][], from[][][], top, stack[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int tmp = testCase;
        while(testCase-->0){
            br.readLine();
            dynamic = new int[MAXL*100 +1][2];
            from = new int[MAXL*2 + 1][MAXL*100 +1][2];
            stack = new int[MAXL*2];
            n = Integer.parseInt(br.readLine());
            n *= 100;
            for(int i=0; i<=n; i++){
                dynamic[i][0] = -1;
                dynamic[i][1] = 0;
            }
            dynamic[0][0] = 0;
            carlengthsum = 0;
            max = 0;
            int count = 0;
            while(true){
                carlength = Integer.parseInt(br.readLine());
                if(carlength==0) break;
                if(carlengthsum<=2*n){
                    solve(count+1);
                    carlengthsum += carlength;
                }
                count++;
            }




            if(tmp!=testCase) System.out.println();
            System.out.println(dynamic[max][0]);



        }




    }
    public static void solve(int carnum){
        for (int i = n; i >= carlength; i--) {
            if (dynamic[i - carlength][0] != -1 &&
                    carlengthsum - i + carlength <= n && dynamic[i][0] < carnum) {
                dynamic[i][0] = carnum;
                dynamic[i][1] = carlengthsum - i + carlength;
                from[carnum][i][0] = dynamic[i - carlength][0];
                from[carnum][i][1] = carlength;
                if (dynamic[max][0] < dynamic[i][0] || (dynamic[max][0] == dynamic[i][0] &&
                        Math.abs(max - dynamic[max][1]) > Math.abs(i - dynamic[i][1])))
                    max = i;
            }
        }
    }
}