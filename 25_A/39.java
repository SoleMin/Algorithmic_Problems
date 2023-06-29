import java.util.Scanner;

public class Iq {

    static void metod() throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] m = new int[n];

        for (int i = 0; i < n; i++)
            m[i] = in.nextInt();

        byte k = 0;
        if (m[0] % 2 == 0) {
            if (m[1] % 2 == 0) {
                k = 0;
            } else {
                if (m[2] % 2 == 0) {
                    System.out.println(2);
                    return;
                } else {
                    System.out.println(1);
                    return;
                }
            }
        } else {
            if (m[1] % 2 == 1) {
                k = 1;
            } else {
                if (m[2] % 2 == 0) {
                    System.out.println(1);
                    return;
                } else {
                    System.out.println(2);
                    return;
                }
            }
        }
        if (k == 0) {
            for (int i = 0; i < m.length; i++) {
                if (m[i] % 2 == 1) {
                    System.out.println(i + 1);
                    break;
                }
            }
        } else {
            for (int i = 0; i < m.length; i++) {
                if (m[i] % 2 == 0) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }

    }

    public static void main(String args[]) throws Exception {
        Iq.metod();
    }

}