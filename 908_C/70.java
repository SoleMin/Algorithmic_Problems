
import java.util.Scanner;

/**
 *
 * @author msagimbekov
 */
public class Codeforces908C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int[] x = new int[n];
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            res[i] = (double)r;
            for (int j = i - 1; j >= 0; j--) {
                int diff = x[j] - x[i];
                if (Math.abs(x[j] - x[i]) <= 2 * r) {
                    res[i] = Math.max(res[i], res[j] + Math.sqrt(4 * r * r - diff * diff));
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println("");
    }
}
