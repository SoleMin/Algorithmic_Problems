import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] ss = br.readLine().split(" ");
        int n = ss.length;
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = Integer.parseInt(ss[i]);
        for (int i = 0; i < n; ++i) {
            boolean ok = true;
            for (int j = 0; j < n; ++j)
                if (j != i && a[j] % 2 == a[i] % 2)
                    ok = false;
            if (ok)
                System.out.println(i + 1);
        }
    }
}
