import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int n;
        n = inputReader.nextInt();

        boolean[] mark = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++)
            if (!mark[i])
                for (int j = i * 2; j <= n; j += i)
                    mark[j] = true;

        for (int i = 2; i <= n / 2; i++)
            if (mark[i] && mark[n - i]) {
                System.out.println("" + i + " " + (n - i));
                break;
            }
    }
}