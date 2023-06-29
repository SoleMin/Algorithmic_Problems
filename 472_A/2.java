import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0) {
            System.out.printf("%d %d", 4, n - 4);
        } else {
            System.out.printf("%d %d", 9, n - 9);
        }
    }
}
