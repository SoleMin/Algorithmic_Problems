import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class A {
    public static void main(String[] args) throws IOException {
        new A().run();
    }

    BufferedReader br;
    StringTokenizer st = new StringTokenizer("");

    private void run() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = nextInt();
        Set<Integer> set = new TreeSet<Integer>();

        for (int i = 0; i < n; i++) {
            set.add(nextInt());
        }
        set.remove(set.iterator().next());
        PrintWriter pw = new PrintWriter(System.out);
        if (set.isEmpty()) {
            pw.println("NO");
        } else {
            pw.println(set.iterator().next());
        }
        pw.close();
    }

    int nextInt() throws IOException {
        while (!st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

}
