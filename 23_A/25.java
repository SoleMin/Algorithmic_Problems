import java.util.Scanner;

public class St {

    static void metod() throws Exception {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length() + 1; j++) {

                for (int k = 0; k < str.length(); k++) {
                    for (int n = k + 1; n < str.length() + 1; n++) {

                        if ((str.substring(i, j).equals(str.substring(k, n)))
                                && (k != i)) {
                            if (j - i > max)
                                max = j - i;
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }

    public static void main(String args[]) throws Exception {
        St.metod();
    }
}
