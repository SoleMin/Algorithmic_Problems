import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scn.nextInt();
        scn.close();

        Arrays.sort(a);

        ArrayList<Integer> cyka = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[j] % a[i] == 0) {
                    boolean add = true;
                    for (int k : cyka) {
                        if (a[i] % k == 0) {
                            add = false;
                            break;
                        }
                    }
                    if (add) {
                        cyka.add(a[i]);
                    }
                }
            }
        }

        System.out.println(cyka.size());

    }
}