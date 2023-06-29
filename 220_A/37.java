import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Problem220A {
    static int[] numbers;
    static int[] numbersCopy;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(in.readLine());
        numbers = new int[i];
        numbersCopy = new int[i];
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int numOutOfPlace = 0;
        for (int j = 0; j < i; j++) {
            numbers[j] = Integer.parseInt(stringTokenizer.nextToken());
            numbersCopy[j] = numbers[j];
        }
        Arrays.sort(numbers);
        for (int j = 0; j < i; j++) {
            if (numbers[j] != numbersCopy[j]) {
                numOutOfPlace++;
                if (numOutOfPlace > 2) {
                    break;
                }
            }
        }
        if (numOutOfPlace == 0 || numOutOfPlace == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
