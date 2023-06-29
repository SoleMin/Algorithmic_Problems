import java.io.*;
import java.util.StringTokenizer;

public class A {

    public static void main(String[] args) throws IOException {
        new A().solve();
    }

    BufferedReader br;
    StringTokenizer st = new StringTokenizer("");

    private void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String s = nextToken();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int k = 0;
                while (k < s.length() - j && s.charAt(i + k) == s.charAt(j + k)) {
                    k++;
                }
                res = Math.max(res, k);
            }
        }
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(res);
        pw.close();
    }

    String nextToken() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

}
