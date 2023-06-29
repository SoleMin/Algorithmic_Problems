import java.io.*;
import java.util.*;

public class A {

    BufferedReader in;
    StringTokenizer st;
    PrintWriter out;

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }

    int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    long nextLong() throws Exception {
        return Long.parseLong(next());
    }

    double nextDouble() throws Exception {
        return Double.parseDouble(next());
    }

    void solve() throws Exception {
        // int min = 1;
        // int max = 1000000000;
        int n = nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();

        Arrays.sort(a);

        if (a[n - 1] == 1) {
            for (int i = 1; i < n; i++)
                out.print("1 ");
            out.print(2);
            return;
        }

        // a[0]=max;

        Arrays.sort(a);
        out.print(1);
        for (int i = 1; i < n; i++)
            out.print(" " + a[i-1]);

    }

    void run() {
        try {
            Locale.setDefault(Locale.US);
            boolean oj = System.getProperty("ONLINE_JUDGE") != null;
            Reader reader = oj ? new InputStreamReader(System.in)
                    : new FileReader("input.txt");
            Writer writer = oj ? new OutputStreamWriter(System.out)
                    : new FileWriter("output.txt");
            in = new BufferedReader(reader);
            out = new PrintWriter(writer);

            solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new A().run();

    }

}
