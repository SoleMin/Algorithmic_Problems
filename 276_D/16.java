import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long l = s.nextLong();
        long r = s.nextLong();
        long a = l ^ r;
        long b = a;
        while (b != 0) {
            a = b;
            b = (b-1) & b;
        }
        if (a != 0) {
            a = (a << 1) - 1;
        }
        System.out.println(a);
    }

}
