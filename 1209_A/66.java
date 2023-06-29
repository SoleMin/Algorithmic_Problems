import java.util.*;

/**
 * https://codeforces.com/contests
 */
public class TaskA {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
        int a = sc.nextInt();

        boolean flag = false; // true = не нужно добавлять
        List<Integer> toRemove = new ArrayList<>();
        for (int b : set) {
            if (a % b == 0) {
                flag = true;
                break;
            } else if (b % a == 0 && a < b) {
                toRemove.add(b);
            }
        }
        for (int r: toRemove) {
            set.remove(r);
        }
        if (!flag) {
            set.add(a);
        }
    }
    System.out.println(set.size());
}
}
