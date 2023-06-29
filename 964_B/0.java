import java.util.Scanner;

public class B964 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int T = in.nextInt();
        int[] time = new int[N];
        for (int n = 0; n < N; n++) {
            time[n] = in.nextInt();
        }
        int answer;
        if (C > B) {
            // read at time T
            answer = 0;
            for (int t : time) {
                answer += A+(T-t)*(C-B);
            }
        } else {
            // read immediatelly
            answer = A*N;
        }
        System.out.println(answer);
    }

}
