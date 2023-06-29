import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class A {
    
    static StringTokenizer st;
    static BufferedReader in;
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        int[]a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = nextInt();
        }
        if (k >= m) {
            System.out.println(0);
            return;
        }
        Arrays.sort(a, 1, n+1);
        int ans = 0;
        for (int i = n; i >= 1; i--) {
            ans++;
            k--;
            k += a[i];
            if (k >= m) {
                System.out.println(ans);
                return;
            }
        }
        System.out.println(-1);
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
