import java.util.Scanner;

public class Codeforces_912A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong(), b = in.nextLong();
        long x = in.nextLong(), y = in.nextLong(), z = in.nextLong();
        long yel = x * 2 + y, blue = z * 3 + y;
        long t1 = yel- a;
        long t2 = blue - b;
        if(t1 < 0) t1 = 0;
        if(t2 < 0) t2 = 0;
        System.out.println(t1 + t2);
    }
}
