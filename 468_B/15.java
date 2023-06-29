import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(System.out)));

        while (in.hasNext()) {
            int n = in.nextInt(), a = in.nextInt(), b = in.nextInt(), c = 0;
            int[] p = new int[n];

            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
                map.put(p[i], i);
            }
            
            if (a > b) {
                int t = b;
                b = a;
                a = t;
                c = 1;
            }

            boolean ok = true;
            int[] cls = new int[n];
            while (ok && map.size() > 0) {
                Entry<Integer, Integer> last = map.lastEntry();
                int v = last.getKey();
                int idx = last.getValue();
                if (map.containsKey(a - v)) {
                    cls[idx] = 0;
                    cls[map.get(a - v)] = 0;
                    map.remove(v);
                    map.remove(a -v);
                } else if (map.containsKey(b - v)) {
                    cls[idx] = 1;
                    cls[map.get(b - v)] = 1;
                    map.remove(v);
                    map.remove(b -v);
                } else 
                    ok = false;
            }

            if (!ok)
                System.out.println("NO");
            else {
                System.out.println("YES");
                for (int j = 0; j < cls.length; j++) {
                    if (j != 0)
                        System.out.print(" ");
                    System.out.print(c ^ cls[j]);
                }
                System.out.println();
            }
            out.flush();
        }
        in.close();
    }

}