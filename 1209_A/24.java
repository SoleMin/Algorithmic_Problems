
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int numbers[] = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(numbers);

        boolean[] colored = new boolean[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!colored[i]) {
                res += 1;
            }
            for (int j = i; j < n; j++) {
                if (numbers[j] % numbers[i] == 0) {
                    colored[j] = true;
                }
            }
        }

        System.out.println(res);
    }
}
