import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PaintColor {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        int c = 0;
        Set<Integer> s = new HashSet<>();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (!s.contains(arr[i])) {
                c++;
                for (int j = i; j < n; j++) {
                    if (arr[j] % arr[i] == 0) {
                        s.add(arr[j]);
                    }
                }
            }
        }
        System.out.println(c);
    }
}
