
import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class A {

    int INF = 1 << 28;

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        long[] chores = new long[n];
        for(int i=0;i<n;i++) chores[i] = sc.nextLong();
        sort(chores);
        System.out.println(chores[b]-chores[b-1]);
    }

    public static void main(String[] args) {
        new A().run();
    }
}
