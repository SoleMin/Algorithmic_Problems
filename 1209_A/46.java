import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int min;
        int count = 0;
        int c = 0;
        while (count != n) {
            min = 1000;
            for (int i = 0; i < n; i++) {
                if (a[i] < min) {
                    min = a[i];
                }
            }
            for (int i = 0; i < n; i++) {
                if (a[i] != 1000 && a[i] % min == 0) {
                    count++;
                    a[i] = 1000;
                }
            }
            c++;
        }
        System.out.println(c);
    }
}