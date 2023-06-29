import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class Inf {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
    }
    static void kmp(String T, String P, Inf inf) {
        int n = T.length();
        int m = P.length();
        int i = 0;
        int[] next = compute_Next(P);
        int q = 0;
        while (i < n) {
            while (q > 0 && P.charAt(q) != T.charAt(i)) {
                q = next[q - 1];
            }
            if (P.charAt(q) == T.charAt(i)) {
                if (q == m - 1) {
                    inf.count++;
                    inf.list.add(i - m + 2);
                    q=next[q];
                }
                else
                    q++;
            }
            i++;
        }
    }
    static int[] compute_Next(String P) {
        int m = P.length();
        int[] next = new int[m];
        int k = 0; // number of characters matched so far
        int q = 1;
        while (q < m) {
            while (k > 0 && P.charAt(k) != P.charAt(q)) {
                k = next[k - 1];
            }
            if (P.charAt(k) == P.charAt(q))
                next[q] = ++k;
            q++;
        }
        return next;
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String T = scan.nextLine();
        String P = scan.nextLine();
        Inf inf = new Inf();
        kmp(T, P, inf);
        System.out.println(inf.count);
        for(int i = 0; i < inf.list.size(); i++) {
            System.out.print(inf.list.get(i) + " ");
        }
    }
}
