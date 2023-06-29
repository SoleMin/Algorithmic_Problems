import java.util.*;
public class Solution {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] a = new int [n];
        int i;
        int s = 0;
        for (i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            s += a[i];
        }
        Arrays.sort(a);
        int sum = 0;
        for (i = n - 1; i > -1; i--) {
            sum += a[i];
            if (s - sum < sum) {
                System.out.println(n - i);
                return;
            }
        }
    }
}
