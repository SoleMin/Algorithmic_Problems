import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 16.09.12
 * Time: 19:29
 * To change this template use File | Settings | File Templates.
 */
public class stub implements Runnable {
    public static void main(String[] args) {
        new stub().run();
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    StringTokenizer st;

    public String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private void solve() throws IOException {
        int[] cnt = new int[(int) 1e6];
        int n = nextInt();
        int k = nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        int cur = 0;
        int left = 0;
        int i = left;
        while (i < n && cur != k) {
            if (cnt[a[i]] == 0) {
                cur++;
            }
            cnt[a[i]]++;
            i++;
        }
        i--;
        if (cur != k) {
            out.println("-1 -1");
            return;
        }
        int right = i;
        while (cnt[a[left]] > 1) {
            cnt[a[left]]--;
            left++;
        }
        out.println((left + 1) + " " + (right + 1));
    }

    public void run() {
        try {
            solve();
            out.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
