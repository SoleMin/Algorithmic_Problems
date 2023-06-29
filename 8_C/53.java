import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CF008C {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        int n = s.nextInt();
        int[] xx = new int[n+1];
        int[] yy = new int[n+1];
        for(int i = 0;i<n;i++){
            xx[i] = s.nextInt();
            yy[i] = s.nextInt();
        }
//        int[][] dp = new int[n][n];
//        for(int i = 0;i<n;i++){
//            Arrays.fill(dp[i],-1);
//        }
        xx[n] = x;
        yy[n] = y;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = i + 1; j <= n; j++) {
                int dx = xx[i] - xx[j];
                int dy = yy[i] - yy[j];
                dp[i][j] = dx * dx + dy * dy;
            }
            int[] aa = new int[1 << n];
            int[] bb = new int[1 << n];
            for (int k = 1; k < 1 << n; k++) {
                int a = -1;
                for (int b = 0; b < n; b++)
                    if ((k & 1 << b) > 0) {
                        a = b;
                        break;
                    }
                int l = k ^ 1 << a;
                int d = dp[a][n] + dp[a][n];
                aa[k] = aa[l] + d;
                bb[k] = l;
                for (int b = a + 1; b < n; b++)
                    if ((k & 1 << b) > 0) {
                        l = k ^ 1 << a ^ 1 << b;
                        d = dp[a][n] + dp[b][n] + dp[a][b];
                        if (aa[l] + d < aa[k]) {
                            aa[k] = aa[l] + d;
                            bb[k] = l;
                        }
                    }
            }
            int k = (1 << n) - 1;
            System.out.println(aa[k]);
            StringBuilder sb = new StringBuilder();
            sb.append(0);
            while (k != 0) {
                int l = bb[k];
                int m = k ^ l;
                for (int b = 0; b < n; b++)
                    if ((m & 1 << b) > 0)
                        sb.append(' ').append(b + 1);
                sb.append(' ').append(0);
                k = l;
            }
            System.out.println(sb);
        }
//        int[] distFromOrigin = new int[n];
////        HashMap<Integer,Boolean> map = new HashMap<>();
//        for(int i=0;i<n;i++){
//            distFromOrigin[i] = (int) (Math.pow((xCoord[i] - x),2) + Math.pow(yCoord[i] - y,2));
////            map.put(i,true);
//        }
//        System.out.println(0);
//        long sum = 0;
//        String str = "0 ";
//
//        while(!map.isEmpty()){
//            int first = 0;
//            int second = Integer.MIN_VALUE;
//            if(map.size() == 1){
//                first = new ArrayList<Integer>(map.keySet()).get(0) + 1;
//                int min = distFromOrigin[first - 1] + distFromOrigin[first - 1];
//                sum += min;
//                map.remove(first - 1);
//            }else {
//                int min = Integer.MAX_VALUE;
//
//                for (int i = 0; i < n; i++) {
//                    for (int j = 0; j <= i; j++) {
//                        if (map.containsKey(i) && map.containsKey(j) && distFromOrigin[i] + distFromOrigin[j] + dp[i][j] < min) {
//                            min = distFromOrigin[i] + distFromOrigin[j] + dp[i][j];
//                            first = i + 1;
//                            if(i == j){
//                                second = Integer.MIN_VALUE;
//                            }else {
//                                second = j + 1;
//                            }
//                        }
//                    }
//                }
//                sum += min;
//                map.remove(first - 1);
//                if(second != Integer.MIN_VALUE){
//                    map.remove(second - 1);
//                }
//            }
//            if(second == Integer.MIN_VALUE){
//                str = str + first + " ";
//            }else{
//                if(map.size() == 0) {
//                    str = str + first + " " + second + " ";
//                }else{
//                    str = str + first + " " + second + " 0 ";
//                }
//            }
////            System.out.print(first + " " + second + " ");
//        }
//        System.out.println(sum);
//        System.out.println(str + "0");
//        int[] ans = new int[(int)Math.pow(2,n)];
//        Arrays.fill(ans,Integer.MAX_VALUE);
//        for(int i = 0;i<Math.pow(2,n);i++){
//            for(int j = 0;j<n;j++){
//                //I can't figure out how to do that.
//            }
//        }
//        System.out.print(sum);
//        System.out.print(0);


    private static int calculateDistanceBetweenIandJ(int[] xCoord, int[] yCoord, int i, int j) {
        int length = (int) (Math.pow((xCoord[i] - xCoord[j]),2) + Math.pow(yCoord[i] - yCoord[j], 2));
        return length;
    }
}
