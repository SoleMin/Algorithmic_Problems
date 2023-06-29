import java.io.*;
import java.util.StringTokenizer;

public class TaskB {

    void run() {
        FastReader in = new FastReader(System.in);
//        FastReader in = new FastReader(new FileInputStream("input.txt"));
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));


        long n = in.nextLong();
        long k = in.nextLong();

        long a = 1;
        long b = -(2 * n + 3);
        long c = n * n + n - 2 * k;

        long d = b * b - 4 * a * c;
        long ans1 = (-b + (long) Math.sqrt(d)) / 2;
        long ans2 = (-b - (long) Math.sqrt(d)) / 2;

        if (ans1 >= 0 && ans1 <= n) {
            out.println(ans1);
        } else {
            out.println(ans2);
        }


        out.close();
    }

    class FastReader {
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
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(nextLine());

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


    public static void main(String[] args) {
        new TaskB().run();
    }
}
