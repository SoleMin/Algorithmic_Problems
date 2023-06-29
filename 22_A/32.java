import java.util.*;
import java.math.*;
/**
 *
 * @author Izhari Ishak Aksa
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Hashtable<Integer, Integer> hi = new Hashtable<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            hi.put(m, 1);
        }
        Set<Integer> set = hi.keySet();
        Integer[] key = set.toArray(new Integer[set.size()]);
        Arrays.sort(key);
        try {
            System.out.println(key[1]);
        } catch (Exception e) {
            System.out.println("NO");
        }
    }

}
