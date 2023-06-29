import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_135A {
    static final FS sc = new FS();
    static final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = sc.nextInt();
        long[] a = sc.nextLongArray(n);
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        if(a[0]>1){
            sb.append(1+" ");
            for(int i=0; i<n-1; i++){
                sb.append(a[i]+" ");
            }
            System.out.println(sb.toString());
        }
        else if(a[n-1]==1){
            for(int i=1; i<n; i++){
                sb.append(a[i]+" ");
            }
            sb.append(2);
            System.out.println(sb.toString());
        }
        else{
            int i = 0;
            while(a[i]==1){
                sb.append(a[i]+" ");
                i++;
            }
            sb.append(1+" ");
            while(i<n-1){
                sb.append(a[i]+" ");
                i++;
            }
            System.out.println(sb.toString());
        }
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
