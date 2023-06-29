import javafx.util.Pair;

import java.io.*;
import java.util.*;

public class C {
    static HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = System.out;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> depth = new ArrayList<>();
            int y = 0;
            String[] ans = new String[n];
            for (int x = 0; x < n; x++) {
                int in = Integer.parseInt(br.readLine());
                if (in == 1) {
                    if (y == depth.size()) depth.add(1);
                    else depth.set(y, 1);
                    y++;
                    StringBuilder curr = new StringBuilder();
                    curr.append(depth.get(0));
                    for (int a = 1; a < y; a++) {
                        curr.append('.');
                        curr.append(depth.get(a));
                    }
                    ans[x] = curr.toString();
                    continue;
                }
                for (int d = y-1; d >= 0; d--) {
                    if (depth.get(d) == in-1) {
                        y = d+1;
                        depth.set(d, depth.get(d)+1);
                        StringBuilder curr = new StringBuilder();
                        for (int a = 0; a < d; a++) {
                            curr.append(depth.get(a));
                            curr.append('.');
                        }
                        curr.append(in);
                        ans[x] = curr.toString();
                        break;
                    }
                }
            }
            //Arrays.sort(ans);
            for (String x : ans) out.println(x);
        }

        System.out.flush();
    }
}