import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author madi
 */
public class Speadsheets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String code = "";
        

    for (int i = 0; i < n; i++) {
        long chResult = 0;
        long chResult1 = 0;
        long nResult = 0;
        long nResult1 = 0;
        boolean t = false;
        boolean k = false;
        code = sc.nextLine();

        for (int j = 0; j < code.length(); j++) {
            char c = code.charAt(j);
            if (('Z' - c) < 33) {
                if (t) {
                    chResult1 = chResult;
                    chResult = 0;
                    t = false;
                    k = true;
                }
                chResult = chResult * 26 + (26 - ('Z' - c));
            } else {
                t = true;
                if (k) {
                    nResult1 = nResult;
                    nResult = 0;
                    k = false;
                }
                nResult = nResult * 10 + (9 - ('9' - c));
            }

        }

        if (chResult1 == 0) {
            System.out.println("R" + nResult + "C" + chResult);
        } else {
            System.out.println(convert(nResult) + nResult1);
        }

    }

    }

    private static String convert(long number) {
        String [] chars = new String[]{"Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y"};
        String result = "";
        int rem = 0;
        int m = 0;
        while (number > 0) {
        	m = 0;
            rem = (int) (number % 26);
            result = chars[rem] + result;
            /*if (number == 26) {
            	number = -1;
            }*/
            if (number % 26 == 0) {
            	m = 1;
            }
            number = number / 26;
            number = number - m;
        }
        return result;
    }
}