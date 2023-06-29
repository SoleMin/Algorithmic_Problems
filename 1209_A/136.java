import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class A {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int vis[] = new int[n];
        Arrays.fill(vis, -1);
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] != -1) continue;
            c++;
            for (int j = i; j < n; j++) {
                if (vis[j] == -1 && a[j] % a[i] == 0) {
                    vis[j] = c;
                }
            }
        }
        
        pw.println(c);

        pw.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}