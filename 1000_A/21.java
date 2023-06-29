
import java.util.*;
import java.io.*;

public class A{
    
    static int N, M, K;
    static String s;
    static StringTokenizer st;
    static int[] d;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        PrintWriter out = new PrintWriter(System.out);
        
        int[][] d = new int[5][3];
        int[][] d2 = new int[5][3];
        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String r = br.readLine();
            int len = r.length();
            int fin = 0;
            if(r.charAt(r.length()-1) == 'S')
                fin = 0;
            if(r.charAt(r.length()-1) == 'M')
                fin = 1;
            if(r.charAt(r.length()-1) == 'L')
                fin = 2;
            d[len][fin]++;
        }
        
        for (int i = 0; i < N; i++) {
            String r = br.readLine();
            int len = r.length();
            int fin = 0;
            if(r.charAt(r.length()-1) == 'S')
                fin = 0;
            if(r.charAt(r.length()-1) == 'M')
                fin = 1;
            if(r.charAt(r.length()-1) == 'L')
                fin = 2;
            d2[len][fin]++;
        }
        
        int ans = 0;
        for (int i = 0; i < d.length; i++) {
            int sum = 0;
            int sum2 = 0;
            for (int j = 0; j < d[0].length; j++) {
                sum += d[i][j];
                sum2 += d2[i][j];
                ans += Math.max(0, d2[i][j] - d[i][j]);
            }
            
        }
        System.out.println(ans);
        out.close();
    }    
}
