import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class CF274A {

    public static void main(String[] args) throws Exception {
        new CF274A().solve();
    }

    private void solve() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        HashSet<Integer> used = new HashSet<>(n);
        int count = 0;
        for (int i = 0; i < n; i++) {
            Integer v = a[i];
            if (!used.contains(v)) {
                count++;
                long next = v * k;
                if (next <= 1000000000) used.add((int) next);
            }
        }
        System.out.println(count);
    }

}
