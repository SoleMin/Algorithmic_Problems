import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1177A {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        // Scanner in = new Scanner(new File("input.txt"));
        System.out.println(solve(in.nextLong()));

    }

    private static String solve(long k) {

        long digitCnt = 1;
        long nine = 9;

        while (k > nine * digitCnt) {
            k -= nine * digitCnt;
            nine *= 10;
            digitCnt++;
        }

        long num = nine / 9 - 1 + (k - 1) / digitCnt + 1;
        return String.valueOf(String.valueOf(num).charAt((int) ((k - 1) % digitCnt)));

    }

}
