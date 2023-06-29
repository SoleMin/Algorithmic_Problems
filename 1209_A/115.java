import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner  scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);
        boolean[] div = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if (!div[i]) {

                count++;
                div[i] = true;
                for(int j = i+1; j < n; j++) {
                    if (nums[j] % nums[i] == 0) {
                        div[j] = true;
                    }
                }
            }
        }
        System.out.println(count);

    }
}
