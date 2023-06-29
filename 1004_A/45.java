import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);

        List<Integer> list = new ArrayList<>();
        s = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(s[i]));
        }

        HashSet<Integer> set = new HashSet<>();
        for (Integer i : list) {
            set.add(i - d);
            set.add(i + d);
        }

        HashSet<Integer> set2 = new HashSet<>();

        for (Integer i : set) {
            for (Integer x : list) {
                if (Math.abs(i - x) < d) {
                    set2.add(i);
            }
            }
        }

        set.removeAll(set2);
        System.out.println(set.size());

    }
}
