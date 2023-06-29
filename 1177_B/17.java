import java.util.Scanner;

public class DigitsSequence2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long index = scanner.nextLong();
        solution1(index);

    }

    static void solution1(Long index){
        int i = 1;  // group number
        long len = 9;    // the max length
        long max = 9;    // the max integer
        while(len < index){
            long tmp = 9 * (long) Math.pow(10, i);
            i++;
            len += i * tmp;
            max += tmp;
        }
        long diff = len - index; // the digit number between index and len
        long laterCount = diff / i;  // the number after index
        int remainder = (int) (diff % i);
        long current = max - laterCount; // the number of the index
        int k = i - 1 - remainder;
        System.out.println(String.valueOf(current).charAt(k));
    }
}
