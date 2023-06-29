import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int distinct = sc.nextInt();
        HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
            if (set.containsKey(ar[i])) {
                set.put(ar[i], set.get(ar[i])+1);
            } else {
                set.put(ar[i], 1);
            }
            if (set.size() == distinct) {
                int st = 0;
                for (int j = 0; j < i; j++) {
                    st=j;
                    if (set.get(ar[j]) > 1) {
                        set.put(ar[j], set.get(ar[j]) - 1);
                    } else {
                        break;
                    }
                }
                System.out.println((st + 1) + " " + (i + 1));
                return;
            }
        }
        System.out.println("-1 -1");
    }
}
