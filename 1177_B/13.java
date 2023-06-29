
import java.util.Scanner;

public class BDigitSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long k = scan.nextLong();

        long digits = 1;
        long counter = 9L;

        while(k > counter * digits) {
            k -= counter * digits;
            counter *= 10;
            digits++;
        }

        long num = (long)(Math.ceil((double)k/digits));
        String s = String.valueOf((long)Math.pow(10,digits-1) - 1 + num );

        System.out.println(s.charAt((int)((k+digits-1)%digits)));
    }
}
