import java.util.Scanner;

public class Tsk1 {
    static void metod() throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        String ss = s + s;
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'T') {
                t++;
            }
        }
        if (t == 1 || t == n - 1) {
            System.out.println(0);
        } else {
            int sum = 0;
            for (int i = 0; i < t; i++) {
                if (s.charAt(i) == 'T') {
                    sum++;
                }
            }
            
            int max = sum;
            for (int i = 0; i < s.length(); i++) {
                if (ss.charAt(i) == 'T') {
                    if (ss.charAt(i + t) == 'H') {
                        sum--;
                    }
                } else {
                    if (ss.charAt(i + t) == 'T') {
                        sum++;
                        max = Math.max(max, sum);
                    }
                }
            }
            System.out.println(t - max);
        }
    }

    public static void main(String[] args) throws Exception {
        Tsk1.metod();
    }
}