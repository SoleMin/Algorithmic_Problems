import java.util.*;

public class PaintNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        boolean[] visited = new boolean[n];
        int min = Integer.MAX_VALUE;
        int a = 0;
        boolean cont = true;
        while (cont) {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    min = Math.min(min, nums[i]);
                }
            }

            cont = false;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && nums[i] % min == 0) {
                    cont = true;
                    visited[i] = true;
                }
            }
            a++;
            min = Integer.MAX_VALUE;
        }
        System.out.println(a - 1);
    }



}
