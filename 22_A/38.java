import java.util.*;
import java.io.*;
public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] nums = new int[n];
        args = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        Arrays.sort(nums);
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i]>min) {
                System.out.println(nums[i]); return;
            }
        }
        System.out.println("NO");
    }
}