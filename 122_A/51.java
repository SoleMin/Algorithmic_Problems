
import java.util.Scanner;

public class three {
    static boolean check;

    public static void main(String[] args) {
        check = true;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = n + "";
        recurse(n, s.length(), "4");
        if (!check)
            System.out.println("YES");
        else {
            recurse(n, s.length(), "7");
            if (!check)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static void recurse(int n, int length, String string) {
        int k = Integer.parseInt(string);
        if (n % k == 0) {
            check = false;
        } else if (string.length() <= length && check) {
            recurse(n, length, string + "4");
            recurse(n, length, string + "7");
        }

    }
}