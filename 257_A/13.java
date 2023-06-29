import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        Arrays.sort(a);
        int ans = 0, r = k, p = n-1;
        while (r < m && p >= 0) {
            r = r - 1 + a[p];
            p--;
            ans++;
        }
        if (r < m) out.println("-1");
        else out.println(ans);
        
        out.flush();
    }
    
}