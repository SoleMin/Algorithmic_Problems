import java.util.*;

public class A {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.next();
        for (int l = s.length(); l > 0; --l) {
            HashSet<String> set = new HashSet<String>();
            for (int i = 0; i < s.length() - l + 1; ++i)
                if (set.contains(s.substring(i, i + l))) {
                    System.out.println(l);
                    return;
                } else {
                    set.add(s.substring(i, i + l));
                }
        }
        System.out.println(0);
    }

}
