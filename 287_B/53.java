import java.util.Locale;
import java.util.Scanner;

public class PipelineSolver {

    private long n;

    private long k;

    public static void main(String[] args) {
        PipelineSolver solver = new PipelineSolver();

        solver.readData();
        int solution = solver.solve();
        solver.print(solution);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private void print(int[] values) {
        StringBuilder builder = new StringBuilder();

        for (int value : values) {
            builder.append(value);
            builder.append(" ");
        }

        print(builder);
    }

    private void print(Object value) {
        System.out.println(value);
    }

    private void print(boolean value) {
        System.out.println(value ? "YES" : "NO");
    }

    private void print(int value) {
        System.out.println(value);
    }

    private void print(long value) {
        System.out.println(value);
    }

    private void print(double value) {
        System.out.printf(Locale.ENGLISH, "%.10f", value);
    }

    private int[] getDigits(int number) {
        int[] digits = new int[10];
        int index = digits.length - 1;
        int digitsCount = 0;

        while (number > 0) {
            digits[index] = number % 10;
            number /= 10;
            index--;
            digitsCount++;
        }

        int[] result = new int[digitsCount];

        System.arraycopy(digits, digits.length - digitsCount, result, 0, digitsCount);

        return result;
    }

    private int[] readArray(Scanner scanner, int size) {
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = scanner.nextInt();
        }

        return result;
    }

    private void readData() {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextLong();
        k = scanner.nextLong();
    }

    private int solve() {

        if (n == 1) {
            return 0;
        }
        if (n <= k) {
            return 1;
        }
        int result;
        long l;

        long d = (5 - 2 * k) * (5 - 2 * k) - 4 * (2 * n - 4 * k + 4);
        if (d < 0)
        {
            result = -1;
        } else {
            l = Math.min(Math.max((int)((2 * k - 3 - Math.sqrt(d)) / 2), 0), Math.max((int)((2 * k - 3 + Math.sqrt(d)) / 2), 0));

            long difference = n - k * (l + 1) + l * (l + 3) / 2;

            if (l > k - 2) {
                result = -1;
            } else if (l == k - 2) {
                result = difference == 0 ? (int) (l + 1) : -1;
            } else {
                result = (int) (l + 1 + (difference == 0 ? 0 : 1));
            }
        }

        return result;
    }
}
