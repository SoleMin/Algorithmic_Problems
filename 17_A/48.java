import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class Solution implements Runnable{
    private static BufferedReader br = null;
    private static PrintWriter out = null;
    private static StringTokenizer stk = null;
    
    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        (new Thread(new Solution())).start();
    }
    
    private void loadLine() {
        try {
            stk = new StringTokenizer(br.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private String nextLine() {
        try {
            return br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private Integer nextInt() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return Integer.parseInt(stk.nextToken());
    }
    
    private Long nextLong() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return Long.parseLong(stk.nextToken());
    }
    
    private String nextWord() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return (stk.nextToken());
    }
    
    private Double nextDouble() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return Double.parseDouble(stk.nextToken());
    }
    
    public void run() {
        int n = nextInt();
        int k = nextInt();
        
        boolean[] isP = new boolean[2*n];
        Arrays.fill(isP, true);
        isP[0] = isP[1] = false;
        
        for (int i = 0; i <= n; ++i) {
            if (isP[i]) {
                for (int j = i+i; j <= n; j+=i) {
                    isP[j] = false;
                }
            }
        }
        
        ArrayList<Integer> p = new ArrayList<Integer>();
        for (int i = 0; i <= n; ++i) {
            if (isP[i]) {
                p.add(i);
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < p.size(); ++i) {
            int num = p.get(i) - 1;
            
            for (int j = 0; j < p.size() - 1; ++j) {
                if (p.get(j) + p.get(j+1) == num) {
                    ++cnt;
                    break;
                }
            }
        }
        
        if (cnt >= k) {
            out.println("YES");
        }
        else {
            out.println("NO");
        }
        out.flush();
    }
}

