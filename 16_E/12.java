import java.io.*;
import java.util.*;
import java.math.*;
import java.util.regex.*;

/**
 *
 * @author jon
 */
public class Fish {
    double memo[] = new double[(1<<18)];
    int N, FULL;
    double prob[][] = new double[18][18];
    Fish() {
        Scanner in = new Scanner(System.in);
        Arrays.fill(memo, -1);

        N = in.nextInt();
        FULL = (1<<N) - 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                prob[i][j] = in.nextDouble();
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.printf("%.6f ", go((1<<i)));
        }
        System.out.println();



    }
    public double go(int mask) {
        if(mask == FULL) return 1.0;
        if(memo[mask] >= 0) return memo[mask];
        double ret = 0;
        double mult = Integer.bitCount(mask) + 1;
        mult *= (mult-1)/2.0;


        for(int i = 0; i < N; i++) {
            if(((1<<i) & mask) != 0) {
                for(int j = 0; j < N; j++) {
                    if(((1<<j) & mask) == 0) {
                        ret += go(mask | (1<<j)) * prob[i][j];
                    }
                }
            }
        }
        ret /= mult;

        memo[mask] = ret;
        return ret;
    }
    public static void main(String args[]) {
        new Fish();
    }
}
