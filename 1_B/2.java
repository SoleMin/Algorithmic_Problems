
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author madis
 */
public class Spreadsheet {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        for (int i = 0; i < N; i++) {
            String str = in.nextLine();
            if (str.indexOf("R") == 0 && str.indexOf("R") + 1 < str.indexOf("C") && isNum(str.charAt(1))) {
                int row = Integer.parseInt(str.substring(str.indexOf("R") + 1, str.indexOf("C")));
                int col = Integer.parseInt(str.substring(str.indexOf("C") + 1));
                System.out.println(convertRC(row, col));
            } else {
                String row = "";
                int j = 0;
                while (str.charAt(j) >= 'A' && str.charAt(j) <= 'Z') {
                    row += str.charAt(j);
                    j++;
                }
                int num = Integer.parseInt(str.substring(j));
                System.out.println(convertAB(row, num));
            }
        }
    }

    static String convertAB(String str, int num) {
        String result = "";
        int col = 0;
        for (int i = 0; i < str.length(); i++) {
            col += (int)Math.pow(26, (str.length()) - (i + 1)) * (str.charAt(i) - 'A' + 1);
        }
        result += "R" + num;
        result += "C" + col;

        return result;
    }

    static String convertRC(int row, int column) {
        String result = "";
        while (column > 0) {
            int index = column % 26;

            char c;
            if (index == 0) {
                c = 'Z';
                column = column - 26;
            } else {
                c = (char) ('A' + index - 1);
                column = column - index;
            }
            result += c;

            column = column / 26;
        }

        String res = "";
        for (int i = 0; i < result.length(); i++) {
            res += result.charAt(result.length() - (i + 1));
        }
        res += row;
        return res;
    }

    static boolean isNum(char x){
        return x>'0'&&x<='9';
    }
}
