import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        Set<Integer> div = new HashSet<>();
        boolean[] d = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < n; j++) {
                if (d[j]) {
                    continue;
                }
                if (a[j]%a[i] == 0) {
                    d[j] = true;
                    div.add(a[i]);
                }
            }
        }

        System.out.println(div.size());
    }
}
