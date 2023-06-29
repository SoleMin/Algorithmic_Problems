
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Contest {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Contest().run();
    }

    void init() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time(ms) = " + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    class MyComparator implements Comparable<MyComparator> {

        int x;
        int y;

        public MyComparator(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(MyComparator a) {
            if (x == a.x) {
                return (y - a.y);
            }
            return x - a.x;
        }
    }

    public static boolean isPrime(int num) {
        if (num > 2 && num % 2 == 0) {
            //System.out.println(num + " is not prime");
            return false;
        }
        int top = (int) Math.sqrt(num) + 1;
        for (int i = 3; i < top; i += 2) {
            if (num % i == 0) {
                //System.out.println(num + " is not prime");
                return false;
            }
        }
        //System.out.println(num + " is prime");
        return true;
    }

    private static int lowerBound(int[] a, int low, int high, int element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (element > a[middle]) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }

    private static int upperBound(int[] a, int low, int high, int element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (a[middle] > element) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }

    public void solve() throws IOException {

        int num_a = readInt();
        int[] array = new int[num_a];
        for (int i = 0; i < num_a; i++) {
            array[i] = readInt();
        }
        int result = 0;

        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                continue;
            }
            for (int j = 0; j < array.length; j++) {
                if (array[j] != -1 && array[j] % array[i] == 0 && j != i) {
                    //System.out.println(array[j]);
                    array[j] = -1;
                    //result++;
                }
            }
            result++;
        }

        System.out.println(result);
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    private BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b.divide(a.gcd(b)));
    }

}
