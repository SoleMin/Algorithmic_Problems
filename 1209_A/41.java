import java.io.*;
import java.util.*;

public class TaskA {

    public static void main(String[] args) {
        FastReader in = new FastReader(System.in);
//        FastReader in = new FastReader(new FileInputStream("input.txt"));
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));


        int n = in.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);

        int ans = 1;
        for (int i = 1; i < n; i++) {
            boolean bb = false;
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] % a[j] == 0) {
                    bb = true;
                    break;
                }
            }
            if (!bb) ans++;
        }

        out.println(ans);





        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        Double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }
    }
}
