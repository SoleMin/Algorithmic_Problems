import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C2 {

    public static void main(String args[]) {
        InputScanner is = new InputScanner();
        try {
            int n = is.nextInt();
            String input = is.next();
            char[] tab = input.toCharArray();
            int start = 0, end = 0, dist = 0, hCount = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) if (tab[i] == 'H') dist++;
            for (int i = 0; i < dist; i++) if (tab[i] == 'H') hCount++;
            end = dist;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, dist - hCount);
                if (tab[i] == 'H') hCount--;
                if (tab[end] == 'H') hCount++;
                end++;
                end %= n;
            }
            System.out.println(min);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class InputScanner {

        BufferedReader br;
        StringTokenizer st;

        public InputScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            String next = next();
            return Integer.parseInt(next);
        }

        public long nextLong() throws IOException {
            String next = next();
            return Long.parseLong(next);
        }
    }
}