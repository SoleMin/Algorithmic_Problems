import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i) {
        arr[i] = scanner.nextInt();
    }
    boolean isOdd = false;
    if ((arr[0] % 2 == 0 && arr[1] % 2 == 0) || (arr[0] % 2 == 0 && arr[2] % 2 == 0)
        || (arr[1] % 2 == 0 && arr[2] % 2 == 0)) {
        isOdd = true;
    }
    if (isOdd) {
        for (int i = 0; i < n; ++i) {
        if (arr[i] % 2 == 1) {
            System.out.println(i + 1);
            break;
        }
        }
    } else {
        for (int i = 0; i < n; ++i) {
        if (arr[i] % 2 == 0) {
            System.out.println(i + 1);
            break;
        }
        }
    }

    }

}
