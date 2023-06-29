import java.io.*;
import java.util.*;
import java.math.*;

public class A implements Runnable {

    public void run() {
        long startTime = System.nanoTime();

        int n = nextInt();

        String[] all = new String[9];
        all[0] = "M";
        for (int i = 0; i < 4; i++) {
            String s = "";
            for (int j = 0; j < i; j++) {
                s += "X";
            }
            all[2 * i + 1] = s + "S";
            all[2 * i + 2] = s + "L";
        }

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : all) {
            map1.put(s, 0);
            map2.put(s, 0);
        }
        for (int i = 0; i < n; i++) {
            String s = nextToken();
            map1.put(s, map1.get(s) + 1);
        }
        for (int i = 0; i < n; i++) {
            String s = nextToken();
            map2.put(s, map2.get(s) + 1);
        }

        int res = 0;
        for (String s : all) {
            int a = map1.get(s);
            int b = map2.get(s);

            if (a > b) {
                res += a - b;
            }
        }
        println(res);

        if (fileIOMode) {
            System.out.println((System.nanoTime() - startTime) / 1e9);
        }
        out.close();
    }

    //-----------------------------------------------------------------------------------

    private static boolean fileIOMode;
    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        fileIOMode = args.length > 0 && args[0].equals("!");
        if (fileIOMode) {
            in = new BufferedReader(new FileReader("a.in"));
            out = new PrintWriter("a.out");
        } else {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
        tokenizer = new StringTokenizer("");

        new Thread(new A()).start();
    }

    private static String nextLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private static String nextToken() {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(nextLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private static long nextLong() {
        return Long.parseLong(nextToken());
    }

    private static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private static BigInteger nextBigInteger() {
        return new BigInteger(nextToken());
    }

    private static void print(Object o) {
        if (fileIOMode) {
            System.out.print(o);
        }
        out.print(o);
    }

    private static void println(Object o) {
        if (fileIOMode) {
            System.out.println(o);
        }
        out.println(o);
    }

    private static void printf(String s, Object... o) {
        if (fileIOMode) {
            System.out.printf(s, o);
        }
        out.printf(s, o);
    }
}
