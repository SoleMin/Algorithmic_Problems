//package arbuz;

import java.util.Scanner;

public class Arbuz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int i, j, current, longest = 0;
        for (i = 0; i < s.length(); i++) {
            for (j = 0; j < s.length(); j++) {
                if (i != j) {
                    int ti = i, tj = j;
                    current = 0;
                    while (ti < s.length() && tj < s.length() && s.charAt(ti) == s.charAt(tj)) {
                        current++;
                        ti++;
                        tj++;
                    }
                    if (current > longest) {
                        longest = current;
                    }
                }
            }
        }
        System.out.println(longest);
    }
}
