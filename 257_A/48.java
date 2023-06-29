
import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = in.nextInt();
        Arrays.sort(A);
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k >= m) {
                System.out.println(cnt);
                return;
            }
            cnt++;
            k += A[i] - 1;
        }
        if (k >= m)
            System.out.println(cnt);
        else
            System.out.println(-1);
    }
}
