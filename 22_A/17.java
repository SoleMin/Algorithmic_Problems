import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int i = 0, x; i < N; ++i) {
            x = sc.nextInt();
            if (x < first) {
                second = first;
                first = x;
            } else if (x > first && x < second) {
                second = x;
            }
        }

        if (second == Integer.MAX_VALUE)
            System.out.println("NO");
        else
            System.out.println(second);
    }

}
