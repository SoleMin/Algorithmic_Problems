import java.util.Arrays;
import java.util.Scanner;

public class CF495A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long d = s.nextLong();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
        }
        Arrays.sort(arr);
        long ans  = 2;
        for (int i = 0; i < n - 1; i++) {
            if(arr[i + 1] - arr[i] > 2 * d){
                ans += 2;
            }else if(arr[i + 1] - arr[i] == 2 * d){
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}
