import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++)
            ar[i] = in.nextInt();
        Arrays.sort(ar);
        int x1 = ar[b-1];
        int x2 = ar[b];
        System.out.println(x2-x1);
    }
}