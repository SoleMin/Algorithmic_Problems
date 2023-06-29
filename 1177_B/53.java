
import java.util.Scanner;

public class Training {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long index = in.nextLong();
        if (index < 10) {
            //one digit
            System.out.println(index);
        } else if (index < 190) {
            //two digits
            solve(2, index, 10, 10);

        } else if (index < 2890) {
            //three digits 
            solve(3, index, 190, 100);

        } else if (index < 38890) {
            //four digits 
            solve(4, index, 2890, 1000);

            //start changing ------------------------------------------------------------
        } else if (index < 488890) {
            //five digits 
            solve(5, index, 38890, 10000);

        } else if (index < 5888890) {
            //six digits 
            solve(6, index, 488890, 100000);

        } else if (index < 68888890) {
            //seven digits 
            solve(7, index, 5888890, 1000000);

        } else if (index < 788888890) {
            //eight digits 
            solve(8, index, 68888890, 10000000);

        } else if (index < 8888888890l) {
            //nign digits 
            solve(9, index, 788888890, 100000000);

        } else if (index < 98888888890l) {
            //ten digits 
            solve(10, index, 8888888890l, 1000000000);

        } else {
            solve(11, index, 98888888890l, 10000000000l);

        }

    }

    static void solve(int length, long index, long lastPoint, long num) {
        String s = "";
        num += (index - lastPoint) / length;
        s += num;
        int mod = (int) ((index - lastPoint) % length);
        System.out.println(s.charAt(mod));
    }

}
