
import java.util.Scanner;

public class A {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int f1 = 0;
        int f2 = 1;
        int f3 = 1;
        while (f3 < n) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }
        if (n == 0) {
            System.out.println(0 + " " + 0 + " " + 0);
        } else if (f3 == n) {
            System.out.println(f1 + " " + f1 + " " + (f2 - f1));
        } else {
            System.out.println("I'm too stupid to solve this problem");
        }
    }
}
