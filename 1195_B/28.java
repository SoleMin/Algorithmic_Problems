import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long k = scan.nextLong();
        long D = 9 + 4 * (2 * k + 2 * n);
        long y = (- 3 + (long)Math.sqrt(D)) / 2;
        System.out.println(n - y);
    }
}