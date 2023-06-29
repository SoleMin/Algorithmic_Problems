import java.util.*;
import java.math.*;

public class Main {
    static final long MOD = 1000000007L;
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int res = -1;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        BitSet bits = new BitSet();
        int count = 0;
        int end = -1;
        for (int i = 0; i < arr.length; i++) {
            if (!bits.get(arr[i])) {
                bits.set(arr[i]);
                count++;
                if (count == k) {
                    end = i;
                    break;
                }
            }
        }
        if (end == -1) {
            System.out.print("-1 -1");
            return;
        }
        bits = new BitSet();
        count = 0;
        int start = end;
        while (start >= 0) {
            if (!bits.get(arr[start])) {
                bits.set(arr[start]);
                count++;
                if (count == k) {
                    break;
                }
            }
            start--;
        }
        System.out.println((start + 1) + " " + (end + 1));
    }
}