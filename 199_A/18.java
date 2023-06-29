import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[] answer = new long[3];
        if (n == 1) {
            answer[0] = 0;
            answer[1] = 0;
            answer[2] = 1;
        } else if (n > 1) {
            long f1 = 0;
            long f2 = 1;
            long m = 0;
            while (m < n) {
                answer[0] = answer[1];
                answer[1] = f1;
                answer[2] = f2;
                m = f1 + f2;
                f1 = f2;
                f2 = m;
            }
            answer[2] = answer[1];
        }
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}