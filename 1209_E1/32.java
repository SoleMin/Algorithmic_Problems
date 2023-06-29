import java.io.*;
import java.util.*;

public class r584p5 {
    private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter pw = new PrintWriter(System.out);
    private static int n, m, arr[][];
    private static ArrayList<HashSet<Integer>> chls;

    private static void gench(){
        chls.add(new HashSet<>());
        chls.get(0).add(0);

        for(int i=1; i<(1<<n); i++){
            int des = i^Integer.highestOneBit(i);
            HashSet<Integer> st = new HashSet<>();
            for(int z : chls.get(des)){
                st.add(z);
                st.add(z|Integer.highestOneBit(i));
            }
            chls.add(st);
        }
    }

    private static void cal(){
        int val[][] = new int[(1<<n)][m];

        for(int j=0; j<m; j++){
            val[0][j] = 0;
            for(int mask=1; mask<(1<<n); mask++){
                int max = 0;
                for(int begin=0; begin<n; begin++){
                    int sum = 0;
                    for(int ptr=begin, pos=0; pos<n; ptr=(ptr+1)%n, pos++){
                        if((mask&(1<<pos)) > 0)
                            sum += arr[ptr][j];
                    }
                    max = Math.max(max, sum);
                }
                val[mask][j] = max;
            }
        }

        int dp[][] = new int[(1<<n)][m];

        for(int mask=0; mask<(1<<n); mask++)
            dp[mask][0] = val[mask][0];

        for(int j=1; j<m; j++){
            dp[0][j] = 0;
            for(int mask=1; mask<(1<<n); mask++){

                dp[mask][j] = 0;
                for(int ch1 : chls.get(mask)){
                    int ch2 = mask^ch1;

                    dp[mask][j] = Math.max(dp[mask][j], val[ch1][j]+dp[ch2][j-1]);
                }
            }
        }

        pw.println(dp[(1<<n)-1][m-1]);
    }

    private static void run()throws IOException{
        StringTokenizer tk = new StringTokenizer(r.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        arr = new int[n][m];
        chls = new ArrayList<>();

        for(int i=0; i<n; i++){
            tk = new StringTokenizer(r.readLine());
            for(int j=0; j<m; j++)
                arr[i][j] = Integer.parseInt(tk.nextToken());
        }

        gench();
        cal();
    }

    public static void main(String args[])throws IOException{
        int t = Integer.parseInt(r.readLine());

        while(t-->0)
            run();

        pw.flush();
        pw.close();
    }
}