import java.util.Scanner;

public class A {

    public static int n;
    public static double[] masks;
    public static double[][] matrix;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        matrix = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = scan.nextDouble();

        masks = new double[1 << n];
        masks[(1 << n) - 1] = 1;
        for (int i = 0; (1 << i) < (1 << n); i++)
            fillDP(1 << i);

        for (int i = 0; (1 << i) < (1 << n); i++)
            System.out.printf("%.6f ", masks[1 << i]);


    }

    public static double fillDP(int mask) {
        int bitCount = Integer.bitCount(mask);

        if (masks[mask] != 0)
            return masks[mask];

        double matchProba = 2.0 / (((double) (bitCount)) * ((double) (bitCount + 1)));

        double totalProba = 0;
        for (int i = 0; i < n; i++) {
            int iPower = 1 << i;

            if ((mask & iPower) != iPower)
                continue;

            for (int j = 0; j < n; j++) {
                int jPower = 1 << j;

                if ((mask & jPower) == jPower || i == j)
                    continue;

                // still alive
                totalProba += (matchProba * matrix[i][j] * fillDP(mask | jPower));
            }
        }

        return masks[mask] = totalProba;

    }
}