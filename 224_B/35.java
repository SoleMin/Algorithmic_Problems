import java.util.Scanner;
import java.util.TreeMap;

public class B {

    static Scanner in;

    static void put(TreeMap<Integer, Integer> m, int key) {
        if (m.containsKey(key)) {
            m.put(key, m.get(key) + 1);
        } else {
            m.put(key, 1);
        }
    }

    static void remove(TreeMap<Integer, Integer> m, int key) {
        if (!m.containsKey(key))
            return;
        m.put(key, m.get(key) - 1);
        if (m.get(key) == 0) {
            m.remove(key);
        }
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int i = 0;
        while (i + 1 < n && a[i + 1] == a[0]) {
            i++;
        }
        int left = i;
        TreeMap<Integer, Integer> used = new TreeMap<Integer, Integer>();
        for (; i < n; i++) {
            put(used, a[i]);
            if (used.size() == k) {
                while (used.get(a[left]) > 1) {
                    remove(used, a[left]);
                    left++;
                }
                System.out.println(left + 1 + " " + (i + 1));
                return;
            }
        }
        System.out.println("-1 -1");
    }

}
