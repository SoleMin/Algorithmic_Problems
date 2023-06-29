import java.util.Arrays;
import java.util.Scanner;


public class CF_111_A {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), sum = 0, sum2 = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = in.nextInt();
            sum += a[i];
        }
        
        Arrays.sort(a);
        
        for (int i = n - 1; i >=0; i--){
            sum2 +=a[i];
            if (sum2 * 2 > sum){
                System.out.println(n - 1 - i + 1);
                System.exit(0);             
            }
        }
    }
}
