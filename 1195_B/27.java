
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

public class B {
    final int INF = 1_000_000_000;
    void solve() {
        int n = readInt();
        int k = readInt();
        long l = 0;
        long r = INF;
        while(r - l > 1){
            long m = (r + l) >> 1;
            if(m * (m + 1) / 2 + m >= k + n) r = m;
            else l = m;
        }
        out.print(n - r);
    }

    public static void main(String[] args) {
        new B().run();
    }

    private void run() {
        try {
            init();
            solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private BufferedReader in;
    private StringTokenizer tok = new StringTokenizer("");

    private PrintWriter out;

    private void init() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

//        try {
//            in = new BufferedReader(new FileReader("absum.in"));
//            out = new PrintWriter(new File("absum.out"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    private String readLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readString() {
        while (!tok.hasMoreTokens()) {
            String nextLine = readLine();
            if (nextLine == null) return null;
            tok = new StringTokenizer(nextLine);
        }

        return tok.nextToken();
    }

    private int readInt() {
        return Integer.parseInt(readString());
    }

    private long readLong() {
        return Long.parseLong(readString());
    }

    int[] readIntArray(int n){
        int[] res = new int[n];
        for(int i = 0;i<n;i++){
            res[i] = readInt();
        }
        return res;
    }

    long[] readLongArray(int n){
        long[] res = new long[n];
        for(int i = 0;i<n;i++){
            res[i] = readLong();
        }
        return res;
    }

    int[] castInt(List<Integer> list){
        int[] res = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}