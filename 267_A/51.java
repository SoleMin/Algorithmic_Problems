import java.util.Scanner;

public class Subtractions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        while (numberOfTests-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int[] res = new int[1];
            compute(a, b, res);
            System.out.println(res[0]);
        }
    }

    private static void compute(int x, int y, int[] res) {
        if (x == 0 || y == 0) {
            return;
        }
        int tmp;
        if (x < y) {
            tmp = x;
            x = y;
            y = tmp;
        }
        res[0] += x / y;
        tmp = x % y;
        if (tmp == 0) {
            return;
        }
        x = y;
        y = tmp;
        compute(x, y, res);
    }
}
