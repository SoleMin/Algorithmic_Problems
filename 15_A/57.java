import java.util.*;

/**
 * @author Alexander Grigoryev
 *         Created on 28.07.2011
 */
public
class Main {
    static Scanner in = new Scanner(System.in);

    public static
    void main(String[] args) {
        int n = in.nextInt();
        int t = in.nextInt();

        List<Integer> v = new ArrayList<Integer>(n);
        for(int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            v.add(2 * a - b);
            v.add(2 * a + b);
        }
        Collections.sort(v);
        int ans = 2;
        for(int i = 2; i < v.size(); i += 2) {
            if(v.get(i) - v.get(i - 1) > 2 * t) ans += 2;
            if(v.get(i) - v.get(i - 1) == 2 * t) ans++;
        }
        System.out.println(ans);
    }
}