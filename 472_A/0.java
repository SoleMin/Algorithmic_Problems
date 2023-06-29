import java.util.Scanner;

/**
 * Created by ZeRoGerc on 25.02.15.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        if (n % 2 == 0) {
            System.out.println(4 + " " + (n - 4));
        }
        else {
            System.out.println(9 + " " + (n - 9));
        }
    }
}
