import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Михаил
 * Date: 25.03.12
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */
public class ProblemOne {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int problemCount = scanner.nextInt();
        int petrCount = scanner.nextInt();
        int vasCount = scanner.nextInt();
        int [] problems = new int[problemCount];
        for (int i = 0; i < problemCount; i++) {
            problems[i] = scanner.nextInt();
            

        }
        Arrays.sort(problems);
        System.out.println(-problems[vasCount - 1] + problems[vasCount]);
    }
}
