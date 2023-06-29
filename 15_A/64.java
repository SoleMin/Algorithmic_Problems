import java.util.Arrays;
import java.util.Scanner;


public class A {
    static class Sort implements Comparable<Sort> {
        int x,a;
        public int compareTo(Sort o) {
            if (this.x==o.x)
                return this.a-o.a;
            return this.x-o.x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        Sort[]a = new Sort[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Sort();
            a[i].x = sc.nextInt();
            a[i].a = sc.nextInt();
        }
        Arrays.sort(a);
        int ans = 2;
        for (int i = 1; i < n; i++) {
            double d = a[i].x-a[i].a / 2.0-a[i-1].x-a[i-1].a / 2.0;
            if (d==t)
                ans++;
            else if (d > t)
                ans += 2;
        }
        System.out.println(ans);
    }
}
