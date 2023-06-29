import java.util.*;
import java.io.*;

public class LCMChallenge {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        if (n < 3) {
            System.out.println(n);
        } else if (n % 2 == 1) {
            System.out.println((long) n * (n - 1) * (n - 2));
        } else {
            if (n % 3 != 0) {
                System.out.println((long) n * (n - 1) * (n - 3));
            } else {
                System.out.println((long) (n - 1) * (n - 2) * (n - 3));
            }
        }
    }
}