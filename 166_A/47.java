import java.util.*;
import java.math.*;

public class Main {
    
    
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt() - 1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int p = scan.nextInt();
            int t = scan.nextInt();
            arr[i] = -p * 10000 + t;
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[k]) {
                count++;
            }
        }
        System.out.println(count);
    }
}