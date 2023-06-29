import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_220A {
    static final FS sc = new FS();
    static final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = sc.nextArray(n);
        int[] b = new int[n];
        System.arraycopy(a,0,b,0,n);
        Arrays.sort(b);
        int count = 0;
        for(int i=0; i<n; i++){
            if(a[i]!=b[i]) count++;
        }
//        System.out.println(Arrays.toString(b));
//        System.out.println(count);
        if((count/2==0) || (count/2==1 && count%2==0)) System.out.println("YES");
        else System.out.println("NO");
    }

    static class FS {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception ignored) {
                }
            }
            return st.nextToken();
        }

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
