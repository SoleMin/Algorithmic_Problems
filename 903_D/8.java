import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class CFD {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    final long MOD = 1000L * 1000L * 1000L + 7;
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};


    void solve() throws IOException {
        int n = nextInt();
        long[] arr = nextLongArr(n);
        long[] diff = new long[n];
        long presum = 0;
        for (int i = n - 1; i >= 0; i--) {
            diff[i] = presum - (n - i - 1) * arr[i];
            presum += arr[i];
        }

        BigInteger pairs = new BigInteger("0");
        for (long s : diff) {
            pairs = pairs.add(new BigInteger(Long.toString(s)));
        }

        BigInteger need = new BigInteger("0");
        Map<Long, Long> hm = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            long v1 = hm.getOrDefault(arr[i] - 1, 0L) * (-1);
            need = need.add(new BigInteger(Long.toString(v1)));
            long v2 = hm.getOrDefault(arr[i] + 1, 0L);
            need = need.add(new BigInteger(Long.toString(v2)));

            hm.put(arr[i], hm.getOrDefault(arr[i], 0L) + 1);
        }
        BigInteger res = pairs.subtract(need);
        out(res.toString());
    }

    void shuffle(long[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            long tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }
    private void outln(Object o) {
        out.println(o);
    }
    private void out(Object o) {
        out.print(o);
    }
    public CFD() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new CFD();
    }

    public long[] nextLongArr(int n) throws IOException{
        long[] res = new long[n];
        for(int i = 0; i < n; i++)
            res[i] = nextLong();
        return res;
    }
    public int[] nextIntArr(int n) throws IOException {
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
            res[i] = nextInt();
        return res;
    }
    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }
    public String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}
