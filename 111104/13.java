import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[500][2];
        int count = 0;
        String s = br.readLine();
        while(s!=null){
            StringTokenizer st = new StringTokenizer(s);
            int weight = Integer.parseInt(st.nextToken());
            int strength = Integer.parseInt(st.nextToken());
            arr[count][0] = weight;
            arr[count++][1] = strength;
            s = br.readLine();
        }


        int[][] arr2 = Arrays.copyOf(arr, count);


        Arrays.sort(arr2, ((o1, o2) -> {
            if(o1[1]==o2[1]) return Integer.compare(o1[0], o2[0]);
            else return Integer.compare(o1[1], o2[1]);
        }));

//        for(int i=0; i<count; i++){
//            System.out.println(Arrays.toString(arr2[i]));
//        }


        // index 1부터 사용.
//        int[][] dp = new int[count+1][count+1];
//        for(int i=0; i<count+1; i++){
//            Arrays.fill(dp[i], (int)1e9);
//        }
//
//        dp[0][0] = 0;
//        if(arr2[0][0] <= arr2[0][1]) dp[1][1] = arr2[0][0];
//
//
//        for(int i=1; i<=count; i++){
//            for(int j=1; j<=count; j++){
//                if(dp[i-1][j-1] + arr2[i-1][0] <= arr2[i-1][1]) dp[i][j] = Math.min(dp[i-1][j-1]+arr2[i-1][0], dp[i-1][j]);
//                else if(dp[i-1][j]!=1e9) dp[i][j] = dp[i-1][j];
//            }
//        }
//
//        for(int i=1; i<=count; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }


        int[] dp = new int[count+1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;
        for(int i=0; i<count; i++){
            for(int j=count; j>=0; j--){
                if(dp[j] + arr2[i][0] <= arr2[i][1]) dp[j+1] = Math.min(dp[j+1], dp[j]+arr2[i][0]);
            }
        }

//        System.out.println(Arrays.toString(dp));


        int res = 0;
        for(int i=1; i<=count; i++){
            if(dp[i]!=1e9) res = i;
        }

        System.out.println(res);







    }
}