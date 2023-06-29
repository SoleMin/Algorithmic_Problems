import java.util.*;
import java.io.*;

public class A {

    public static void main(String[] args) {
        Scanner s = new Scanner(new InputStreamReader(System.in));
        int n = s.nextInt();
        if (n == 1) {
            System.out.println("NO");
            System.exit(0);
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }
        Arrays.sort(nums);
        int x = 1;
        while (x < n && nums[x] == nums[x - 1])
            x++;
        if (x == n) {
            System.out.println("NO");
            System.exit(0);
        } else {
            System.out.println(nums[x]);
            System.exit(0);
        }

    }
}
