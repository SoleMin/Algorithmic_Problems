import java.io.IOException;
import java.util.Scanner;

/**
 * TODO: describe
 *
 * @author keks
 */
public class A {
    public static void main(String[] args) throws IOException {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        if (n % 2 == 0) {
            System.out.println(4 + " " + (n - 4));
        } else {
            System.out.println(9 + " " + (n - 9));
        }
    }
}
