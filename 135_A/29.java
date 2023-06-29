import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a = new int[n];
        boolean has_more_than_one = false;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (a[i] > 1)
                has_more_than_one = true;
        }

        Arrays.sort(a);

        if (n == 1) {
            if (a[0] == 1)
                out.print(2);
            else
                out.print(1);
        } else {
            out.print(1 + " ");
            for (int i = 1; i < n; i++) {
                if (has_more_than_one || i < n - 1)
                    out.print(a[i - 1] + " ");
                else
                    out.println(2);
            }
        }

        out.close();
    }
}
