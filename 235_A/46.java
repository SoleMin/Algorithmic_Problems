
import java.util.Scanner;

/**
 * 2013.07.27 No.1 235A LCM Challenge
 * 数论 n%2 == 0?     n%3 == 0?
 * @author Administrator * 
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 3)
            System.out.println(n);
        else if (n % 2 != 0)
            System.out.println((long)n * (n - 1) * (n - 2));
        else if(n % 3 != 0)
            System.out.println((long)n * (n - 1) * (n - 3));
        else 
            System.out.println((long)(n - 1) * (n - 2) * (n - 3));
        in.close();
        

    }
} 