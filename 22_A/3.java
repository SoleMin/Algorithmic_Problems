import java.util.Scanner;

public class Seq2 {

    static void metod() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();

        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min)
                min = a[i];
        }
        
        int min2 = min;
        boolean t = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != min) {
                if (!t) {
                    min2 = a[i];
                    t = true;
                } else {
                    if (min2 > a[i])
                        min2 = a[i];
                }
            }
        }

        System.out.println((min == min2) ? "NO" : min2);        
    }

    public static void main(String[] args) {
        Seq2.metod();
    }
}