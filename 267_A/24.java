import java.util.Scanner;

public class Subtractions {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int res = 0;
            while (a != 0 && b != 0) {
                if (a > b) {
                    res += (a / b);
                    a %= b;
                } else {
                    res += (b / a);
                    b %= a;
                }
            }
            System.out.println(res);

        }
    }
}
