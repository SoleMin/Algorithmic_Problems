
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author madi
 */
public class GivenString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String sub = "";
        int count = 0;
        int max = 0;
        for (int i = 0; i < line.length() - 1; i++) {
            sub = line.substring(i, i + 1);

            int q = i + 1;
            int p;
            int r = i;
            while (q < line.length() && q > 0) {
                p = q;
                r = i;
                int ind = line.indexOf(sub, p);
                count = 0;
                if (ind != -1) {
                    for (int j = ind; j < line.length(); j++) {
                        if (line.substring(j, j + 1).equalsIgnoreCase(line.substring(r, r + 1))) {
                            r++;
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count > max) {
                        max = count;
                    }
                }
                q = ind + 1;
                
            }

        }

        System.out.println(max);

    }
}
