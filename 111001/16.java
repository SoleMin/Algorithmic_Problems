import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static final int maxN = 100;
    static int n, check[];
    static double dot[][], minVal[], result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            br.readLine();
            n = Integer.parseInt(br.readLine());
            dot = new double[n][2];
            check = new int[n];
            minVal = new double[n];
            result = 0;
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                dot[i][0] = Double.parseDouble(st.nextToken());
                dot[i][1] = Double.parseDouble(st.nextToken());
            }

            check[0] = 1;
            for(int i=1; i<n; i++){
                minVal[i] = dist(0, i);
            }
            result += 0;

            for(int i=0; i<n-1; i++){
                int minIndex = (int)1e9;
                double minDist = 1e9;
                for(int j=1; j<n; j++){
                    if(check[j]==0 && minDist>minVal[j]){
                        minDist = minVal[j];
                        minIndex = j;
                    }
                }
                result += minDist;
                check[minIndex] = 1;
                for(int j=1; j<n; j++){
                    minVal[j] = Math.min(minVal[j], dist(minIndex, j));
                }
            }
            sb.append(String.format("%.2f", result)).append('\n').append('\n');
        }
        System.out.println(sb);







    }
    static double dist(int a, int b){
        return Math.sqrt(Math.pow(dot[a][0] - dot[b][0], 2) + Math.pow(dot[a][1] - dot[b][1], 2));
    }
}
