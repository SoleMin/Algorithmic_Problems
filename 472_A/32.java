import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n % 2 == 0) {
            System.out.println((n - 4) + " " + (n - (n - 4)));
        } else {
            System.out.println((n - 9) + " " + (n - (n - 9)));
        }
    }

}
