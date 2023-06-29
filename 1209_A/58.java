import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mainA {
    public static PrintWriter out = new PrintWriter(System.out);
    public static FastScanner enter = new FastScanner(System.in);
    public static void main(String[] args) throws IOException {
        solve();
        out.close();
    }
    public static boolean[] was;
    private static void solve() throws IOException{
        int n=enter.nextInt();
        int[] arr=new int[n];
        was=new boolean[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=enter.nextInt();
        }
        Arrays.sort(arr);
        int ans=0;
        for (int i = 0; i <n ; i++) {
            if(was[i]) continue;
            find(i, arr);
            ans++;
        }
        out.println(ans);
    }

    public static void find (int num, int[] arr){
        for (int i = num+1; i <arr.length ; i++) {
            if(arr[i]%arr[num]==0) was[i]=true;
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer stok;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() throws IOException {
            while (stok == null || !stok.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return null;
                }
                stok = new StringTokenizer(s);
            }
            return stok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        char nextChar() throws IOException {
            return (char) (br.read());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }
}
