import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C1197 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int size = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] nums = new int[size];
        s = reader.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int[] da = new int[size - 1];
        for (int i = 1; i < size; i++) {
            da[i - 1] = nums[i] - nums[i - 1];
        }
        Arrays.sort(da);
        int sum = 0;
        for (int i = 0; i <= da.length - k; i++) {
            sum += da[i];
        }
        System.out.println(sum);
    }
}