import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        for (int i = 0; i < n; i++)
            a[i] *= -1;
        Arrays.sort(a);
        for (int i = 0; i < n; i++)
            a[i] *= -1;

        int ans = 0;
        int sum1 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += a[i];
            sum -= a[i];
            ans++;
            if (sum1 > sum)
                break;
        }

        pw.print(ans);
        pw.close();
    }
}
