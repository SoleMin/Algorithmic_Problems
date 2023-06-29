import java.io.*;
import java.util.*;

public class MainF {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.txt")));
        String S = br.readLine();
        String[]J = S.split(" ");
        int N = Integer.parseInt(J[0]);
        int M = Integer.parseInt(J[1]);

        int K = Integer.parseInt(br.readLine());
        int[]x = new int[K];
        int[]y = new int[K];
        S = br.readLine();
        J = S.split(" ");       
        for(int i = 0; i<2*K; i = i + 2){
            x[i/2] = Integer.parseInt(J[i]);
            y[i/2] = Integer.parseInt(J[i+1]);
        }
        
        int ans = -1;
        int ansX = -1;
        int ansY = -1;
        
        for (int i = 1; i<=N; i++){
            for (int j = 1; j<=M; j++){
                int W = M + N;
                for (int k = 0; k<K; k++){
                    W = Math.min(W, Math.abs(i-x[k]) + Math.abs(j-y[k]));
                }
                if (W < ans)continue;
                ans = W;
                ansX = i;
                ansY = j;               
            }
        }
        bw.write(Integer.toString(ansX)+" "+Integer.toString(ansY));
        br.close();
        bw.close();     
    }
}