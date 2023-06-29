import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class A {
    
    static StringTokenizer st;
    static BufferedReader in;
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = nextInt();
        int k = nextInt();
        Integer[]a = new Integer[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = nextInt();
        }
        if (k==1) {
            System.out.println(n);
            return;
        }
        Arrays.sort(a, 1, n+1);
        Set<Integer> set = new HashSet<Integer>();
        int ans = 0;
        int INF = (int) 1e9;
        for (int i = 1; i <= n; i++) {
            if (set.contains(a[i]))
                continue;
            int t = a[i];
            int s = 1;
            while ((long)t*k <= INF) {
                t *= k;
                if (Arrays.binarySearch(a, 1, n+1,  t) >= 0) {
                    set.add(t);
                    s++;
                }
                else
                    break;
            }
            if (s % 2==0)
                ans += s/2;
            else
                ans += s/2+1;
        }
        System.out.println(ans);
        pw.close();
    }
    private static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    
    private static long nextLong() throws IOException{
        return Long.parseLong(next());
    }
    
    private static double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
    
    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
}
