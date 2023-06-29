import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {


    public void solve() throws IOException {
        int n = nextInt(), r = nextInt();
        int x[] = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
        }
        double res[] = new double[n];
        res[0] = r;
        for (int i = 1; i < n; i++) {
            double max = r;
            for (int j = 0; j < i; j++) {
                int d = Math.abs(x[i] - x[j]);
                if(d <= 2 * r){
                    double yy = Math.sqrt(4 * r * r - d * d);
                    max = Math.max(max, yy + res[j]);
                }
            }
            res[i] = max;
        }
        for (int i = 0; i < n; i++) {
            out.print(res[i] + " ");
        }
    }

    BufferedReader br;
    StringTokenizer sc;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new Main().run();
    }

    void run() throws IOException {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
//            br = new BufferedReader(new FileReader("pnumbers.in"));
//            out = new PrintWriter(new File("out.txt"));
            solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    String nextToken() throws IOException {
        while (sc == null || !sc.hasMoreTokens()) {
            try {
                sc = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                return null;
            }
        }
        return sc.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

}