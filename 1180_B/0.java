
import java.util.Arrays;
import java.util.Scanner;

public class B {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        if (n != 3 || (arr[0] != -3 || arr[1] != -3 || arr[2] != 2)) {
            for (int i = 0; i < n; i++) {
                if (arr[i] >= 0)
                    arr[i] = -arr[i] - 1;
            }
            if (n % 2 != 0) {
                int mx = -1, ind = -1;
                for (int i = 0; i < n; i++) {
                    if (Math.abs(arr[i]) > mx) {
                        mx = Math.abs(arr[i]);
                        ind = i;
                    }
                }
                arr[ind] = -arr[ind] - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
