import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author oleksiys
 */
public class A {
    public static void main(String [] args){
        try(Scanner s = new Scanner(System.in)){
            final int n = s.nextInt();
            final int m = s.nextInt();
            final int k = s.nextInt();
            final int [] a = new int [n];
            for (int i = 0; i < a.length; ++i){
                a[i] = s.nextInt();
            }
            Arrays.sort(a);
            int i = a.length - 1;
            int available = k;
            int filters = 0;
            while (available < m && i >= 0){
                available -= 1;
                available += a[i];
                filters++;
                i--;
            }
            if (available < m){
                System.out.println(-1);
            }else{
                System.out.println(filters);
            }
        }
    }
}
