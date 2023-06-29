
import java.util.Arrays;
import java.util.Scanner;

public class round111A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] coins = new int [n];
        for(int i = 0 ; i < n ; ++i)
            coins[i] = sc.nextInt();
        Arrays.sort(coins);
        int ans = (int)1e9;
        for(int i = 1 ; i <= n ; ++i){
            int sum1 = 0;
            int c = 0;
            int j = n - 1;
            for(j = n - 1 ; j >= 0 && c < i ; --j, ++c){
                sum1 += coins[j];
            }
            int sum2 = 0;
            for(int k = 0 ; k <= j ; ++k)
                sum2 += coins[k];
            if(sum1 > sum2){
                System.out.println(i);
                return;
            }
        }
    }
}
