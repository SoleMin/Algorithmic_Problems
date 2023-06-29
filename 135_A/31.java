import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class A implements Runnable{
    
    
    public void run() {
        int n = nextInt();
        int[] arr = new int[n];
        boolean allOne = true;
        for (int i = 0; i < n; ++i) {
            arr[i] = nextInt();
            if (arr[i] != 1) {
                allOne = false;
            }
        }
        Arrays.sort(arr);
        if (!allOne) {
            out.print("1 ");
        }
        for (int i = 0; i < n-1; ++i) {
            out.print(arr[i] + " ");
        }
        if (allOne) {
            out.print("2");
        }
        out.println();
        out.flush();
    }
    
    private static BufferedReader br = null;
    private static PrintWriter out = null;
    private static StringTokenizer stk = null;
    
    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        (new Thread(new A())).start();
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
    
    
}

