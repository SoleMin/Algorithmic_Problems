import java.util.Scanner;

public class Word {
    static String word;

    private static void check(String subword) {
        int i = 0;
        int j = 0;
        while (j + subword.length() <= word.length()) {
            if (word.substring(j).startsWith(subword)){
                i++;
            }
            j++;
        }
        if (i > 1){
            System.out.println(subword.length());
            System.exit(0);
        }
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        word = in.next();
        if (word.length() == 1) {
            System.out.println(0);
            return;
        }
        for (int i = word.length() - 1; i > 0; i--) {
            int j = 0;
            while (j + i <= word.length()) {
                check(word.substring(j, i+j));
                j++;
            }
        }
        System.out.println(0);
    }
}
