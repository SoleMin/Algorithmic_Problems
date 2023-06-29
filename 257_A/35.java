import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class round159A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));
    static StringTokenizer st = new StringTokenizer("");

    static int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    static String next() throws Exception {
        while (true) {
            if (st.hasMoreTokens()) {
                return st.nextToken();
            }
            String s = br.readLine();
            if (s == null) {
                return null;
            }
            st = new StringTokenizer(s);
        }
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        int[] supply = new int[n];
        for (int i = 0; i < n; ++i)
            supply[i] = nextInt();
        if (m <= k) {
            System.out.println(0);
        } else {
            int have = k;
            Arrays.sort(supply);
            for(int i = n - 1 ; i >= 0 ; --i){
                have--;
                have += supply[i];
                if(have >= m){
                    System.out.println(n - i);
                    return;
                }
            }
            System.out.println(-1);
        }
    }
}
