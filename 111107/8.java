import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int count = 5000;
        int now[]= new int[count + 1];
        int before[] = new int[count + 1];
        int Arraychops[]= new int[count];
        for (int i = 0; i < t; i++) {
            int nums = scanner.nextInt();
            int chopnum = scanner.nextInt();
            for (int j = 0; j < chopnum; j++){
                Arraychops[j] = scanner.nextInt();
            }
            nums += 8;
            for (int j = 0; j <= chopnum; j++){
                before[j] = 0;
            }
            for (int j = 0; j < nums; j++) {
                int high = chopnum - 3 * (nums - 1 - j) - 1;
                now[0] = -1;
                now[1] = -1;
                for (int k = 2; k <= high; k++) {
                    if (before[k - 2] > -1) {
                        int df = Arraychops[k - 1] - Arraychops[k - 2];
                        int a = before[k - 2] + df * df;
                        if (now[k - 1] > a || now[k - 1] == -1)
                            now[k] = a;
                        else
                            now[k] = now[k - 1];
                    } else {
                        now[k] = -1;
                    }
                }
                now[high + 1] = now[high];
                for (int k = 0; k <= high + 1; k++){
                    before[k] = now[k];
                }
            }
            System.out.println(before[chopnum - 1]);
        }
    }
}

