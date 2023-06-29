import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Loader {
    private final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            l.add(in.nextInt());
        }

        Collections.sort(l);


        int k = 0;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) == 0) continue;
            for (int j = i + 1; j < l.size(); j++) {
                if (l.get(j) == 0) continue;
                if (l.get(j) % l.get(i) == 0) {
                    l.set(j, 0);
                }
            }

            l.set(i, 0);
            k++;
        }

        System.out.println(k);
    }
}