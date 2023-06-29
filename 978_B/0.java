import java.util.Scanner;

public class Codeforces_978B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = 0;
        String fileName = in.next().toLowerCase();
        for (int i = 0; i < n; i++) {
            if (i + 2 <= n - 1) {
                if(fileName.charAt(i) == 'x' && fileName.charAt(i + 1) == 'x' && fileName.charAt(i + 2) == 'x') t++;
            }
        }
        System.out.println(t);
    }
}
