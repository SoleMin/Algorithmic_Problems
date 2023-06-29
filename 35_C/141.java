import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class C2 {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("input.txt"));
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[]x = new int[k+1], y = new int[k+1];
        for (int i = 1; i <= k; i++) {
            y[i] = sc.nextInt();
            x[i] = sc.nextInt();
        }
        int max = -1, y0 = 0, x0 = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int min = n+m+2;
                for (int j2 = 1; j2 <= k; j2++) {
                    min = Math.min(min, Math.abs(i-y[j2])+Math.abs(j-x[j2]));
                }
                if (min > max) {
                    max = min;
                    y0 = i;
                    x0 = j;
                }
            }
        }
        pw.println(y0+" "+x0);
        pw.close();
    }

}
