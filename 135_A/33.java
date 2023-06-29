import java.util.*;
public class A135 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);
        int[] ans = new int[n];
        
        if (arr[n-1] == 1) {
            for (int i = 0 ;i < n; i++) {
                ans[i] = arr[i];
            }
            ans[n-1] = 2;
        } else {
            ans[0] = 1;
            for (int i = 1; i < n; i++) {
                ans[i] = arr[i-1];
            }
        }
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            buf.append(ans[i]);
            if (i != n-1) buf.append(' ');
        }
        System.out.print(buf.toString());
    }
}
