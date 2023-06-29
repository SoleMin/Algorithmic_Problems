import java.util.Scanner;


public class ProblemC {

    public static void main(String[] args) {
        ProblemC problem = new ProblemC();
        problem.solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int ret = n;
        int toth = 0;
        int tott = 0;
        for (int j = 0; j < n; j++) {
            if (s.charAt(j) == 'H') {
                toth++;
            } else {
                tott++;
            }
        }
        for (int j = 0; j < n; j++) {
            int cnth = 0;
            for (int k = 0; k < toth; k++) {
                int pos = (j + k) % n;
                if (s.charAt(pos) == 'H') {
                    cnth++;
                }
            }
            int makeh = toth - cnth;
            ret = Math.min(ret, makeh);
        }
        System.out.println(ret);
    }

}
