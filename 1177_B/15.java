import java.util.*;

public class Main {   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long k = in.nextLong();
        long t = 1;
        long l = 1;
        if(k <= 9) {
            System.out.print(k);
            System.exit(0);
        }
        long x = 9;
        while(true) {
            ++l;
            t *= 10;
            x += 9 * l * t;
            if(x >= k) {
                break;
            }
        }
        if(x == k) {
            System.out.print(9);
            System.exit(0);
        }
        x -= 9 * l * t;
        long a = (k - x) / l;
        if((k - x) % l == 0) {
            x = t + a - 1;
            System.out.print(x % 10);
        } else {
            k -= (x + a * l);
            x = t + a;
            String s = Long.toString(x);
            System.out.print(s.charAt((int)k - 1));
        }
    }
}