import java.util.Scanner;

public class B1177 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        long answer = solve(N, 0, 1, 1);
        System.out.println(answer);
    }

    static long solve(long N, long offset, long start, int digits) {
        long thisSection = digits*start*9;
        long fromOffset = N-offset;
        if (fromOffset > thisSection) {
            return solve(N, offset+thisSection, 10*start, digits+1);
        }
        long number = start + (fromOffset-1)/digits;
        long posInNumber = digits - 1 - (fromOffset-1)%digits;
        while (posInNumber > 0) {
            posInNumber--;
            number /= 10;
        }
        return number%10;
    }

}
