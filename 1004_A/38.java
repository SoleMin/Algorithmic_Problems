import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        long d = reader.nextLong();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = reader.nextInt();
        Arrays.sort(a);
        int ans = 2;
        for(int i = 0; i < n - 1; i++){
            if(a[i + 1] - a[i] > 2 * d) {
                ans += 2;
            }
            else if(a[i + 1] - a[i] == 2 * d)
                ans++;
        }
        System.out.println(ans);
    }
}