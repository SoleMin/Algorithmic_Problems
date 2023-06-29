import java.util.Arrays;
import java.util.Scanner;

public class AAA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        int max = a[0];
        int ind = 0;
        for (int k = 1; k < n; k++) {
            if (a[k] > max) {
                max = a[k];
                ind = k;
            }
        }
        if (max != 1) {
            a[ind] = 1;
            Arrays.sort(a);
            for (int i = 0; i < a.length - 1; i++)
                System.out.print(a[i] + " ");
            System.out.println(a[a.length - 1]);
        } else {
            a[0] = 2;
            Arrays.sort(a);
            for (int i = 0; i < a.length - 1; i++)
                System.out.print(a[i] + " ");
            System.out.println(a[a.length - 1]);
        }
    }
}
