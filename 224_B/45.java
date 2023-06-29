import java.util.*;

public class TaskB {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        int k = s.nextInt();
        int[] nums = new int[100000 + 10];
        
        int first = -1, last = -1;
        Set<Integer> dif = new TreeSet<Integer>();
        
        s.nextLine();
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
            dif.add(nums[i]);
            if (dif.size() == k) {
                last = i;
                break;
            }
        }

        dif.clear();

        for (int i = last; i >= 0; i--) {
            dif.add(nums[i]);
            if (dif.size() == k) {
                first = i;
                break;
            }
        }
        
        if (last == -1)
            System.out.print("-1 -1");
        else
            System.out.print(Integer.toString(first + 1) + " "  + Integer.toString(last + 1));
    }
}
