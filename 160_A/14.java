import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < a.length; i++)
            a[i] = p[i] = in.nextInt();
        Arrays.sort(a);

        int sum = 0;
        int t = 0;
        for (int i = 0; i < a.length; i++)
            t += a[i];
        int cnt = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            cnt++;
            sum += a[i];
            if (t - sum < sum)
                break;
        }
        System.out.println(cnt);
    }
}