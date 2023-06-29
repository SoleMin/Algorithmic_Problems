import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;

public class A {

    public static void main(String[] args) {
        InputScanner scanner = new InputScanner();
        try {
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            if ((r - l) < 2) {
                System.out.println("-1");
                return;
            }

            if (l % 2 == 0) {
                long a = l;
                long b = l + 1;
                long c = l + 2;
                System.out.println(a + " " + b + " " + c);
            } else if (r%2==0){
                long a = r;
                long b = r-1;
                long c = r-2;
                System.out.println(c + " " + b + " " + a);
            } else {
                l++;
                if ((r - l) < 2) {
                    System.out.println("-1");
                    return;
                }
                long a = l;
                long b = l + 1;
                long c = l + 2;
                System.out.println(a + " " + b + " " + c);
            }
        } catch (IOException e) {

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
            next.length();
            return Integer.parseInt(next);
        }

        public long nextLong() throws IOException {
            String next = next();
            next.length();
            return Long.parseLong(next);
        }
    }
}
