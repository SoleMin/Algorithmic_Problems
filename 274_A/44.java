import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long k = input.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        Set<Long> wrong = new TreeSet<Long>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (!wrong.contains(nums[i])) {
                try {
                    wrong.add(nums[i] * k);
                } catch (Exception e) {
                }
                ans++;
            }
        }
        System.out.println(ans);
    }
}