import java.util.Scanner;

public class Main {
    static class LeftOver {
        int a;
        long b;
        long c;
        LeftOver(int a, long b, long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    private static long pow(long base, long coe) {
        if (coe == 0)
            return 1;
        if (coe == 1)
            return base;
        long res = pow(base, coe / 2);
        if (coe % 2 == 0) {
            return res * res;
        } else {
            return res * res * base;
        }
    }

    private static void getLen(long n) {
        long tmp = 0;
        int cnt = 0;
        while(tmp < n) {
            ++cnt;
            tmp += cnt * 9 * pow(10, cnt - 1);
        }
        if (tmp == n)
            System.out.println("9");
        else {
            tmp -= cnt * 9 * pow(10, cnt - 1);
            long ans = (n - tmp - 1) / cnt + pow(10, cnt - 1);
            System.out.println(String.valueOf(ans).charAt((int) ((n - tmp - 1) % cnt)));
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        getLen(n);
    }
}
