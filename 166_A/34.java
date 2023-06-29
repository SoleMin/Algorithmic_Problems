import java.util.Arrays;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int x[] = new int[n];
        for (int i = 0; i < n; i++) {
            int p = in.nextInt(), t = in.nextInt();
            x[i] = (50 - p) * 100 + t;
        }
        Arrays.sort(x);
        int cnt = 0;
        for (int q: x)
            if (q == x[k - 1]) cnt++;
        System.out.println(cnt);
    }

}
