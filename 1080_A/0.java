import java.util.Arrays;
import java.util.Scanner;
 
public class CF43A {
    public static void main(String[] args) {
        //1080A
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int answer = (2*n + k - 1)/k + (5*n + k - 1)/k  + (8*n + k - 1)/k;
        System.out.println(answer);
    }
}