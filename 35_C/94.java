
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class C {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(new File("input.txt")));
        PrintWriter out = new PrintWriter(new File("output.txt"));
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] T = new int[n][m];
        int k = in.nextInt();
        int[] X = new int[k];
        int[] Y = new int[k];
        for (int i = 0; i < k; i++) {
            X[i] = in.nextInt() - 1;
            Y[i] = in.nextInt() - 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                int min = Integer.MAX_VALUE;
                for (int ii = 0; ii < k; ii++)
                    min = Math.min(min,
                            Math.abs(i - X[ii]) + Math.abs(j - Y[ii]));
                max = Math.max(max, T[i][j] = min);
            }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (T[i][j] == max) {
                    out.println((i + 1) + " " + (j + 1));
                    out.flush();
                    return;
                }

    }
}