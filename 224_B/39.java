import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader();
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        if (k > n) {
            System.out.println(-1 + " " + -1);
            return;
        }
        int[] v = new int[100010];
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (v[a[i]] == 0) {
                cnt++;
            }
            v[a[i]]++;

        }
        int i = k;
        while (cnt < k && i < n) {
            if (v[a[i]] == 0) {
                cnt++;
            }
            v[a[i]]++;
            i++;
        }
        if (cnt != k) {
            System.out.println(-1 + " " + -1);
        } else {
            int st = 0;
            while (st < n && st < i && v[a[st]] > 1) {
                v[a[st]]--;
                st++;
            }
            System.out.println((st+1) + " " + (i));
        }
    }

    static class InputReader {
        BufferedReader in;
        StringTokenizer st;

        public InputReader() throws IOException {
            in = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(in.readLine());
        }

        public String next() throws IOException {
            while (!st.hasMoreElements())
                st = new StringTokenizer(in.readLine());
            return st.nextToken();
        }

        public int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }
    }

}