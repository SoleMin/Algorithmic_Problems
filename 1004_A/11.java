import java.io.*;
import java.util.*;

public class A {
    String fileName = "<name>";

    public TreeSet<Integer> set = new TreeSet<>();

    public int getLowerDist(int x) {
        Integer higher = set.higher(x);
        Integer lower = set.lower(x);
        if (higher == null)
            return lower;
        if (lower == null)
            return higher;
        if (Math.abs(x - higher) < Math.abs(x - lower)) {
            return higher;
        } else {
            return lower;
        }
    }

    public void solve() throws IOException {
        int n = nextInt();
        int d = nextInt();
        int[] a = new int[n];
        Set<Integer> ans = new HashSet<>((int) 1e6, 1f);
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            set.add(a[i]);
        }
        for (int i = 0; i < n; i++) {
            int pos1 = a[i] + d;
            int pos2 = a[i] - d;
            if (!set.contains(pos1) && Math.abs(pos1 - getLowerDist(pos1)) == d) {
                ans.add(pos1);
            }
            if (!set.contains(pos2) && Math.abs(pos2 - getLowerDist(pos2)) == d) {
                ans.add(pos2);
            }
        }
        out.print(ans.size());
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new A().run();
    }
}