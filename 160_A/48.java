import java.util.*;

public class TaskA {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        int take = 0, num = 0;

        for (int i = n - 1; i > -1; i--) {
            num++;
            take += a[i];
            sum -= a[i];
            if (take > sum) {
                break;
            }
        }

        System.out.println(num);
    }
}
