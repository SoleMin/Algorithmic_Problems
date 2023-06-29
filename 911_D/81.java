import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), sum = 0;
        int [] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 1; i <= n; ++i)
            for (int j = i + 1; j <= n; ++j)
                sum += a[i] > a[j] ? 1 : 0;
        int m = in.nextInt();
        sum &= 1;
        for (int i = 1; i <= m; i++) {
            int l = in.nextInt(), r = in.nextInt();
            if (((r - l + 1) / 2) % 2 == 1)
                sum ^= 1;
            System.out.println(sum == 1 ? "odd" : "even");
        }
    }
}