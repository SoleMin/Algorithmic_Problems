import java.util.Scanner;

/**
 * Created by carolineshi on 3/30/17.
 */
public class Subtractions {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t != 0) {
            int f = scan.nextInt();
            int s = scan.nextInt();
            System.out.println(ops(f, s));
            t--;
        }
    }

    public static int ops(int f, int s) {
        int ops = 0;

        while((f > 0) && (s > 0)) {
            if(f > s) {
                ops += f/s;
                f %= s;
            } else {
                //f <= s
                ops += s/f;
                s %= f;
            }
        }

        return ops;
    }

}
