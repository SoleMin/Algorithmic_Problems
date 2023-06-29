import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by jizhe on 2016/1/29.
 */
public class LCMChallenge {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        long N = in.nextLong();
        if( N == 1 || N == 2 )
        {
            System.out.printf("%d\n", N);
            return;
        }

        if( (N&1) == 1 )
        {
            long lcm = N*(N-1)*(N-2);
            System.out.printf("%d\n", lcm);
        }
        else
        {
            if( N == 4 )
            {
                System.out.printf("12\n");
            }
            else
            {
                long lcm;
                if( N%3 == 0 )
                {
                    lcm = (N-1)*(N-2)*(N-3);
                }
                else
                {
                    lcm = N*(N-1)*(N-3);
                }

                System.out.printf("%d\n", lcm);
            }
        }
    }
}
