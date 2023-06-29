import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws Exception {
        new A().solve();
        // new FileInputStream(new File("input.txt")),
        // new PrintStream(new FileOutputStream(new File("output.txt"))));
    }

    void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        String[] sp;


        sp = in.readLine().split(" ");
        int n = Integer.parseInt(sp[0]);
        long k = Integer.parseInt(sp[1]);
        Long[] a = new Long[n];
        sp = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = (long) Integer.parseInt(sp[i]);
        }

        Arrays.sort(a);
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            long x = a[i];
            if (!set.contains(x)) {
                set.add(x * k);
            }
        }
        System.out.println(set.size());
    }
}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
