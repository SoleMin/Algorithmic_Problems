import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] info = s.split(" ");
        long n = Long.parseLong(info[0]);
        long k = Long.parseLong(info[1]);
        sc.close();

        long maximum = k * (k - 1) / 2 + 1;
        if (n == 1)
            System.out.println(0);
        else if (n > maximum)
            System.out.println(-1);
        else {
            long left = 0, right = k - 1;
            while (left + 1 < right) {
                long mid = (right + left) / 2;
                if (mid * (k - 1 + k - mid) / 2 + 1 >= n)
                    right = mid;
                else
                    left = mid;
            }
            System.out.println(right);
        }
    }
}
