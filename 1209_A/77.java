import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int cnt = 0;
        int pos = 0;
        while (true) {
            while (pos < n && arr[pos] == -1) pos++;
            if (pos == n) break;
            int min = arr[pos];
            arr[pos] = -1;
            cnt++;
            for (int i = pos + 1; i < n; i++) {
                if (arr[i] % min == 0) {
                    arr[i] = -1;
                }
            }
        }
        System.out.println(cnt);
    }
}