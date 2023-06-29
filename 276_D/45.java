import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long a,b;
        a = scn.nextLong();
        b = scn.nextLong();
        long diff = b -a , tot = 0;
        int ind = 0;
        while(true) {
            long res = (long)Math.pow(2.0, ind);
            if (res > b) break;
            if (((a>>ind) != (b>>ind)) || diff >= res)
                tot += res;
            ind++;
        }
        System.out.println(tot);
    }                                                                                                                                                                                                                          

}
