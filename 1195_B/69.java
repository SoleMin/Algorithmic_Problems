import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();
        long disc = (long)(Math.sqrt(9 - 4 * (-2 * n - 2 * k)));
        long x = (-3 + disc) / 2;
        System.out.println(n - x);
    }
}