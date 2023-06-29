import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static int OO = (int) 9e6 + 9;
    private static int[] dx = {0, 1, -1, 1};
    private static int[] dy = {1, 0, -1, 1};

    public static void main(String[] args) {
        int n = scanner.nextInt(), s = scanner.nextInt(), r;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        r = s - arr[n - 1][0];
        if (r < arr[n - 1][1]) {
            r += (arr[n - 1][1] - r);
        }
        for (int i = n - 2; i >= 0; i--) {
            r += arr[i + 1][0] - arr[i][0];
            if ((arr[i][1]) > r) {
                r += (arr[i][1] - r);
            }
        }
        System.out.println(r + arr[0][0]);
    }

}
